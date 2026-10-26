package in.adarshsingh.gatekeeper.management.dto.responseDto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {

    private String username;
    private String tokenType;
    private long expiresInSeconds;
    private String role;
    private Long organizationId;


}
