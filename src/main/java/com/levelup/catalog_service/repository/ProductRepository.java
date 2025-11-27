package com.levelup.catalog_service.repository;

import com.levelup.catalog_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Aquí puedes agregar métodos custom si los necesitas después
}
