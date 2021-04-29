package ticketingprogram;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import exchangeprogram.exchangetype;

public class FileWrite {
	private FileWriter fw;
	private boolean isFileExist;
	
	public FileWrite() {		
		try {
			File file = new File(Constant.file_Address);									//데이터를 저장할 파일
			if (file.exists() == false) {													//파일의 존재 유무를 판별하기 위한 if문
				isFileExist = false;
			} else {
				isFileExist = true;
			}
			fw = new FileWriter(Constant.file_Address, true);
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
	
	public void headerWrite() throws IOException {											//파일에 헤더라인을 입력하기 위한 메소드
		if  (isFileExist == false) {														//새로 파일이 생성될 때 헤더라인 입력하기 위한 조건문
			String head = "날짜," + "권종," + "연령구분," + "수량," + "가격," + "우대사항," + "\n";
			fw.write(head);	
		}
	}
	
	public void dataWrite(Ticketing tic) throws IOException {								//파일에 데이터를 입력하기 위한 메소드
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
		
		String result = sdf.format(c.getTime()) + "," + tic.ticketType + "," + 
								   tic.group + "," + tic.orderCount + "," + tic.finalPrice + "," + tic.discountType + "\n";
		fw.write(result);	
	}
}
