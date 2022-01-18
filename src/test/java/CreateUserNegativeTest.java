import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.requests.CreateUserRequestBody;
import users.response.CreateUserErrorResponseBody;

import java.util.UUID;

public class CreateUserNegativeTest {

    // Arrange
    private UsersClient usersClient;

    @BeforeClass
    public void setUp() {
        usersClient = new UsersClient();
    }

    @Test
    public void shouldNotCreateNewUserInvalidEmailAddress() {
        String email = String.format("%sgmail.com", UUID.randomUUID());
        CreateUserRequestBody requestBody = CreateUserRequestBody
                .builder()
                .name("Jessica Kane")
                .gender("female")
                .email(email)
                .status("active")
                .build();

        // Act
        CreateUserErrorResponseBody response = usersClient.createUserError(requestBody);
        // Assert
        Assert.assertEquals(response.getStatusCode(), 422);
        response.assertHasError("email", "is invalid");
    }

    @Test
    public void shouldNotCreateNewUserWithBlankGenderAndStatus() {
        String email = String.format("%sgmail.com", UUID.randomUUID());
        CreateUserRequestBody requestBody = CreateUserRequestBody
                .builder()
                .name("Jessica Kane")
                .gender("")
                .email(email)
                .status("")
                .build();

        // Act
        CreateUserErrorResponseBody response = usersClient.createUserError(requestBody);
        // Assert
        Assert.assertEquals(response.getStatusCode(), 422);
        response.assertHasError("gender", "can't be blank");
        response.assertHasError("status", "can't be blank");
    }
}
