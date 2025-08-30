package university.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLLoginCheck {
    // Database URL, username, and password
    static final String DB_URL = "jdbc:mysql://localhost:3306/universitymanagement"; // Connect to the specific database
    static final String USER = "root"; // Change this to your MySQL username
    static final String PASS = "112233"; // Change this to your MySQL password

    public static void main(String[] args) {
        String inputUsername = "admin"; // Replace with the username you want to check
        String inputPassword = "admin"; // Replace with the password you want to check

        Connection conn = null;

        try {
            // Establish the connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the MySQL server and database 'universitymanagement' successfully!");

            // Prepare SQL query to check login credentials
            String sql = "SELECT * FROM login WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, inputUsername);
            pstmt.setString(2, inputPassword);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Check if any record exists
            if (rs.next()) {
                System.out.println("Login successful! Welcome, " + inputUsername + "!");
            } else {
                System.out.println("Invalid username or password.");
            }

            // Close the ResultSet and PreparedStatement
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            // Handle any SQL exceptions
            System.out.println("Connection failed!");
            e.printStackTrace();
        } finally {
            // Close the connection if it was established
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
