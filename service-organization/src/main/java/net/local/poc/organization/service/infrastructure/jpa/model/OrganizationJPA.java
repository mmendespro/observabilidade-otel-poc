package net.local.poc.organization.service.infrastructure.jpa.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "organizations")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationJPA implements Serializable {

    @Id
    @Column(name = "PK_ORGANIZATION", nullable = false)
    private UUID organizationId;

    @Column(name = "DS_ORGANIZATION", nullable = false)
    private String organizationName;
}
