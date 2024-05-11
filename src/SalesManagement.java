import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Date;

public class SalesManagement {
	Scanner sc=new Scanner(System.in);
	Connection conn; 
	Statement stmt = null;
	
	void daily(int year,int month, int day) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");		
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/daiso", "root","rlsmr123");
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT SUM(price) AS dailytotal " +
                    "FROM sales " +
                    "WHERE DATE(date) = '" + year + "-" + month + "-" + day + "'");
	
				 if (rs.next()) {
                     double dailyTotal = rs.getInt("dailytotal");
                     System.out.println("일매출 총액: " + dailyTotal + "원");
                 }
				
			
			
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}
	
	void monthly(int year,int month) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");		
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/daiso", "root","rlsmr123");
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT YEAR(date) AS sales_year, MONTH(date) AS sales_month, SUM(price) AS monthly_total " +
                    "FROM sales " +
                    "WHERE YEAR(date) = " + year + " AND MONTH(date) = " + month + " " +
                    "GROUP BY YEAR(date), MONTH(date)");
	
				 if (rs.next()) {
					 int salesYear = rs.getInt("sales_year");
		                int salesMonth = rs.getInt("sales_month");
		                double monthlyTotal = rs.getDouble("monthly_total");
		                System.out.println(salesYear + "년 " + salesMonth + "월 매출 총액: " + monthlyTotal);
		            } else {
		                System.out.println("해당 연도와 월에 매출이 없습니다.");
		            }
                 
				
			
			
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}
}
