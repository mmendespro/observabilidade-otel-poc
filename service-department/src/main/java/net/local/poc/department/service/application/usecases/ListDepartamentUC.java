package net.local.poc.department.service.application.usecases;


import java.util.stream.Stream;

import net.local.poc.department.service.application.dto.DepartamentResponse;
import net.local.poc.department.service.domain.repository.LoadDepartmentPort;

public class ListDepartamentUC {
    
    private final LoadDepartmentPort loadDepartmentPort;

    public ListDepartamentUC(LoadDepartmentPort loadDepartmentPort) {
        this.loadDepartmentPort = loadDepartmentPort;
    }

    public Stream<DepartamentResponse> handle() {
        return loadDepartmentPort.load()
                                 .map(dep -> new DepartamentResponse(dep.departmentId(), dep.departmentName(), Stream.empty(), dep.organizationId()));
    }
}
