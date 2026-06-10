package servlet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import utils.JpaUtils;

import java.io.IOException;
import java.util.List;

@WebServlet("/procedure")
public class StoredProcedureServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        EntityManager em =
                JpaUtils.getEntityManager();

        StoredProcedureQuery query =
                em.createNamedStoredProcedureQuery(
                        "Video.favoriteReport");

        List<Object[]> list =
                query.getResultList();

        req.setAttribute("items", list);

        req.getRequestDispatcher(
                "/views/procedure.jsp")
                .forward(req, resp);
    }
}