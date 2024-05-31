package org.codegym.bookapp.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static final String URL = "jdbc:mysql://localhost:3306/library?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "123456@Abc";
    public DBConnect(){}

    public Connection getConnection() {
        // Tao bien connection chua ket noi den csdl
       Connection connection = null;
       try {
           // Dang ky Driver mysql jdbc driver
           Class.forName("com.mysql.jdbc.Driver");
           // Thuc hien ket noi CSDL
           connection = DriverManager.getConnection(URL, USER, PASSWORD);
           System.out.println("Connect database successfully");
       }catch (SQLException | ClassNotFoundException e) {
           System.out.println(e.getMessage());
       }
       return connection;
    }
}
