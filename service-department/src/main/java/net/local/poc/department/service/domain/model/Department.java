package net.local.poc.department.service.domain.model;

import java.util.UUID;

public record Department(UUID departmentId, String departmentName, UUID organizationId) {
}
