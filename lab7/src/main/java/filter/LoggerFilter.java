package filter;

import java.io.IOException;
import java.time.LocalDateTime;

import entity.User;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class LoggerFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req =
                (HttpServletRequest) request;

        HttpSession session =
                req.getSession(false);

        String userId = "Guest";

        if (session != null &&
                session.getAttribute("user") != null) {

            User user =
                    (User) session.getAttribute("user");

            userId = user.getId();
        }

        System.out.println(
                "[" + LocalDateTime.now() + "] "
                        + userId
                        + " -> "
                        + req.getMethod()
                        + " "
                        + req.getRequestURI());

        chain.doFilter(request, response);
    }
}