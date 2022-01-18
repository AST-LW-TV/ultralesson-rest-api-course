import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.requests.CreateUserRequestBody;

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
        String name = "James John";
        String gender = "male";
        String status = "active";

        CreateUserRequestBody requestBody = new CreateUserRequestBody(name, gender, email, status);

        // Act
        usersClient.createUser(requestBody)
                .then()
                // Assert
                .statusCode(201)
                .body("data.email", Matchers.equalTo(email));
    }

    @Test
    public void shouldCreateNewFemaleUser() {
        // Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        String name = "Jessica John";
        String gender = "female";
        String status = "active";

        CreateUserRequestBody requestBody = new CreateUserRequestBody(name, gender, email, status);

        // Act
        usersClient.createUser(requestBody)
                .then()
                // Assert
                .statusCode(201)
                .body("data.email", Matchers.equalTo(email));
    }
}
