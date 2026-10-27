package in.adarshsingh.gatekeeper.management.controller;

import in.adarshsingh.gatekeeper.management.dto.requestDto.TenantOrganizationRequest;
import in.adarshsingh.gatekeeper.management.dto.responseDto.OrganizationResponse;
import in.adarshsingh.gatekeeper.management.service.OrganizationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tenant/organization")
public class TenantOrganizationController {

    private final OrganizationService organizationService;

    public TenantOrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    // 1. Get
    @GetMapping
    public ResponseEntity<OrganizationResponse> getOwnOrganization(){
        return ResponseEntity.ok(organizationService.getOwnOrganization());
    }

    // 2. update --> name of organization
    @PutMapping
    public ResponseEntity<OrganizationResponse> updateOwnOrganization(
            @Valid @RequestBody TenantOrganizationRequest request){
        return ResponseEntity.ok(organizationService.updateOwnOrganization(request));
    }

}
