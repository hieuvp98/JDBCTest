package com.bksoftware.dao;

import com.bksoftware.model.Product;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public List<Product> findByCategory(int categoryId) throws SQLException {
        List<Product> products = new ArrayList<>();
        //câu lệnh where bổ sung điều kiện để tìm kiếm record
        String sql = "select * from product where deleted = false and category_id = ?";
        PreparedStatement ps = prepare(sql);
        ps.setInt(1, categoryId);
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
    public List<Product> findByBrand(int brandId) throws SQLException {
        List<Product> products = new ArrayList<>();
        //câu lệnh where bổ sung điều kiện để tìm kiếm record
        String sql = "select * from product where deleted = false and brand_id = ?";
        PreparedStatement ps = prepare(sql);
        ps.setInt(1, brandId);
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
    public List<Product> find(int categoryId, int brandId) throws SQLException {
        List<Product> products = new ArrayList<>();
        //câu lệnh where bổ sung điều kiện để tìm kiếm record
        String sql = "select * from product where deleted = false " +
                "and (category_id = ? or  0 = ?) and (brand_id = ? or 0 = ?) ";

        PreparedStatement ps = prepare(sql);
        ps.setInt(1, categoryId);
        ps.setInt(2, categoryId);

        ps.setInt(3, brandId);
        ps.setInt(4, brandId);
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
    public Product getObject(ResultSet rs) {
        try {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setPromoPrice(rs.getDouble("promo_price"));
            product.setCreateDate(rs.getDate("create_date"));
            product.setImage(rs.getString("image"));
            product.setSoldOut(rs.getBoolean("sold_out"));
            product.setIntroduction(rs.getString("introduction"));
            product.setDeleted(rs.getBoolean("deleted"));
            product.setCategoryId(rs.getInt("category_id"));
            product.setBrandId(rs.getInt("brand_id"));
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
        PreparedStatement ps = prepare("insert into product values (null,?,?,?,?,?,?,?,?,?,?) ");
        ps.setString(1, data.getName());
        ps.setDouble(2, data.getPrice());
        ps.setDouble(3, data.getPromoPrice());
        ps.setDate(4, new Date(new java.util.Date().getTime()));
        ps.setString(5, data.getImage());
        ps.setBoolean(6, data.isSoldOut());
        ps.setString(7, data.getIntroduction());
        ps.setBoolean(8, data.isDeleted());
        ps.setInt(9, data.getCategoryId());
        ps.setInt(10, data.getBrandId());
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
        PreparedStatement ps = prepare("update product set name = ?" +
                ", price = ?, promo_price = ?,image = ?" +
                ",sold_out = ?, introduction = ?, category_id = ?" +
                ", brand_id = ?  where id = ?");
        ps.setString(1, data.getName());
        ps.setDouble(2, data.getPrice());
        ps.setDouble(3, data.getPromoPrice());
        ps.setString(4, data.getImage());
        ps.setBoolean(5, data.isSoldOut());
        ps.setString(6, data.getIntroduction());
        ps.setInt(7, data.getCategoryId());
        ps.setInt(8, data.getBrandId());
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
