import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.response.GetAllUsersResponse;

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
        GetAllUsersResponse response = userClient.getAllUsers();
        // Assert
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.getDataList().size(),20);
        Assert.assertTrue(response.hasMaleUser());
    }
}
