import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsersTest {

    @Test
    public void validateStatusCodeOfGetAllUsersAPI() {
        // Arrange

        // Act
        getUsers()
                .then()
        // Assert
                .statusCode(200)
                .log()
                .body();
    }

    private Response getUsers() {
        return given()
                .when()
                .get("https://gorest.co.in/public/v1/users");
    }
}
