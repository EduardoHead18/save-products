
package com.eduardo.productsapirest.controllers;

import java.util.List;

import com.eduardo.productsapirest.services.Implementation.ProductsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.eduardo.productsapirest.repository.ProductsRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.eduardo.productsapirest.entities.Products;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/v1/products")
public class ProductsController {
    @Autowired


    private ProductsImpl productsImplementation;

    @GetMapping("/")
    public List<Products> getAllProducts() {
      return  productsImplementation.getAllProducts();
    }

    @GetMapping("/{id}")
    public Products getProduct(@PathVariable Long id) {
      return productsImplementation.getProduct(id);
    }
//cok
    @PostMapping("/create")
    public void  createProduct(@RequestBody Products newProduct) {
        productsImplementation.createProduct(newProduct);
    }

    @PutMapping("update/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Products product) {
         productsImplementation.updateProduct(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productsImplementation.deleteProduct(id);
    }

}
