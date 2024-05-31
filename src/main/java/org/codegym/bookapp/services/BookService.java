package org.codegym.bookapp.services;

import org.codegym.bookapp.entity.Book;
import org.codegym.bookapp.models.BookModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BookService {
    private BookModel bookModel;
    public BookService() {
        this.bookModel = new BookModel();
    }

    public void renderPageListBook(HttpServletRequest request,
                                   HttpServletResponse response) throws ServletException, IOException, SQLException {
        // goi model de lay data
        List<Book> books = this.bookModel.getAllBook();
        // gan data vao requet de gui xuong view
        request.setAttribute("books", books);
        RequestDispatcher out = request.getRequestDispatcher("/views/books/list.jsp");
        out.forward(request, response);
    }

    public void renderPageCreateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher out = request.getRequestDispatcher("/views/books/create.jsp");
        out.forward(request, response);
    }

    public void createBook(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        String price = request.getParameter("price");
        // get Category trong data
        Book book = new Book(name, desc, Double.parseDouble(price));
        this.bookModel.save(book);
        response.sendRedirect("/books/list");
    }

    public void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String id = request.getParameter("id");
        this.bookModel.delete(Integer.parseInt(id));
        response.sendRedirect("/books/list");
    }

    public void renderPageUpdateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        // Lay id book sau truy van CSDL de lay thong tin sach
        int id = Integer.parseInt(request.getParameter("id"));
        // truy van csdl
        Book bookUpdate = this.bookModel.findById(id);
        // truyen data xuong view
        request.setAttribute("book", bookUpdate);
        RequestDispatcher requestDispat = request.getRequestDispatcher("/views/books/update.jsp");
        requestDispat.forward(request, response);
    }

    public void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        String price = request.getParameter("price");
        Book book = new Book(name, desc, Double.parseDouble(price));
        this.bookModel.update(id, book);
        response.sendRedirect("/books/list");
    }

    public List<Book> searchBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String keyword = request.getParameter("keyword");
        List<Book> books = this.bookModel.search(keyword);
        request.setAttribute("books", books);
        RequestDispatcher requestDispat = request.getRequestDispatcher("/views/books/list.jsp");
        requestDispat.forward(request, response);
        return books;
    }
}
