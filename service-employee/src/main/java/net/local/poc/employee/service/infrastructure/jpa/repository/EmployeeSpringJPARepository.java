package net.local.poc.employee.service.infrastructure.jpa.repository;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import net.local.poc.employee.service.infrastructure.jpa.model.EmployeeJPA;

public interface EmployeeSpringJPARepository extends JpaRepository<EmployeeJPA, UUID> {

    Optional<EmployeeJPA> findByEmployeeName(String employeeName); 
    Stream<EmployeeJPA> findByDepartmentId(UUID departmentId);
}
