package com.bksoftware.model;

import java.util.Date;

public class Product {

    private int id;

    private String name;

    private double price;

    private Date createDate;

    private boolean deleted;

    public Product(int id, String name, double price, Date createDate, boolean deleted) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createDate = createDate;
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", createDate=" + createDate +
                ", deleted=" + deleted +
                '}';
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Product setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Product setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }
}
