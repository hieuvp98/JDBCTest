package com.bksoftware.model;

public class Comment {

    private int id;

    private String name;

    private String email;

    private String content;

    private int point;

    private int status;

    private int product_id;

    public Comment(int id, String name, String email, String content, int point, int status, int product_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.content = content;
        this.point = point;
        this.status = status;
        this.product_id = product_id;
    }

    public Comment() {
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", point=" + point +
                ", status=" + status +
                ", product_id=" + product_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public Comment setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Comment setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Comment setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Comment setContent(String content) {
        this.content = content;
        return this;
    }

    public int getPoint() {
        return point;
    }

    public Comment setPoint(int point) {
        this.point = point;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Comment setStatus(int status) {
        this.status = status;
        return this;
    }

    public int getProduct_id() {
        return product_id;
    }

    public Comment setProduct_id(int product_id) {
        this.product_id = product_id;
        return this;
    }
}
