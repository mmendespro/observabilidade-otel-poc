package net.local.poc.organization.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.local.poc.organization.service.application.clients.DepartmentClientPort;
import net.local.poc.organization.service.application.usecases.CreateOrganizationUC;
import net.local.poc.organization.service.application.usecases.ListOrganizationUC;
import net.local.poc.organization.service.domain.repository.LoadOrganizationPort;
import net.local.poc.organization.service.domain.repository.SaveOrganizationPort;

@Configuration
public class ApplicationConfig {

    @Bean
    public ListOrganizationUC listOrganizationUC(DepartmentClientPort departmentClientPort, LoadOrganizationPort loadOrganizationPort) {
        return new ListOrganizationUC(departmentClientPort, loadOrganizationPort);
    }

    @Bean
    public CreateOrganizationUC createOrganizationUC(LoadOrganizationPort loadOrganizationPort, SaveOrganizationPort saveOrganizationPort) {
        return new CreateOrganizationUC(loadOrganizationPort, saveOrganizationPort);
    }
}
