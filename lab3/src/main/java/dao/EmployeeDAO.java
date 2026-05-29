package dao;

import model.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDAO {

    private final String jdbcUrl =
            "jdbc:mysql://localhost:3306/company_db";

    private final String dbUser = "root";

    private final String dbPass = "";

    // Constructor
    public EmployeeDAO() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // =========================
    // INSERT
    // =========================

    public boolean insert(Employee e) {

        String sql =
                "INSERT INTO employees " +
                "(emp_code, full_name, email, phone, gender, birth_date, department, position, salary) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (

                Connection conn =
                        DriverManager.getConnection(
                                jdbcUrl,
                                dbUser,
                                dbPass
                        );

                PreparedStatement ps =
                        conn.prepareStatement(sql)

        ) {

            ps.setString(1, e.getEmpCode());

            ps.setString(2, e.getFullName());

            ps.setString(3, e.getEmail());

            ps.setString(4, e.getPhone());

            ps.setString(5, e.getGender());

            ps.setDate(
                    6,
                    Date.valueOf(e.getBirthDate())
            );

            ps.setString(7, e.getDepartment());

            ps.setString(8, e.getPosition());

            ps.setDouble(9, e.getSalary());

            return ps.executeUpdate() == 1;

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return false;
    }

    // =========================
    // GET ALL
    // =========================

    public void getAll() {

        String sql =
                "SELECT * FROM employees";

        try (

                Connection conn =
                        DriverManager.getConnection(
                                jdbcUrl,
                                dbUser,
                                dbPass
                        );

                Statement st =
                        conn.createStatement();

                ResultSet rs =
                        st.executeQuery(sql)

        ) {

            while (rs.next()) {

                System.out.println(

                        rs.getString("emp_code")
                                + " - " +

                        rs.getString("full_name")
                                + " - " +

                        rs.getString("email")
                                + " - " +

                        rs.getDouble("salary")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // =========================
    // FIND BY CODE
    // =========================

    public void findByCode(String code) {

        String sql =
                "SELECT * FROM employees " +
                "WHERE emp_code=?";

        try (

                Connection conn =
                        DriverManager.getConnection(
                                jdbcUrl,
                                dbUser,
                                dbPass
                        );

                PreparedStatement ps =
                        conn.prepareStatement(sql)

        ) {

            ps.setString(1, code);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                        "Mã: " +
                        rs.getString("emp_code")
                );

                System.out.println(
                        "Tên: " +
                        rs.getString("full_name")
                );

                System.out.println(
                        "Email: " +
                        rs.getString("email")
                );

                System.out.println(
                        "Phone: " +
                        rs.getString("phone")
                );

                System.out.println(
                        "Gender: " +
                        rs.getString("gender")
                );

                System.out.println(
                        "Birth Date: " +
                        rs.getDate("birth_date")
                );

                System.out.println(
                        "Department: " +
                        rs.getString("department")
                );

                System.out.println(
                        "Position: " +
                        rs.getString("position")
                );

                System.out.println(
                        "Salary: " +
                        rs.getDouble("salary")
                );

            } else {

                System.out.println(
                        "Không tìm thấy nhân viên"
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // =========================
    // UPDATE
    // =========================

    public boolean update(Employee e) {

        String sql =
                "UPDATE employees SET " +
                "full_name=?, " +
                "email=?, " +
                "phone=?, " +
                "gender=?, " +
                "birth_date=?, " +
                "department=?, " +
                "position=?, " +
                "salary=? " +
                "WHERE emp_code=?";

        try (

                Connection conn =
                        DriverManager.getConnection(
                                jdbcUrl,
                                dbUser,
                                dbPass
                        );

                PreparedStatement ps =
                        conn.prepareStatement(sql)

        ) {

            ps.setString(1, e.getFullName());

            ps.setString(2, e.getEmail());

            ps.setString(3, e.getPhone());

            ps.setString(4, e.getGender());

            ps.setDate(
                    5,
                    Date.valueOf(e.getBirthDate())
            );

            ps.setString(6, e.getDepartment());

            ps.setString(7, e.getPosition());

            ps.setDouble(8, e.getSalary());

            ps.setString(9, e.getEmpCode());

            return ps.executeUpdate() == 1;

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return false;
    }

    // =========================
    // DELETE
    // =========================

    public boolean delete(String code) {

        String sql =
                "DELETE FROM employees " +
                "WHERE emp_code=?";

        try (

                Connection conn =
                        DriverManager.getConnection(
                                jdbcUrl,
                                dbUser,
                                dbPass
                        );

                PreparedStatement ps =
                        conn.prepareStatement(sql)

        ) {

            ps.setString(1, code);

            return ps.executeUpdate() == 1;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    // =========================
    // SEARCH
    // =========================

    public void search(String keyword) {

        String sql =
                "SELECT * FROM employees " +
                "WHERE emp_code LIKE ? " +
                "OR full_name LIKE ?";

        try (

                Connection conn =
                        DriverManager.getConnection(
                                jdbcUrl,
                                dbUser,
                                dbPass
                        );

                PreparedStatement ps =
                        conn.prepareStatement(sql)

        ) {

            ps.setString(
                    1,
                    "%" + keyword + "%"
            );

            ps.setString(
                    2,
                    "%" + keyword + "%"
            );

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                System.out.println(

                        rs.getString("emp_code")
                                + " - " +

                        rs.getString("full_name")
                                + " - " +

                        rs.getString("email")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}