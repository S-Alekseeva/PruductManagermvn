package ru.netology.ProductManager.ProductManagermvn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(11, "Green mile", 560, "King");
    Product book2 = new Book(22, "The Adventures of Sherlock Holmes", 800, "Doyle");

    Product smartphone1 = new Smartphone(111, "S23", 100_000, "Samsung");
    Product smartphone2 = new Smartphone(222, "S23+", 120_000, "Samsung");

    Product smartphone3 = new Smartphone(333, "S22", 60_000, "Samsung");

    Product smartphone4 = new Smartphone(444, "iPhone14", 100_000, "Apple");


    @Test
    public void shouldAddProduct() {
        manager.add(smartphone1);

        Product[] actual = repo.findAll();
        Product[] expected = {smartphone1};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldAddAllProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone1, smartphone2, smartphone3, smartphone4};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchBy2Product() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        String name = "S23";

        Product[] actual = manager.searchBy(name);
        Product[] expected = {smartphone1, smartphone2};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        String name = "mile";

        Product[] actual = manager.searchBy(name);
        Product[] expected = {book1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNoProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        String name = "iPhone13";

        Product[] actual = manager.searchBy(name);
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveByIdProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        repo.removeById(11);

        Product[] actual = {book2, smartphone1, smartphone2, smartphone3, smartphone4};
        Product[] expected = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByAllIdProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        repo.removeById(11);
        repo.removeById(22);
        repo.removeById(111);
        repo.removeById(222);
        repo.removeById(333);
        repo.removeById(444);

        Product[] actual = {};
        Product[] expected = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchTrueNameBook() {
        manager.add(book1);
        manager.add(book2);

        assertTrue(book2.matches("Adventures"));
    }

    @Test
    public void shouldSearchFalseNameBook() {
        manager.add(book1);
        manager.add(book2);

        assertFalse(book1.matches("Adventures"));
    }

    @Test
    public void shouldSearchAuthorBook() {
        manager.add(book1);
        manager.add(book2);

        assertTrue(book2.matches("Doyle"));
    }

    @Test
    public void shouldSearchTrueNameSmartphone() {
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        assertTrue(smartphone3.matches("S22"));
    }

    @Test
    public void shouldSearchFalseNameSmartphone() {
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        assertFalse(smartphone3.matches("S23"));
    }

    @Test
    public void shouldSearchManufacturerSmartphone() {
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        assertTrue(smartphone4.matches("Apple"));
    }
}
