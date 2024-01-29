package net.local.poc.department.service.application.dto;

import java.util.UUID;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public record DepartamentResponse(
    UUID departmentId, 
    String departamentName,
    @JsonInclude(value = Include.NON_EMPTY) 
    Stream<EmployeeDTO> employees,
    UUID organizationId) {
}
