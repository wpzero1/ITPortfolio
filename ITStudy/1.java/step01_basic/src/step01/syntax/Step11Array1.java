/* �н����� - �迭
 * 1. �ټ��� �����͸� �ϳ��� ������ ����
 * 2. ������ �����ʹ� ������ index�� ����!
 *  - ù��° ������ ������ ������ 0
 * 3. ��� �迭�� ������ ��ü
 * 	 - �迭�� ���� ��� �����ϰ� ������ ��� � �޸𸮿� ����?
 * 	  : ��ü�� ����Ǵ� �޸���, heap�� ����
 * 4. �ѹ� ������Ų �迭�� ũ��� ���� �Ұ�
 *  - �������� ������ ǥ���� ���ؼ��� �迭�� �ƴ� list ������ ����
 *  - java.util package �н� ����
 * 5. ������Ų �迭���� �迭 �޸� ũ�Ⱚ�� ������ length��� ������ �ڵ� ����
 * [ ] ���ȣ ǥ���� �迭
 * �츮�� ����� ����� Ÿ�Ե� �迭�� �� �� �ִ�.
 * 
 * int[] i = {1,2,5,29} : �迭��
 * String[] s = {new String ("a"),"b","c"}
 * Test[] i = {new Test(), }
 * 
 * 
 */

package step01.syntax;

import step01.domain.PeopleDTO;

public class Step11Array1 {

	//int �迭
	public static int[] intArray(){ //��Ʈ �迭�� ��ȯ
		int [] i = {1,2,3}; //[] �� ��ġ�� ���� �� �� �������. 0��°, 1��°, 2��° i�� �����ϴ� �迭�� ���´�. 4��¥��(1,2,3,�׸��� length) -> �ּҰ��� i���� �ش�.
		return i; //ȣ���ϴ� ������ �� �ֱ�
		
	}
	//String �迭
	public static String[] stringArray() {
		String[] s = {"���δ�", "��泲", "�̿���"};
		
		return s;
	}
	
	// People DTO �迭
	public static PeopleDTO[] peopleArray() { //��ȯŸ�� ���ȣ ����
		PeopleDTO [] all = {new PeopleDTO("�ŵ���", 30),
									new PeopleDTO("�̿���", 31)};
		return all;
		
		}
	
	
	public static void main(String[] args) {
		
		int[] i = intArray(); //int[] �� �� ����������Ѵ�.
		System.out.println(i[0]);
		//int[] i2 = intArray()[2];
		String[] s= stringArray();
		System.out.println(s[1]); //index 1�� ���� ���
		System.out.println(stringArray()[1]); //�ٵ� �̷��� �ص� ��(String[] ���� ���ϰ�)
		
		//index 1��° ģ���� �̸����� ����غ���
		PeopleDTO [] all = peopleArray();
		PeopleDTO p = all[1];
		String name = p.getName(); //���ڿ��� �ޱ�
		System.out.println(name);
		
		//�̰� ��� ���ϱ�?
		//PeopleDTO p1 = peopleArray()[1]; //���� �� ������ ����
	
		String p1 = peopleArray()[0].getName(); 	//-> 3���� ���ٷ��ϸ�?..  []�� �迭 �� � �ε����� ȣ���� ��, .�� ��ü ���� �ִ� �� ȣ��
		System.out.println(p1);
		
		/* peopleArray(): PeopleDTO �迭 ��ȯ
		 * peopleArray()[1] : �迭 ���� �ִ� Index 1��° ��ü�� PeopleDTO ��ü ��ȯ
		 * peopleArray()[1].getName() : ��ü�� getName() ȣ��
		 */
		
	
	
	}

}
