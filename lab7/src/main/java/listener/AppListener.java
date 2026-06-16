package listener;

import java.nio.file.Files;
import java.nio.file.Paths;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class AppListener implements ServletContextListener, HttpSessionListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext application = sce.getServletContext();

        Integer visitors = 0;

        try {
            String path = application.getRealPath("/visitors.txt");

            visitors = Integer.parseInt(
                    Files.readAllLines(Paths.get(path)).get(0));

        } catch (Exception e) {
            visitors = 0;
        }

        application.setAttribute("visitors", visitors);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        ServletContext application = sce.getServletContext();

        Integer visitors =
                (Integer) application.getAttribute("visitors");

        try {
            String path = application.getRealPath("/visitors.txt");

            Files.write(
                    Paths.get(path),
                    String.valueOf(visitors).getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        ServletContext application =
                se.getSession().getServletContext();

        Integer visitors =
                (Integer) application.getAttribute("visitors");

        application.setAttribute(
                "visitors",
                visitors + 1);
    }
}