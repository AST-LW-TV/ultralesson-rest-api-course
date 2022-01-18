import org.testng.annotations.Test;
import users.UsersClient;


public class CreateUserTest {

    @Test
    public void shouldCreateNewMaleUser() {
        // Arrange
        String body = "{\n" +
                "    \"name\":\"James John\", \n" +
                "    \"gender\":\"male\", \n" +
                "    \"email\":\"jamesjohn19@gmail.com\", \n" +
                "    \"status\":\"active\"\n" +
                "}";
        // Act
        new UsersClient().createUser(body)
                .then()
                // Assert
                .statusCode(201);
    }

    @Test
    public void shouldCreateNewFemaleUser() {
        // Arrange
        String body = "{\n" +
                "    \"name\":\"Jessica John\", \n" +
                "    \"gender\":\"male\", \n" +
                "    \"email\":\"jessicajohn19@gmail.com\", \n" +
                "    \"status\":\"active\"\n" +
                "}";
        // Act
        new UsersClient().createUser(body)
                .then()
                // Assert
                .statusCode(201);
    }
}
