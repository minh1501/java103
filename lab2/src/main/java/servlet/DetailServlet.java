package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import  model.Item;

import java.io.IOException;
import java.util.Date;

@WebServlet("/detail")
public class DetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        Item item = new Item(
                "Iphone 15",
                "iphone.jpg",
                100,
                0.1,
                new Date()
        );

        req.setAttribute("item", item);

        req.getRequestDispatcher(
                "/views/detail.jsp")
                .forward(req, resp);
    }
}