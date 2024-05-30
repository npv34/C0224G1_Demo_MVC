package org.codegym.bookapp.services;

import org.codegym.bookapp.entity.Book;
import org.codegym.bookapp.models.BookModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookService {
    private BookModel bookModel;
    public BookService() {
        this.bookModel = new BookModel();
    }

    public void renderPageListBook(HttpServletRequest request,
                                   HttpServletResponse response) throws ServletException, IOException {
        // goi model de lay data
        List<Book> books = this.bookModel.getAllBook();
        // gan data vao requet de gui xuong view
        request.setAttribute("books", books);
        RequestDispatcher out = request.getRequestDispatcher("/views/books/list.jsp");
        out.forward(request, response);
    }

    public void renderPageCreateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher out = request.getRequestDispatcher("/views/books/create.jsp");
        out.forward(request, response);
    }

    public void createBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        String price = request.getParameter("price");
        String author = request.getParameter("author");
        Book book = new Book(Integer.parseInt(id), name, desc, Double.parseDouble(price), author);
        this.bookModel.save(book);
        response.sendRedirect("/books/list");
    }

    public void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        this.bookModel.delete(Integer.parseInt(id));
        response.sendRedirect("/books/list");
    }
}
