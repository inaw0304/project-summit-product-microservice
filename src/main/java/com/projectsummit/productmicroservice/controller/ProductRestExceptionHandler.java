package com.projectsummit.productmicroservice.controller;

import com.projectsummit.productmicroservice.dto.ProductErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductRestExceptionHandler {

    // add exception handling code
    // This exception handler will catch productNotFoundException throws
    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handleException(ProductNotFoundException productNotFoundException){

        ProductErrorResponse productErrorResponse = new ProductErrorResponse();
        productErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        productErrorResponse.setMessage(productNotFoundException.getMessage());
        productErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(productErrorResponse,HttpStatus.NOT_FOUND);

    }

    // This exception handler will catch all other exceptions
    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handleException(Exception exception){

        ProductErrorResponse productErrorResponse = new ProductErrorResponse();
        productErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        productErrorResponse.setMessage(exception.getMessage());
        productErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(productErrorResponse,HttpStatus.BAD_REQUEST);

    }

}
