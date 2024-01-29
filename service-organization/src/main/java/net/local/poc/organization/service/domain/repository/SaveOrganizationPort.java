package net.local.poc.organization.service.domain.repository;

import net.local.poc.organization.service.domain.model.Organization;

public interface SaveOrganizationPort {
    void save(Organization organization);
}
