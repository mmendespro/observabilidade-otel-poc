package net.local.poc.employee.service.presentation.api;

import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.local.poc.employee.service.application.dto.EmployeeRequest;
import net.local.poc.employee.service.application.dto.EmployeeResponse;
import net.local.poc.employee.service.application.usecases.CreateEmployeeUC;
import net.local.poc.employee.service.application.usecases.DetailEmployeeUC;
import net.local.poc.employee.service.application.usecases.ListEmployeeUC;
import net.local.poc.employee.service.application.usecases.LoadByDepartmentUC;
import net.local.poc.employee.service.application.usecases.RemoveEmployeeUC;

@Slf4j
@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {
    
    private final ListEmployeeUC listEmployeeUC;
    private final LoadByDepartmentUC loadByDepartmentUC;
    private final DetailEmployeeUC detailEmployeeUC;
    private final CreateEmployeeUC createEmployeeUC;
    private final RemoveEmployeeUC removeEmployeeUC;

    public EmployeeController(ListEmployeeUC listEmployeeUC, LoadByDepartmentUC loadByDepartmentUC,
            DetailEmployeeUC detailEmployeeUC, CreateEmployeeUC createEmployeeUC, RemoveEmployeeUC removeEmployeeUC) {
        this.listEmployeeUC = listEmployeeUC;
        this.loadByDepartmentUC = loadByDepartmentUC;
        this.detailEmployeeUC = detailEmployeeUC;
        this.createEmployeeUC = createEmployeeUC;
        this.removeEmployeeUC = removeEmployeeUC;
    }

    @GetMapping
    public ResponseEntity<Stream<EmployeeResponse>> listEmployees() {
        log.info("Request for list all employees");
        return ResponseEntity.ok(listEmployeeUC.handle());
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponse> detailEmployee(@PathVariable UUID employeeId) {
        log.info("Request for detail employee {}", employeeId);
        return ResponseEntity.ok(detailEmployeeUC.handle(employeeId));
    }
    
    @GetMapping("/department/{departmentId}")
    public ResponseEntity<Stream<EmployeeResponse>> loadEmployeeByDepartment(@PathVariable UUID departmentId) {
        log.info("Request for list employees by department {}", departmentId);
        return ResponseEntity.ok(loadByDepartmentUC.handle(departmentId));
    }
    
    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest request) {
        log.info("Request for create new employee {}", request);
        return ResponseEntity.ok(createEmployeeUC.handle(request));
    }
    
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<HttpStatusCode> deleteEmployee(@PathVariable UUID employeeId) {
        log.info("Request for delete employee {}", employeeId);
        removeEmployeeUC.handle(employeeId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
