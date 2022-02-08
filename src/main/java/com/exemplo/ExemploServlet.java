package com.exemplo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ola")
public class ExemploServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        try {
            out.println("<html>");
            out.println("<head><title> Java Home Page </title></head>");
            out.println("<body style='text-align: center'>");
            out.println("<h1> Hello darknes my old friend! </h1>");
            out.println("</body></html>");
        } finally {
            out.close();
        }

    }
}