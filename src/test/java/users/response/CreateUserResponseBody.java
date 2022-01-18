package users.response;

import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateUserResponseBody {
    @Setter
    private int statusCode;
    private String meta;
    private Data data;
}
