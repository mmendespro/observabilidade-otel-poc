package net.local.poc.department.service.infrastructure.repository;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import net.local.poc.department.service.domain.model.Department;
import net.local.poc.department.service.domain.repository.DeleteDepartmentPort;
import net.local.poc.department.service.domain.repository.LoadDepartmentPort;
import net.local.poc.department.service.domain.repository.SaveDepartmentPort;
import net.local.poc.department.service.infrastructure.jpa.repository.DepartmentSpringJPARepository;
import net.local.poc.department.service.infrastructure.mappers.DepartmentMapper;

@Repository
public class DepartmentRepository implements LoadDepartmentPort, SaveDepartmentPort, DeleteDepartmentPort {

    private final DepartmentSpringJPARepository repository;
    
    public DepartmentRepository(DepartmentSpringJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public Stream<Department> load() {
        return repository.findAll()
                         .stream()
                         .map(jpa -> DepartmentMapper.of(jpa));
    }

    @Override @Transactional
    public Stream<Department> loadByOrganizationId(UUID organizationId) {
        return repository.findByOrganizationId(organizationId)
                         .map(jpa -> DepartmentMapper.of(jpa));
    }

    @Override
    public Optional<Department> load(UUID departmentId) {
        var jpa = repository.findById(departmentId);
        if(jpa.isPresent()) {
            return Optional.of(DepartmentMapper.of(jpa.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Department> load(String departmentName) {
        var jpa = repository.findByDepartmentName(departmentName);
        if(jpa.isPresent()) {
            return Optional.of(DepartmentMapper.of(jpa.get()));
        }
        return Optional.empty();
    }

    @Override
    public void save(Department department) {
        repository.save(DepartmentMapper.of(department));
    }

    @Override
    public void delete(UUID departmentId) {
        repository.deleteById(departmentId);
    }
    
}
