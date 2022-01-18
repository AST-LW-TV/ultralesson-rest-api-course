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
        CreateUserRequestBody requestBody = CreateUserRequestBody
                .builder()
                .name("James John")
                .gender("male")
                .email(email)
                .status("active")
                .build();

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
        CreateUserRequestBody requestBody = CreateUserRequestBody
                .builder()
                .name("Jessica John")
                .gender("female")
                .email(email)
                .status("active")
                .build();

        // Act
        usersClient.createUser(requestBody)
                .then()
                // Assert
                .statusCode(201)
                .body("data.email", Matchers.equalTo(email));
    }
}
