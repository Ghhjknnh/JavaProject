import java.util.Scanner;


public class Daiso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProductManager 물품관리 =new ProductManager();
		CustomerManagement 고객관리 = new CustomerManagement();
		CustomerPage customer = new CustomerPage();
		AdminPage admin = new AdminPage();
		
		Scanner sc = new Scanner(System.in);
		int select;
		System.out.println("다이소 매장관리 프로그램");
		
		System.out.print("아이디를 입력해주세요: ");
		String id = sc.next();
		System.out.print("비밀번호를 입력해주세요: ");
		String password = sc.next();
		
		Login login = new Login();
		int loginSuccess = login.authenticate(id, password);
		
		       
		    
		
		if(loginSuccess==1) {
			System.out.println("관리자 로그인");
				 	while (true) {
			            System.out.println("1. 매장 물품 리스트\n2. 신규 물품 등록\n3. 매장 입출고 관리\n4. 매장매출확인\n5. 끝내기");
			            System.out.print("메뉴를 선택하세요: ");
			            select = sc.nextInt();
			            admin.admin(id, select);
		            }
		    
		}else if(loginSuccess==2){
			System.out.println("환영합니다.");
					while(true) {
						System.out.println("1. 물품 구매\n2. 물품검색 \n3. 구매기록 확인\n4. 끝내기");
			            System.out.print("메뉴를 선택하세요: ");
			            select = sc.nextInt();
			            customer.customer(id,select);
			        }
            
		}else {System.out.print("일치하는 아이디가 없습니다.");}
		
		 
	
	}
}
