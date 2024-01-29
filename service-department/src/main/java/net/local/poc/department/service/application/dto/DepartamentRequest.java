package net.local.poc.department.service.application.dto;

import java.util.UUID;

public record DepartamentRequest(String departamentName, UUID organizationId) {
}
