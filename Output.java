package ticketingprogram;

import java.util.ArrayList;

public class Output {
		
	
	// Ƽ�� ���� ���
	
	public static void printPrice(double finalPrice) {
		System.out.printf("������ %d �� �Դϴ�.\n", (int)finalPrice);
		System.out.printf("�����մϴ�.\n\n");
	}	        	
	
	// �ֹ� ���� ���
	
	public static void printOrder(ArrayList al) {
		System.out.printf("==================== �������� ====================\n");
		for (int i = 0; i < al.size(); i++) {
		System.out.printf("%s\n", al.get(i));		
		}
	}
	
	// �ֹ� ���� ���Ϸ� ���
	
	
	// �̾ �ֹ� or �ֹ����� ��� �� ����
}
