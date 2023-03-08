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
}
