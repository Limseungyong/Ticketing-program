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
		
		fw.headerWrite();																		//파일 헤더 부분 작성
		
		do {
			int ticketType = input.selectTicket();												//티켓 주/야간 선택	         
	        
			if (ticketType == Constant.TYPE_DAY) {												//주간권 선택 시
				
				Processing.TYPE_DAY_Processing();
	        	 	        	 
	        } else if (ticketType == Constant.TYPE_NIGHT) { 									//야간권 선택 시
	        	
	        	Processing.TYPE_NIGHT_Processing();
	        }
			
			fw.dataWrite(tic);																	//파일에 데이터 저장
			
		} while (input.selectExit() != 2);											
		
		fw.fileClose();
		Output.printOrder(Processing.al);    													//티켓 발권 총내역 출력
	}
}
