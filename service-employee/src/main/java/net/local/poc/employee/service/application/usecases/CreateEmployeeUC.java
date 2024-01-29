package net.local.poc.employee.service.application.usecases;

import java.util.UUID;

import net.local.poc.employee.service.application.dto.EmployeeRequest;
import net.local.poc.employee.service.application.dto.EmployeeResponse;
import net.local.poc.employee.service.domain.model.Employee;
import net.local.poc.employee.service.domain.repository.LoadEmployeePort;
import net.local.poc.employee.service.domain.repository.SaveEmployeePort;

public class CreateEmployeeUC {
    
    private final LoadEmployeePort loadEmployeePort;
    private final SaveEmployeePort saveEmployeePort;

    public CreateEmployeeUC(LoadEmployeePort loadEmployeePort, SaveEmployeePort saveEmployeePort) {
        this.loadEmployeePort = loadEmployeePort;
        this.saveEmployeePort = saveEmployeePort;
    }

    public EmployeeResponse handle(EmployeeRequest request) {
        loadEmployeePort.load(request.employeeName()).ifPresent(emp -> {
            throw new RuntimeException("Employee "+request.employeeName()+" already exists.");
        });

        var newEmp = new Employee(UUID.randomUUID(), request.employeeName(), UUID.fromString(request.departmentId()));

        saveEmployeePort.save(newEmp);

        return new EmployeeResponse(newEmp.employeeId().toString(), newEmp.employeeName(), newEmp.departmentId().toString());
    }
}
