package com.bksoftware;

import com.bksoftware.dao.ConnectionController;
import com.bksoftware.dao.ProductDAO;
import com.bksoftware.dao.ProductDAOImpl;
import com.bksoftware.model.Product;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        try {
            ConnectionController.connect();
            //
            ProductDAO dao = new ProductDAOImpl();
            List<Product> productList = dao.find(1,0);

            for (Product p : productList){
                System.out.println(p);
            }
            ConnectionController.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }
}
