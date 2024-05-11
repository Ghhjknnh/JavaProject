import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Function {
	Scanner sc=new Scanner(System.in);
	Connection conn; 
	Statement stmt = null;
	
	public void 물품리스트() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");		// org.mariadb.jdbc.Driver 또는 com.mysql.jdbc.Driver
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/daiso", "root","rlsmr123");
											// jdbc:mariadb: 또는 jdbc:mysql: 시놀로지 마리아DB 5 연결
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from product");
			while (rs.next()) {
				int pid = rs.getInt("pid");
				String pName = rs.getString("pname");
				int pprice = rs.getInt("pprice");
				int pcount = rs.getInt("pcount");
				String	ploction = rs.getString("plocation");
				
				System.out.println("물품번호:" + pid + "\t"+ "물품개수:" + pcount + "\t" +"물품:"+ pName + "\t" +"가격:" + pprice + "\t" + "위치:"+ ploction);
			}
			
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}
	
	
	
	public void 입고() {
		
		
		System.out.println("입고시킬 제품의 이름과 가격, 위치, 수량을 입력해주세요");
		String name = sc.next();
		int	   price = sc.nextInt();
		String location = sc.next();
		int	   pcount = sc.nextInt();
		try {
			Class.forName("org.mariadb.jdbc.Driver");		
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/daiso", "root","rlsmr123");
															
			stmt = conn.createStatement();
			
			int i = stmt.executeUpdate("INSERT INTO product(pname, pprice, plocation, pcount) VALUES ('" + 
	                name + "', " + price + ", '" + location + "', " + pcount + ");");
			
			if (i == 1) 
				System.out.println("상품이 입고 되었습니다");
			else
				System.out.println("데이터 입력 오류입니다.");
			
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
		
	}
	public void 출고() {
			
			
			System.out.println("출고시킬 제품의 번호를 입력해주세요");
			int	   pid = sc.nextInt();
			
			try {
				Class.forName("org.mariadb.jdbc.Driver");		
				conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/daiso", "root","rlsmr123");
																
				stmt = conn.createStatement();
				
				int i = stmt.executeUpdate("DELETE FROM product WHERE pid =" + pid);
				
				if (i == 1) 
					System.out.println("1개의 상품이 출고 되었습니다");
				else
					System.out.println("데이터 입력 오류입니다.");
				
				conn.close();
			} catch (ClassNotFoundException e) {
				System.out.println("JDBC 드라이버 로드 에러");
			} catch (SQLException e) {
				System.out.println("DB 연결 오류");
			}
			
		}
  
}

