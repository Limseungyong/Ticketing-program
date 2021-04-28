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
				 tic.ticketType = "�ְ���";
	        	 String id = input.inputIDNumber();											//�ֹε�Ϲ�ȣ �Է�
	        	 int age = Processing.calcAge(id);											//�� ���� ���
	        	 tic.group = Processing.ageGroup(age);										//���̺� �׷� ����
	        	 tic.orderCount = input.inputOrderCount();									//Ƽ�� ���� �Է�
	        	 int price = Processing.ticketPrice(1, tic.group);							//Ƽ�� ����
	        	 int discountTypeNum = input.selectDiscount();								//������ ���� �Է�
	        	 tic.discountType = Processing.discountType(discountTypeNum);				//������ ����
	        	 int discountedPrice = Processing.priceDiscount(discountTypeNum, price);	//���ε� ����
	        	 tic.finalPrice = Processing.finalPrice(discountedPrice, tic.orderCount);	//���ε� ���� * Ƽ�� ����
	        	 Output.printPrice(tic.finalPrice);											//���� ���
	        	 
	        	 al.add(tic.ticketType + " " + tic.group + "  X  " + (tic.orderCount + "") + "    " + (tic.finalPrice + "") + "��  " + "  *" + tic.discountType);
	        	 	        	 
	        } else if (ticketType == 2) { 	
	        	 tic.ticketType = "�߰���";
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
	        	 
	        	 al.add(tic.ticketType + " " + tic.group + "  X  " + (tic.orderCount + "") + "    " + (tic.finalPrice + "") + "��  " + "  *" + tic.discountType);
	        }
			
			fw.dataWrite(tic);
			
		} while (input.selectExit() != 2);
		
		fw.fileClose();
		Output.printOrder(al);    
	}
}
