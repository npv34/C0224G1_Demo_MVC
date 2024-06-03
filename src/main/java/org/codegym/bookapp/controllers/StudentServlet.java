package org.codegym.bookapp.controllers;

import org.codegym.bookapp.services.StudentService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "StudentServlet", urlPatterns = {"/students/*"})
public class StudentServlet extends HttpServlet {
    private StudentService studentService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.studentService = new StudentService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                try {
                    this.studentService.renderPageListStudent(req,  resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/create":
                try {
                    this.studentService.renderPageCreateStudent(req,  resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/create":
                try {
                    this.studentService.createStudent(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }
}
