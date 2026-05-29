package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import model.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/products")
public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        List<Item> items = new ArrayList<>();

        items.add(new Item(
                "Iphone 15",
                "iphone.jpg",
                1000,
                0.1,
                new Date()
        ));

        items.add(new Item(
                "Samsung S24",
                "samsung.jpg",
                900,
                0.05,
                new Date()
        ));

        items.add(new Item(
                "Macbook Pro",
                "macbook.jpg",
                2000,
                0.15,
                new Date()
        ));

        items.add(new Item(
                "Ipad Pro",
                "ipad.jpg",
                1200,
                0.08,
                new Date()
        ));

        items.add(new Item(
                "Apple Watch",
                "watch.jpg",
                500,
                0.12,
                new Date()
        ));

        items.add(new Item(
                "Airpods Pro",
                "airpods.jpg",
                300,
                0.07,
                new Date()
        ));

        req.setAttribute("items", items);

        req.getRequestDispatcher(
                "/views/products.jsp")
                .forward(req, resp);
    }
}