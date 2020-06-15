package com.bksoftware.model;

public class Category {

    private int id;

    private String name;

    private boolean deleted;

    public Category(int id, String name, boolean deleted) {
        this.id = id;
        this.name = name;
        this.deleted = deleted;
    }

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deleted=" + deleted +
                '}';
    }

    public int getId() {
        return id;
    }

    public Category setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Category setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }
}
