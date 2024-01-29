package net.local.poc.organization.service.domain.repository;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import net.local.poc.organization.service.domain.model.Organization;

public interface LoadOrganizationPort {
    
    Stream<Organization> load();
    Optional<Organization> load(UUID organizationId);
    Optional<Organization> load(String organizationName);  
}
