package org.codegym.bookapp.entity;

public class Book {
    private int id;
    private String name;
    private String desc;
    private double price;
    private String author;


    public Book(int id, String name, String desc, double price, String author) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
