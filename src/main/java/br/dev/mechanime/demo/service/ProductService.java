package br.dev.mechanime.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.dev.mechanime.demo.entities.Product;
import br.dev.mechanime.demo.repositories.ProductRepository;

@Service
public record ProductService(ProductRepository productRepository) {
    
    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Product product) {
       productRepository.delete(product);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
