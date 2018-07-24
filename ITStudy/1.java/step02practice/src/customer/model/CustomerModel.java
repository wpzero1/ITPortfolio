package customer.model;

import customer.domain.CustomerDTO;

public class CustomerModel {

	static CustomerDTO[] all = new CustomerDTO[5];
	static {
	all[0] = new CustomerDTO("abc", "123", "�̼���", 15, "�����ȸ��");
	all[1]	 = new CustomerDTO("babo","456","�ָͱ�", 40, "���ȸ��");
	all[2]	= 	new CustomerDTO("guess", "789", "���ǰ", 35, "���̾�ȸ��");
	all[3] = new CustomerDTO("azae", "002","�ھ���",30, "�ǹ�ȸ��");
	
	}
	
	public static CustomerDTO[] getAll() {
		return all;
		
	}
//����
	//�迭�� �� null���� ���� ��츸 ���� �����ϰ� �ϱ� ���Ͽ� �̰����� ��ħ
	//����� ���� ������ ��.
	
 public static int addOne(CustomerDTO one) {
	 int index = all.length; //5�� ����
	 
	 for(int i=0; i<all.length;i++) {
		 if(all[i] == null) {
			 all[i] = one;
			 index = i;
			 break;
			 		 }
	 }
	 return index; //5 �Ǵ� ����� �迭 ��
 }
 
 //id ������ ���� ��ȯ�ϱ�(getOne)
 
 public static CustomerDTO getOne(String id) {
	 CustomerDTO dto = null;
	 for(int i=0; i<all.length;i++) {
		 dto = all[i];
		 if(dto != null && dto.getId().equals(id)) {
			 break;
		 }else {
			 dto = null;
		 }
	 }
	 return dto;
 }
}
