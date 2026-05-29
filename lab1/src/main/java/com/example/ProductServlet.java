package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.*;
import java.util.*;

@WebServlet("/product/*")
public class ProductServlet extends HttpServlet {

    private static List<Product> list = new ArrayList<>();

    static {
        list.add(new Product(1, "Laptop", 1500));
        list.add(new Product(2, "Phone", 800));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String path = request.getPathInfo();

        if (path == null || path.equals("/index")) {
            out.println("<h2>Product List</h2>");
            out.println("<a href='create'>Add</a><br><br>");

            for (Product p : list) {
                out.println(p.getId() + " - " + p.getName() + " - " + p.getPrice());
                out.println(" <a href='edit/" + p.getId() + "'>Edit</a>");
                out.println(" <a href='delete/" + p.getId() + "'>Delete</a><br>");
            }
        }

        else if (path.equals("/create")) {
            out.println("<form method='post'>");
            out.println("Name: <input name='name'><br>");
            out.println("Price: <input name='price'><br>");
            out.println("<button>Create</button>");
            out.println("</form>");
        }

        else if (path.startsWith("/delete/")) {
            int id = Integer.parseInt(path.split("/")[2]);
            list.removeIf(p -> p.getId() == id);
            response.sendRedirect("index");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String path = request.getPathInfo();

        if (path.equals("/create")) {
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));

            int id = list.size() + 1;
            list.add(new Product(id, name, price));

            response.sendRedirect("index");
        }
    }
}