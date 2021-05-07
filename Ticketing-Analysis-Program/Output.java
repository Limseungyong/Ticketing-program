package salesAnalysisprogram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Output {
	
	Variable var = new Variable();
	FileWrite fw = new FileWrite();
	
	public void printCsv() throws IOException {											//콘솔창에 티켓팅 데이터 출력
			
		File f = new File (Constant.read_file);
		BufferedReader br = new BufferedReader(new FileReader(f));
	
		ArrayList <String> data = new ArrayList <String> ();
	
		while((var.readtxt = br.readLine()) != null) {
			data.add(var.readtxt);
		}
	
		String[][] dataArr = new String[data.size()][];
	
		for(int i = 0; i < data.size(); i++) {
			dataArr[i] = data.get(i).split(",");
		}
	
		System.out.printf("====================== TicketingData.csv ======================\n");
		for (int i = 0; i < dataArr.length; i++) {
			for (int j = 0; j < dataArr[i].length; j++) {
				System.out.printf("%s \t", dataArr[i][j]);
			}
			System.out.println();
		}
		System.out.printf("---------------------------------------------------------------\n\n");	
	}
	
	public void printByType() throws IOException {										// 주/야 구분에 따른 티켓팅 데이터 출력
		
		Processing.analysis();
		
		System.out.printf("======================= 권종별 판매현황 =======================\n");
		System.out.printf("주간권 총 %d매\n", var.day_ticket);
		System.out.printf("신생아 %d매, 아이 %d매, 청소년 %d매, 어른 %d매, 노인 %d매\n", var.day_baby, var.day_child, var.day_teen, var.day_adult, var.day_old);
		System.out.printf("주간권 매출 : %d원\n\n", var.day_sum);
		
		System.out.printf("야간권 총 %d매\n", var.night_ticket);
		System.out.printf("신생아 %d매, 아이 %d매, 청소년 %d매, 어른 %d매, 노인 %d매\n", var.night_baby, var.night_child, var.night_teen, var.night_adult, var.night_old);
		System.out.printf("야간권 매출 : %d원\n", var.night_sum);
		System.out.printf("---------------------------------------------------------------\n\n");
		
		fw.ticketCountByType();															// 출력한 데이터 파일에 쓰기
	}
	
	public void printByDay() throws IOException {										//일자별 구분에 따른 티켓팅 데이터 출력
		
		File f = new File (Constant.read_file);
		BufferedReader br = new BufferedReader(new FileReader(f));
	
		ArrayList <String> data = new ArrayList <String> ();
	
		while((var.readtxt = br.readLine()) != null) {
			data.add(var.readtxt);
		}
	
		String[][] dataArr = new String[data.size()][];
	
		for(int i = 0; i < data.size(); i++) {
			dataArr[i] = data.get(i).split(",");
		}
		
		HashSet <String> date = new HashSet <String>();
		
		for(int i = 0; i < dataArr.length; i++) {
			date.add(dataArr[i][0]);
		}
		
		var.finalDate = new ArrayList <String>(date);
		Collections.sort(var.finalDate);
		var.sumByDate = new int [var.finalDate.size()];
		
		for(int i = 1; i < dataArr.length; i++) {
			for(int j = 0; j < var.finalDate.size(); j++) {
				if(dataArr[i][0].equals(var.finalDate.get(j))) {
					var.sumByDate[j] += Integer.parseInt(dataArr[i][4]);
				}
			}
		}
		
		for(int i = 0; i < var.sumByDate.length-1; i++) {
			System.out.printf("%s년 %s월 %s일 : 총 매출 : %8d원\n", var.finalDate.get(i).substring(0,4), var.finalDate.get(i).substring(4,6), var.finalDate.get(i).substring(6,8), var.sumByDate[i]);
		}
		System.out.printf("----------------------------------------\n\n");	
		
		fw.salesByDate();														// 출력한 데이터 파일에 쓰기
	}
	
	public void printByDiscountType() {											//우대권 구분에 따른 티켓팅 데이터 출력
		
		System.out.printf("===== 우대권 판매 현황 ======\n");
		System.out.printf("총 판매 티켓수      : %5d매\n", var.total_ticket_count);
		System.out.printf("우대적용 업음       : %5d매\n", var.no_discount);
		System.out.printf("장애인 우대적용     : %5d매\n", var.disabled);
		System.out.printf("국가유공자 우대적용 : %5d매\n", var.merit);
		System.out.printf("다자녀 우대적용     : %5d매\n", var.multi_child);
		System.out.printf("임산부 우대적용     : %5d매\n", var.pregnant);
		System.out.printf("-----------------------------\n\n");
	}	
}
