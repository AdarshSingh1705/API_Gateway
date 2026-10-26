package in.adarshsingh.gatekeeper.management.dto.requestDto;

import in.adarshsingh.gatekeeper.management.entity.OrganizationStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizationStatusRequest {

    @NotNull
    private OrganizationStatus status;

}
