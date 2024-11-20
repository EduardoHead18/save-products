package com.eduardo.productsapirest.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eduardo.productsapirest.persistence.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
