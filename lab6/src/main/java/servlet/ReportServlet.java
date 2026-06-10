package servlet;

import dao.FavoriteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/report")
public class ReportServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        FavoriteDAO dao =
                new FavoriteDAO();

        req.setAttribute(
                "items",
                dao.getReport());

        req.getRequestDispatcher(
                "/views/report.jsp")
                .forward(req, resp);
    }
}