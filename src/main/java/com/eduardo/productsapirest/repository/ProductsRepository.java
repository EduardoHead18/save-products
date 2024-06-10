package com.eduardo.productsapirest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eduardo.productsapirest.entities.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {
}
