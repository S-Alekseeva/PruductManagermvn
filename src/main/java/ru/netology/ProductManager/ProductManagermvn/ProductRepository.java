package ru.netology.ProductManager.ProductManagermvn;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product product) {
        if (findById(product.getId()) != null) {
            throw new AlreadyExistsException ("Element with id: " + product.getId() + " already exists");
        }

        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public void removeById(int id) {
        Product removeProduct = findById(id);
        if (removeProduct == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }

        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}