package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.requests.CreateUserRequestBody;
import users.response.CreateUserErrorResponseBody;
import users.response.CreateUserResponseBody;
import users.response.GetAllUsersResponse;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public CreateUserResponseBody createUser(CreateUserRequestBody requestBody) {
        Response response = create(requestBody);
        CreateUserResponseBody createUserResponse = response.as(CreateUserResponseBody.class);
        createUserResponse.setStatusCode(response.statusCode());
        return createUserResponse;
    }

    public CreateUserErrorResponseBody createUserError(CreateUserRequestBody requestBody){
        Response response = create(requestBody);
        CreateUserErrorResponseBody createUserErrorResponse = response.as(CreateUserErrorResponseBody.class);
        createUserErrorResponse.setStatusCode(response.statusCode());
        return createUserErrorResponse;
    }

    public Response create(CreateUserRequestBody requestBody) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer c3a25b6a2efa1b47e3bc3b4276cfb5c457368e1fa5af5c1e44815b1cd5811fa5")
                .body(requestBody)
                .when()
                .post("https://gorest.co.in/public/v1/users");
    }

    public GetAllUsersResponse getAllUsers() {
        Response response = given()
                .when()
                .get("https://gorest.co.in/public/v1/users");
        GetAllUsersResponse getAllUsersResponse = response.as(GetAllUsersResponse.class);
        getAllUsersResponse.setStatusCode(response.statusCode());
        return getAllUsersResponse;
    }
}
