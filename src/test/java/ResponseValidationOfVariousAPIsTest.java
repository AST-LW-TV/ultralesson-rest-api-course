import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.requests.CreateUserRequestBody;
import users.response.CreateUserResponseBody;
import users.response.GetAllUsersResponse;

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
        response.assertUserResponse(requestBody);
    }

    @Test
    public void validateAttributeLimitOfGetAllUsersAPI() {
        // Act
        GetAllUsersResponse response = usersClient.getAllUsers();
        // Assert
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.getMeta().getPagination().getLimit(),"20");

    }
}
