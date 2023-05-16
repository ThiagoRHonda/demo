package br.dev.mechanime.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.mechanime.demo.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
    
}
