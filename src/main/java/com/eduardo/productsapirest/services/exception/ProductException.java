package com.eduardo.productsapirest.services.exception;

import com.eduardo.productsapirest.presentation.dto.ErrorMessage;
import lombok.*;

import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public ProductException(String message, HttpStatus status) {
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
