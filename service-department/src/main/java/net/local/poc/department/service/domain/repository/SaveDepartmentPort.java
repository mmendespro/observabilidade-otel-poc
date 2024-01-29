package net.local.poc.department.service.domain.repository;

import net.local.poc.department.service.domain.model.Department;

public interface SaveDepartmentPort {
    void save(Department department);
}
