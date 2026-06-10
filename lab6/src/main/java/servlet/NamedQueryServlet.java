package servlet;

import dao.VideoDAO;
import entity.Video;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import utils.JpaUtils;

import java.io.IOException;
import java.util.List;

@WebServlet("/named-query")
public class NamedQueryServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher(
                "/views/named-query.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        String keyword =
                req.getParameter("keyword");

        EntityManager em =
                JpaUtils.getEntityManager();

        TypedQuery<Video> query =
                em.createNamedQuery(
                        "Video.findByKeyword",
                        Video.class);

        query.setParameter(
                "keyword",
                "%" + keyword + "%");

        List<Video> list =
                query.getResultList();

        req.setAttribute("items", list);

        req.getRequestDispatcher(
                "/views/named-query.jsp")
                .forward(req, resp);
    }
}