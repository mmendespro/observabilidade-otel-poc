package net.local.poc.employee.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.local.poc.employee.service.application.usecases.CreateEmployeeUC;
import net.local.poc.employee.service.application.usecases.DetailEmployeeUC;
import net.local.poc.employee.service.application.usecases.ListEmployeeUC;
import net.local.poc.employee.service.application.usecases.LoadByDepartmentUC;
import net.local.poc.employee.service.application.usecases.RemoveEmployeeUC;
import net.local.poc.employee.service.domain.repository.DeleteEmployeePort;
import net.local.poc.employee.service.domain.repository.LoadEmployeePort;
import net.local.poc.employee.service.domain.repository.SaveEmployeePort;

@Configuration
public class ApplicationConfig {
    
    @Bean
    public ListEmployeeUC listEmployeeUC (LoadEmployeePort loadEmployeePort) {
        return new ListEmployeeUC(loadEmployeePort);
    }

    @Bean
    public LoadByDepartmentUC loadByDepartmentUC(LoadEmployeePort loadEmployeePort) {
        return new LoadByDepartmentUC(loadEmployeePort);
    }

    @Bean
    public DetailEmployeeUC detailEmployeeUC(LoadEmployeePort loadEmployeePort) {
        return new DetailEmployeeUC(loadEmployeePort);
    }

    @Bean
    public CreateEmployeeUC createEmployeeUC(LoadEmployeePort loadEmployeePort, SaveEmployeePort saveEmployeePort) {
        return new CreateEmployeeUC(loadEmployeePort, saveEmployeePort);
    }

    @Bean
    public RemoveEmployeeUC removeEmployeeUC(LoadEmployeePort loadEmployeePort, DeleteEmployeePort deleteEmployeePort) {
        return new RemoveEmployeeUC(loadEmployeePort, deleteEmployeePort);
    }
}
