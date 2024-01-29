package net.local.poc.employee.service.domain.model;

import java.util.UUID;

public record Employee(UUID employeeId, String employeeName, UUID departmentId) {
}
