package ticketingprogram;

public class Constant {
	
	// 권종별 가격
	
	static final int baby_price = 0,
					 adult_day_price = 56000, adult_night_price = 46000,
					 teen_day_price = 47000, teen_night_price = 40000,
					 child_day_price = 44000, child_night_price = 37000,
					 old_day_price = 44000, old_night_price = 37000;
	
	// 나이에 따른 범위
	
	static final int min_baby = 1, min_child = 3, min_teen = 13, min_adult = 19,
					 max_child = 12, max_teen = 18, max_adult = 64;
					  	
	// 나이에 따른 그룹
	
	static final String baby = "신생아", child = "아이", teen = "청소년", adult = "어른", old = "노인";
	
	// 할인율
	
	static final double disable_rate = 0.6, merit_rate = 0.5, multichild_rate = 0.8, pregnant_rate = 0.85;
	
	// 최대 주문량
	
	static final int max_count = 10, min_count = 1;
	
	// 파일 주소
	
	static final String file_Address = "C:\\Users\\임승용\\Desktop\\TicketingData.csv";
}
