package step01;
/*1. Parent 2 ��� �ޱ�
 *2. int no2 ���� �� �ʱ�ȭ(�� ����)
 *3. printAll() �޼ҵ� ������
 *4. �������� ����� ��ü�� ���ο��� ����
 *5. printAll() ȣ��
 *6. Child2���� no2 ���� 100���� ����
 *7. no2 ���� ��� 
 */
public class Child2 extends Parent2{

	int no2 = 5; //�ʱ�ȭ ��ü�� �� �ִ� ����.

	public void printAll() {
		super.printAll();
		System.out.println(no2);
		
	}
	
	public static void main(String[] args) {
		
		Parent2 p = new Child2(); //������ ����� ��ü
		Child2 c2 = (Child2)p;
		//p.printAll(); //�����
	
		c2.no2 = 100;
		c2.printAll(); //�Ǵ� System.out.printIn(c.no2);
		System.out.println(p.no1); //10
		p.no1 = 1000; 
		System.out.println(c2.no1); //1000. ���� ���� �����ϱ� ������ ����
	}

}

class Parent2{ //Ŭ���� ��������
	int no1 = 10;
	void printAll() {
		System.out.println(no1);
		
	}
}