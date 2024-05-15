import java.util.Scanner;


public class AdminPage {
	ProductManager 물품관리 =new ProductManager();
	CustomerManagement 고객관리 = new CustomerManagement();
	SalesManagement 매출관리 = new SalesManagement();
	Scanner sc = new Scanner(System.in);
	
	
	void admin(String id,int select) { //월별,일별 매출 확인표 추가
        switch (select) {
            case 1:
                System.out.println("매장 물품 리스트를 출력합니다.");
                물품관리.물품리스트();
                break;
            case 2:
                System.out.println("신규 물품 등록");
                물품관리.신규물품();
                break;
            case 3:
                System.out.println("매장 입출고를 관리합니다.");
                System.out.println("1. 입고\n2. 출고");
                int inoutSelect = sc.nextInt();
                switch (inoutSelect) {
                    case 1:
                        System.out.println("물품을 입고합니다.");
                        물품관리.입고();
                        break;
                    case 2:
                        System.out.println("물품을 출고합니다.");
                        물품관리.출고();
                        break;
                    default:
                        System.out.println("잘못된 선택입니다.");
                        break;
                }
                break;
            case 4:
            	System.out.println("1.일매출 2.월매출");
            	select = sc.nextInt();
            	switch(select){
            
            	case 1: System.out.println("확인하고 싶은 날짜를 년 월 일 순으로 입력해주세요");
		                System.out.print("년도:");
		                int year = sc.nextInt();
		                System.out.print("월:");
		                int month = sc.nextInt();
		                System.out.print("일:");
		                int day = sc.nextInt();
		                매출관리.daily(year, month, day);
		                break;
		                
            	case 2: System.out.println("확인하고 싶은 날짜를 년 월 순으로 입력해주세요");
		                System.out.print("년도:");
		                year = sc.nextInt();
		                System.out.print("월:");
		                month = sc.nextInt();
		                매출관리.monthly(year, month);
		                break;
            	default:
	                    System.out.println("잘못된 선택입니다.");
	                    break;
            			}
                break;
                
                
            case 5:
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
                break;
            default:
                System.out.println("잘못된 선택입니다.");
                break;
        }
	}
}
