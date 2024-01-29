package net.local.poc.employee.service.infrastructure.repository;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.local.poc.employee.service.domain.model.Employee;
import net.local.poc.employee.service.domain.repository.DeleteEmployeePort;
import net.local.poc.employee.service.domain.repository.LoadEmployeePort;
import net.local.poc.employee.service.domain.repository.SaveEmployeePort;
import net.local.poc.employee.service.infrastructure.jpa.repository.EmployeeSpringJPARepository;
import net.local.poc.employee.service.infrastructure.mappers.EmployeeMapper;

@Repository
public class EmployeeRepository implements LoadEmployeePort, SaveEmployeePort, DeleteEmployeePort {
    
    private final EmployeeSpringJPARepository repo;

    public EmployeeRepository(EmployeeSpringJPARepository repo) {
        this.repo = repo;
    }

    @Override
    public Stream<Employee> load() {
        return repo.findAll()
                   .stream()
                   .map(jpa -> new Employee(jpa.getEmployeeId(), jpa.getEmployeeName(), jpa.getDepartmentId()));
    }

    @Override
    @Transactional
    public Stream<Employee> loadByDepartment(UUID departmentId) {
        return repo.findByDepartmentId(departmentId).map(jpa -> new Employee(jpa.getEmployeeId(), jpa.getEmployeeName(), jpa.getDepartmentId()));
    }

    @Override
    public Optional<Employee> load(UUID employeeId) {
        var opt = repo.findById(employeeId);
        if(opt.isPresent()) {
            return Optional.of(EmployeeMapper.fromJPA(opt.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Employee> load(String emplyeeName) {
        var opt = repo.findByEmployeeName(emplyeeName);
        if(opt.isPresent()) {
            return Optional.of(EmployeeMapper.fromJPA(opt.get()));
        }
        return Optional.empty();
    }

    @Override
    public void save(Employee employee) {
        repo.save(EmployeeMapper.fromDomain(employee));
    }

    @Override
    public void delete(UUID employeeId) {
        repo.deleteById(employeeId);
    }
}
