import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Name {
	Connection conn; 
	Statement stmt = null;
	DBconnect db = new DBconnect();
	
	String Get_name(String id) {
		String name = null;
		try {
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT name FROM customer WHERE cid = '" + id + "'");
			while (rs.next()) {
				
				name = rs.getString("name");
			}
			
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
	
		return name;
	}
}
