package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.requests.CreateUserRequestBody;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public Response createUser(CreateUserRequestBody requestBody) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer c3a25b6a2efa1b47e3bc3b4276cfb5c457368e1fa5af5c1e44815b1cd5811fa5")
                .body(requestBody)
                .when()
                .post("https://gorest.co.in/public/v1/users");
    }

    public Response getAllUsers() {
        return given()
                .when()
                .get("https://gorest.co.in/public/v1/users");
    }
}
