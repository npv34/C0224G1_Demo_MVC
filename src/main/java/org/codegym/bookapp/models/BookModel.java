package org.codegym.bookapp.models;

import org.codegym.bookapp.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookModel {
    private List<Book> books = new ArrayList<Book>();

    public BookModel() {
        Book b1 = new Book(1, "Truyen Conan", "Truyen tranh conan trinh tham", 2399.00, "Japan");
        Book b2 = new Book(2, "Truyen De men phuu luu ky", "Truyn chuu", 2399.00, "Vietnam");
        books.add(b1);
        books.add(b2);
    }

    public List<Book> getAllBook() {
        return this.books;
    }

    public void save(Book book) {
        this.books.add(book);
    }

    public void delete(int id) {
        // code logic xoa
    }

    public void update(int id, Book book) {

    }
}
