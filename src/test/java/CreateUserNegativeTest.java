import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.requests.CreateUserRequestBody;

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
        String name = "Jessica Kane";
        String gender = "female";
        String status = "active";

        CreateUserRequestBody requestBody = new CreateUserRequestBody(name, gender, email, status);

        // Act
        usersClient.createUser(requestBody)
                .then()
                // Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message", "is invalid")));
    }
}
