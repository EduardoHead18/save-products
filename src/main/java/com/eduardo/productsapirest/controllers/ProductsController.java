
package com.eduardo.productsapirest.controllers;

import java.util.List;

import com.eduardo.productsapirest.services.Implementation.ProductsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// import com.eduardo.productsapirest.repository.ProductsRepository;

import com.eduardo.productsapirest.entities.Products;

@RestController
@RequestMapping("/v1/products")
public class ProductsController {
    @Autowired
    private ProductsImpl productsImplementation;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Products>> getAllProducts() {
      return  productsImplementation.getAllProducts();
    }

    @GetMapping("/{id}")
    public Products getProduct(@PathVariable Long id) {
      return productsImplementation.getProduct(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Products> createProduct(@Valid  @RequestBody Products newProduct) {
       return  productsImplementation.createProduct(newProduct);
    }

    @PutMapping("update/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Products product) {
         productsImplementation.updateProduct(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        return productsImplementation.deleteProduct(id);
    }

}
