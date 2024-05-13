
package com.eduardo.productsapirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.productsapirest.repository.ProductsRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.eduardo.productsapirest.entities.Products;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

;

@RestController
@RequestMapping("/v1/products")
public class ProductsController {
    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("/")
    public List<Products> getAllProducts() {
        try {
            List<Products> responseAllProducts = productsRepository.findAll();
            return responseAllProducts;
        } catch (Exception e) {
            throw new RuntimeException("Error when obtaining the products ", e);
        }
    }

    @GetMapping("/{id}")
    public Products getProduct(@PathVariable Long id) {
        Products product = productsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("This id is'n  exist"));
        return product;
    }

    @PostMapping("/create")
    public String createProduct(@RequestBody Products newProduct) {
        try {
            productsRepository.save(newProduct);
            return "The product was created successfully.";
        } catch (Exception e) {
            throw new RuntimeException("Error craeting a new product", e);
        }
    }

    @PutMapping("update/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody Products product) {
        try {
            Products productUpdate = getProduct(id);
            if (productUpdate != null) {
                productsRepository.save(product);
                return "The product was updated successfully.";
            }
            return "The product was updated successfully.";
        } catch (Exception e) {
            throw new RuntimeException("Error updating the product", e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        try {
            if (getProduct(id) != null) {
                productsRepository.deleteById(id);
                return "The product was deleted successfully.";
            }
            return "";
        } catch (Exception e) {
            throw new RuntimeException("Error deleting product " + e);
        }
    }

}
