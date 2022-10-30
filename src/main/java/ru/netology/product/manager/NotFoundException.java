package ru.netology.product.manager;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String s) {
        super(s);
    }
}