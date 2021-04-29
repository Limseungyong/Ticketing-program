package ticketingprogram;

import java.io.IOException;
import java.util.ArrayList;

import ticketingprogram.Constant;
import exchangeprogram.exchangetype;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Input input = new Input();
		FileWrite fw = new FileWrite();
		Ticketing tic = new Ticketing();		
		
		fw.headerWrite();																		//���� ��� �κ� �ۼ�
		
		do {
			int ticketType = input.selectTicket();												//Ƽ�� ��/�߰� ����	         
	        
			if (ticketType == Constant.TYPE_DAY) {												//�ְ��� ���� ��
				
				Processing.TYPE_DAY_Processing();
	        	 	        	 
	        } else if (ticketType == Constant.TYPE_NIGHT) { 									//�߰��� ���� ��
	        	
	        	Processing.TYPE_NIGHT_Processing();
	        }
			
			fw.dataWrite(tic);																	//���Ͽ� ������ ����
			
		} while (input.selectExit() != 2);											
		
		fw.fileClose();
		Output.printOrder(Processing.al);    													//Ƽ�� �߱� �ѳ��� ���
	}
}
