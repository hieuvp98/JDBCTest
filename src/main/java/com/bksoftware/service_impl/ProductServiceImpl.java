package com.bksoftware.service_impl;

import com.bksoftware.dao.ProductDAO;
import com.bksoftware.dao.ProductDAOImpl;
import com.bksoftware.model.Product;
import com.bksoftware.service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductDAO dao = new ProductDAOImpl();

    @Override
    public List<Product> findAll() {
        try {
            return dao.findAll();
        }catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Product findById(int id) {
        try {
            return dao.findById(id);
        }catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Product insert(Product data) {
        return null;
    }

    @Override
    public boolean update(Product data) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Product> sortByNewest() {
        return null;
    }

    @Override
    public List<Product> sortByPrice(boolean asc) {
        return null;
    }

    @Override
    public List<Product> searchByName(String text) {
        return null;
    }
}
