package com.bksoftware.service;

import com.bksoftware.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll() ;

    Product findById(int id);

    Product insert(Product data); // insert a new product then return product which has just been inserted

    boolean update(Product data);

    boolean delete(int id); // "delete" the product which has 'id' = id

    List<Product> sortByNewest(); // find all product and sort by create date, newest product on the top.

    List<Product> sortByPrice(boolean asc); // ind all product and sort by price, asc is cheapest on the top.

    List<Product> searchByName(String text); // find all product which it's name contains 'text'
}
