package servlet;

import dao.FavoriteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/user-video")
public class UserByVideoServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher(
                "/views/user-video.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        String videoId =
                req.getParameter("videoId");

        FavoriteDAO dao =
                new FavoriteDAO();

        req.setAttribute(
                "items",
                dao.findUserByVideo(videoId));

        req.getRequestDispatcher(
                "/views/user-video.jsp")
                .forward(req, resp);
    }
}