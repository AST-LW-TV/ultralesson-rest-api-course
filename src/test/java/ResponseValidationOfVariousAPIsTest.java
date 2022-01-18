import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.requests.CreateUserRequestBody;
import users.response.CreateUserResponseBody;

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
        CreateUserRequestBody requestBody = CreateUserRequestBody
                .builder()
                .name("James Kane")
                .gender("male")
                .email(email)
                .status("active")
                .build();

        // Act
        CreateUserResponseBody response = usersClient.createUser(requestBody);
        // Assert
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.getData().getName(), requestBody.getName());
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
