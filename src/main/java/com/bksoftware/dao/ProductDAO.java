package com.bksoftware.dao;

import com.bksoftware.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {

    List<Product> findByCategory(int categoryId) throws SQLException;

    List<Product> findByBrand(int brandId) throws SQLException;

    // có thẻ chỉ dùng 1 trong 2 Id
    List<Product> find(int categoryId, int brandId) throws SQLException;

    Product getObject(ResultSet rs) throws SQLException;

    default PreparedStatement prepare(String sql) {
        try {
            return ConnectionController.connection.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    List<Product> findAll() throws SQLException;

    Product findById(int id) throws SQLException;

    Product insert(Product data) throws SQLException;
    // insert a new product then return product which has just been inserted

    boolean update(Product data) throws SQLException;

    boolean delete(int id) throws SQLException;
    // "delete" the product which has 'id' = id

    List<Product> sortByNewest() throws SQLException;
    // find all product and sort by create date, newest product on the top.

    List<Product> sortByPrice(boolean asc) throws SQLException; // find all product and sort by price, asc is cheapest on the top.

    List<Product> searchByName(String text) throws SQLException; // find all product which it's name contains 'text'

}
