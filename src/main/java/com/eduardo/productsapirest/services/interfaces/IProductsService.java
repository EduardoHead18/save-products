package com.eduardo.productsapirest.services.interfaces;

import com.eduardo.productsapirest.persistence.entities.Products;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IProductsService {
    public ResponseEntity<List<Products>> getAllProducts();
    public Optional<Products> getProduct(Long id);
    public ResponseEntity<Products> createProduct(Products products);
    public void updateProduct(Long id, Products products);
    public ResponseEntity<String> deleteProduct(Long id);

}
