package net.local.poc.organization.service.presentation.api;

import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.local.poc.organization.service.application.dto.OrganizationRequest;
import net.local.poc.organization.service.application.dto.OrganizationResponse;
import net.local.poc.organization.service.application.usecases.CreateOrganizationUC;
import net.local.poc.organization.service.application.usecases.ListOrganizationUC;

@Slf4j
@RestController
@RequestMapping("/v1/organization")
public class OrganizationController {
    
    private final ListOrganizationUC listOrganizationUC;
    private final CreateOrganizationUC createOrganizationUC;

    public OrganizationController(ListOrganizationUC listOrganizationUC, CreateOrganizationUC createOrganizationUC) {
        this.listOrganizationUC = listOrganizationUC;
        this.createOrganizationUC = createOrganizationUC;
    }

    @GetMapping
    public ResponseEntity<Stream<OrganizationResponse>> listOrganizations() {
        log.info("Request for list all Organizations");
        return ResponseEntity.ok(listOrganizationUC.handle());
    }

    @PostMapping
    public ResponseEntity<OrganizationResponse> createOrganization(@RequestBody OrganizationRequest request) {
        log.info("Request for create new organization {}", request);
        return ResponseEntity.ok(createOrganizationUC.handle(request.organizationName()));
    }
}
