package ticketingprogram;

import java.util.ArrayList;
import java.util.Calendar;

public class Processing {
	
	public static Ticketing tic = new Ticketing();
	public static Input input = new Input();
	public static ArrayList al = new ArrayList();		
	
	// 만나이 계산
	static int calcAge(String inputIDNumber) {
		
		Calendar cal = Calendar.getInstance();
			
		String year = inputIDNumber.substring(0,2);
		int age = Integer.parseInt(year);
		tic.age = 0;
		
		String month = inputIDNumber.substring(2,4);
		int month2 = Integer.parseInt(month);
		int month3 = 0;
		
		String day = inputIDNumber.substring(4,6);
		int day2 = Integer.parseInt(day);
		int day3 = 0;
		
		char ch = inputIDNumber.charAt(6);
		
		if (month2 - (cal.get(Calendar.MONTH) + 1) > 0) {
			
				if (ch == '1' || ch == '2') {
					tic.age = (cal.get(Calendar.YEAR)) - (1900 + age + 1);
				} else if (ch == '3' || ch == '4') {
					tic.age = (cal.get(Calendar.YEAR)) - (2000 + age + 1);
				}
			
		} else if (month2 - (cal.get(Calendar.MONTH) + 1) < 0) {
			
				if (ch == '1' || ch == '2') {
					tic.age = (cal.get(Calendar.YEAR)) - (1900 + age);
				} else if (ch == '3' || ch == '4') {
					tic.age = (cal.get(Calendar.YEAR)) - (2000 + age);
				}
			
		} else if (month2 - (cal.get(Calendar.MONTH) + 1) == 0) {
			if (day2 - (cal.get(Calendar.DATE)) <= 0) { 
				if (ch == '1' || ch == '2') {
					tic.age = (cal.get(Calendar.YEAR)) - (1900 + age);
				} else if (ch == '3' || ch == '4') {
					tic.age = (cal.get(Calendar.YEAR)) - (2000 + age);
				}
			} else if (day2 - (cal.get(Calendar.DATE)) > 0) { 
				if (ch == '1' || ch == '2') {
					tic.age = (cal.get(Calendar.YEAR)) - (1900 + age + 1);
				} else if (ch == '3' || ch == '4') {
					tic.age = (cal.get(Calendar.YEAR)) - (2000 + age + 1);
				}
			}
		}
		return tic.age;	
	}

	// 연령대 별 분류
	static String ageGroup(int age) {		
		String group = "";
		if (Constant.min_baby <= age && age < Constant.min_child) {
			group = Constant.baby;
		} else if (Constant.min_child <= age && age < Constant.min_teen) {
			group = Constant.child;
		} else if (Constant.min_teen <= age && age < Constant.min_adult) {
			group = Constant.teen;
		} else if (Constant.min_adult <= age && age <= Constant.max_adult) {
			group = Constant.adult;
		} else if (age > Constant.max_adult) {
			group = Constant.old;
		}
		return group;
	}
	
	// 주/야권과 나이에 따른 금액 계산
	static int ticketPrice(int ticketType, String group) {
		tic.price = 0;
		if (ticketType == 1) {
			if (group.equals("신생아")) {
				tic.price = Constant.baby_price;
			} else if (group.equals("아이")) {
				tic.price = Constant.child_day_price;
			} else if (group.equals("청소년")) {
				tic.price = Constant.teen_day_price;
			} else if (group.equals("어른")) {
				tic.price =  Constant.adult_day_price;
			} else if (group.equals("노인")) {
				tic.price = Constant.old_day_price;
			}			
		} else if (ticketType == 2) {
			if (group.equals("신생아")) {
				tic.price = Constant.baby_price;
			} else if (group.equals("아이")) {
				tic.price = Constant.child_night_price;
			} else if (group.equals("청소년")) {
				tic.price = Constant.teen_night_price;
			} else if (group.equals("어른")) {
				tic.price = Constant.adult_night_price;
			} else if (group.equals("노인")) {
				tic.price = Constant.old_night_price;
			}		
		}
		return tic.price;
	}
		
