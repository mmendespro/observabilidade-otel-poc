package net.local.poc.department.service.infrastructure.jpa.model;

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
@Table(name = "depatrments")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentJPA implements Serializable {

    @Id
    @Column(name = "PK_DEPARTMENT", nullable = false)
    private UUID departmentId;

    @Column(name = "DS_DEPARTMENT", nullable = false)
    private String departmentName;

    @Column(name = "FK_ORGANIZATION", nullable = false)
    private UUID organizationId;    
}
