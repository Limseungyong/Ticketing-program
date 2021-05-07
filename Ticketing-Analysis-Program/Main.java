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
		
		output.printCsv();					//콘솔창에 티켓팅 데이터 출력
		output.printByType();				// 주/야 구분에 따른 티켓팅 데이터 출력
		output.printByDay();				//일자별 구분에 따른 티켓팅 데이터 출력
		output.printByDiscountType();		//우대권 구분에 따른 티켓팅 데이터 출력
	}
}
