import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBconnect {
	static final String DB_DRIVER_CLASS = "org.mariadb.jdbc.Driver";
	static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/daiso";
	static final String DB_USERNAME = "root";
	static final String DB_PASSWORD = "rlsmr123";
	
	static Connection conn;
	PreparedStatement pstmt = null;
	static void connectDB() {
		try {
			Class.forName(DB_DRIVER_CLASS);
			Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			System.out.println("DB 연결성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
		}
	}
}
	

