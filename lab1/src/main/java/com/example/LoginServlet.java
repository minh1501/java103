package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login/*")
public class LoginServlet extends HttpServlet {

    // ================= GET =================
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String path = request.getPathInfo();

        if (path.equals("/form")) {

            out.println("<html><body>");
            out.println("<h2>Login Form</h2>");

            out.println("<form method='post' action='check'>");

            out.println("Username: <input type='text' name='username'><br><br>");
            out.println("Password: <input type='password' name='password'><br><br>");

            // Gender
            out.println("Gender: ");
            out.println("<input type='radio' name='gender' value='Male'> Male");
            out.println("<input type='radio' name='gender' value='Female'> Female<br><br>");

            // Hobbies
            out.println("Hobbies: ");
            out.println("<input type='checkbox' name='hobbies' value='Music'> Music");
            out.println("<input type='checkbox' name='hobbies' value='Sports'> Sports");
            out.println("<input type='checkbox' name='hobbies' value='Game'> Game<br><br>");

            // City
            out.println("City: ");
            out.println("<select name='city'>");
            out.println("<option value='Hanoi'>Hanoi</option>");
            out.println("<option value='HCM'>HCM</option>");
            out.println("<option value='Danang'>Danang</option>");
            out.println("</select><br><br>");

            out.println("<button type='submit'>Submit</button>");

            out.println("</form>");
            out.println("</body></html>");
        }
    }

    // ================= POST =================
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String path = request.getPathInfo();

        if (path.equals("/check")) {

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String gender = request.getParameter("gender");
            String city = request.getParameter("city");

            String[] hobbies = request.getParameterValues("hobbies");

            out.println("<html><body>");
            out.println("<h2>Result</h2>");

            // kiểm tra password
            if (!"123".equals(password)) {
                out.println("<p style='color:red'>Wrong password!</p>");
            }

            out.println("<p>Username: " + username + "</p>");
            out.println("<p>Password: " + password + "</p>");
            out.println("<p>Gender: " + gender + "</p>");
            out.println("<p>City: " + city + "</p>");

            out.println("<p>Hobbies: ");
            if (hobbies != null) {
                for (String h : hobbies) {
                    out.print(h + " ");
                }
            } else {
                out.print("None");
            }
            out.println("</p>");

            out.println("</body></html>");
        }
    }
}