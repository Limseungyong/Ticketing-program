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
	
	// 주야권과 나이에 따른 금액 계산
	static int ticketPrice(int ticketType, String group) {
		int price = 0;
		if (ticketType == 1) {
			if (group.equals("신생아")) {
				price = 0;
			} else if (group.equals("아이")) {
				price = 44000;
			} else if (group.equals("청소년")) {
				price = 47000;
			} else if (group.equals("어른")) {
				price = 56000;
			} else if (group.equals("노인")) {
				price = 44000;
			}			
		} else if (ticketType == 2) {
			if (group.equals("신생아")) {
				price = 0;
			} else if (group.equals("아이")) {
				price = 37000;
			} else if (group.equals("청소년")) {
				price = 40000;
			} else if (group.equals("어른")) {
				price = 46000;
			} else if (group.equals("노인")) {
				price = 37000;
			}		
		}
		return price;
	}
		
	// 우대사항에 따른 할인 계산
	static int priceDiscount(int discountType, int price) {
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
		return (int)discountedPrice;
	}	
	
	// 주문 갯수에 따른 금액 계산
	static int finalPrice(int discountedPrice, int count) {
		int finalprice = discountedPrice * count;
		return finalprice;
	}
	
	//우대사항 출력
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
		
	// 계산 함수 호출
	
	
	// 주문 내역 저장
}
