package servlet;

import java.io.IOException;

import dao.UserDAO;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UserDAO dao = new UserDAO();

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        String id = req.getParameter("id");
        String password =
                req.getParameter("password");

        User user = dao.findById(id);

        if (user == null) {

            req.setAttribute(
                    "message",
                    "Tài khoản không tồn tại");

        } else if (!user.getPassword()
                .equals(password)) {

            req.setAttribute(
                    "message",
                    "Sai mật khẩu");

        } else {

            req.getSession()
                    .setAttribute("user", user);

            resp.sendRedirect(
                    req.getContextPath()
                            + "/index.jsp");
            return;
        }

        req.getRequestDispatcher("/login.jsp")
                .forward(req, resp);
    }
}