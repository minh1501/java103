package controller;

import dao.UserDAO;
import model.User;
import utils.ValidationUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/register")
public class RegistrationServlet
        extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        request.getRequestDispatcher(
                "register.jsp")
                .forward(request, response);
    }

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String fullname =
                request.getParameter("fullname");

        String email =
                request.getParameter("email");

        String gender =
                request.getParameter("gender");

        String major =
                request.getParameter("major");

        Map<String, String> errors =
                new HashMap<>();

        if (ValidationUtil.isEmpty(fullname)) {
            errors.put(
                    "fullname",
                    "Không được để trống");
        }

        if (!ValidationUtil.isValidEmail(email)) {
            errors.put(
                    "email",
                    "Email không hợp lệ");
        }

        if (!errors.isEmpty()) {

            request.setAttribute(
                    "errors",
                    errors);

            request.getRequestDispatcher(
                    "register.jsp")
                    .forward(request, response);

            return;
        }

        User user = new User();

        user.setFullname(fullname);
        user.setEmail(email);
        user.setGender(gender);
        user.setMajor(major);

        UserDAO dao = new UserDAO();

        dao.insert(user);

        request.setAttribute("user", user);

        request.getRequestDispatcher(
                "result.jsp")
                .forward(request, response);
    }
}