	// 우대사항에 따른 할인된 금액 계산
	static int priceDiscount(int discountType, int price) {
		tic.discountedPrice = 0;
		if (discountType == 1) {
			tic.discountedPrice = price;
		} else if (discountType == 2) {
			tic.discountedPrice = (int)(price * Constant.disable_rate);
		} else if (discountType == 3) {
			tic.discountedPrice = (int)(price * Constant.merit_rate);
		} else if (discountType == 4) {
			tic.discountedPrice = (int)(price * Constant.multichild_rate);
		} else if (discountType == 5) {
			tic.discountedPrice = (int)(price * Constant.pregnant_rate);
		}
		return tic.discountedPrice;
	}	
	
	// 티켓 수량에 따른 최종 금액 계산
	static int finalPrice(int discountedPrice, int count) {
		int finalprice = discountedPrice * count;
		return finalprice;
	}
	
	// 우대사항 출력
	static String discountType(int discountTypeNum) {
		String str = "";
		if (discountTypeNum == 1) {
			str = "우대적용 없음";
		} else if (discountTypeNum == 2) {
			str = "장애인 우대적용";
		} else if (discountTypeNum == 3) {
			str = "국가유공자 우대적용";
		} else if (discountTypeNum == 4) {
			str = "다자녀 우대적용";
		} else if (discountTypeNum == 5) {
			str = "임산부 우대적용";
		}
		return str;
	}
		
	// 주간권 선택 시 처리 과정
	
	
	static void TYPE_DAY_Processing() {		
		
		tic.ticketType = "주간권";
   	 	input.inputIDNumber();															//주민등록번호 입력
   	 	Processing.calcAge(tic.id);														//만 나이 계산
   	 	tic.group = Processing.ageGroup(tic.age);										//나이별 그룹 지정
   	 	tic.orderCount = input.inputOrderCount();										//티켓 수량 입력
   	 	Processing.ticketPrice(1, tic.group);											//티켓 가격
   	 	input.selectDiscount();															//우대사항 선택 입력
   	 	tic.discountType = Processing.discountType(tic.discountTypeNum);				//우대사항 고르기
   	 	Processing.priceDiscount(tic.discountTypeNum, tic.price);						//우대사항으로 할인된 가격
   	 	tic.finalPrice = Processing.finalPrice(tic.discountedPrice, tic.orderCount);	//할인된 가격 * 티켓 수량
   	 	Output.printPrice(tic.finalPrice);												//가격 출력
   	 	tic.finalSum = tic.finalSum + tic.finalPrice;
   	 	al.add(tic.ticketType + " " + tic.group + "  X  " + (tic.orderCount + "") + "    " + (tic.finalPrice + "") + "원  " + "  *" + tic.discountType);		
	}
	
	// 야간권 선택 시 처리 과정
	static void TYPE_NIGHT_Processing() {
		
		tic.ticketType = "야간권";
		input.inputIDNumber();
		Processing.calcAge(tic.id);
		tic.group = Processing.ageGroup(tic.age);
		tic.orderCount = input.inputOrderCount();
		Processing.ticketPrice(2, tic.group);
		input.selectDiscount();
		tic.discountType = Processing.discountType(tic.discountTypeNum);
		Processing.priceDiscount(tic.discountTypeNum, tic.price);
		tic.finalPrice = Processing.finalPrice(tic.discountedPrice, tic.orderCount);
		Output.printPrice(tic.finalPrice);   
		tic.finalSum = tic.finalSum + tic.finalPrice;
   		al.add(tic.ticketType + " " + tic.group + "  X  " + (tic.orderCount + "") + "    " + (tic.finalPrice + "") + "원  " + "  *" + tic.discountType);
	}	
}
