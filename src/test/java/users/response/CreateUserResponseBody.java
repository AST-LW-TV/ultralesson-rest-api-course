package users.response;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;
import users.requests.CreateUserRequestBody;

@Getter
public class CreateUserResponseBody {
    @Setter
    private int statusCode;
    private String meta;
    private Data data;

    public void assertUserResponse(CreateUserRequestBody requestBody){
        Assert.assertEquals(this.getStatusCode(), 201);
        Assert.assertEquals(this.getData().getEmail(), requestBody.getEmail());
        Assert.assertEquals(this.getData().getName(), requestBody.getName());
        Assert.assertEquals(this.getData().getGender(), requestBody.getGender());
        Assert.assertEquals(this.getData().getStatus(), requestBody.getStatus());
    }
}
