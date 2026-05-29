package servlet;

import dao.VideoDAO;
import entity.Video;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        VideoDAO dao = new VideoDAO();

        List<Video> list = dao.findAll();

        request.setAttribute("videos", list);

        request.getRequestDispatcher("/views/home.jsp")
                .forward(request, response);
    }
}