import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;


public class Login {

	    public boolean authenticate(String id, String password) {
	        String url = "jdbc:mariadb://127.0.0.1:3306/daiso";
	        String username = "root";
	        String dbPassword = "rlsmr123";

	        String query = "SELECT EXISTS (SELECT 1 FROM admin WHERE id = ? AND password = ?) AS result";
	        boolean loginSuccess = false;

	        try (Connection connection = DriverManager.getConnection(url, username, dbPassword);
	             PreparedStatement pstmt = connection.prepareStatement(query)) {
	            pstmt.setString(1, id);
	            pstmt.setString(2, password);

	            try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    int result = rs.getInt("result");
	                    loginSuccess = result == 1;
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return loginSuccess;
	    }
	}

