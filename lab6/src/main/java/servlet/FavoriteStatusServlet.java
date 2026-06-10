package servlet;

import dao.FavoriteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/favorite-status")
public class FavoriteStatusServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        FavoriteDAO dao = new FavoriteDAO();

        req.setAttribute(
                "favoriteVideos",
                dao.findFavoriteVideos());

        req.setAttribute(
                "notFavoriteVideos",
                dao.findNotFavoriteVideos());

        req.getRequestDispatcher(
                "/views/favorite-status.jsp")
                .forward(req, resp);
    }
}