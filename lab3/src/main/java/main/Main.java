package main;

import dao.EmployeeDAO;
import model.Employee;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeDAO dao = new EmployeeDAO();

        while (true) {

            System.out.println("\n========== MENU ==========");

            System.out.println("1. Thêm nhân viên");

            System.out.println("2. Hiển thị danh sách");

            System.out.println("3. Tìm theo mã");

            System.out.println("4. Cập nhật");

            System.out.println("5. Xóa");

            System.out.println("6. Tìm kiếm");

            System.out.println("7. Thoát");

            System.out.print("Chọn: ");

            int choice =
                    Integer.parseInt(sc.nextLine());

            switch (choice) {

                // =========================
                // INSERT
                // =========================

                case 1:

                    Employee e = new Employee();

                    System.out.print("Mã: ");
                    e.setEmpCode(sc.nextLine());

                    System.out.print("Tên: ");
                    e.setFullName(sc.nextLine());

                    System.out.print("Email: ");
                    e.setEmail(sc.nextLine());

                    System.out.print("Phone: ");
                    e.setPhone(sc.nextLine());

                    System.out.print("Gender: ");
                    e.setGender(sc.nextLine());

                    System.out.print(
                            "Birth date (yyyy-mm-dd): "
                    );

                    e.setBirthDate(
                            LocalDate.parse(
                                    sc.nextLine()
                            )
                    );

                    System.out.print("Department: ");
                    e.setDepartment(sc.nextLine());

                    System.out.print("Position: ");
                    e.setPosition(sc.nextLine());

                    System.out.print("Salary: ");

                    e.setSalary(
                            Double.parseDouble(
                                    sc.nextLine()
                            )
                    );

                    boolean inserted =
                            dao.insert(e);

                    if (inserted) {

                        System.out.println(
                                "Thêm thành công"
                        );

                    } else {

                        System.out.println(
                                "Thêm thất bại"
                        );
                    }

                    break;

                // =========================
                // GET ALL
                // =========================

                case 2:

                    dao.getAll();

                    break;

                // =========================
                // FIND BY CODE
                // =========================

                case 3:

                    System.out.print(
                            "Nhập mã nhân viên: "
                    );

                    String code =
                            sc.nextLine();

                    dao.findByCode(code);

                    break;

                // =========================
                // UPDATE
                // =========================

                case 4:

                    Employee updateEmp =
                            new Employee();

                    System.out.print(
                            "Nhập mã cần sửa: "
                    );

                    updateEmp.setEmpCode(
                            sc.nextLine()
                    );

                    System.out.print("Tên mới: ");

                    updateEmp.setFullName(
                            sc.nextLine()
                    );

                    System.out.print("Email mới: ");

                    updateEmp.setEmail(
                            sc.nextLine()
                    );

                    System.out.print("Phone mới: ");

                    updateEmp.setPhone(
                            sc.nextLine()
                    );

                    System.out.print("Gender mới: ");

                    updateEmp.setGender(
                            sc.nextLine()
                    );

                    System.out.print(
                            "Birth date mới: "
                    );

                    updateEmp.setBirthDate(
                            LocalDate.parse(
                                    sc.nextLine()
                            )
                    );

                    System.out.print(
                            "Department mới: "
                    );

                    updateEmp.setDepartment(
                            sc.nextLine()
                    );

                    System.out.print(
                            "Position mới: "
                    );

                    updateEmp.setPosition(
                            sc.nextLine()
                    );

                    System.out.print(
                            "Salary mới: "
                    );

                    updateEmp.setSalary(
                            Double.parseDouble(
                                    sc.nextLine()
                            )
                    );

                    boolean updated =
                            dao.update(updateEmp);

                    if (updated) {

                        System.out.println(
                                "Cập nhật thành công"
                        );

                    } else {

                        System.out.println(
                                "Cập nhật thất bại"
                        );
                    }

                    break;

                // =========================
                // DELETE
                // =========================

                case 5:

                    System.out.print(
                            "Nhập mã cần xóa: "
                    );

                    String deleteCode =
                            sc.nextLine();

                    boolean deleted =
                            dao.delete(deleteCode);

                    if (deleted) {

                        System.out.println(
                                "Xóa thành công"
                        );

                    } else {

                        System.out.println(
                                "Xóa thất bại"
                        );
                    }

                    break;

                // =========================
                // SEARCH
                // =========================

                case 6:

                    System.out.print(
                            "Nhập từ khóa tìm kiếm: "
                    );

                    String keyword =
                            sc.nextLine();

                    dao.search(keyword);

                    break;

                // =========================
                // EXIT
                // =========================

                case 7:

                    System.out.println(
                            "Thoát chương trình"
                    );

                    System.exit(0);

                    break;

                default:

                    System.out.println(
                            "Lựa chọn không hợp lệ"
                    );
            }
        }
    }
}