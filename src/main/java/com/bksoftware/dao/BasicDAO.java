package com.bksoftware.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class BasicDAO<T> {

    protected String table; // table name

    public BasicDAO(String table) {
        this.table = table;
    }

    protected abstract T getObject(ResultSet rs) throws SQLException;

    protected PreparedStatement prepare(String sql) throws SQLException {
        return ConnectionController.connection
                .prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }

    public List<T> getList(ResultSet rs) throws SQLException {
        rs.first();
        List<T> data = new ArrayList<>();
        do {
            data.add(getObject(rs));
        } while (rs.next());
        return data;
    }

    public T findById(int id) throws SQLException {
        String sql = "select * from " + table + " where id = ? and deleted = false";
        PreparedStatement ps = prepare(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.first();
        return getObject(rs);
    }

    public List<T> findAll() throws SQLException {
        String sql = "select * from " + table + " where deleted = false";
        PreparedStatement ps = prepare(sql);
        ResultSet rs = ps.executeQuery();
        return getList(rs);
    }

    public boolean delete(int id) throws SQLException {
        String sql = "update " + table + " set deleted = b'1' where id = ?";
        PreparedStatement ps = prepare(sql);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    }

    public abstract T upload(T data) throws SQLException;

    public abstract boolean update(T data) throws SQLException;

    public List<T> findByParent(String parent, int parentId) throws SQLException {
        String sql = "select * from " + table + " where " + parent + " = ? and deleted = false";
        PreparedStatement ps = prepare(sql);
        ps.setInt(1, parentId);
        ResultSet rs = ps.executeQuery();
        return getList(rs);
    }

    public List<T> sortBy(String field, boolean isAsc) throws SQLException {
        String sql = "select * from " + table + " where deleted = false order by " + field + " " + (isAsc ? "asc" : "desc");
        PreparedStatement ps = prepare(sql);
        ResultSet rs = ps.executeQuery();
        return getList(rs);
    }

    public List<T> searchBy(String field, String text) throws SQLException {
        String sql = "select * from " + table + " where deleted = false and " + field + " like ?";
        PreparedStatement ps = prepare(sql);
        ps.setString(1, text);
        ResultSet rs = ps.executeQuery();
        return getList(rs);
    }

}
