package servlet;

import dao.FavoriteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/favorite-user")
public class FavoriteByUserServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher(
                "/views/favorite-user.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        String userId =
                req.getParameter("userId");

        FavoriteDAO dao =
                new FavoriteDAO();

        req.setAttribute(
                "items",
                dao.findByUser(userId));

        req.getRequestDispatcher(
                "/views/favorite-user.jsp")
                .forward(req, resp);
    }
}