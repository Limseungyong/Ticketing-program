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
			File file = new File(Constant.file_Address);									//�����͸� ������ ����
			if (file.exists() == false) {													//������ ���� ������ �Ǻ��ϱ� ���� if��
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
	
	public void fileClose() {																//���� ���⸦ �����ϱ� ���� �޼ҵ�
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void headerWrite() throws IOException {											//���Ͽ� ��������� �Է��ϱ� ���� �޼ҵ�
		if  (isFileExist == false) {														//���� ������ ������ �� ������� �Է��ϱ� ���� ���ǹ�
			String head = "��¥," + "����," + "���ɱ���," + "����," + "����," + "������," + "\n";
			fw.write(head);	
		}
	}
	
	public void dataWrite(Ticketing tic) throws IOException {								//���Ͽ� �����͸� �Է��ϱ� ���� �޼ҵ�
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
		
		String result = sdf.format(c.getTime()) + "," + tic.ticketType + "," + 
								   tic.group + "," + tic.orderCount + "," + tic.finalPrice + "," + tic.discountType + "\n";
		fw.write(result);	
	}
}
