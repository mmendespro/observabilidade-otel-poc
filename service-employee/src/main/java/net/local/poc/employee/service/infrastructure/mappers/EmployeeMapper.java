package net.local.poc.employee.service.infrastructure.mappers;

import net.local.poc.employee.service.domain.model.Employee;
import net.local.poc.employee.service.infrastructure.jpa.model.EmployeeJPA;

public abstract class EmployeeMapper {
    
    public static Employee fromJPA(EmployeeJPA employeeJPA) {
        return new Employee(employeeJPA.getEmployeeId(), employeeJPA.getEmployeeName(), employeeJPA.getDepartmentId());
    }

    public static EmployeeJPA fromDomain(Employee employee) {
        return new EmployeeJPA(employee.employeeId(), employee.employeeName(), employee.departmentId());
    }
}
