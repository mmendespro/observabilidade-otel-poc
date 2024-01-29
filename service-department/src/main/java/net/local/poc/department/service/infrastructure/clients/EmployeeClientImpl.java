package net.local.poc.department.service.infrastructure.clients;

import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import net.local.poc.department.service.application.clients.EmployeeClientPort;
import net.local.poc.department.service.application.dto.EmployeeDTO;

@Slf4j
@Component
public class EmployeeClientImpl implements EmployeeClientPort {

    private final String BASE_URL;
    
    public EmployeeClientImpl(@Value("${clients.service-employee}") String baseUrl) {
        BASE_URL = baseUrl;
    }

    @Override
    public Stream<EmployeeDTO> loadEmployees(UUID departmentId) {
        log.info("Loading employees for department {}", departmentId);
        return getWebClient().get()
                             .uri(uriBuilder -> uriBuilder.path("/department/{departmentId}").build(departmentId))
                             .retrieve()
                             .bodyToFlux(EmployeeDTO.class)
                             .toStream();
    }

    private WebClient getWebClient() {
        return  WebClient.builder()
                         .baseUrl(BASE_URL)
                         .build();
    }    
}
