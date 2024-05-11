import java.util.Scanner;


public class Daiso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBconnect test = new DBconnect();
		test.connectDB();
		Function 기능 = new Function();
		Scanner sc = new Scanner(System.in);
		int select;
		System.out.println("다이소 매장관리 프로그램");
		
		System.out.print("아이디를 입력해주세요");
		String id = sc.next();
		System.out.print("비밀번호를 입력해주세요");
		String password = sc.next();
		
		Login login = new Login();
		boolean loginSuccess = login.authenticate(id, password);
		
		       
		    
		
		if(loginSuccess==true) {
			while(true) {
				System.out.println("1.매장 물품 리스트\n2.매장 물품 검색\n3.매장 입출고 관리\n4.끝내기");
				select = sc.nextInt();
				switch(select) {
				case 1 : {기능.물품리스트(); continue;}
				case 2 : 
				case 3 : System.out.print("1.입고\n2.출고");
							select = sc.nextInt();
							switch(select){
							case 1: {기능.입고(); continue;}
							case 2: {기능.출고(); continue;}
							}
							
				case 4 : {System.out.print("종료합니다"); break;}
				}
			}
		}else{
			System.out.print("로그인 실패");
		}
		 
	
	}
}
