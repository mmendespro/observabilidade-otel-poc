package net.local.poc.organization.service.application.clients;

import java.util.UUID;
import java.util.stream.Stream;

import net.local.poc.organization.service.application.dto.DepartmentDTO;

public interface DepartmentClientPort {
    Stream<DepartmentDTO> loadDepartments(UUID organizationId);
}
