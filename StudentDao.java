import java.sql.*;
import java.util.*;

public class StudentDAO {

    // Insert student
    public void addStudent(Student student) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO students (prn, name, batch) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, student.getPrn());
        ps.setString(2, student.getName());
        ps.setString(3, student.getBatch());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    // View all students
    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM students";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            students.add(new Student(rs.getString("prn"), rs.getString("name"), rs.getString("batch")));
        }
        rs.close();
        stmt.close();
        conn.close();
        return students;
    }

    // View student by PRN
    public Student getStudentByPRN(String prn) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM students WHERE prn=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, prn);
        ResultSet rs = ps.executeQuery();
        Student student = null;
        if (rs.next()) {
            student = new Student(rs.getString("prn"), rs.getString("name"), rs.getString("batch"));
        }
        rs.close();
        ps.close();
        conn.close();
        return student;
    }

    // Update student
    public void updateStudent(Student student) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE students SET name=?, batch=? WHERE prn=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, student.getName());
        ps.setString(2, student.getBatch());
        ps.setString(3, student.getPrn());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    // Delete student
    public void deleteStudent(String prn) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM students WHERE prn=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, prn);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}
