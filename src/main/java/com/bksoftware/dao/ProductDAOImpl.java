package com.bksoftware.dao;

import com.bksoftware.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public Product getObject(ResultSet rs) {
        try {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setCreateDate(rs.getDate("create_date"));
            product.setDeleted(rs.getBoolean("deleted"));
            return product;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> findAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        //câu lệnh where bổ sung điều kiện để tìm kiếm record
        String sql = "select * from product where deleted = false";
        PreparedStatement ps = prepare(sql);
        ResultSet resultSet = ps.executeQuery();
        resultSet.first();
        //hàm next() sẽ đưa con trỏ đến dòng phía dưới,
        //trả về kết quả true nếu có tồn tại dòng phía dưới
        //sử dụng do while để không bỏ qua dòng đầu tiên
        do {
            Product product = getObject(resultSet);
            if (product != null)
                products.add(product);
        } while (resultSet.next());
        return products;
    }

    @Override
    public Product findById(int id) throws SQLException {
        String sql = "select * from product where id = ?";
        PreparedStatement ps = prepare(sql);

        ps.setInt(1, id);

        ResultSet resultSet = ps.executeQuery();
        resultSet.first();
        return getObject(resultSet);
    }

    @Override
    public Product insert(Product data) throws SQLException {
        PreparedStatement ps = prepare("insert into product values (null,?,?,?,?)");
        int rs = ps.executeUpdate();
        //insert success
        if (rs > 0) {
            // find the new record
            PreparedStatement ps2 = prepare("select * from product");
            ResultSet resultSet = ps2.executeQuery();
            resultSet.last();
            return getObject(resultSet);
        }
        //insert fail
        return null;
    }

    @Override
    public boolean update(Product data) throws SQLException {
        PreparedStatement ps = prepare("update product set name = ?, price = ? where id = ?");
        ps.setString(1, data.getName());
        ps.setDouble(2, data.getPrice());
        ps.setInt(3, data.getId());
        return ps.executeUpdate() > 0;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        PreparedStatement ps = prepare("update product set deleted = true where id = ?");
        ps.setInt(2, id);
        return ps.executeUpdate() > 0;
    }

    @Override
    public List<Product> sortByNewest() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "select * from product where deleted = false order by created_date desc";
        PreparedStatement ps = prepare(sql);
        ResultSet resultSet = ps.executeQuery();
        resultSet.first();
        do {
            Product product = getObject(resultSet);
            if (product != null)
                products.add(product);
        } while (resultSet.next());

        return products;
    }

    @Override
    public List<Product> sortByPrice(boolean asc) throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "select * from product where deleted = false order by price " + (asc ? "asc" : "desc");
        PreparedStatement ps = prepare(sql);
        ResultSet resultSet = ps.executeQuery();
        resultSet.first();
        do {
            Product product = getObject(resultSet);
            if (product != null)
                products.add(product);
        } while (resultSet.next());

        return products;
    }

    @Override
    public List<Product> searchByName(String text) throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "select * from product where name like ? and deleted = false ";
        PreparedStatement ps = prepare(sql);
        ps.setString(1, '%' + text + '%');
        ResultSet resultSet = ps.executeQuery();
        resultSet.first();
        do {
            Product product = getObject(resultSet);
            if (product != null)
                products.add(product);
        } while (resultSet.next());

        return products;
    }
}
