import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateUserNegativeTest {

    @Test
    public void shouldNotCreateNewUserInvalidEmailAddress() {
        // Arrange
        String body = "{\n" +
                "    \"name\":\"Jessica Kane\", \n" +
                "    \"gender\":\"male\", \n" +
                "    \"email\":\"jessicakanegmail.com\", \n" +
                "    \"status\":\"active\"\n" +
                "}";
        // Act
        new UsersClient().createUser(body)
                .then()
                // Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message", "is invalid")));
    }
}
