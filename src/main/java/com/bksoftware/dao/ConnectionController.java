package com.bksoftware.dao;

import java.sql.*;
import java.time.LocalDate;

public class ConnectionController {

    public static Connection connection = null;

    public static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static boolean connect() throws ClassNotFoundException, SQLException {
        //Load thư viện cho driver kết nối database
        Class.forName(DRIVER);

        //Tạo kết nối đến database
        connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

        //Kiểm tra kết nối
        if (connection != null) {
            System.out.println("DB is connected");
            return true;
        }

        System.out.println("Fail to connect");
        return false;
    }

    public static void close() throws SQLException {
        //Đóng connection sau khi sử dụng xong
        if (connection != null) {
            connection.close();
            if (connection.isClosed())
                System.out.println("Connection had been closed");
        }
    }

}
