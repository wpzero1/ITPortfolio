package customer.controller;

import customer.domain.CustomerDTO;
import customer.model.CustomerModel;
import customer.view.EndView;

public class CustomerController { //Controller�� ����� ��, EndView�� �ִ� ��. ��� �޼ҵ�� ��ȯ���� ���� void��. (��� ����)
	//��� �˻�
	public static void all() {
		EndView.printAll(CustomerModel.getAll()); //printAll�� ����ϰ� ��Ŵ.
		
		//CustomerDTO[] all = CustomerModel.getAll();
		//EndView.printAll(all);
		//�� �� ���� �����Ѱ� EndView.printAll(CustomerModel.getAll());
	}
	
	//grade�� �ش� ��޵鸸 �˻�
	
	// id�� �ش� �� ������ �˻�
	/* Model�� getOne()�� ��ȯ��
	 *  - CustomerDTO or null
	 *   - EndView���� ����� ������ �� �� �ΰ��� �����͸� ��� ��� ��û?
	 *   ���� ����� ����� ��
	 *   1. ����� �� 1
	 *    - EndView�� �޼ҵ忡 ������ ��� ����
	 *			: EndView�� null ���� ����
	 *	  2. ����� �� 2 -> �̰ŷ� �����Ұ���
	 *		- Controller���� null ����
	 *		- null�� ��� �ٸ� ��� �޼ҵ� ȣ��, null �ƴ� ��� �Ǵٸ� �޼ҵ� ȣ��
	 *
	 */
	
	public static void getOne(String id) {
		CustomerDTO one = CustomerModel.getOne(id);
		if(one != null) { //�˻��� ������ �����ϴ� ��� true
			EndView.printOne(one);
		  } else {
			  EndView.printMsg(); //�� �޼ҵ尡 �������� ��������, ������ ���󰡼� ����Ŭ���ϸ� EndView�� ���������.
		  }
	}
	
	//����
	public static void addOne(CustomerDTO newDTO) {
		int result = CustomerModel.addOne(newDTO);
		if(result != 5) {
			EndView.printMsg("ȸ������ �Ϸ�");
		}else {
			EndView.printMsg("ȸ������ ����. ���� ���� ������ �Ұ��Դϴ�");
		}
	}
	
	//���� - id�� �������� grade ����
	public static void updateOne(String id) {
		boolean result = CustomerModel.updateOne(id);
		if(result) {
			
			EndView.printMsg(id + " ���� ����� " + CustomerModel.getOne(id).getGrade() + "������� ����Ǿ����ϴ�");
		}
		else {
			EndView.printMsg(id + " ���� ��� ���濡 �����Ͽ����ϴ�");
			}
		}

	
	//���� - id
	public static void deleteOne(String id) {
		boolean result = CustomerModel.deleteOne(id);
		if(result) {
			EndView.printMsg(id+" ȸ���� ���� ����");
		}else {
			EndView.printMsg("���� ����");
		}
	}
	
	//

}

