package ticketingprogram;

import java.util.ArrayList;

public class Output {
		
	
	// 티켓 가격 출력
	
	public static void printPrice(double finalPrice) {
		System.out.printf("가격은 %d 원 입니다.\n", (int)finalPrice);
		System.out.printf("감사합니다.\n\n");
	}	        	
	
	// 주문 내역 출력
	
	public static void printOrder(ArrayList al) {
		System.out.printf("==================== 에버랜드 ====================\n");
		for (int i = 0; i < al.size(); i++) {
		System.out.printf("%s\n", al.get(i));		
		}
	}
	
	// 주문 내역 파일로 출력
	
	
	// 이어서 주문 or 주문내역 출력 후 종료
}
