package customer.view;

import customer.domain.CustomerDTO;

public class EndView {
	//��� �� ���� ���
	public static void printAll(CustomerDTO[] all) { //�ٵ� 5���� �����Ͱ� �� �ִ°� �ƴ϶�, null�� ����.(�ϸ� �ȵǴµ�)
		for(int i=0; i < all.length; i++) {
			
			if (all[i] != null) { //�߰� �����Ͱ� �������� null���� ����� ������ ����� ���� üũ�ؾ��� != : ���� �ʴ�
			System.out.println(all[i].toString());
			}
			
		}
	}
	
	//������ null�� ��� �ܼ� �޽��� ���
	
	//�����Ͱ� CustomerDTO�� ��� �ش� ������ ���� ���
	public static void printOne(CustomerDTO one) {
		System.out.println(one.toString());
		
	}

	public static void printMsg() {
		System.out.println("��û�Ͻ� ������ �� �����մϴ�");
	}

	public static void printMsg(String msg) {
		System.out.println(msg);
	}
}
