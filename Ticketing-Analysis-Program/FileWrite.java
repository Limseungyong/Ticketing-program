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
			File file = new File(filename);													//�����͸� ������ ����
			if (file.exists() == false) {													//������ ���� ������ �Ǻ��ϱ� ���� if��
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
	
	public void fileClose() {																//���� ���⸦ �����ϱ� ���� �޼ҵ�
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void salesByDate() throws IOException {
		
		FileWrite(Constant.salesByDate_file);
		
		if (isFileExist == false) {														//���� ������ ������ �� ������� �Է��ϱ� ���� ���ǹ�
			String head = "����," + "�� ����," + "\n";
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
		
		if (isFileExist == false) {														//���� ������ ������ �� ������� �Է��ϱ� ���� ���ǹ�
			String head = "����," + "�ְ���," + "�߰���," + "\n";
			fw.write(head);	
		}
		
		String result ="�Ż���," + var.day_baby + "," + var.night_baby + "," + 
					"\n����," + var.day_child + "," + var.night_child + "," + 
					"\nû�ҳ�," + var.day_teen + "," + var.night_teen + "," + 
					"\n�," + var.day_adult + "," + var.night_adult + "," + 
					"\n����," + var.day_old + "," + var.night_old + "," + 
					"\n�հ�," + var.discount_day_ticket + "," + var.discount_night_ticket + "," +
					"\n����," + var.discount_day_sum + "," + var.discount_night_sum + "," + "\n";
		
		fw.write(result);
		
		fileClose();		
	}
	
	public void countByDiscountType() throws IOException {

		FileWrite(Constant.countByDiscountType_file);
		
		if (isFileExist == false) {														//���� ������ ������ �� ������� �Է��ϱ� ���� ���ǹ�
			String head = "����," + "�ְ���," + "�߰���," + "\n";
			fw.write(head);	
		}
		
		String result ="�Ż���," + var.discount_day_baby + "," + var.discount_night_baby + "," + 
					"\n����," + var.discount_day_child + "," + var.discount_night_child + "," + 
					"\nû�ҳ�," + var.discount_day_teen + "," + var.discount_night_teen + "," + 
					"\n�," + var.discount_day_adult + "," + var.discount_night_adult + "," + 
					"\n����," + var.discount_day_old + "," + var.discount_night_old + "," + 
					"\n�հ�," + var.discount_day_ticket + "," + var.discount_night_ticket + "," +
					"\n����," + var.day_sum + "," + var.night_sum + "," + "\n";
					
		fw.write(result);
		
		fileClose();		
	}

}
