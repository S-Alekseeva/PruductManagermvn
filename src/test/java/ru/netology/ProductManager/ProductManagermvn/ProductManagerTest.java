package ru.netology.ProductManager.ProductManagermvn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(11, "Green mile", 560, "King");
    Product book2 = new Book(22, "The Adventures of Sherlock Holmes", 800, "Doyle");

    Product smartphone1 = new Smartphone(111, "S23", 100_000, "Samsung");
    Product smartphone2 = new Smartphone(222, "S23+", 120_000, "Samsung");


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

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone1, smartphone2};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        String name = "S23";

        Product[] actual = manager.searchBy(name);
        Product[] expected = {smartphone1, smartphone2};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByProduct2() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        String name = "mile";

        Product[] actual = manager.searchBy(name);
        Product[] expected = {book1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        repo.removeById(11);

        Product[] actual = {book2, smartphone1, smartphone2};
        Product[] expected = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByAllIdProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        repo.removeById(11);
        repo.removeById(22);
        repo.removeById(111);
        repo.removeById(222);

        Product[] actual = {};
        Product[] expected = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }
}
