package com.bksoftware.service;

import java.util.List;

public interface BaseService<T>{

    T findById(int id);

    List<T> findAll();

    T upload(T data);

    boolean update(T data);

    boolean delete(int id);

    List<T> findByParent(String parent, int parentId);

    List<T> sortBy(String field, boolean isAsc);

    List<T> searchBy(String field, String text);
}
