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

import br.dev.mechanime.demo.entities.Product;
import br.dev.mechanime.demo.repositories.ProductRepository;
import br.dev.mechanime.demo.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getObjects() {
        /*Department d1 = new Department(1L, "Tech");
        Department d2 = new Department(2L, "Pet");

        Product p1 = new Product(1L,4000.0,"Macbook Pro", d1);
        Product p2 = new Product(2L,5000.0, "PC Gamer", d1);
        Product p3 = new Product(3L,300.0, "Pet House", d2); */

        List<Product> list = productRepository.findAll();
        return list;
    }

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
        Optional<Product> productOptional = productService.findById(id);
        productService.delete(productOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto excluido com sucesso");
    } 
    
}
