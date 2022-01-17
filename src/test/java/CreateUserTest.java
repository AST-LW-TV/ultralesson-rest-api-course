import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTest {

    @Test
    public void shouldCreateNewMaleUser() {
        // Arrange
        String body = "{\n" +
                "    \"name\":\"James John\", \n" +
                "    \"gender\":\"male\", \n" +
                "    \"email\":\"jamesjohn17@gmail.com\", \n" +
                "    \"status\":\"active\"\n" +
                "}";
        // Act
        createUser(body)
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
                "    \"email\":\"jessicajohn17@gmail.com\", \n" +
                "    \"status\":\"active\"\n" +
                "}";
        // Act
        createUser(body)
                .then()
                // Assert
                .statusCode(201);
    }

    private Response createUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer c3a25b6a2efa1b47e3bc3b4276cfb5c457368e1fa5af5c1e44815b1cd5811fa5")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
    }
}
