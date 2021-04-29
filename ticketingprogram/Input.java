package ticketingprogram;

import java.util.Scanner;

public class Input {
	
	public static Scanner s = new Scanner(System.in);
	public static Ticketing tic = new Ticketing();
		
	// 권종 입력
	public static int selectTicket() {
		
		int w = 0;
		while (true) {
			System.out.printf("권종을 선택하세요.\n");
			System.out.printf("1. 주간권\n");
			System.out.printf("2. 야간권\n");	
			w = s.nextInt();
			if ( w <  1 || w > 2) {
				System.out.printf("잘못된 번호입니다. 다시 입력하세요.\n");
			} else {
				break;
			}
		}		
		return w;
	}
	
	// 주민등록번호 입력
	public static String inputIDNumber() { 
		
		tic.id = "";
		while (true) {
			System.out.printf("주민등록번호 앞에서 7자리를 입력하세요\n");
			tic.id = s.next();
			if (tic.id.length() != 7) {
				System.out.printf("주민등록번호 앞에서 7자리를 다시 정확하게 입력하십시오.\n");
			} else {
				break;
			}
		}
		return tic.id;
	}	
		
	// 티켓 수량 입력
	public static int inputOrderCount() {
		
		int w = 0;
		while (true) {
			System.out.printf("몇개를 주문하시겠습니까? (최대 10개)\n");
			w = s.nextInt();
			if ( w <  Constant.min_count || w > Constant.max_count) {
			System.out.printf("티켓은 1장 이상 최대 10장까지만 구매 가능합니다.\n");
			} else if ( Constant.min_count <= w && w <= Constant.max_count) {
				break;
			}
		}		
		return w;
	}
			
	// 우대사항 입력
	public static int selectDiscount() {
		
		tic.discountTypeNum = 0;
		while (true) {
			System.out.printf("우대사항을 선택하세요.\n");
			System.out.printf("1. 없음 (나이 우대는 자동처리)\n");
			System.out.printf("2. 장애인\n");
			System.out.printf("3. 국가유공자\n");
			System.out.printf("4. 다자녀\n");
			System.out.printf("5. 임산부\n");
			tic.discountTypeNum = s.nextInt();
			if ( tic.discountTypeNum <  1 || tic.discountTypeNum > 5) {
			System.out.printf("잘못된 번호입니다. 다시 입력하세요.\n");
			} else {
				break;
			}
		}		
		return tic.discountTypeNum;
	}
	
	//계속 실행 여부
	public static int selectExit() {
		
		int w = 0;
		while (true) {
			System.out.printf("계속 발권 하시겠습니까?\n");
			System.out.printf("1. 티켓 발권\n");
			System.out.printf("2. 종료\n");
			w = s.nextInt();
			if ( w <  1 || w > 2) {
			System.out.printf("잘못된 번호입니다. 다시 입력하세요.\n");
			} else {
				break;
			}
		}
		if (w == 2) {
			System.out.printf("티켓 발권을 종료합니다. 감사합니다\n\n");
		}
		return w;
	}	
}
