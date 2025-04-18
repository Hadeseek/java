import java.sql.*;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String user = "root";
        String password = "yourpassword"; // change this
        return DriverManager.getConnection(url, user, password);
    }
}
