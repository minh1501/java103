package servlet;

import dao.FavoriteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/video-keyword")
public class VideoByKeywordServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher(
                "/views/keyword.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        String keyword =
                req.getParameter("keyword");

        FavoriteDAO dao =
                new FavoriteDAO();

        req.setAttribute(
                "items",
                dao.findVideoByKeyword(keyword));

        req.getRequestDispatcher(
                "/views/keyword.jsp")
                .forward(req, resp);
    }
}