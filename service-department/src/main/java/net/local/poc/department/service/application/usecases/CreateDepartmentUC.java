package net.local.poc.department.service.application.usecases;

import java.util.UUID;
import java.util.stream.Stream;

import net.local.poc.department.service.application.dto.DepartamentRequest;
import net.local.poc.department.service.application.dto.DepartamentResponse;
import net.local.poc.department.service.domain.model.Department;
import net.local.poc.department.service.domain.repository.LoadDepartmentPort;
import net.local.poc.department.service.domain.repository.SaveDepartmentPort;

public class CreateDepartmentUC {
    
    private final LoadDepartmentPort loadDepartmentPort;
    private final SaveDepartmentPort saveDepartmentPort;

    public CreateDepartmentUC(LoadDepartmentPort loadDepartmentPort, SaveDepartmentPort saveDepartmentPort) {
        this.loadDepartmentPort = loadDepartmentPort;
        this.saveDepartmentPort = saveDepartmentPort;
    }

    public DepartamentResponse handle(DepartamentRequest request) {
        loadDepartmentPort.load(request.departamentName()).ifPresent(dep -> {
            throw new RuntimeException("Department with name = " + dep.departmentName() + " already exist.");
        });
        var department = new Department(UUID.randomUUID(),request.departamentName(), request.organizationId());
        saveDepartmentPort.save(department);
        return new DepartamentResponse(department.departmentId(), department.departmentName(), Stream.empty(), department.organizationId());
    }
}
