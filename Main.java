package ticketingprogram;

import exchangeprogram.Constant;
import exchangeprogram.exchangetype;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Input input = new Input();	
				
		do {
			int ticketType = input.selectTicket();				         
	        if (ticketType == 1) {			
	        	 String id = input.inputIDNumber();
	        	 int age = Processing.calcAge(id);
	        	 int groupNum = Processing.ageGroup(age);
	        	 int orderCount = input.inputOrderCount();
	        	 int price = Processing.ticketPrice(1, groupNum);
	        	 int discountType = input.selectDiscount();
	        	 double discountedPrice = Processing.priceDiscount(discountType, price);
	        	 double finalPrice = Processing.finalPrice((int)discountedPrice, orderCount);
	        	 System.out.printf("가격은 %d 원 입니다.\n", (int)finalPrice);
	        	 System.out.printf("감사합니다.\n");
	        	 	        	 
	        } else if (ticketType == 2) { 	
	        	String id = input.inputIDNumber();
	        	 int age = Processing.calcAge(id);
	        	 int groupNum = Processing.ageGroup(age);
	        	 int orderCount = input.inputOrderCount();
	        	 int price = Processing.ticketPrice(2, groupNum);
	        	 int discountType = input.selectDiscount();
	        	 double discountedPrice = Processing.priceDiscount(discountType, price);
	        	 double finalPrice = Processing.finalPrice((int)discountedPrice, orderCount);
	        	 System.out.printf("가격은 %d 원 입니다.\n", (int)finalPrice);
	        	 System.out.printf("감사합니다.\n");	        	 
	        }   	        
	        int exit = input.selectExit();
	        
		} while (input.selectExit() != 2);	        
	}
}
