package salesAnalysisprogram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Output output = new Output();
		
		output.printCsv();					//�ܼ�â�� Ƽ���� ������ ���
		output.printByType();				// ��/�� ���п� ���� Ƽ���� ������ ���
		output.printByDay();				//���ں� ���п� ���� Ƽ���� ������ ���
		output.printByDiscountType();		//���� ���п� ���� Ƽ���� ������ ���
	}
}
