package br.dev.mechanime.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.dev.mechanime.demo.entities.Department;
import br.dev.mechanime.demo.repositories.DepartmentRepository;

@Service
public record DepartmentService(DepartmentRepository departmentRepository) {
    
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public void delete(Department department) {
       departmentRepository.delete(department);
    }

    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }
}
