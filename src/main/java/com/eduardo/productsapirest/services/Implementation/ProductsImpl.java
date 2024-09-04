package com.eduardo.productsapirest.services.Implementation;

import com.eduardo.productsapirest.entities.Products;
import com.eduardo.productsapirest.exception.RequestException;
import com.eduardo.productsapirest.repository.ProductsRepository;
import com.eduardo.productsapirest.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductsImpl implements ProductsService {
    @Autowired
    ProductsRepository productsRepository;

    @Override
    public List<Products> getAllProducts() {
        try {
            List<Products> responseAllProducts = productsRepository.findAll();
            return responseAllProducts;
        } catch (Exception e) {
            throw new RequestException("400","Algo salio mal");
        }
    }

    @Override
    public Products getProduct(Long id) {
        Products product = productsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("This id is'n  exist"));
        return product;
    }

    @Override
    public void createProduct(Products products) {
        try {
            productsRepository.save(products);
        } catch (Exception e) {
            throw new RuntimeException("Error craeting a new product", e);
        }

    }

    @Override
    public void updateProduct(Long id, Products products) {
        try {
            Products productUpdate = getProduct(id);
            if (productUpdate != null) {
//                productUpdate.setName(product.getName());
//                productUpdate.setPrice(product.getPrice());
//                productsRepository.save(productUpdate);
//                System.out.println(productUpdate.getName());
                productsRepository.save(products);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error updating the product", e);
        }
    }

    @Override
    public void deleteProduct(Long id) {
        try {
            if (getProduct(id) != null) {
                productsRepository.deleteById(id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error deleting product " + e);
        }
    }

}
