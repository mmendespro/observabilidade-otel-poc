package net.local.poc.department.service.infrastructure.jpa.repository;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import net.local.poc.department.service.infrastructure.jpa.model.DepartmentJPA;

public interface DepartmentSpringJPARepository extends JpaRepository<DepartmentJPA, UUID> {

    Optional<DepartmentJPA> findByDepartmentName(String departmentName); 
    Stream<DepartmentJPA> findByOrganizationId(UUID departmentId);
}
