package net.local.poc.organization.service.application.dto;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public record DepartmentDTO(
    UUID departmentId, 
    @JsonProperty(value = "departamentName")
    String departmentName,
    @JsonInclude(JsonInclude.Include.NON_NULL) 
    List<EmployeeDTO> employees) {
}
