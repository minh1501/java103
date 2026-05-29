package dao;

import entity.User;
import utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public User login(String id, String password) {

        try {

            Connection con = DBConnect.getConnection();

            String sql = "SELECT * FROM Users WHERE Id=? AND Password=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, id);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                User u = new User();

                u.setId(rs.getString("Id"));
                u.setPassword(rs.getString("Password"));
                u.setEmail(rs.getString("Email"));
                u.setFullname(rs.getString("Fullname"));
                u.setAdmin(rs.getBoolean("Admin"));

                return u;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}