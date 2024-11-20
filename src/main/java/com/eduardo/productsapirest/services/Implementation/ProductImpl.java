package com.eduardo.productsapirest.services.Implementation;

import com.eduardo.productsapirest.persistence.entities.Product;
import com.eduardo.productsapirest.services.exception.ProductException;
import com.eduardo.productsapirest.persistence.repository.ProductRepository;
import com.eduardo.productsapirest.services.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductImpl implements IProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Optional<List<Product>> getAllProducts() throws ProductException {
            List<Product> responseAllProducts = productRepository.findAll();
            if(responseAllProducts.isEmpty()) throw new ProductException("no record of products", HttpStatus.NOT_FOUND);
            return Optional.of(responseAllProducts);
    }

    @Override

    public Optional<Product> getProduct(Long id) throws ProductException {
        Optional<Product>  products = productRepository.findById(id);
        if(products.isEmpty()) throw new ProductException("The product doesn't exist", HttpStatus.NOT_FOUND);
        return productRepository.findById(id);
    }

    @Override
    public ResponseEntity<Product> createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @Override
    public Optional<Product> updateProduct(Long id, Product product) throws ProductException {

            Optional<Product> productOption = getProduct(id);
            if(productOption.isEmpty()) throw  new ProductException("The product doesn't exist", HttpStatus.NOT_FOUND);
            if (productOption.isPresent()) {
                Product productUpdate = productOption.get();
                productUpdate.setName(product.getName());
                productUpdate.setPrice(product.getPrice());
                productRepository.save(productUpdate);
                return Optional.of(productUpdate);
            }
            throw new ProductException("Error updating product",HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public Optional<String> deleteProduct(Long id) throws ProductException {
        Optional<Product> getProduct = productRepository.findById(id);
        if(getProduct.isEmpty()) throw new ProductException("The product doesn't exist", HttpStatus.NOT_FOUND);
        productRepository.deleteById(id);
        return Optional.of("Product with id " + id + " deleted");
    }
}
