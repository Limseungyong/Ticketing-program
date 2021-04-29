package ticketingprogram;

import java.util.ArrayList;

public class Output {
		
	public static Ticketing tic = new Ticketing();

	// 티켓 가격 출력	
	public static void printPrice(double finalPrice) {
		System.out.printf("가격은 %d 원 입니다.\n", (int)finalPrice);
		System.out.printf("감사합니다.\n\n");
	}	        	
	
	// 총 주문 내역 출력	
	public static void printOrder(ArrayList al) {
		System.out.printf("==================== 에버랜드 ====================\n");
		
		for (int i = 0; i < al.size(); i++) {
			System.out.printf("%s\n", al.get(i)); 		
		}
		System.out.println();
		System.out.printf("입장료 총액은 %d원 입니다.\n", tic.finalSum );
		System.out.printf("==================================================\n\n");
	}
}
