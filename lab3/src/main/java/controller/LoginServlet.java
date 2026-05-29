package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        request.getRequestDispatcher(
                "views/login.jsp"
        ).forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        // Kiểm tra đăng nhập

        if (
                username.equals("admin")
                        &&
                password.equals("123")
        ) {

            // Tạo session

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "username",
                    username
            );

            // Chuyển sang home.jsp

            response.sendRedirect("home.jsp");

        } else {

            // Báo lỗi

            request.setAttribute(
                    "message",
                    "Sai tài khoản hoặc mật khẩu"
            );

            request.getRequestDispatcher(
                    "views/login.jsp"
            ).forward(request, response);
        }
    }
}