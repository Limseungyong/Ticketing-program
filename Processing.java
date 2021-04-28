package ticketingprogram;

import java.util.Calendar;

public class Processing {
	
	
	// 만나이 계산
	static int calcAge(String inputIDNumber) {
		
		Calendar cal = Calendar.getInstance();
			
		String year = inputIDNumber.substring(0,2);
		int age = Integer.parseInt(year);
		int age2 = 0;
		
		String month = inputIDNumber.substring(2,4);
		int month2 = Integer.parseInt(month);
		int month3 = 0;
		
		String day = inputIDNumber.substring(4,6);
		int day2 = Integer.parseInt(day);
		int day3 = 0;
		
		char ch = inputIDNumber.charAt(6);
		
		if (month2 - (cal.get(Calendar.MONTH) + 1) > 0) {
			
				if (ch == '1' || ch == '2') {
					age2 = (cal.get(Calendar.YEAR)) - (1900 + age + 1);
				} else if (ch == '3' || ch == '4') {
					age2 = (cal.get(Calendar.YEAR)) - (2000 + age + 1);
				}
			
		} else if (month2 - (cal.get(Calendar.MONTH) + 1) < 0) {
			
				if (ch == '1' || ch == '2') {
					age2 = (cal.get(Calendar.YEAR)) - (1900 + age);
				} else if (ch == '3' || ch == '4') {
					age2 = (cal.get(Calendar.YEAR)) - (2000 + age);
				}
			
		} else if (month2 - (cal.get(Calendar.MONTH) + 1) == 0) {
			if (day2 - (cal.get(Calendar.DATE)) <= 0) { 
				if (ch == '1' || ch == '2') {
					age2 = (cal.get(Calendar.YEAR)) - (1900 + age);
				} else if (ch == '3' || ch == '4') {
					age2 = (cal.get(Calendar.YEAR)) - (2000 + age);
				}
			} else if (day2 - (cal.get(Calendar.DATE)) > 0) { 
				if (ch == '1' || ch == '2') {
					age2 = (cal.get(Calendar.YEAR)) - (1900 + age + 1);
				} else if (ch == '3' || ch == '4') {
					age2 = (cal.get(Calendar.YEAR)) - (2000 + age + 1);
				}
			}
		}
		return age2;	
	}

	// 연령대 별 분류
	static int ageGroup(int age) {		
		int groupNum = 0;
		if (Constant.min_baby <= age && age < Constant.min_child) {
			groupNum = Constant.baby;
		} else if (Constant.min_child <= age && age < Constant.min_teen) {
			groupNum = Constant.child;
		} else if (Constant.min_teen <= age && age < Constant.min_adult) {
			groupNum = Constant.teen;
		} else if (Constant.min_adult <= age && age <= Constant.max_adult) {
			groupNum = Constant.adult;
		} else if (age > Constant.max_adult) {
			groupNum = Constant.old;
		}
		return groupNum;
	}
	
	// 주야권과 나이에 따른 금액 계산
	static int ticketPrice(int ticketType, int groupNum) {
		int price = 0;
		if (ticketType == 1) {
			if (groupNum == 1) {
				price = 0;
			} else if (groupNum == 2) {
				price = 44000;
			} else if (groupNum == 3) {
				price = 47000;
			} else if (groupNum == 4) {
				price = 56000;
			} else if (groupNum == 5) {
				price = 44000;
			}			
		} else if (ticketType == 2) {
			if (groupNum == 1) {
				price = 0;
			} else if (groupNum == 2) {
				price = 37000;
			} else if (groupNum == 3) {
				price = 40000;
			} else if (groupNum == 4) {
				price = 46000;
			} else if (groupNum == 5) {
				price = 37000;
			}		
		}
		return price;
	}
		
	// 우대사항에 따른 할인 계산
	static double priceDiscount(int discountType, int price) {
		double discountedPrice = 0;
		if (discountType == 1) {
			discountedPrice = (double)price;
		} else if (discountType == 2) {
			discountedPrice = price * Constant.disable_rate;
		} else if (discountType == 3) {
			discountedPrice = price * Constant.merit_rate;
		} else if (discountType == 4) {
			discountedPrice = price * Constant.multichild_rate;
		} else if (discountType == 5) {
			discountedPrice = price * Constant.pregnant_rate;
		}
		return discountedPrice;
	}	
	
	// 주문 갯수에 따른 금액 계산
	static double finalPrice(int discountedPrice, int count) {
		double finalprice = discountedPrice * count;
		return finalprice;
	}
	
	
	// 계산 함수 호출
	
	
	// 주문 내역 저장
}
