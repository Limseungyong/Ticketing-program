package ticketingprogram;

import java.util.Scanner;

public class Input {
	
	public static Scanner s = new Scanner(System.in);
		
	//  ���� �Է�
	public static int selectTicket() {
		
		System.out.printf("������ �����ϼ���.\n");
		System.out.printf("1. �ְ���\n");
		System.out.printf("2. �߰���\n");		
		return s.nextInt();
	}
	
	// �ֹε�Ϲ�ȣ �Է�
	public static String inputIDNumber() { 
		
		System.out.printf("�ֹι�ȣ�� �Է��ϼ���\n");
		String w = s.next();
		return w;
	}
		
	// �ֹ� ���� �Է�
	public static int inputOrderCount() {
		
		int w = 0;
		while (true) {
			System.out.printf("��� �ֹ��Ͻðڽ��ϱ�? (�ִ� 10��)\n");
			w = s.nextInt();
			if ( w <  Constant.min_count || w > Constant.max_count) {
			System.out.printf("Ƽ���� 1�� �̻� �ִ� 10������� ���� �����մϴ�.\n");
			} else if ( Constant.min_count <= w && w <= Constant.max_count) {
				break;
			}
		}		
		return w;
	}
	
	public static int correctOrderCount(int w) {
		return w;
		
	}
		
	// ������ �Է�
	public static int selectDiscount() {
		
		System.out.printf("�������� �����ϼ���.\n");
		System.out.printf("1. ���� (���� ���� �ڵ�ó��)\n");
		System.out.printf("2. �����\n");
		System.out.printf("3. ����������\n");
		System.out.printf("4. ���ڳ�\n");
		System.out.printf("5. �ӻ��\n");
		int w = s.nextInt();
		return w;
	}
	
	//���� ����
	public static int selectExit() {
		
		System.out.printf("��� �߱� �Ͻðڽ��ϱ�?\n");
		System.out.printf("1. Ƽ�� �߱�\n");
		System.out.printf("2. ����\n");
		int w = s.nextInt();
		if (w == 2) {
			System.out.printf("Ƽ�� �߱��� �����մϴ�. �����մϴ�\n\n");
		}
		return w;		
	}	
}
