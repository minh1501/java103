package dao;

import entity.Video;
import utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VideoDAO {

    public List<Video> findAll() {

        List<Video> list = new ArrayList<>();

        try {
            Connection con = DBConnect.getConnection();

            String sql = "SELECT * FROM Videos ORDER BY Views DESC";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Video v = new Video();

                v.setId(rs.getString("Id"));
                v.setTitle(rs.getString("Title"));
                v.setPoster(rs.getString("Poster"));
                v.setViews(rs.getInt("Views"));
                v.setDescription(rs.getString("Description"));
                v.setActive(rs.getBoolean("Active"));

                list.add(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}