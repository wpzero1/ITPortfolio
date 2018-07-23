/*�н�����
 * 1. �迭 Ÿ���� �̿��� ����� ���
 * 2. String �����Ͱ� ���ϱ�
 * 		- public boolean equals(String v) {���ڿ� ��} - ������ True, �ٸ��� False
 * 3. ����� ������
 * 		==
 * 		1. �⺻ Ÿ�� : ���� ����
 * 		2. ��ü Ÿ�� : �ּҰ�(��ġ) ��
 * 		
 * 
 * 
 * d3 �ð�ȭ ���̺귯��
 */

package step01.syntax;

import step01.domain.PeopleDTO;

public class Step12Array2 {

		//���ڿ� ��
	public static void equalsTest(String v) { //v : ���ϰ��� �ϴ� ��
		String id ="tester";
		System.out.println(id.equals(v)); //id ������ tester�� ���� true, �ƴϸ� false�� ���� ��. ���ο� �����Ϳ��� ��
		
	}
		//== ���� �� �����ڷ� ��
	
	public static void operator(int i) {
		int data = 10;
		System.out.println(data== i);
		
	}
	
	//== ��ü Ÿ�� �� : �ּҰ� ��
	public static void operator(PeopleDTO dto) { //�׻� �ٸ����� ������� ctrl shift O�� ����Ʈ
		PeopleDTO p = new PeopleDTO("name", 10); //��ü �ϳ� �����
		System.out.println(p == dto); //false. �ٸ� ��. �̰� �ּҰ��̴�. ��ü ��ü���� ���ϴ°ǵ�, ���� �ٸ� �ּҰ��� ������ �ִ�.
			
		System.out.println(p.getName().equals(dto.getName())); //true ��. ��ü ���� �������� ��
		
		//���� ������ Ǯ� �Ẽ��.
		// p.getName().equals(dto.getName()) �̰Ͱ� ������ �ڵ�� �Ʒ��� ����.
		String name = p.getName();
		String name2 = dto.getName();
		name.equals(name2); //string ��ü �ȿ� �ִ� equals �޼ҵ带 ���ڴٴ� �ǹ�...
		
		System.out.println(name.equals(name2)); // - true
		
		/*���� ����
		 * p : PeopleDTO
		 * p.getName() : PeopleDTO�� name String �� ��ȯ�� ����
		 * p.getName().equals() : String�� equals() ȣ�⸸.
		 * dto.getName() : dto�� getName() �� name ������ ȹ��
		 * dto.getName()�� ������� Ȯ���� ��ȯ�Ǹ�(dto.getName() �����ϰ� ����, �� ���ϴ°� �ֳ�?
		 *  �׷��ϱ� equals() �޼ҵ尡 ����.
		 */
	}
	
	//�迭�� length ���� ��� ����
	
	//String[] �������� ID���� ������ �ž�. �� �Ŀ� �ϳ��� ID�� �ָ鼭 ���翩�θ� ��ȯ���ִ� ����� ©�ž�
	public static void lengthTest() {
		int[] i = {1,6,77,7,67};
		for(int index=0; index < i.length; index++) //index�� 0���� ����, 0~4���� 5�� ����. �ε����� �������Ѱ��鼭 ���� ���̴�
		System.out.print(i[index] + "\t");
		
	}
	
	public static void main(String[] args) {
		equalsTest("tester"); //true
		equalsTest("e"); //false
		
		operator(10); //true
		operator(9); //false
		
		operator(new PeopleDTO("name", 10)); //false. new�� ���ο� ��ü�� ����� ������ ���� �ٸ���. �ȿ��� ���ο� ��ü ���� ����
		
		lengthTest(); //���ο��� �޼ҵ� ȣ�� (�� ���ο��� ȣ���ϴ°� ������ �ȵȴ�)		
	}

}
