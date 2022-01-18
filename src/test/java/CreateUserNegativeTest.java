import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

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
        String body = String.format("{\n" +
                "    \"name\":\"Jessica Kane\", \n" +
                "    \"gender\":\"male\", \n" +
                "    \"email\":\"email\", \n" +
                "    \"status\":\"active\"\n" +
                "}", email);
        // Act
        usersClient.createUser(body)
                .then()
                // Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message", "is invalid")));
    }
}
