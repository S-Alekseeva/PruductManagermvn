package ru.netology.ProductManager.ProductManagermvn;

import ru.netology.ProductManager.ProductManagermvn.Product;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Smartphone(String search) {
        super(search);
    }

    @Override
    public boolean matches(String search) {
        if (getName().contains(search)) {
            return true;
        }
        if (getManufacturer().contains(search)) {
            return true;
        }
        return false;
    }
}