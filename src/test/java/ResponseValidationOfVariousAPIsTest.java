import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.requests.CreateUserRequestBody;

import java.util.UUID;


public class ResponseValidationOfVariousAPIsTest {

    // Arrange
    private UsersClient usersClient;

    @BeforeClass
    public void setUp() {
        usersClient = new UsersClient();
    }

    @Test
    public void validateCreateUserAPIResponse() {
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        String name = "James Kane";
        String gender = "male";
        String status = "active";

        CreateUserRequestBody requestBody = new CreateUserRequestBody(name, gender, email, status);

        // Act
        usersClient.createUser(requestBody)
                .then()
                // Assert
                .statusCode(201)
                .body("data.name", Matchers.equalTo("James Kane"));
    }

    @Test
    public void validateAttributeLimitOfGetAllUsersAPI() {
        // Act
        usersClient.getAllUsers()
                .then()
                // Assert
                .statusCode(200)
                .body("meta.pagination.limit", Matchers.equalTo(20));
    }
}
