import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Date;



public class CustomerManagement {
	Scanner sc=new Scanner(System.in);
	Connection conn; 
	Statement stmt = null;
	DBconnect db = new DBconnect();
	public void 구매(String id,String name,int count) {
		try {
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT pname, pcount, pprice FROM product WHERE pname = '" + name + "'");
			
			if (rs.next()) {
			    String pName = rs.getString("pname");
			    int pprice = rs.getInt("pprice");
			    int cost = pprice * count;
			    int pcount = rs.getInt("pcount");
			    
			    
			    if(pcount == 0) {
		    	System.out.println("현재"+ pName + "제품의 재고가 없습니다.");
			    }else {
				    System.out.println("물품:" + pName + " 수량:" + count + " 가격:" + cost +"\n구매하시겠습니까? 1.구매/2.취소");
				    int select = sc.nextInt();
				    if(select == 1) {
				    	System.out.println("1개상품이 구매되었습니다.");
				    	stmt.executeUpdate("UPDATE product SET pcount = pcount - " + count + " WHERE pname = '" + name + "'");
				    	stmt.executeUpdate("INSERT INTO sales(cid,pname, price,pcount) VALUES ('"+ id + "','" + 
				                name + "', " + cost + ", " + count + ");");
				    }
				    else if(select == 2) {System.out.print("주문이 취소 되었습니다");}
				    else {System.out.print("잘못 입력 하셨습니다");}
				    } 
			}
			else {
			    System.out.println("일치하는 물품이 없습니다.");
			}
			
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}
	
	
	public void 구매기록(String id) {  //이름 테이블 만들어서 "이름"님의 구매기록 만들기
		try {
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM sales WHERE cid = '" + id + "'");
			while (rs.next()) {
				String pName = rs.getString("pname");
				int pprice = rs.getInt("price");
				int pcount = rs.getInt("pcount");
				Date date = rs.getDate("date");
				
				
				System.out.println("날짜:" + date.toString() + "\t" +
						"물품:" + pName + "\t" +
		                   "수량:" + pcount + "\t" +
		                   "가격:" + pprice);
			}
			
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}
	
	
	
}
