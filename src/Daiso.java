import java.util.Scanner;


public class Daiso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
			 while (true) {
		            System.out.println("1. 매장 물품 리스트\n2. 신규 물품 등록\n3. 매장 입출고 관리\n4. 끝내기");
		            System.out.print("메뉴를 선택하세요: ");
		            select = sc.nextInt();
		            switch (select) {
		                case 1:
		                    System.out.println("매장 물품 리스트를 출력합니다.");
		                    기능.물품리스트();
		                    break;
		                case 2:
		                    System.out.println("신규 물품 등록");
		                    기능.신규물품();
		                    break;
		                case 3:
		                    System.out.println("매장 입출고를 관리합니다.");
		                    System.out.println("1. 입고\n2. 출고");
		                    int inoutSelect = sc.nextInt();
		                    switch (inoutSelect) {
		                        case 1:
		                            System.out.println("물품을 입고합니다.");
		                            기능.입고();
		                            break;
		                        case 2:
		                            System.out.println("물품을 출고합니다.");
		                            기능.출고();
		                            break;
		                        default:
		                            System.out.println("잘못된 선택입니다.");
		                            break;
		                    }
		                    break;
		                case 4:
		                    System.out.println("프로그램을 종료합니다.");
		                    System.exit(0);
		                    break;
		                default:
		                    System.out.println("잘못된 선택입니다.");
		                    break;
		            }
		        }
		    
		}else{
			System.out.print("로그인 실패");
		}
		 
	
	}
}
