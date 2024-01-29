package net.local.poc.employee.service.infrastructure.jpa.model;

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
@Table(name = "employees")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeJPA implements Serializable {
    
    @Id
    @Column(name = "PK_EMPLOYEE", nullable = false)
    private UUID employeeId;

    @Column(name = "DS_EMPLOYEE", nullable = false)
    private String employeeName;

    @Column(name = "FK_DEPARTMENT", nullable = false)
    private UUID departmentId;
}
