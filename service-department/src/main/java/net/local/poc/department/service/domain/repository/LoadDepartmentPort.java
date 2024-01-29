package net.local.poc.department.service.domain.repository;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import net.local.poc.department.service.domain.model.Department;

public interface LoadDepartmentPort {
    Stream<Department> load();
    Stream<Department> loadByOrganizationId(UUID organizationId);
    Optional<Department> load(UUID departmentId);
    Optional<Department> load(String departmentName);    
}
