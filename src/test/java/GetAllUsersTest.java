import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

public class GetAllUsersTest {

    // Arrange
    private UsersClient userClient;

    @BeforeClass
    public void setUp() {
        userClient = new UsersClient();
    }

    @Test
    public void validateStatusCodeOfGetAllUsersAPI() {
        // Act
        userClient.getAllUsers()
                .then()
        // Assert
                .statusCode(200)
                .log()
                .body();
    }
}
