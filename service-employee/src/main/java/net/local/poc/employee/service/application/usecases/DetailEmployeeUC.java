package net.local.poc.employee.service.application.usecases;

import java.util.UUID;

import net.local.poc.employee.service.application.dto.EmployeeResponse;
import net.local.poc.employee.service.domain.repository.LoadEmployeePort;

public class DetailEmployeeUC {
    
    private final LoadEmployeePort loadEmployeePort;

    public DetailEmployeeUC(LoadEmployeePort loadEmployeePort) {
        this.loadEmployeePort = loadEmployeePort;
    }

    public EmployeeResponse handle(UUID employeeId) {
        var emp = loadEmployeePort.load(employeeId).orElseThrow(RuntimeException::new);
        return new EmployeeResponse(emp.employeeId().toString(), emp.employeeName(), emp.employeeId().toString());
    }
}
