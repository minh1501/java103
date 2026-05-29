package bai1;

import utils.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListEmployee {

    public static void main(String[] args) {

        try (

                Connection conn =
                        DBConnection.getConnection();

                Statement st =
                        conn.createStatement()

        ) {

            // =========================
            // 1. Hiển thị danh sách
            // =========================

            String sql1 =
                    "SELECT * FROM employees";

            ResultSet rs1 =
                    st.executeQuery(sql1);

            System.out.println(
                    "===== DANH SÁCH NHÂN VIÊN ====="
            );

            while (rs1.next()) {

                System.out.println(

                        rs1.getInt("id")
                                + " - " +

                        rs1.getString("full_name")
                                + " - " +

                        rs1.getString("email")
                                + " - " +

                        rs1.getDouble("salary")
                );
            }

            // =========================
            // 2. Đếm số nhân viên
            // =========================

            String sql2 =
                    "SELECT COUNT(*) AS total " +
                    "FROM employees";

            ResultSet rs2 =
                    st.executeQuery(sql2);

            if (rs2.next()) {

                System.out.println(
                        "\nTổng nhân viên: "
                                + rs2.getInt("total")
                );
            }

            // =========================
            // 3. Phòng ban >= 2 nhân viên
            // =========================

            String sql3 =

                    "SELECT d.name, COUNT(e.id) AS total " +

                    "FROM departments d " +

                    "JOIN employees e " +

                    "ON d.id = e.department_id " +

                    "GROUP BY d.id " +

                    "HAVING COUNT(e.id) >= 2";

            ResultSet rs3 =
                    st.executeQuery(sql3);

            System.out.println(
                    "\n===== PHÒNG BAN >= 2 NHÂN VIÊN ====="
            );

            while (rs3.next()) {

                System.out.println(

                        rs3.getString("name")
                                + " - " +

                        rs3.getInt("total")
                );
            }

            // =========================
            // 4. Thống kê phòng ban
            // =========================

            String sql4 =

                    "SELECT d.name, COUNT(e.id) AS total " +

                    "FROM departments d " +

                    "LEFT JOIN employees e " +

                    "ON d.id = e.department_id " +

                    "GROUP BY d.id";

            ResultSet rs4 =
                    st.executeQuery(sql4);

            System.out.println(
                    "\n===== THỐNG KÊ PHÒNG BAN ====="
            );

            while (rs4.next()) {

                System.out.println(

                        rs4.getString("name")
                                + " - " +

                        rs4.getInt("total")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}