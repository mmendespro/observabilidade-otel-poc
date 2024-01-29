package net.local.poc.department.service.application.usecases;

import java.util.UUID;
import java.util.stream.Stream;

import net.local.poc.department.service.application.clients.EmployeeClientPort;
import net.local.poc.department.service.application.dto.DepartamentResponse;
import net.local.poc.department.service.domain.repository.LoadDepartmentPort;

public class ListByOrganizationUC {
    
    private final EmployeeClientPort employeeClientPort;
    private final LoadDepartmentPort loadDepartmentPort;

    public ListByOrganizationUC(EmployeeClientPort employeeClientPort, LoadDepartmentPort loadDepartmentPort) {
        this.employeeClientPort = employeeClientPort;
        this.loadDepartmentPort = loadDepartmentPort;
    }

    public Stream<DepartamentResponse> handle(UUID organizationId) {
        var departments = loadDepartmentPort.loadByOrganizationId(organizationId);
        var result = departments.map(dep -> new DepartamentResponse(dep.departmentId(), dep.departmentName(), employeeClientPort.loadEmployees(dep.departmentId()), dep.organizationId()));
        return result;
    }
}
