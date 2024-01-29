package net.local.poc.organization.service.infrastructure.clients;

import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import net.local.poc.organization.service.application.clients.DepartmentClientPort;
import net.local.poc.organization.service.application.dto.DepartmentDTO;

@Slf4j
@Component
public class DepartmentClientImpl implements DepartmentClientPort {

    private final String BASE_URL;
    
    public DepartmentClientImpl(@Value("${clients.service-department}") String baseUrl) {
        BASE_URL = baseUrl;
    }

    @Override
    public Stream<DepartmentDTO> loadDepartments(UUID organizationId) {
        log.info("Loading departments for organization {}", organizationId);
        return getWebClient().get()
                             .uri(uriBuilder -> uriBuilder.path("/organization/{organizationId}").build(organizationId))
                             .retrieve()
                             .bodyToFlux(DepartmentDTO.class)
                             .toStream();        
    }
    
    private WebClient getWebClient() {
        return  WebClient.builder()
                         .baseUrl(BASE_URL)
                         .build();
    }
}
