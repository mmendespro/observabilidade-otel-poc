package net.local.poc.employee.service.application.usecases;

import java.util.UUID;

import net.local.poc.employee.service.domain.repository.DeleteEmployeePort;
import net.local.poc.employee.service.domain.repository.LoadEmployeePort;

public class RemoveEmployeeUC {
    
    private final LoadEmployeePort loadEmployeePort;
    private final DeleteEmployeePort deleteEmployeePort;

    public RemoveEmployeeUC(LoadEmployeePort loadEmployeePort, DeleteEmployeePort deleteEmployeePort) {
        this.loadEmployeePort = loadEmployeePort;
        this.deleteEmployeePort = deleteEmployeePort;
    }

    public void handle(UUID employeeId) {
        loadEmployeePort.load(employeeId).orElseThrow(RuntimeException::new);
        deleteEmployeePort.delete(employeeId);
    }
}
