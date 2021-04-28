package ticketingprogram;

import java.util.Scanner;

public class Input {
	
	public static Scanner s = new Scanner(System.in);
		
	//  권종 입력
	public static int selectTicket() {
		
		System.out.printf("권종을 선택하세요.\n");
		System.out.printf("1. 주간권\n");
		System.out.printf("2. 야간권\n");		
		return s.nextInt();
	}
	
	// 주민등록번호 입력
	public static String inputIDNumber() { 
		
		System.out.printf("주민번호를 입력하세요\n");
		String w = s.next();
		return w;
	}
		
	// 주문 갯수 입력
	public static int inputOrderCount() {
		
		System.out.printf("몇개를 주문하시겠습니까? (최대 10개)\n");
		int w = s.nextInt();
		return w;
	}
		
	// 우대사항 입력
	public static int selectDiscount() {
		
		System.out.printf("우대사항을 선택하세요.\n");
		System.out.printf("1. 없음 (나이 우대는 자동처리)\n");
		System.out.printf("2. 장애인\n");
		System.out.printf("3. 국가유공자\n");
		System.out.printf("4. 다자녀\n");
		System.out.printf("5. 임산부\n");
		int w = s.nextInt();
		return w;
	}
	
	//실행 여부
	public static int selectExit() {
		
		System.out.printf("계속 발권 하시겠습니까?\n");
		System.out.printf("1. 티켓 발권\n");
		System.out.printf("2. 종료\n");
		int w = s.nextInt();
		if (w == 1) {
			selectTicket();
		}
		return w;
		
	}
	
	
	// 입력 함수 호출
	
	
}
