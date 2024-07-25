package com.amg.reto01.domain.exceptions;

public class ProductoNotFound extends RuntimeException{
    public ProductoNotFound() {
    }

    public ProductoNotFound(String message) {
        super(message);
    }
}
