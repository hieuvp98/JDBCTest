package com.bksoftware.model;

import java.util.Date;

public class Bill {

    private int id;

    private String name;

    private String email;

    private String phone;

    private String address;

    private int status;

    private Date createTime;

    private boolean deleted;

    public Bill(int id, String name, String email, String phone, String address, int status, Date createTime, boolean deleted) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.createTime = createTime;
        this.deleted = deleted;
    }

    public Bill() {
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", deleted=" + deleted +
                '}';
    }

    public int getId() {
        return id;
    }

    public Bill setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Bill setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Bill setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Bill setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Bill setAddress(String address) {
        this.address = address;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Bill setStatus(int status) {
        this.status = status;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Bill setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Bill setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }
}
