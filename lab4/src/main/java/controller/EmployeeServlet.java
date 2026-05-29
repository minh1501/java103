package controller;

import dao.EmployeeDAO;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet("/employees")
public class EmployeeServlet
        extends HttpServlet {

    EmployeeDAO dao = new EmployeeDAO();

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        String action =
                request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {

            case "create":
                request.getRequestDispatcher(
                        "employees/create.jsp")
                        .forward(request, response);
                break;

            case "edit":

                String editCode =
                        request.getParameter("code");

                request.setAttribute(
                        "emp",
                        dao.findById(editCode));

                request.getRequestDispatcher(
                        "employees/edit.jsp")
                        .forward(request, response);

                break;

            case "delete":

                dao.delete(
                        request.getParameter("code"));

                response.sendRedirect("employees");

                break;

            case "view":

                String viewCode =
                        request.getParameter("code");

                request.setAttribute(
                        "emp",
                        dao.findById(viewCode));

                request.getRequestDispatcher(
                        "employees/detail.jsp")
                        .forward(request, response);

                break;

            default:

                request.setAttribute(
                        "list",
                        dao.findAll());

                request.getRequestDispatcher(
                        "employees/list.jsp")
                        .forward(request, response);
        }
    }

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        String action =
                request.getParameter("action");

        String code =
                request.getParameter("empCode");

        String name =
                request.getParameter("fullName");

        String email =
                request.getParameter("email");

        Employee emp =
                new Employee(code, name, email);

        if (action.equals("insert")) {
            dao.insert(emp);
        } else if (action.equals("update")) {
            dao.update(emp);
        }

        response.sendRedirect("employees");
    }
}