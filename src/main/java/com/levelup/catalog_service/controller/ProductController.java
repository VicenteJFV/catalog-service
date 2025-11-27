package com.levelup.catalog_service.controller;

import com.levelup.catalog_service.model.Product;
import com.levelup.catalog_service.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*") // para permitir peticiones desde la app móvil
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // GET /api/products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // GET /api/products/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/products
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product saved = productRepository.save(product);
        return ResponseEntity.ok(saved);
    }

    // PUT /api/products/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @RequestBody Product productDetails) {

        return productRepository.findById(id)
                .map(existing -> {
                    existing.setName(productDetails.getName());
                    existing.setDescription(productDetails.getDescription());
                    existing.setPrice(productDetails.getPrice());
                    existing.setImageUrl(productDetails.getImageUrl());
                    existing.setStock(productDetails.getStock());
                    existing.setPlatform(productDetails.getPlatform());
                    Product updated = productRepository.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/products/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    productRepository.delete(product);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
