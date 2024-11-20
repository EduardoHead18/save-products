package com.eduardo.productsapirest.services.interfaces;

import com.eduardo.productsapirest.persistence.entities.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public Optional<List<Product>> getAllProducts();
    public Optional<Product> getProduct(Long id);
    public ResponseEntity<Product> createProduct(Product product);
    public Optional<Product> updateProduct(Long id, Product product);
    public Optional<String> deleteProduct(Long id);

}
