package com.bksoftware.model;

import java.util.Date;

public class Product {

    private int id;

    private String name;

    private String image;////

    private double price;

    private double promoPrice;////

    private boolean soldOut;////

    private String introduction;///

    private Date createDate;

    private boolean deleted;

    private int categoryId;////

    private int brandId;/////

    public Product(int id, String name, String image, double price, double promoPrice, boolean soldOut, String introduction, Date createDate, boolean deleted, int categoryId, int brandId) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.promoPrice = promoPrice;
        this.soldOut = soldOut;
        this.introduction = introduction;
        this.createDate = createDate;
        this.deleted = deleted;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", promoPrice=" + promoPrice +
                ", soldOut=" + soldOut +
                ", introduction='" + introduction + '\'' +
                ", createDate=" + createDate +
                ", deleted=" + deleted +
                ", categoryId=" + categoryId +
                ", brandId=" + brandId +
                '}';
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

    public String getImage() {
        return image;
    }

    public Product setImage(String image) {
        this.image = image;
        return this;
    }

    public double getPromoPrice() {
        return promoPrice;
    }

    public Product setPromoPrice(double promoPrice) {
        this.promoPrice = promoPrice;
        return this;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public Product setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
        return this;
    }

    public String getIntroduction() {
        return introduction;
    }

    public Product setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }


    public int getCategoryId() {
        return categoryId;
    }

    public Product setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public int getBrandId() {
        return brandId;
    }

    public Product setBrandId(int brandId) {
        this.brandId = brandId;
        return this;
    }
}
