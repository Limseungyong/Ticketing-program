package ticketingprogram;

import java.util.Scanner;

public class Input {
	
	public static Scanner s = new Scanner(System.in);
	public static Ticketing tic = new Ticketing();
		
	// ���� �Է�
	public static int selectTicket() {
		
		int w = 0;
		while (true) {
			System.out.printf("������ �����ϼ���.\n");
			System.out.printf("1. �ְ���\n");
			System.out.printf("2. �߰���\n");	
			w = s.nextInt();
			if ( w <  1 || w > 2) {
				System.out.printf("�߸��� ��ȣ�Դϴ�. �ٽ� �Է��ϼ���.\n");
			} else {
				break;
			}
		}		
		return w;
	}
	
	// �ֹε�Ϲ�ȣ �Է�
	public static String inputIDNumber() { 
		
		tic.id = "";
		while (true) {
			System.out.printf("�ֹε�Ϲ�ȣ �տ��� 7�ڸ��� �Է��ϼ���\n");
			tic.id = s.next();
			if (tic.id.length() != 7) {
				System.out.printf("�ֹε�Ϲ�ȣ �տ��� 7�ڸ��� �ٽ� ��Ȯ�ϰ� �Է��Ͻʽÿ�.\n");
			} else {
				break;
			}
		}
		return tic.id;
	}	
		
	// Ƽ�� ���� �Է�
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
			
	// ������ �Է�
	public static int selectDiscount() {
		
		tic.discountTypeNum = 0;
		while (true) {
			System.out.printf("�������� �����ϼ���.\n");
			System.out.printf("1. ���� (���� ���� �ڵ�ó��)\n");
			System.out.printf("2. �����\n");
			System.out.printf("3. ����������\n");
			System.out.printf("4. ���ڳ�\n");
			System.out.printf("5. �ӻ��\n");
			tic.discountTypeNum = s.nextInt();
			if ( tic.discountTypeNum <  1 || tic.discountTypeNum > 5) {
			System.out.printf("�߸��� ��ȣ�Դϴ�. �ٽ� �Է��ϼ���.\n");
			} else {
				break;
			}
		}		
		return tic.discountTypeNum;
	}
	
	//��� ���� ����
	public static int selectExit() {
		
		int w = 0;
		while (true) {
			System.out.printf("��� �߱� �Ͻðڽ��ϱ�?\n");
			System.out.printf("1. Ƽ�� �߱�\n");
			System.out.printf("2. ����\n");
			w = s.nextInt();
			if ( w <  1 || w > 2) {
			System.out.printf("�߸��� ��ȣ�Դϴ�. �ٽ� �Է��ϼ���.\n");
			} else {
				break;
			}
		}
		if (w == 2) {
			System.out.printf("Ƽ�� �߱��� �����մϴ�. �����մϴ�\n\n");
		}
		return w;
	}	
}
