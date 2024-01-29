package net.local.poc.organization.service.infrastructure.jpa.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import net.local.poc.organization.service.infrastructure.jpa.model.OrganizationJPA;

public interface OrganizationSpringJPARepository extends JpaRepository<OrganizationJPA, UUID> {

    Optional<OrganizationJPA> findByOrganizationName(String departmentName); 
}
