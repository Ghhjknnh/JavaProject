import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class Login {

	public int authenticate(String id, String password) {
	    String url = "jdbc:mariadb://221.141.176.19:3306/daiso";
	    String username = "test";
	    String dbPassword = "111";

	    String query = "SELECT CASE " +
	                   "WHEN EXISTS (SELECT 1 FROM admin WHERE aid = ? AND apassword = ?) THEN 1 " +
	                   "WHEN EXISTS (SELECT 1 FROM customer WHERE cid = ? AND cpassword = ?) THEN 2 " +
	                   "ELSE 0 " +
	                   "END AS login_result";

	    int loginResult = 0; // Default to 0, indicating unsuccessful login

	    try (Connection connection = DriverManager.getConnection(url, username, dbPassword);
	         PreparedStatement pstmt = connection.prepareStatement(query)) {
	        pstmt.setString(1, id);
	        pstmt.setString(2, password);
	        pstmt.setString(3, id);
	        pstmt.setString(4, password);

	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                loginResult = rs.getInt("login_result");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return loginResult;
	}
	}

