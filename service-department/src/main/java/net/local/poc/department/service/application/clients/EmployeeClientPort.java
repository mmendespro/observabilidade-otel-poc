package net.local.poc.department.service.application.clients;

import java.util.UUID;
import java.util.stream.Stream;

import net.local.poc.department.service.application.dto.EmployeeDTO;

public interface EmployeeClientPort {
    Stream<EmployeeDTO> loadEmployees(UUID departmentId);
}
