package ru.netology.ProductManager.ProductManagermvn;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String s) {
        super(s);
    }
}