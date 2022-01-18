import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;


public class ResponseValidationOfVariousAPIsTest {

    @Test
    public void validateCreateUserAPIResponse() {
        // Arrange
        String body = "{\n" +
                "    \"name\":\"James Kane\", \n" +
                "    \"gender\":\"male\", \n" +
                "    \"email\":\"jameskane19@gmail.com\", \n" +
                "    \"status\":\"active\"\n" +
                "}";
        // Act
        new UsersClient().createUser(body)
                .then()
                // Assert
                .statusCode(201)
                .body("data.name", Matchers.equalTo("James Kane"));
    }

    @Test
    public void validateAttributeLimitOfGetAllUsersAPI() {
        // Act
        new UsersClient().getAllUsers()
                .then()
                // Assert
                .statusCode(200)
                .body("meta.pagination.limit", Matchers.equalTo(20));
    }
}
