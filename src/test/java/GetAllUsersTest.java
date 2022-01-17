import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsersTest {

    @Test
    public void validateStatusCodeOfGetAllUsersAPI() {
        given()
                .when()
                .get("https://gorest.co.in/public/v1/users")
                .then()
                .statusCode(200)
                .log()
                .body();
    }
}
