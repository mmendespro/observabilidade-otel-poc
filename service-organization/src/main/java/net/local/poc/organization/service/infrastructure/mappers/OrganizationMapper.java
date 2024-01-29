package net.local.poc.organization.service.infrastructure.mappers;

import net.local.poc.organization.service.domain.model.Organization;
import net.local.poc.organization.service.infrastructure.jpa.model.OrganizationJPA;

public abstract class OrganizationMapper {

    public static Organization of(OrganizationJPA organizationJPA) {
        return new Organization(organizationJPA.getOrganizationId(), organizationJPA.getOrganizationName());
    }

    public static OrganizationJPA of(Organization organization) {
        return new OrganizationJPA(organization.organizationId(), organization.organizationName());
    }
}