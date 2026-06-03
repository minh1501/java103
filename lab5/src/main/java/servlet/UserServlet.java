package servlet;

import dao.UserDAO;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({
"/user/index",
"/user/edit",
"/user/create",
"/user/update",
"/user/delete",
"/user/reset"
})
public class UserServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

private UserDAO dao = new UserDAO();

@Override
protected void service(
        HttpServletRequest req,
        HttpServletResponse resp)
        throws ServletException, IOException {

    String uri = req.getRequestURI();

    User form = new User();

    String message = "";

    try {

        // EDIT
        if (uri.contains("edit")) {

            String id = req.getParameter("id");

            form = dao.findById(id);

            if (form == null) {
                form = new User();
                message = "Không tìm thấy User!";
            }
        }

        // CREATE
        else if (uri.contains("create")) {

            form.setId(req.getParameter("id"));
            form.setPassword(req.getParameter("password"));
            form.setFullname(req.getParameter("fullname"));
            form.setEmail(req.getParameter("email"));
            form.setPhone(req.getParameter("phone"));

            form.setAdmin(
                    "true".equals(
                            req.getParameter("admin")));

            String emailRegex =
                    "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

            String phoneRegex =
                    "^(03|05|07|08|09)\\d{8}$";

            if (!form.getEmail().matches(emailRegex)) {

                message = "Email không hợp lệ!";
            }
            else if (!form.getPhone().matches(phoneRegex)) {

                message = "Số điện thoại không hợp lệ!";
            }
            else {

                dao.create(form);

                message = "Thêm User thành công!";

                form = new User();
            }
        }

        // UPDATE
        else if (uri.contains("update")) {

            form.setId(req.getParameter("id"));
            form.setPassword(req.getParameter("password"));
            form.setFullname(req.getParameter("fullname"));
            form.setEmail(req.getParameter("email"));
            form.setPhone(req.getParameter("phone"));

            form.setAdmin(
                    "true".equals(
                            req.getParameter("admin")));

            String emailRegex =
                    "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

            String phoneRegex =
                    "^(03|05|07|08|09)\\d{8}$";

            if (!form.getEmail().matches(emailRegex)) {

                message = "Email không hợp lệ!";
            }
            else if (!form.getPhone().matches(phoneRegex)) {

                message = "Số điện thoại không hợp lệ!";
            }
            else {

                dao.update(form);

                message = "Cập nhật User thành công!";
            }
        }

        // DELETE
        else if (uri.contains("delete")) {

            String id = req.getParameter("id");

            dao.delete(id);

            message = "Xóa User thành công!";

            form = new User();
        }

        // RESET
        else if (uri.contains("reset")) {

            form = new User();

            message = "Đã làm mới form!";
        }

    } catch (Exception e) {

        message = "Lỗi: " + e.getMessage();

        e.printStackTrace();
    }

    req.setAttribute("message", message);

    req.setAttribute("form", form);

    req.setAttribute("items", dao.findAll());

    req.getRequestDispatcher("/user.jsp")
            .forward(req, resp);
}

}
