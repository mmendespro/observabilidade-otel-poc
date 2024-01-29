package net.local.poc.employee.service.domain.repository;

import java.util.UUID;

public interface DeleteEmployeePort {
    void delete(UUID employeeId);
}
