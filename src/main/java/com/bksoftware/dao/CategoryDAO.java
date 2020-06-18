package com.bksoftware.dao;

import com.bksoftware.model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDAO extends BasicDAO<Category>{

    public CategoryDAO() {
        super("category");
    }

    @Override
    public Category upload(Category data) throws SQLException {
        PreparedStatement ps = prepare("insert into category values (null,?,?) ");
        ps.setString(1, data.getName());
        ps.setBoolean(2, false);
        int rs = ps.executeUpdate();
        //insert success
        if (rs > 0) {
            // find the new record
            PreparedStatement ps2 = prepare("select * from category");
            ResultSet resultSet = ps2.executeQuery();
            resultSet.last();
            return getObject(resultSet);
        }
        //insert fail
        return null;
    }

    @Override
    public boolean update(Category data) throws SQLException {
        PreparedStatement ps = prepare("update product set name = ? where id = ?");
        ps.setString(1, data.getName());
        return ps.executeUpdate() > 0;
    }

    @Override
    protected Category getObject(ResultSet rs) throws SQLException{
        Category category = new Category();
        category.setId(rs.getInt("id"));
        category.setName(rs.getString("name"));
        category.setDeleted(rs.getBoolean("deleted"));
        return category;
    }
}
