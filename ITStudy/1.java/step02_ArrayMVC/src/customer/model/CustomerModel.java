/* test ������ ǥ��, DTO ��ü�� ����, ����, ����, �˻� (��� �˻�����, id�� �˻����� ���) �� �ٽ� ������ ����
 * ������ �迭�� ����Ѵ�(������¡ �Ұ���)
 *  1. �� ����� ���� �޼ҵ�� ����
 *  2. ���� �޼ҵ忡�� �ϳ��� �����͸� ���� (���� ���ú����� ��������� ��������� �߰�ȣ �� ���� Ŭ�������� ��밡��)
 *  3. �����͸� �迭 Ȱ�� : DTO ��ü�� CRUD
 */

package customer.model;

import customer.domain.CustomerDTO;

public class CustomerModel {
	//5���� �޸𸮰� �ִ� �迭 ���� (index 0~4, length ����)
	static CustomerDTO[] all = new CustomerDTO[5];
	//all�� �Ϲ� �ν��Ͻ� ����. ��ü ������ �� �� ���� (�׷��� static�� ���⼭�� ����)
	//DB�� ���� ������ byte code�� �޸𸮿� �ε��� �� ������ �ڵ�����Ǵ� ���
	// �ӽ� test ������ �ʱ�ȭ�� ����
	static {
		all[0] = new CustomerDTO("tester", "�̻��", "11", 26, "vip");
		all[1] = new CustomerDTO("ldh", "�̵���", "55", 27, "vip");
		all[2] = new CustomerDTO("admin", "��â��", "22", 28, "vvip");
		all[3] = new CustomerDTO("master", "��泲", "33", 28, "vvip");

	}
	//���Ǿ��� ��� �˻�
	public static CustomerDTO[] getAll() {
		return all;
	}

		
	//����
	/* id�� �ش� �� �����ϱ�(�迭�� �ش� index�� null ����)
	 * 1. �ʿ��� ������ : id
	 * 2. ��ȯ Ÿ�� : boolean 
	 * 
	 */
	
	public static boolean deleteOne(String id) { //������ �ƴ� ����� Ƽ�� ���� �ڵ��
		for(int i=0; i<all.length;i++) {
			if(all[i] != null && all[i].getId().equals(id)) { // [i]�� �迭, all[i]�� DTO, all[i].getId()������ ���ڿ�
				all[i] = null;
				return true;
			}
		}
		return false;
	}
	
	
	//����
	
	public static boolean updateOne(String id) { //string�� ==�� �ƴ϶� equals�� ���ؾ���
		//������ 2�� �����ؼ� �� ���� �ִ�. (String id, String grade)
		int index = -1; //�� ������ �ǹ�
		CustomerDTO one = null; //�ʱ�ȭ
		
		for(int i=0; i<all.length; i++) {
			one = all[i]; //��� ���ֱ� ���� ������ �����ߴ�.
			if(one != null && one.getId().equals(id)) { 
				index = i; 
				one.setGrade("vvvip");
				return true;	
			}
		}
		return false;
	}
		
	//����
	/* [1] ���� ��������
	 * 1. ����� �� 1 - ������ �迭 ������ �ܼ� ���� (all[4] = DTO ��ü ����
	 * 2. ����� �� 2 - null�� ���� �ִ� �� delete�� ������ �޸� ������ �ִٸ� �ش� index�� ���� (���� ������ null�ΰ� �����Ǹ� ����)
	 *
	 * [2] ȣ�� ����
	 * 1. null�� ������ ��� �ش� ��ġ�� ���ο� CustomerDTO ����
	 * 2. null�� ����? �� ��� ȣ���ϴ� ���� ��Ȳ�� �𸥴�.
	 *   - ��ȯ ���� 5 (�迭�� ��ü ũ��)�� ��� ������ ���� ����
	 *   - ��ȯ ���� 5�� �ƴ� ��� ������ ���� ����
	 */
	
	public static int addOne(CustomerDTO one) { //�Ķ���ʹ� ���������� ������ �����ϴ� DTO�����Ѵ�.
		int index = all.length; //5, 0~4 -> �̰� �ϴ� ������, ���������� ����ڰ� �����Ͱ� ����� ������ �ƴ����� Ȯ���ϱ� ����
		
		for(int i=0; i<all.length; i++) {
			if(all[i] == null) { // ==�� �� ���ϴ� ��. null�̶��, �� i �迭�� ����.
				all[i] = one; //CustomerDTO�� �����
				index = i; // 5�� index �������� �����Ų �迭�� index ������ ����
				break;	//����ִ� �ε����� �־��ٸ� �ű⿡ ������ ä������ break�ǰ� �ؿ� return���� ��.
			}
		}
		return index; //5 �Ǵ� ����� �迭�� index ���� ��ȯ
	}
	

	/* id ������ �ش� ���� ��� ���� ��ȯ
	 * 1. parameter - String id
	 * 2. ��ȯŸ�� - CustomerDTO
	 * 
	 * ���񱳽� �ʿ��� API - equals()
	 * �� - ���ǽ�
	 * �迭���� �������� DTO ��ü�� - �ݺ�
	 * 
	 * �����Ͱ� �����ϸ� �ش� DTO ��ü ��ȯ
	 * �ش� �����Ͱ� �� �����, null ��ȯ
	 */
	
	public static CustomerDTO getOne(String id) {
		CustomerDTO dto = null; //dto�� ��ȯ�Ϸ��� �̰� �ʿ��ϰ�, null������ �ʱ�ȭ���Ѿ���.
		for(int i=0; i < all.length; i++) {
				dto = all[i];
				System.out.println(i); //i ���� ��� �귯������ Ȯ���غ����� �־���.
				if(dto != null && dto.getId().equals(id)) { //������ �迭���� id, �ڴ� getOne���� ���� id. �� �ΰ� ���� ���Ѵ�.
					//dto != null �̰� null ������ ������ �ؾ���  && : and ������ 
					//���⼭ ������, tester2 (�� ���� ������)�� �ִ´ٸ� ���� ������ ���� �����µ�, null ���� ������ ��� �ұ�
					break; //�ݺ��� �����ϴ� �����
				} else {
					dto = null;
				}		
			}
	
		return dto;
		// return null;
	}
	


public static void main(String [] args) {
	 System.out.println(getOne("tester3"));  //���� �������� �ʴ� �� ����Ʈ. null�� ���;��Ѵ�.
	
  }

}
