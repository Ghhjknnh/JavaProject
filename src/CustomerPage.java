import java.util.Scanner;


public class CustomerPage {
	ProductManager 물품관리 =new ProductManager();
	CustomerManagement 고객관리 = new CustomerManagement();
	Scanner sc = new Scanner(System.in);
	
	void customer(String id,int select) {
          switch (select) {
	            case 1:
	                System.out.println("구매하고싶은 물품의 이름과 수량을 입력해주세요");
	                System.out.print("물품:");
	                String name = sc.next();
	                System.out.print("수량:");
	                int count = sc.nextInt();
	                고객관리.구매(id,name, count);
	                break;
	            case 2:
	                System.out.println("검색하고자하는 물품의 이름을 입력해주세요:");
	                name = sc.next();
	                물품관리.물품검색(name);
	                break;
	            case 3:
	                System.out.println("구매기록 확인");
	                고객관리.구매기록(id);              
	                        
	                
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
}
