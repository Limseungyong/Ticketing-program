package salesAnalysisprogram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Processing {
	
	public static void analysis() throws IOException {
		
		Variable var = new Variable();
		FileWrite fw = new FileWrite();
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
		
		
		for (int i = 1; i < dataArr.length; i++) {
			var.total_ticket_count += Integer.parseInt(dataArr[i][3]);
			
			if (dataArr[i][5].equals("우대적용 없음")) {				
			} else {
				if (dataArr[i][1].equals("주간권")) {
					var.discount_day_ticket += Integer.parseInt(dataArr[i][3]);
					var.discount_day_sum =+ Integer.parseInt(dataArr[i][4]);					
					if (dataArr[i][2].equals("신생아")) {
						var.discount_day_baby += Integer.parseInt(dataArr[i][3]);
					} else if (dataArr[i][2].equals("아이")) {
						var.discount_day_baby += Integer.parseInt(dataArr[i][3]);
					} else if (dataArr[i][2].equals("청소년")) {
						var.discount_day_baby += Integer.parseInt(dataArr[i][3]);
					} else if (dataArr[i][2].equals("어른")) {
						var.discount_day_baby += Integer.parseInt(dataArr[i][3]);
					} else if (dataArr[i][2].equals("노인")) {
						var.discount_day_baby += Integer.parseInt(dataArr[i][3]);
					}
				} else if (dataArr[i][1].equals("야간권")) {
					var.discount_night_ticket += Integer.parseInt(dataArr[i][3]);
					var.discount_night_sum =+ Integer.parseInt(dataArr[i][4]);
					if (dataArr[i][2].equals("신생아")) {
						var.discount_night_baby += Integer.parseInt(dataArr[i][3]);
					} else if (dataArr[i][2].equals("아이")) {
						var.discount_night_child += Integer.parseInt(dataArr[i][3]);
					} else if (dataArr[i][2].equals("청소년")) {
						var.discount_night_teen += Integer.parseInt(dataArr[i][3]);
					} else if (dataArr[i][2].equals("어른")) {
						var.discount_night_adult += Integer.parseInt(dataArr[i][3]);
					} else if (dataArr[i][2].equals("노인")) {
						var.discount_night_old += Integer.parseInt(dataArr[i][3]);
					}
				}
			}
			
			if (dataArr[i][5].equals("우대적용 없음")) {
				var.no_discount += Integer.parseInt(dataArr[i][3]);
			} else if (dataArr[i][5].contains("장애인")) {
				var.disabled += Integer.parseInt(dataArr[i][3]);
			} else if (dataArr[i][5].contains("국가유공자")) {
				var.merit += Integer.parseInt(dataArr[i][3]);
			} else if (dataArr[i][5].contains("다자녀")) {
				var.multi_child += Integer.parseInt(dataArr[i][3]);
			} else if (dataArr[i][5].contains("임산부")) {
				var.pregnant += Integer.parseInt(dataArr[i][3]);
			}
			
			if (dataArr[i][1].equals("주간권")) {
				var.day_ticket += Integer.parseInt(dataArr[i][3]);
				var.day_sum += Integer.parseInt(dataArr[i][4]);
				if (dataArr[i][2].equals("신생아")) {
					var.day_baby += Integer.parseInt(dataArr[i][3]);
				} else if (dataArr[i][2].equals("아이")) {
					var.day_child += Integer.parseInt(dataArr[i][3]);
				} else if (dataArr[i][2].equals("청소년")) {
					var.day_teen += Integer.parseInt(dataArr[i][3]);
				} else if (dataArr[i][2].equals("어른")) {
					var.day_adult += Integer.parseInt(dataArr[i][3]);
				} else if (dataArr[i][2].equals("노인")) {
					var.day_old += Integer.parseInt(dataArr[i][3]);
				}
			} else if (dataArr[i][1].equals("야간권")) {
				var.night_ticket += Integer.parseInt(dataArr[i][3]);
				var.night_sum += Integer.parseInt(dataArr[i][4]);
				if (dataArr[i][2].equals("신생아")) {
					var.night_baby += Integer.parseInt(dataArr[i][3]);
				} else if (dataArr[i][2].equals("아이")) {
					var.night_child += Integer.parseInt(dataArr[i][3]);
				} else if (dataArr[i][2].equals("청소년")) {
					var.night_teen += Integer.parseInt(dataArr[i][3]);
				} else if (dataArr[i][2].equals("어른")) {
					var.night_adult += Integer.parseInt(dataArr[i][3]);
				} else if (dataArr[i][2].equals("노인")) {
					var.night_old += Integer.parseInt(dataArr[i][3]);
				}
			}
		}		
		fw.countByDiscountType();										//우대권 종류에 따른 데이터 파일에 쓰기
	}
}
