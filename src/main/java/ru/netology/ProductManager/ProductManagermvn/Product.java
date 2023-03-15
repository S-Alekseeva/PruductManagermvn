package ru.netology.ProductManager.ProductManagermvn;

public class Product {
    protected int id;
    protected String name;
    protected int price;

    public Product(String search) {

    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean matches(String search) {
        Book book = new Book(search);
        if (book.getName().contains(search)) {
            return true;
        }
        Smartphone smartphone = new Smartphone(search);
        if (smartphone.getName().contains(search)) {
            return true;
        }
        return false;
    }
}

