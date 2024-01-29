package net.local.poc.department.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.local.poc.department.service.application.clients.EmployeeClientPort;
import net.local.poc.department.service.application.usecases.CreateDepartmentUC;
import net.local.poc.department.service.application.usecases.DetailDepartamentUC;
import net.local.poc.department.service.application.usecases.ListByOrganizationUC;
import net.local.poc.department.service.application.usecases.ListDepartamentUC;
import net.local.poc.department.service.domain.repository.LoadDepartmentPort;
import net.local.poc.department.service.domain.repository.SaveDepartmentPort;

@Configuration
public class ApplicationConfig {

    @Bean
    public ListDepartamentUC listDepartamentUC(LoadDepartmentPort loadDepartmentPort) {
        return new ListDepartamentUC(loadDepartmentPort);    
    }

    @Bean
    public DetailDepartamentUC detailDepartamentUC(EmployeeClientPort employeeClientPort, LoadDepartmentPort loadDepartmentPort) {
        return new DetailDepartamentUC(employeeClientPort, loadDepartmentPort);
    }

    @Bean
    public CreateDepartmentUC createDepartmentUC(LoadDepartmentPort loadDepartmentPort, SaveDepartmentPort saveDepartmentPort) {
        return new CreateDepartmentUC(loadDepartmentPort, saveDepartmentPort);
    }

    @Bean
    public ListByOrganizationUC listByOrganizationUC(EmployeeClientPort employeeClientPort, LoadDepartmentPort loadDepartmentPort) {
        return new ListByOrganizationUC(employeeClientPort, loadDepartmentPort);
    }
}
