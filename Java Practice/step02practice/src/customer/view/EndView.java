package customer.view;

import customer.domain.CustomerDTO;

public class EndView {
	
	public static void printAll(CustomerDTO[] all) {
		for(int i=0; i<all.length; i++) {
			if(all[i] != null) {
				System.out.println(all[i].toString());
			}
		}
	}
	
	public static void printOne(CustomerDTO one) {
		System.out.println(one.toString());
	}
	public static void printMsg() { //getOne�� ���� �޽���
		System.out.println("��û�Ͻ� ������ �������� �ʽ��ϴ�");
	}
	
	public static void printMsg(String addmsg) { //addOne�� ���� �޽���
		System.out.println(addmsg);
	}
}
