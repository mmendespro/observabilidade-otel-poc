package net.local.poc.organization.service.domain.repository;

import java.util.UUID;

public interface DeleteOrganizationPort {
    void delete(UUID organizationId);
}
