package com.example.productmanagements.repository;

import com.example.productmanagements.enity.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1,"iphone8",200.0,"new","china"  ));
        productList.add(new Product(2,"iphonex",400.0,"new","china"  ));
        productList.add(new Product(3,"iphone11",500.0,"old","vietnam"  ));
        productList.add(new Product(4,"iphone12",700.0,"like new 99%","korea"  ));
        productList.add(new Product(5,"iphone13",800.0,"new","japan"  ));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public boolean addProduct(Product product) {
        productList.add(product);
        return true;
    }

    @Override
    public Product findById(int id) {
        for (Product p : productList) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public void update(Product product) {
        Product existing = findById(product.getId());
        if (existing != null) {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            existing.setDescription(product.getDescription());
            existing.setManufacturer(product.getManufacturer());
        }
    }

    @Override
    public boolean removeById(int id) {
        Product product = findById(id);
        if (product != null) {
            productList.remove(product);
            return true;
        }
        return false;
    }
}
