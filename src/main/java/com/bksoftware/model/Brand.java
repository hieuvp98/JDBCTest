package com.bksoftware.model;

public class Brand {
    private int id;

    private String name;

    private boolean deleted;

    public Brand(int id, String name, boolean deleted) {
        this.id = id;
        this.name = name;
        this.deleted = deleted;
    }

    public Brand() {
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deleted=" + deleted +
                '}';
    }

    public int getId() {
        return id;
    }

    public Brand setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Brand setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Brand setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }
}
