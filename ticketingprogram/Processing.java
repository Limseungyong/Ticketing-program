package ticketingprogram;

import java.util.ArrayList;
import java.util.Calendar;

public class Processing {
	
	public static Ticketing tic = new Ticketing();
	public static Input input = new Input();
	public static ArrayList al = new ArrayList();		
	
	// ������ ���
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

	// ���ɴ� �� �з�
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
	
	// ��/�߱ǰ� ���̿� ���� �ݾ� ���
	static int ticketPrice(int ticketType, String group) {
		tic.price = 0;
		if (ticketType == 1) {
			if (group.equals("�Ż���")) {
				tic.price = Constant.baby_price;
			} else if (group.equals("����")) {
				tic.price = Constant.child_day_price;
			} else if (group.equals("û�ҳ�")) {
				tic.price = Constant.teen_day_price;
			} else if (group.equals("�")) {
				tic.price =  Constant.adult_day_price;
			} else if (group.equals("����")) {
				tic.price = Constant.old_day_price;
			}			
		} else if (ticketType == 2) {
			if (group.equals("�Ż���")) {
				tic.price = Constant.baby_price;
			} else if (group.equals("����")) {
				tic.price = Constant.child_night_price;
			} else if (group.equals("û�ҳ�")) {
				tic.price = Constant.teen_night_price;
			} else if (group.equals("�")) {
				tic.price = Constant.adult_night_price;
			} else if (group.equals("����")) {
				tic.price = Constant.old_night_price;
			}		
		}
		return tic.price;
	}
		
	// �����׿� ���� ���ε� �ݾ� ���
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
	
	// Ƽ�� ������ ���� ���� �ݾ� ���
	static int finalPrice(int discountedPrice, int count) {
		int finalprice = discountedPrice * count;
		return finalprice;
	}
	
	// ������ ���
	static String discountType(int discountTypeNum) {
		String str = "";
		if (discountTypeNum == 1) {
			str = "������� ����";
		} else if (discountTypeNum == 2) {
			str = "����� �������";
		} else if (discountTypeNum == 3) {
			str = "���������� �������";
		} else if (discountTypeNum == 4) {
			str = "���ڳ� �������";
		} else if (discountTypeNum == 5) {
			str = "�ӻ�� �������";
		}
		return str;
	}
		
	// �ְ��� ���� �� ó�� ����
	
	
	static void TYPE_DAY_Processing() {		
		
		tic.ticketType = "�ְ���";
   	 	input.inputIDNumber();															//�ֹε�Ϲ�ȣ �Է�
   	 	Processing.calcAge(tic.id);														//�� ���� ���
   	 	tic.group = Processing.ageGroup(tic.age);										//���̺� �׷� ����
   	 	tic.orderCount = input.inputOrderCount();										//Ƽ�� ���� �Է�
   	 	Processing.ticketPrice(1, tic.group);											//Ƽ�� ����
   	 	input.selectDiscount();															//������ ���� �Է�
   	 	tic.discountType = Processing.discountType(tic.discountTypeNum);				//������ ����
   	 	Processing.priceDiscount(tic.discountTypeNum, tic.price);						//���������� ���ε� ����
   	 	tic.finalPrice = Processing.finalPrice(tic.discountedPrice, tic.orderCount);	//���ε� ���� * Ƽ�� ����
   	 	Output.printPrice(tic.finalPrice);												//���� ���
   	 	tic.finalSum = tic.finalSum + tic.finalPrice;
   	 	al.add(tic.ticketType + " " + tic.group + "  X  " + (tic.orderCount + "") + "    " + (tic.finalPrice + "") + "��  " + "  *" + tic.discountType);		
	}
	
	// �߰��� ���� �� ó�� ����
	static void TYPE_NIGHT_Processing() {
		
		tic.ticketType = "�߰���";
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
   		al.add(tic.ticketType + " " + tic.group + "  X  " + (tic.orderCount + "") + "    " + (tic.finalPrice + "") + "��  " + "  *" + tic.discountType);
	}	
}
