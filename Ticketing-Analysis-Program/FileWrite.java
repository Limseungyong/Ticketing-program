package salesAnalysisprogram;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import salesAnalysisprogram.Constant;
import ticketingprogram.Ticketing;

public class FileWrite {
	private FileWriter fw;
	private boolean isFileExist;
	
	Variable var = new Variable();
	
	public void FileWrite(String filename) {		
		try {
			File file = new File(filename);													//데이터를 저장할 파일
			if (file.exists() == false) {													//파일의 존재 유무를 판별하기 위한 if문
				isFileExist = false;
			} else {
				isFileExist = true;
			}
			fw = new FileWriter(filename, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fileClose() {																//파일 쓰기를 종료하기 위한 메소드
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void salesByDate() throws IOException {
		
		FileWrite(Constant.salesByDate_file);
		
		if (isFileExist == false) {														//새로 파일이 생성될 때 헤더라인 입력하기 위한 조건문
			String head = "일자," + "총 매출," + "\n";
			fw.write(head);	
		}

		for (int i = 0; i < var.sumByDate.length-1; i++) {
			String result ="\n" + var.finalDate.get(i).substring(0,4) + "-" + var.finalDate.get(i).substring(4,6) + "-" + var.finalDate.get(i).substring(6,8) + "," + var.sumByDate[i] + "\n";
			fw.write(result);
		}
		
		fileClose();		
	}
	
	public void ticketCountByType() throws IOException {

		FileWrite(Constant.ticketCountByType_file);
		
		if (isFileExist == false) {														//새로 파일이 생성될 때 헤더라인 입력하기 위한 조건문
			String head = "구분," + "주간권," + "야간권," + "\n";
			fw.write(head);	
		}
		
		String result ="신생아," + var.day_baby + "," + var.night_baby + "," + 
					"\n아이," + var.day_child + "," + var.night_child + "," + 
					"\n청소년," + var.day_teen + "," + var.night_teen + "," + 
					"\n어른," + var.day_adult + "," + var.night_adult + "," + 
					"\n노인," + var.day_old + "," + var.night_old + "," + 
					"\n합계," + var.discount_day_ticket + "," + var.discount_night_ticket + "," +
					"\n매출," + var.discount_day_sum + "," + var.discount_night_sum + "," + "\n";
		
		fw.write(result);
		
		fileClose();		
	}
	
	public void countByDiscountType() throws IOException {

		FileWrite(Constant.countByDiscountType_file);
		
		if (isFileExist == false) {														//새로 파일이 생성될 때 헤더라인 입력하기 위한 조건문
			String head = "구분," + "주간권," + "야간권," + "\n";
			fw.write(head);	
		}
		
		String result ="신생아," + var.discount_day_baby + "," + var.discount_night_baby + "," + 
					"\n아이," + var.discount_day_child + "," + var.discount_night_child + "," + 
					"\n청소년," + var.discount_day_teen + "," + var.discount_night_teen + "," + 
					"\n어른," + var.discount_day_adult + "," + var.discount_night_adult + "," + 
					"\n노인," + var.discount_day_old + "," + var.discount_night_old + "," + 
					"\n합계," + var.discount_day_ticket + "," + var.discount_night_ticket + "," +
					"\n매출," + var.day_sum + "," + var.night_sum + "," + "\n";
					
		fw.write(result);
		
		fileClose();		
	}

}
