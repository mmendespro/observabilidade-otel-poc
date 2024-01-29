package net.local.poc.organization.service.application.dto;

import java.util.UUID;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonInclude;

public record OrganizationResponse(
    UUID organizationId, 
    String organizationName,
    @JsonInclude(JsonInclude.Include.NON_NULL) 
    Stream<DepartmentDTO> departments) {
}
