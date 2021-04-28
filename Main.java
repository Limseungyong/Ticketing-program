package ticketingprogram;

import java.io.IOException;
import java.util.ArrayList;

import exchangeprogram.Constant;
import exchangeprogram.exchangetype;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Input input = new Input();
		FileWrite fw = new FileWrite();
		Ticketing tic = new Ticketing();
		
		ArrayList al = new ArrayList();
		
		fw.headerWrite();
		
		do {
			int ticketType = input.selectTicket();				         
	        
			if (ticketType == 1) {
				 tic.ticketType = "주간권";
	        	 String id = input.inputIDNumber();											//주민등록번호 입력
	        	 int age = Processing.calcAge(id);											//만 나이 계산
	        	 tic.group = Processing.ageGroup(age);										//나이별 그룹 지정
	        	 tic.orderCount = input.inputOrderCount();									//티켓 수량 입력
	        	 int price = Processing.ticketPrice(1, tic.group);							//티켓 가격
	        	 int discountTypeNum = input.selectDiscount();								//우대사항 선택 입력
	        	 tic.discountType = Processing.discountType(discountTypeNum);				//우대사항 고르기
	        	 int discountedPrice = Processing.priceDiscount(discountTypeNum, price);	//할인된 가격
	        	 tic.finalPrice = Processing.finalPrice(discountedPrice, tic.orderCount);	//할인된 가격 * 티켓 수량
	        	 Output.printPrice(tic.finalPrice);											//가격 출력
	        	 
	        	 al.add(tic.ticketType + " " + tic.group + "  X  " + (tic.orderCount + "") + "    " + (tic.finalPrice + "") + "원  " + "  *" + tic.discountType);
	        	 	        	 
	        } else if (ticketType == 2) { 	
	        	 tic.ticketType = "야간권";
	        	 String id = input.inputIDNumber();
	        	 int age = Processing.calcAge(id);
	        	 tic.group = Processing.ageGroup(age);
	        	 tic.orderCount = input.inputOrderCount();
	        	 int price = Processing.ticketPrice(2, tic.group);
	        	 int discountTypeNum = input.selectDiscount();
	        	 tic.discountType = Processing.discountType(discountTypeNum);
	        	 int discountedPrice = Processing.priceDiscount(discountTypeNum, price);
	        	 tic.finalPrice = Processing.finalPrice(discountedPrice, tic.orderCount);
	        	 Output.printPrice(tic.finalPrice);       
	        	 
	        	 al.add(tic.ticketType + " " + tic.group + "  X  " + (tic.orderCount + "") + "    " + (tic.finalPrice + "") + "원  " + "  *" + tic.discountType);
	        }
			
			fw.dataWrite(tic);
			
		} while (input.selectExit() != 2);
		
		fw.fileClose();
		Output.printOrder(al);    
	}
}
