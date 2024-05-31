package org.codegym.bookapp.models;

import org.codegym.bookapp.databases.DBConnect;
import org.codegym.bookapp.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookModel {
    private Connection connection;

    public BookModel() {
        DBConnect dbConnect = new DBConnect();
        this.connection = dbConnect.getConnection();
    }

    public List<Book> getAllBook() throws SQLException {
        List<Book> books = new ArrayList<Book>();
        // Viet cau lenh SQL
        String sql = "SELECT * FROM books";
        // dua SQL vao ket noi de chuan bi thuc thi truy van
        PreparedStatement ps = connection.prepareStatement(sql);
        // Thuc thi truy van
        ResultSet rs = ps.executeQuery();
        // Xu ly du lieu chuyen ve Object Book
        while (rs.next()) {
            // Lay du lieu tu ResultSet
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String description = rs.getString("description");
            double price = rs.getDouble("price");
            // Tao doi tuong book
            Book book = new Book(id, name, description, price);
            // Them doi tuong vao list
            books.add(book);
        }
        return books;
    }

    public void save(Book book) throws SQLException {
        // Viet cau lenh SQL
        String sql = "INSERT INTO books(name,description,price) VALUE (?, ?, ?)";
        // dua SQL vao ket noi de chuan bi thuc thi truy van
        PreparedStatement ps = connection.prepareStatement(sql);
        // set cac gia tri tuong ung voi tham so ? tren cau lenh sql
        ps.setString(1, book.getName());
        ps.setString(2, book.getDesc());
        ps.setDouble(3, book.getPrice());
        // Thuc thi truy van
        ps.execute();
        ps.close();
    }

    public void delete(int id) throws SQLException {
        // code logic xoa
        String sql = "DELETE FROM books WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }

    public void update(int id, Book book) throws SQLException {
        String sql = "UPDATE books SET name = ?, description = ?, price = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, book.getName());
        ps.setString(2, book.getDesc());
        ps.setDouble(3, book.getPrice());
        ps.setInt(4, id);
        //thuc thi
        ps.execute();
    }

    public Book findById(int id) throws SQLException {
        Book book = null;
        String sql = "SELECT * FROM books WHERE id = ?";
        // dua SQL vao ket noi de chuan bi thuc thi truy van
        PreparedStatement ps = connection.prepareStatement(sql);
        // set gia tri cho parameter
        ps.setInt(1, id);
        // Thuc thi truy van
        ResultSet rs = ps.executeQuery();
        // xy ly du lieu chuyen ve Object Book
        while (rs.next()) {
            String name = rs.getString("name");
            String description = rs.getString("description");
            double price = rs.getDouble("price");
            book = new Book(id, name, description, price);
        }
        return book;
    }

    public List<Book> search(String keyword) throws SQLException {
        List<Book> books = new ArrayList<Book>();
        String sql = "SELECT * FROM books WHERE name Like '%' ? '%'";
        // dua SQL vao ket noi de chuan bi thuc thi truy van
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, keyword);
        // Thuc thi truy van
        ResultSet rs = ps.executeQuery();
        // Xu ly du lieu chuyen ve Object Book
        while (rs.next()) {
            // Lay du lieu tu ResultSet
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String description = rs.getString("description");
            double price = rs.getDouble("price");
            // Tao doi tuong book
            Book book = new Book(id, name, description, price);
            // Them doi tuong vao list
            books.add(book);
        }
        return books;

    }
}
