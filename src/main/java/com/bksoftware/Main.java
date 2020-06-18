package com.bksoftware;

import com.bksoftware.dao.CategoryDAO;
import com.bksoftware.dao.ConnectionController;
import com.bksoftware.dao.ProductDAO;
import com.bksoftware.dao.ProductDAOImpl;
import com.bksoftware.model.Category;
import com.bksoftware.model.Product;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Field[] fields = Category.class.getDeclaredFields();

        Category category = new Category();
        category.setName("Iphone");

        for (Field field : fields){
            System.out.println(field.getName() + " " + field.getType());
            try {
                field.setAccessible(true);
                System.out.println(field.get(category));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }


    }
}
