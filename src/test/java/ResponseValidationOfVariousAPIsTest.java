import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ResponseValidationOfVariousAPIsTest {

    @Test
    public void validateCreateUserAPIResponse() {
        // Arrange
        String body="{\n" +
                "    \"name\":\"James Kane\", \n" +
                "    \"gender\":\"male\", \n" +
                "    \"email\":\"jameskane17@gmail.com\", \n" +
                "    \"status\":\"active\"\n" +
                "}";
        // Act
        createUser(body)
                .then()
        // Assert
                .statusCode(201)
                .body("data.name", Matchers.equalTo("James Kane"));
    }

    @Test
    public void validateAttributeLimitOfGetAllUsersAPI() {
        // Act
        getUsers()
                .then()
        // Assert
                .statusCode(200)
                .body("meta.pagination.limit", Matchers.equalTo(20));
    }

    private Response getUsers() {
        return given()
                .when()
                .get("https://gorest.co.in/public/v1/users");
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
