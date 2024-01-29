package net.local.poc.organization.service.domain.model;

import java.util.UUID;

public record Organization(UUID organizationId, String organizationName) {
}
