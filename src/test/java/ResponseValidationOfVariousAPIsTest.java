import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

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
        String body = String.format("{\n" +
                "    \"name\":\"James Kane\", \n" +
                "    \"gender\":\"male\", \n" +
                "    \"email\":\"%s\", \n" +
                "    \"status\":\"active\"\n" +
                "}", email);
        // Act
        usersClient.createUser(body)
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
