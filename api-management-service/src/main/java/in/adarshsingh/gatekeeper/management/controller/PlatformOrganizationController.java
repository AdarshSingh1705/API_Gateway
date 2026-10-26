package in.adarshsingh.gatekeeper.management.controller;

import in.adarshsingh.gatekeeper.management.dto.requestDto.OrganizationRequest;
import in.adarshsingh.gatekeeper.management.dto.requestDto.OrganizationStatusRequest;
import in.adarshsingh.gatekeeper.management.dto.requestDto.TenantAdminRequest;
import in.adarshsingh.gatekeeper.management.dto.responseDto.OrganizationResponse;
import in.adarshsingh.gatekeeper.management.dto.responseDto.TenantAdminResponse;
import in.adarshsingh.gatekeeper.management.service.OrganizationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platform/organizations")
public class PlatformOrganizationController {

    public final OrganizationService organizationService;

    public PlatformOrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    // CRUD -> organization & tenant admin

    // 1. Create
    @PostMapping
    public ResponseEntity<OrganizationResponse> create(
            @Valid @RequestBody OrganizationRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(organizationService.create(request));
    }

    // 2. Read all
    @GetMapping
    public ResponseEntity<List<OrganizationResponse>> findAll(){
        return ResponseEntity.ok(organizationService.findAll());
    }

    //3. read one
    @GetMapping("/{id}")
    public ResponseEntity<OrganizationResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(organizationService.findById(id));
    }

    //4. Update
    @PutMapping("/{id}")
    public ResponseEntity<OrganizationResponse> update(@PathVariable Long id,
                                                       @Valid @RequestBody OrganizationRequest request){
        return ResponseEntity.ok(organizationService.update(id, request));
    }

    //5. patch
    @PatchMapping("/{id}/status")
    public ResponseEntity<OrganizationResponse> changeStatus(@PathVariable Long id,
                                                             @Valid @RequestBody OrganizationStatusRequest request){
        return ResponseEntity.ok(organizationService.changeStatus(id, request));
    }

    //6. Delete (soft delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        organizationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // CRUD --> Tenant Admins
    @PostMapping("/{organizationId}/tenant-admin")
    public ResponseEntity<TenantAdminResponse> createTenantAdmin(@PathVariable Long organizationId,
                                                                 @Valid @RequestBody TenantAdminRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(organizationService.createTenantAdmin(organizationId, request));
    }

    @GetMapping("/{organizationId}/tenant-admin")
    public ResponseEntity<TenantAdminResponse> getTenantAdmin(@PathVariable Long organizationId){
        return ResponseEntity.ok(organizationService.getTenantAdmin(organizationId));
    }

    @PutMapping("/{organizationId}/tenant-admin")
    public ResponseEntity<TenantAdminResponse> updateTenantAdmin(@PathVariable Long organizationId,
                                                                 @Valid @RequestBody TenantAdminRequest request){
        return ResponseEntity.ok(organizationService.updateTenantAdmin(organizationId, request));
    }

    @DeleteMapping("/{organizationId}/tenant-admin")
    public ResponseEntity<Void> deleteTenantAdmin(@PathVariable Long organizationId){
        organizationService.delete(organizationId);
        return ResponseEntity.noContent().build();
    }

}
