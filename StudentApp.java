/*
 * Name: Your Name
 * PRN: Your PRN
 * Batch: Your Batch
 */

import java.sql.*;
import java.util.*;

public class StudentApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n--- Student Data Entry Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Student by PRN");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter PRN: ");
                        String prn = sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Batch: ");
                        String batch = sc.nextLine();
                        dao.addStudent(new Student(prn, name, batch));
                        System.out.println("Student added.");
                        break;

                    case 2:
                        List<Student> list = dao.getAllStudents();
                        for (Student s : list)
                            System.out.println(s.getPrn() + " | " + s.getName() + " | " + s.getBatch());
                        break;

                    case 3:
                        System.out.print("Enter PRN: ");
                        String searchPrn = sc.nextLine();
                        Student student = dao.getStudentByPRN(searchPrn);
                        if (student != null)
                            System.out.println(student.getPrn() + " | " + student.getName() + " | " + student.getBatch());
                        else
                            System.out.println("Student not found.");
                        break;

                    case 4:
                        System.out.print("Enter PRN to update: ");
                        String updatePrn = sc.nextLine();
                        System.out.print("Enter New Name: ");
                        String updateName = sc.nextLine();
                        System.out.print("Enter New Batch: ");
                        String updateBatch = sc.nextLine();
                        dao.updateStudent(new Student(updatePrn, updateName, updateBatch));
                        System.out.println("Student updated.");
                        break;

                    case 5:
                        System.out.print("Enter PRN to delete: ");
                        String delPrn = sc.nextLine();
                        dao.deleteStudent(delPrn);
                        System.out.println("Student deleted.");
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
