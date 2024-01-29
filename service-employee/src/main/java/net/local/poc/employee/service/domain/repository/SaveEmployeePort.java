package net.local.poc.employee.service.domain.repository;

import net.local.poc.employee.service.domain.model.Employee;

public interface SaveEmployeePort {
    void save(Employee employee);
}
