import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ResponseValidationOfVariousAPIsTest {

    @Test
    public void validateCreateUserAPIResponse() {
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer c3a25b6a2efa1b47e3bc3b4276cfb5c457368e1fa5af5c1e44815b1cd5811fa5")
                .body("{\n" +
                        "    \"name\":\"James John\", \n" +
                        "    \"gender\":\"male\", \n" +
                        "    \"email\":\"jamesjohn11@gmail.com\", \n" +
                        "    \"status\":\"active\"\n" +
                        "}")
                .when()
                .post("https://gorest.co.in/public/v1/users")
                .then()
                .statusCode(201)
                .body("data.name", Matchers.equalTo("James John"));
    }

    @Test
    public void validateAttributeLimitOfGetAllUsersAPI() {
        given()
                .when()
                .get("https://gorest.co.in/public/v1/users")
                .then()
                .statusCode(200)
                .body("meta.pagination.limit", Matchers.equalTo(20));
    }
}
