package com.eduardo.productsapirest.exceptions;

import com.eduardo.productsapirest.exceptions.dto.ErrorMessage;
import lombok.*;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsExceptions extends RuntimeException {
    private HttpStatus status;
    private String message;

    public ProductsExceptions(String message, HttpStatus status) {
//        super(message);
        this.message = message;
        this.status = status;
    }
    public HttpStatus getStatus() {
        return this.status;
    }

    public ErrorMessage getResponse(){
        return new ErrorMessage(this.status, this.message);
    }
}
