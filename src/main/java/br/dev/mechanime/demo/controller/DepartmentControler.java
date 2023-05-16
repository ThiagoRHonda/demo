package br.dev.mechanime.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.mechanime.demo.entities.Department;
import br.dev.mechanime.demo.repositories.DepartmentRepository;
import br.dev.mechanime.demo.service.DepartmentService;

@RestController
@RequestMapping(value = "/department")
public class DepartmentControler {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getObjects() {
        /*Department d1 = new Department(1L, "Tech");
        Department d2 = new Department(2L, "Pet");

        Product p1 = new Product(1L,4000.0,"Macbook Pro", d1);
        Product p2 = new Product(2L,5000.0, "PC Gamer", d1);
        Product p3 = new Product(3L,300.0, "Pet House", d2); */

        List<Department> list = departmentRepository.findAll();
        return list;
    }

    @PostMapping
    public Department save(@RequestBody Department product) {
        return departmentService.save(product);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
        Optional<Department> departmentOptional = departmentService.findById(id);
        departmentService.delete(departmentOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Departamento excluido com sucesso");
    } 
    
}
