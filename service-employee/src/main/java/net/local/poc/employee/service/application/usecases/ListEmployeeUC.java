package net.local.poc.employee.service.application.usecases;

import java.util.stream.Stream;

import net.local.poc.employee.service.application.dto.EmployeeResponse;
import net.local.poc.employee.service.domain.repository.LoadEmployeePort;

public class ListEmployeeUC {
    
    private final LoadEmployeePort loadEmployeePort;

    public ListEmployeeUC(LoadEmployeePort loadEmployeePort) {
        this.loadEmployeePort = loadEmployeePort;
    }

    public Stream<EmployeeResponse> handle() {
        return loadEmployeePort.load().map(emp -> new EmployeeResponse(emp.employeeId().toString(), emp.employeeName(), emp.departmentId().toString()));
    }
}
