package com.eduardo.productsapirest.presentation.controller;

import com.eduardo.productsapirest.services.exception.ProductsExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = ProductsExceptions.class)
    public ResponseEntity<Object> productsExceptions(ProductsExceptions ex){

        //ProductsExceptions productsExceptions = ProductsExceptions.builder().code(ex.getCode)

        ProductsExceptions productsExceptions = new ProductsExceptions(ex.getMessage(),ex.getStatus());
        return new ResponseEntity<>(productsExceptions.getResponse(), HttpStatus.NOT_FOUND);

    }
}
