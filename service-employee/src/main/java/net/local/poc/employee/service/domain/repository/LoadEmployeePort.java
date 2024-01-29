package net.local.poc.employee.service.domain.repository;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import net.local.poc.employee.service.domain.model.Employee;

public interface LoadEmployeePort {
    Stream<Employee> load();
    Stream<Employee> loadByDepartment(UUID departmentId);
    Optional<Employee> load(UUID employeeId);
    Optional<Employee> load(String emplyeeName);
}
