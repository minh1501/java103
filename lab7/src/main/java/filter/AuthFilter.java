package filter;

import java.io.IOException;

import entity.User;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

@WebFilter("/admin/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req =
                (HttpServletRequest) request;

        HttpServletResponse resp =
                (HttpServletResponse) response;

        HttpSession session =
                req.getSession(false);

        if (session == null
                || session.getAttribute("user") == null) {

            resp.sendRedirect(
                    req.getContextPath()
                            + "/login");

            return;
        }

        User user =
                (User) session.getAttribute("user");

        if (!user.getAdmin()) {

            resp.sendRedirect(
                    req.getContextPath()
                            + "/accessDenied.jsp");

            return;
        }

        chain.doFilter(request, response);
    }
}