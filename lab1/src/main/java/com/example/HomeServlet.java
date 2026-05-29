package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home/*")
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String path = request.getPathInfo();

        out.println("<html><body>");

        if (path == null || path.equals("/index")) {
            out.println("<h1>Welcome to Home Page</h1>");
        } else if (path.equals("/about")) {
            out.println("<h1>About Us Page</h1>");
        } else if (path.equals("/contact")) {
            out.println("<h1>Contact Page</h1>");
        } else {
            out.println("<h1>404 Not Found</h1>");
        }

        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<h1>POST method is called</h1>");
    }
}