package net.local.poc.department.service.presentation.api;

import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.local.poc.department.service.application.dto.DepartamentRequest;
import net.local.poc.department.service.application.dto.DepartamentResponse;
import net.local.poc.department.service.application.usecases.CreateDepartmentUC;
import net.local.poc.department.service.application.usecases.DetailDepartamentUC;
import net.local.poc.department.service.application.usecases.ListByOrganizationUC;
import net.local.poc.department.service.application.usecases.ListDepartamentUC;

@Slf4j
@RestController
@RequestMapping("/v1/department")
public class DepartmentController {
    
    private final ListDepartamentUC listDepartamentUC;
    private final ListByOrganizationUC listByOrganizationUC;
    private final CreateDepartmentUC createDepartmentUC;
    private final DetailDepartamentUC detailDepartamentUC;

    public DepartmentController(ListDepartamentUC listDepartamentUC, ListByOrganizationUC listByOrganizationUC,
            CreateDepartmentUC createDepartmentUC, DetailDepartamentUC detailDepartamentUC) {
        this.listDepartamentUC = listDepartamentUC;
        this.listByOrganizationUC = listByOrganizationUC;
        this.createDepartmentUC = createDepartmentUC;
        this.detailDepartamentUC = detailDepartamentUC;
    }

    @GetMapping
    public ResponseEntity<Stream<DepartamentResponse>> listDepartments() {
        log.info("Request for list all departments");
        return ResponseEntity.ok(listDepartamentUC.handle());
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartamentResponse> detailDepartment(@PathVariable UUID departmentId) {
        log.info("Request for detail departmentId {}", departmentId);
        return ResponseEntity.ok(detailDepartamentUC.handle(departmentId));
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<Stream<DepartamentResponse>> loadDepartmentsByOrganization(@PathVariable UUID organizationId) {
        log.info("Request for list departments by organizationId {}", organizationId);
        return ResponseEntity.ok(listByOrganizationUC.handle(organizationId));
    }    

    @PostMapping
    public ResponseEntity<DepartamentResponse> createDepartment(@RequestBody DepartamentRequest request) {
        log.info("Request for create new department {}", request);
        return ResponseEntity.ok(createDepartmentUC.handle(request));
    }
}
