import org.testng.annotations.Test;
import users.UsersClient;

public class GetAllUsersTest {

    @Test
    public void validateStatusCodeOfGetAllUsersAPI() {
        // Arrange

        // Act
        new UsersClient().getAllUsers()
                .then()
                // Assert
                .statusCode(200)
                .log()
                .body();
    }
}
