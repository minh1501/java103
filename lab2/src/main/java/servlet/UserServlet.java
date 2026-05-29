package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import model.User;

import java.io.IOException;
import java.util.*;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        List<User> users = new ArrayList<>();

        users.add(new User("user1", "123", true));
        users.add(new User("user2", "456", false));

        req.setAttribute("message",
                "Quản lý người dùng");

        req.setAttribute("form",
                users.get(0));

        req.setAttribute("items",
                users);

        req.getRequestDispatcher(
                "/views/user/index.jsp")
                .forward(req, resp);
    }
}