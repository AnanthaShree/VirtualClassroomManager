package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Updated driver class name for newer versions of the MySQL connector
            String url = "jdbc:mysql://localhost:3306/virtual_classroom_manager";
            String user = "root";
            String password = "Shree@123";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC driver not found.", e);
        }
    }
}
