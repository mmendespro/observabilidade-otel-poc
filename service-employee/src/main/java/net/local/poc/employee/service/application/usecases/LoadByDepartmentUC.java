package net.local.poc.employee.service.application.usecases;

import java.util.UUID;
import java.util.stream.Stream;

import net.local.poc.employee.service.application.dto.EmployeeResponse;
import net.local.poc.employee.service.domain.repository.LoadEmployeePort;

public class LoadByDepartmentUC {
    
    private final LoadEmployeePort loadEmployeePort;

    public LoadByDepartmentUC(LoadEmployeePort loadEmployeePort) {
        this.loadEmployeePort = loadEmployeePort;
    }

    public Stream<EmployeeResponse> handle(UUID departmentId) {
        var results = loadEmployeePort.loadByDepartment(departmentId);
        return results.map(emp -> new EmployeeResponse(emp.employeeId().toString(), emp.employeeName(), emp.departmentId().toString()));
    }
}
