/* �н�����
 * 1. �ֿ� API
 * 		1) java.util
 * 		2) ArrayList - �����迭�� ���
 * 			- ù ������ 10���� �޸� ����
 * 			- 11��° ������ ������ 10���� �߰� ����(21, 31 ������)
 * 
 * 		3) �޼ҵ�
 * 			1] ������ ���� : add(Object o) //��� �Ķ���� ����
 * 			2] ������ ���� : remove(int index) //���° ������ ��������
 * 			3] ������ ��ȯ : Object get(int index) //���° ������ ����� �ּ���
 * 			4] ������ ���� : size() 
 * Object o = "Ee"; 
 * Object�� ��ȯ���Ѽ� ����  Object�� ��ȯ�� ��
 * 
 */

package step01.util;

import java.util.ArrayList; //java.util�� import �ʼ�
			
public class Step01ListTest {

	public static void main(String[] args) {
		System.out.println("---���׸� �� �ݿ�---");
		ArrayList a = new ArrayList();
		a.add(3); //new Integer(3)�� autoboxing�ؼ� �ٲ����
		a.add("ans"); //��� ���� ���� �� ����
		//? index 1��° ���ڿ� ��ü���� ������ charAt(1)
		String v = (String) a.get(1); //����ȯ �ؾ���
		System.out.println(v.charAt(1));
		//�� ������ ���ٷ� ���̸�?
		System.out.println(((String)a.get(1)).charAt(1)); //a.get(1)���� ����, String���� ����ȯ, �׸��� charAt(1)���� 1��° ���ڿ� ����
		
		
		
		//String�鸸 ���� ������ ���� �޸��� �迭 ���� ��ü ����
		// Ÿ�� ���� - ���׸� : <>�� ������ �ִ� ����
		System.out.println("---���׸� ������ list : jdk1.5���� ���� ---");
		ArrayList<String> list = new ArrayList<String>();  //�����迭. ũ�Ⱑ �������� ���� �迭
		
		System.out.println(list.size()); //0. size��� �޼ҵ带 ���� ũ�� ��Ÿ��
		//������ ����
		list.add("������"); //0��° �ڵ� ����
		//���׸� ������ ����ȯ ���� index ������ ���� ������ Ÿ���� ��ü�� ��ȯ
		System.out.println(list.get(0).charAt(0)); //list.get(0)�� string ��ü��. �׳� get(0).charAt(0)�̸�, get(0)�� Object�� charAt�Ұ�
		
		list.add("���Ѹ�"); //1��° �ڵ� ����
		list.add("Ȳ�ι�"); //2��° �ڵ� ����
		//list.add(new Integer(3)); ���� ����. ��? String�� ���� �����ϴϱ�. ���� 3�� �־ new Integer(3)���� �ڵ� ��ȯ��(Object �Ʒ��� �ֱ� ������)
		System.out.println(list.size()); //3
		
		//index�� 1�� ����� ������ ��ȯ �� ���
		System.out.println(list.get(1));
		//������ ����
		list.remove(1); //1��° ������ ����
		System.out.println(list.size()); 
		System.out.println(list.get(1)); //2��° �ִ� �����Ͱ� 1��°��...
		
		System.out.println(list); //��ü ������ ������(�迭��)
		
		
		System.out.println("--- DTO ��ü Ȱ���� ���� ---");
		ArrayList<PeopleDTO> list2 = new ArrayList <PeopleDTO>();
		list2.add(new PeopleDTO("����",20));
		list2.add(new PeopleDTO("����",10));
		
		PeopleDTO one = list2.get(0);
		String name = one.getName();
		System.out.println(name);
		//���� ª�� �ٿ�����?
		System.out.println(list2.get(0).getName());
		System.out.println(list2.get(1).getAge());
	}

}
