package dao;

import model.User;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {

    public void insert(User user) {

        String sql =
        "INSERT INTO users(fullname,email,gender,major) VALUES(?,?,?,?)";

        try (
                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, user.getFullname());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getMajor());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}