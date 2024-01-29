package net.local.poc.department.service.infrastructure.mappers;

import net.local.poc.department.service.domain.model.Department;
import net.local.poc.department.service.infrastructure.jpa.model.DepartmentJPA;

public abstract class DepartmentMapper {
    
    public static Department of(DepartmentJPA departmentJPA) {
        return new Department(departmentJPA.getDepartmentId(), departmentJPA.getDepartmentName(), departmentJPA.getOrganizationId());
    }

    public static DepartmentJPA of(Department department) {
        return new DepartmentJPA(department.departmentId(), department.departmentName(), department.organizationId());
    }
}
