package dao;

import model.Employee;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public List<Employee> findAll() {

        List<Employee> list =
                new ArrayList<>();

        String sql = "SELECT * FROM employees";

        try (
                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql);

                ResultSet rs =
                        ps.executeQuery()
        ) {

            while (rs.next()) {

                Employee emp =
                        new Employee();

                emp.setEmpCode(
                        rs.getString("emp_code"));

                emp.setFullName(
                        rs.getString("full_name"));

                emp.setEmail(
                        rs.getString("email"));

                list.add(emp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void insert(Employee emp) {

        String sql =
        "INSERT INTO employees VALUES(?,?,?)";

        try (
                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, emp.getEmpCode());
            ps.setString(2, emp.getFullName());
            ps.setString(3, emp.getEmail());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Employee findById(String code) {

        String sql =
        "SELECT * FROM employees WHERE emp_code=?";

        try (
                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, code);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Employee(
                        rs.getString("emp_code"),
                        rs.getString("full_name"),
                        rs.getString("email")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void update(Employee emp) {

        String sql =
        "UPDATE employees SET full_name=?,email=? WHERE emp_code=?";

        try (
                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, emp.getFullName());
            ps.setString(2, emp.getEmail());
            ps.setString(3, emp.getEmpCode());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String code) {

        String sql =
        "DELETE FROM employees WHERE emp_code=?";

        try (
                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, code);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}