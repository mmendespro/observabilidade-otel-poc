package net.local.poc.organization.service.infrastructure.repository;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import net.local.poc.organization.service.domain.model.Organization;
import net.local.poc.organization.service.domain.repository.LoadOrganizationPort;
import net.local.poc.organization.service.domain.repository.SaveOrganizationPort;
import net.local.poc.organization.service.infrastructure.jpa.repository.OrganizationSpringJPARepository;
import net.local.poc.organization.service.infrastructure.mappers.OrganizationMapper;

@Repository
public class OrganizationRepository implements LoadOrganizationPort, SaveOrganizationPort {

    private final OrganizationSpringJPARepository repository;

    public OrganizationRepository(OrganizationSpringJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public Stream<Organization> load() {
        return repository.findAll()
                         .stream()
                         .map(jpa -> OrganizationMapper.of(jpa));
    }

    @Override
    public Optional<Organization> load(UUID organizationId) {
        var jpa = repository.findById(organizationId);
        if (jpa.isPresent()) {
            return Optional.of(OrganizationMapper.of(jpa.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Organization> load(String organizationName) {
        var jpa = repository.findByOrganizationName(organizationName);
        if (jpa.isPresent()) {
            return Optional.of(OrganizationMapper.of(jpa.get()));
        }
        return Optional.empty();
    }

    @Override
    public void save(Organization organization) {
        repository.save(OrganizationMapper.of(organization));
    }
    
}
