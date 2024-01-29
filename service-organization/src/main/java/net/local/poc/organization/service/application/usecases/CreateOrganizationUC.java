package net.local.poc.organization.service.application.usecases;

import java.util.UUID;

import net.local.poc.organization.service.application.dto.OrganizationResponse;
import net.local.poc.organization.service.domain.model.Organization;
import net.local.poc.organization.service.domain.repository.LoadOrganizationPort;
import net.local.poc.organization.service.domain.repository.SaveOrganizationPort;

public class CreateOrganizationUC {
    
    private final LoadOrganizationPort loadOrganizationPort;
    private final SaveOrganizationPort saveOrganizationPort;

    public CreateOrganizationUC(LoadOrganizationPort loadOrganizationPort, SaveOrganizationPort saveOrganizationPort) {
        this.loadOrganizationPort = loadOrganizationPort;
        this.saveOrganizationPort = saveOrganizationPort;
    }

    public OrganizationResponse handle(String organizationName) {
        loadOrganizationPort.load(organizationName).ifPresent(org -> {
            throw new RuntimeException(String.format("Organization with name %s already exists", organizationName));
        });
        var newOrg = new Organization(UUID.randomUUID(), organizationName);
        saveOrganizationPort.save(newOrg);
        return new OrganizationResponse(newOrg.organizationId(), newOrg.organizationName(), null);
    }
}
