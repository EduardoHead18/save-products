package com.eduardo.productsapirest.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eduardo.productsapirest.persistence.entities.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {
}
