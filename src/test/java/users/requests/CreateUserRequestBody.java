package users.requests;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserRequestBody {

    private String name;
    private String gender;
    private String email;
    private String status;
}
