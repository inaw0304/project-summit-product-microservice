package com.projectsummit.productmicroservice.controller;

public class ImageUrlNotFoundException extends RuntimeException{


    public ImageUrlNotFoundException(String message) {
        super(message);
    }

    public ImageUrlNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImageUrlNotFoundException(Throwable cause) {
        super(cause);
    }
}
