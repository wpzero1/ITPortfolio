package traffic.view;

import java.util.Scanner;

import traffic.controller.TrafficController;
import traffic.domain.TrafficDTO;

public class TrafficStartView {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		String areaInput;
		
		System.out.println("***��� ��� ***");
		TrafficController.all();
		
		/*System.out.println("***������ �߰� ***");
		TrafficDTO accident1 = new TrafficDTO(2018070615, "�ְ�", "��", 1,1,1,1,"����","������","������","�ߵ����","�ε�","������","�л�");
		TrafficController.accidentInsert(accident1); */
		
		
		
		/*System.out.println("***������ ����***");
		int date = 2017010104;
		String area3 = "����";
		TrafficController.areaChange(date, area3); */

		/*System.out.println("***������ ����***");
		System.out.println("�����͸� ������ ������ �Է��ϼ��� ex)����");
		areaInput = scanner.nextLine();
		TrafficController.areaDelete(areaInput);
		
		
		System.out.println("***�������� �˻�***");
		System.out.println("�˻��� ������ �Է��ϼ��� ex)����");
		areaInput = scanner.nextLine();
		TrafficController.areaSearch(areaInput); */
		
		
		/*System.out.println("***�ִ� ??? ����***");
		TrafficController.findMax("Total");
		TrafficController.findMax("Death");
		TrafficController.findMax("InjuryHigh");
		TrafficController.findMax("InjuryLow");*/
		
	}
}
/*System.out.println("***������ ����***");
System.out.println("������ �������� ��¥�����͸� �Է����ּ��� ex)2017010104");
int date = Integer.parseInt(scanner.nextLine());
	if(date !=0) {
System.out.println("�ش� �������� ���� �׸��� ��� �������� �ٲٰ� ��������?");
String area3 = scanner.nextLine();
//String area3 = "����";
TrafficController.areaChange(date, area3);
	}
}
}*/