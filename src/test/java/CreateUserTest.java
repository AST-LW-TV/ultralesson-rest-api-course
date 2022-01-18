import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.requests.CreateUserRequestBody;
import users.response.CreateUserResponseBody;

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
        CreateUserResponseBody response = usersClient.createUser(requestBody);
        // Assert
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.getData().getEmail(), requestBody.getEmail());
    }

    @Test
    public void shouldCreateNewFemaleUser() {
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        CreateUserRequestBody requestBody = CreateUserRequestBody
                .builder()
                .name("Jessica John")
                .gender("female")
                .email(email)
                .status("active")
                .build();

        // Act
        CreateUserResponseBody response = usersClient.createUser(requestBody);
        // Assert
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.getData().getEmail(), requestBody.getEmail());
    }
}
