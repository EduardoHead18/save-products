package com.eduardo.productsapirest.services.Implementation;

import com.eduardo.productsapirest.entities.Products;
import com.eduardo.productsapirest.repository.ProductsRepository;
import com.eduardo.productsapirest.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductsImpl implements ProductsService {
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
    public Products getProduct(Long id) {
        try{
            Products product = productsRepository.findById(id).get();
            return product;
        } catch (Exception e){
             return null;
        }
    }

    @Override
    public ResponseEntity<Products> createProduct( Products products) {
        Products savedProduct = productsRepository.save(products);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
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
