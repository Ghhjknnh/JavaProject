import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnect {  //DB교체시 login claas 와 같이 수정
	 private static Connection conn;

	    public static Connection getConnection() throws ClassNotFoundException, SQLException {
	        if (conn == null || conn.isClosed()) {
	            Class.forName("org.mariadb.jdbc.Driver");
	            conn = DriverManager.getConnection("jdbc:mariadb://221.141.176.19:3306/daiso", "test", "111");
	        }
	        return conn;
	    }
	    
}
