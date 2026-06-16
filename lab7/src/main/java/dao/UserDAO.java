package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import utils.Dbconnector;

import entity.User;

public class UserDAO {

    // SELECT *
    public List<User> findAll() {

        List<User> list = new ArrayList<>();

        String sql = "SELECT * FROM Users";

        try (
                Connection conn = Dbconnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {

            while (rs.next()) {

                User user = new User();

                user.setId(rs.getString("id"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setAdmin(rs.getBoolean("admin"));

                list.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // SELECT BY ID
    public User findById(String id) {

        String sql =
                "SELECT * FROM Users WHERE id=?";

        try (
                Connection conn = Dbconnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                User user = new User();

                user.setId(rs.getString("id"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setAdmin(rs.getBoolean("admin"));

                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // INSERT
    public void create(User user) {

        String sql =
                "INSERT INTO Users VALUES(?,?,?,?,?,?)";

        try (
                Connection conn = Dbconnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, user.getId());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFullname());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPhone());
            ps.setBoolean(6, user.getAdmin());

            ps.executeUpdate();

            System.out.println("Insert Success");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void update(User user) {

        String sql =
                "UPDATE Users "
                        + "SET password=?,"
                        + "fullname=?,"
                        + "email=?,"
                        + "admin=? "
                        + "WHERE id=?";

        try (
                Connection conn = Dbconnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, user.getPassword());
            ps.setString(2, user.getFullname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());
            ps.setBoolean(5, user.getAdmin());
            ps.setString(6, user.getId());

            ps.executeUpdate();

            System.out.println("Update Success");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void delete(String id) {

        String sql =
                "DELETE FROM Users WHERE id=?";

        try (
                Connection conn = Dbconnector.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, id);

            ps.executeUpdate();

            System.out.println("Delete Success");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}