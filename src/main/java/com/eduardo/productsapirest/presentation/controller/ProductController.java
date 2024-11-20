
package com.eduardo.productsapirest.presentation.controller;

import java.util.List;
import java.util.Optional;

import com.eduardo.productsapirest.services.Implementation.ProductImpl;
import com.eduardo.productsapirest.services.interfaces.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// import com.eduardo.productsapirest.repository.ProductsRepository;

import com.eduardo.productsapirest.persistence.entities.Product;

@RestController
@RequestMapping("/v1/products")
public class ProductController implements IProductService {
    @Autowired
    private ProductImpl productImplementation;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Optional<List<Product>> getAllProducts() {
      return  productImplementation.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable Long id){
      return productImplementation.getProduct(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product newProduct) {
       return  productImplementation.createProduct(newProduct);
    }

    @PutMapping("update/{id}")
    public Optional<Product> updateProduct(@Valid @PathVariable Long id, @RequestBody Product product) {
         return productImplementation.updateProduct(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public Optional<String> deleteProduct(@PathVariable Long id) {
        return  productImplementation.deleteProduct(id);
    }

}
