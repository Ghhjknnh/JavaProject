import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class ProductManager {
	Scanner sc=new Scanner(System.in);
	Connection conn; 
	Statement stmt = null;
	public void 물품리스트() {
		try {
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from product");
			while (rs.next()) {
				int pid = rs.getInt("pid");
				String pName = rs.getString("pname");
				int pprice = rs.getInt("pprice");
				int pcount = rs.getInt("pcount");
				String	ploction = rs.getString("plocation");
				
				System.out.println("물품:" + pName + "\n" +
		                   "물품개수:" + pcount + "\n" +
		                   "가격:" + pprice + "\n" +
		                   "위치:" + ploction + "\n");
			}
			
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}
	
	public void 물품검색(String name) {
		try {
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM product WHERE pname = '" + name + "'");
			if(rs.next()) {
				
				String pName = rs.getString("pname");
				int pprice = rs.getInt("pprice");
				String	ploction = rs.getString("plocation");
				
				System.out.println("물품:" + pName + "\t" +
		                   "가격:" + pprice + "\t" +
		                   "위치:" + ploction);
			     
			}else {System.out.println("해당하는 상품이 없습니다.");}
			
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}
	
	
	
	public void 신규물품() {
		
		
		System.out.println("등록할 제품의 이름, 수량, 위치, 가격을 입력해주세요");
		String name = sc.next();
		int	   price = sc.nextInt();
		String location = sc.next();
		int	   pcount = sc.nextInt();
		try {
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
			
			int i = stmt.executeUpdate("INSERT INTO product(pname, pprice, plocation, pcount) VALUES ('" + 
	                name + "', " + pcount + ", '" + location + "', " + price + ");");
			
			if (i == 1) 
				System.out.println("상품이 등록 되었습니다");
			else
				System.out.println("데이터 입력 오류입니다.");
			
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
		
	}
	
	public void 입고() {
		
		
		System.out.println("입고시킬 제품의 이름과 수량을 입력해주세요");
		String	pname = sc.next();
		int pcount = sc.nextInt();
		
		try {
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
			
			int i = stmt.executeUpdate("UPDATE product SET pcount = pcount + " + pcount + " WHERE pname = '" + pname + "'");
			
			if (i == 1) 
				System.out.println("1개의 상품이 입고 되었습니다");
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
			
			
			System.out.println("출고시킬 제품의 이름과 수량을 입력해주세요");
			String	pname = sc.next();
			int pcount = sc.nextInt();
			
			try {
				conn = DBconnect.getConnection();
				stmt = conn.createStatement();
				
				int i = stmt.executeUpdate("UPDATE product SET pcount = pcount - " + pcount + " WHERE pname = '" + pname + "'");
				
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

