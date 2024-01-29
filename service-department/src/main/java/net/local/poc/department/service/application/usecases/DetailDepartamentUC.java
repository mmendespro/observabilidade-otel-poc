package net.local.poc.department.service.application.usecases;

import java.util.UUID;

import net.local.poc.department.service.application.clients.EmployeeClientPort;
import net.local.poc.department.service.application.dto.DepartamentResponse;
import net.local.poc.department.service.domain.repository.LoadDepartmentPort;

public class DetailDepartamentUC {
    
    private final EmployeeClientPort employeeClientPort;
    private final LoadDepartmentPort loadDepartmentPort;

    public DetailDepartamentUC(EmployeeClientPort employeeClientPort, LoadDepartmentPort loadDepartmentPort) {
        this.employeeClientPort = employeeClientPort;
        this.loadDepartmentPort = loadDepartmentPort;
    }

    public DepartamentResponse handle(UUID departamentId) {
        var department = loadDepartmentPort.load(departamentId).orElseThrow(() -> new RuntimeException("Department with Id = " + departamentId.toString() + "does not exist.") );
        var employees = employeeClientPort.loadEmployees(departamentId);
        return new DepartamentResponse(department.departmentId(), department.departmentName(), employees, department.organizationId());
    }
}
