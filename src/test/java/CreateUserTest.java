import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

import java.util.UUID;


public class CreateUserTest {

    // Arrange
    private UsersClient usersClient;

    @BeforeClass
    public void setUp() {
        usersClient = new UsersClient();
    }

    @Test
    public void shouldCreateNewMaleUser() {
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        String body = String.format("{\n" +
                "    \"name\":\"James John\", \n" +
                "    \"gender\":\"male\", \n" +
                "    \"email\":\"%s\", \n" +
                "    \"status\":\"active\"\n" +
                "}", email);
        // Act
        usersClient.createUser(body)
                .then()
                // Assert
                .statusCode(201)
                .body("data.email", Matchers.equalTo(email));
    }

    @Test
    public void shouldCreateNewFemaleUser() {
        // Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        String body = String.format("{\n" +
                "    \"name\":\"Jessica John\", \n" +
                "    \"gender\":\"male\", \n" +
                "    \"email\":\"%s\", \n" +
                "    \"status\":\"active\"\n" +
                "}", email);
        // Act
        usersClient.createUser(body)
                .then()
                // Assert
                .statusCode(201)
                .body("data.email", Matchers.equalTo(email));
    }
}
