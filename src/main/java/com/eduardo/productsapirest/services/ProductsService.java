package com.eduardo.productsapirest.services;

import com.eduardo.productsapirest.entities.Products;

import java.util.List;

public interface ProductsService {
    public List<Products> getAllProducts();
    public Products getProduct(Long id);
    public void createProduct(Products products);
    public void updateProduct(Long id, Products products);
    public void deleteProduct(Long id);

}
