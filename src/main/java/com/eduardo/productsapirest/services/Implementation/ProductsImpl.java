package com.eduardo.productsapirest.services.Implementation;

import com.eduardo.productsapirest.persistence.entities.Products;
import com.eduardo.productsapirest.services.exception.ProductsExceptions;
import com.eduardo.productsapirest.persistence.repository.ProductsRepository;
import com.eduardo.productsapirest.services.interfaces.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductsImpl implements IProductsService {
    @Autowired
    ProductsRepository productsRepository;

    @Override
    public ResponseEntity<List<Products>> getAllProducts() {
        try {
            List<Products> responseAllProducts = productsRepository.findAll();
            return ResponseEntity.ok(responseAllProducts);
        } catch (Exception e) {
//            throw new RequestException("400","Algo salio mal");
            return null;
        }
    }

    @Override

    public Optional<Products> getProduct(Long id) throws ProductsExceptions {

        Optional<Products>  products = productsRepository.findById(id);
        if (id == null || id == 0) {
            throw new ProductsExceptions("400", HttpStatus.NOT_FOUND );
        }
        if(products.isEmpty()) throw new ProductsExceptions("The product doesn't exist", HttpStatus.NOT_FOUND);

        return productsRepository.findById(id);
    }

    @Override
    public ResponseEntity<Products> createProduct( Products products) {
        Products savedProduct = productsRepository.save(products);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @Override
    public void updateProduct(Long id, Products products) {
        try {
            Optional<Products> productUpdate = getProduct(id);
            if (productUpdate.isPresent()) {
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
    public ResponseEntity<String> deleteProduct(Long id) {
        try {
            if (getProduct(id) != null) {
                productsRepository.deleteById(id);
                return ResponseEntity.status(HttpStatus.OK).body("Product with id " + id + " deleted");
            }
        } catch (Exception e) {
//            throw new RuntimeException("Error deleting product " + e);
             return ResponseEntity.status(HttpStatus.FOUND).body("Error deleting the product, possibly the id does not exist ");
        }
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error deleting the product, possibly the id does not exist");
    }

}
