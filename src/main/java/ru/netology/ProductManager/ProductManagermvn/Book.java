package ru.netology.ProductManager.ProductManagermvn;

import ru.netology.ProductManager.ProductManagermvn.Product;

public class Book extends Product {
    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public Book(String search) {
        super(search);
    }

    @Override
    public boolean matches(String search) {
        if (getName().contains(search)) {
            return true;
        }
        if (getAuthor().contains(search)) {
            return true;
        }
        return false;
    }
}
