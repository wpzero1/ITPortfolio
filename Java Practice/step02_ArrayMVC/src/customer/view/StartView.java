package customer.view;

import customer.controller.CustomerController;
import customer.domain.CustomerDTO;

public class StartView {

	public static void main(String[] args) {
		//��� �˻� - null�� ���� ���� ��� �Ұ����� ��.
		System.out.println("*** ��� �˻� ***");
		CustomerController.all();
		
		//�˻� - id�� �˻�
		System.out.println("*** id�� �˻� ***");
		CustomerController.getOne("tester");
		CustomerController.getOne("a");
		
		//���� - id�� �ߺ��Ǹ� ���ԺҰ�
		System.out.println("*** ���� ***");
		CustomerDTO newOne = new CustomerDTO("man","������","77",26,"vip");
		CustomerDTO newOne2 = new CustomerDTO("aa","���Ѹ�","13",25,"�Ϲ�ȸ��");
		CustomerController.addOne(newOne);
		CustomerController.addOne(newOne2); //6��° �����ʹ� ������ �ȵȴ�.
		
		//���� - �����ϴ� ������ ���� ����, �������ϴ� ������ �����õ�?
		/* id�� ����� ����
		 * ��, ���� �����Ǿ����� �ƴ����� ���ؼ��� �ݵ�� ���� (���� ������ Ȯ�� �����ؾ���)
		 * 
		 */
		System.out.println("***����***");
		
		CustomerController.updateOne("tester");
		CustomerController.all();
		
		
		//���� - �����ϴ� ������ ����, �������ϴ� ������ ���� �õ�?
		System.out.println("*** ���� ***");
		CustomerController.deleteOne("admin");
		CustomerController.deleteOne("admin");
		CustomerController.all();
		
		
	}

}
