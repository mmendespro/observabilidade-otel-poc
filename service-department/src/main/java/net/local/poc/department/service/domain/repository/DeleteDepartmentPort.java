package net.local.poc.department.service.domain.repository;

import java.util.UUID;

public interface DeleteDepartmentPort {
    void delete(UUID departmentId);
}
