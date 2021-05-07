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
	
	public void printCsv() throws IOException {											//�ܼ�â�� Ƽ���� ������ ���
			
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
	
	public void printByType() throws IOException {										// ��/�� ���п� ���� Ƽ���� ������ ���
		
		Processing.analysis();
		
		System.out.printf("======================= ������ �Ǹ���Ȳ =======================\n");
		System.out.printf("�ְ��� �� %d��\n", var.day_ticket);
		System.out.printf("�Ż��� %d��, ���� %d��, û�ҳ� %d��, � %d��, ���� %d��\n", var.day_baby, var.day_child, var.day_teen, var.day_adult, var.day_old);
		System.out.printf("�ְ��� ���� : %d��\n\n", var.day_sum);
		
		System.out.printf("�߰��� �� %d��\n", var.night_ticket);
		System.out.printf("�Ż��� %d��, ���� %d��, û�ҳ� %d��, � %d��, ���� %d��\n", var.night_baby, var.night_child, var.night_teen, var.night_adult, var.night_old);
		System.out.printf("�߰��� ���� : %d��\n", var.night_sum);
		System.out.printf("---------------------------------------------------------------\n\n");
		
		fw.ticketCountByType();															// ����� ������ ���Ͽ� ����
	}
	
	public void printByDay() throws IOException {										//���ں� ���п� ���� Ƽ���� ������ ���
		
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
			System.out.printf("%s�� %s�� %s�� : �� ���� : %8d��\n", var.finalDate.get(i).substring(0,4), var.finalDate.get(i).substring(4,6), var.finalDate.get(i).substring(6,8), var.sumByDate[i]);
		}
		System.out.printf("----------------------------------------\n\n");	
		
		fw.salesByDate();														// ����� ������ ���Ͽ� ����
	}
	
	public void printByDiscountType() {											//���� ���п� ���� Ƽ���� ������ ���
		
		System.out.printf("===== ���� �Ǹ� ��Ȳ ======\n");
		System.out.printf("�� �Ǹ� Ƽ�ϼ�      : %5d��\n", var.total_ticket_count);
		System.out.printf("������� ����       : %5d��\n", var.no_discount);
		System.out.printf("����� �������     : %5d��\n", var.disabled);
		System.out.printf("���������� ������� : %5d��\n", var.merit);
		System.out.printf("���ڳ� �������     : %5d��\n", var.multi_child);
		System.out.printf("�ӻ�� �������     : %5d��\n", var.pregnant);
		System.out.printf("-----------------------------\n\n");
	}	
}
