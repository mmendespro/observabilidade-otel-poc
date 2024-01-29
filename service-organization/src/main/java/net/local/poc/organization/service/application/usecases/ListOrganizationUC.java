package net.local.poc.organization.service.application.usecases;

import java.util.stream.Stream;

import net.local.poc.organization.service.application.clients.DepartmentClientPort;
import net.local.poc.organization.service.application.dto.OrganizationResponse;
import net.local.poc.organization.service.domain.repository.LoadOrganizationPort;

public class ListOrganizationUC {

    private final DepartmentClientPort departmentClientPort;
    private final LoadOrganizationPort loadOrganizationPort;

    public ListOrganizationUC(DepartmentClientPort departmentClientPort, LoadOrganizationPort loadOrganizationPort) {
        this.departmentClientPort = departmentClientPort;
        this.loadOrganizationPort = loadOrganizationPort;
    }

    public Stream<OrganizationResponse> handle() {
        var organizations = loadOrganizationPort.load();
        return organizations.map(org -> new OrganizationResponse(org.organizationId(), org.organizationName(), departmentClientPort.loadDepartments(org.organizationId())));
    }
}
