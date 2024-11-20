package com.eduardo.productsapirest.presentation.controller;

import com.eduardo.productsapirest.services.exception.ProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = ProductException.class)
    public ResponseEntity<Object> productsExceptions(ProductException ex){

        //ProductsExceptions productsExceptions = ProductsExceptions.builder().code(ex.getCode)

        ProductException productException = new ProductException(ex.getMessage(),ex.getStatus());
        return new ResponseEntity<>(productException.getResponse(), HttpStatus.NOT_FOUND);

    }
}
