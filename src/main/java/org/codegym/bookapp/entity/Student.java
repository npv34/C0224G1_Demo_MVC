package org.codegym.bookapp.entity;

public class Student {
    private int id;
    private String name;
    private String email;
    private Group group;

    public Student(int id, String name, String email, Group group) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.group = group;
    }

    public Student(String name, String email, Group group) {
        this.name = name;
        this.email = email;
        this.group = group;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
