/* �н�����
 * 1. �⺻ syntax ����
 * 2. ���� ����(����), ���� �ʱ�ȭ(�� ����)
 * 		�޼ҵ� ����(����), �޼ҵ� ȣ��
 *		������ ����, ������ ȣ��
 *3. �� ���� ����� �뵵
 *		1) ���� - ������ ǥ��
 *		2) �޼ҵ� - �پ��� ó�� ����� �����ϴ� ���
 *				��ȯŸ�� �޼ҵ��( [] ) { [..] }
 *		3) ������ - ��ü ������ ȣ��Ǵ� �ʼ� ���� ���
 */

package step01.syntax;

public class Step02Type { 
	//Ȳ�ι�,27
	String name; //����. ����� ������
	int age;
	public Step02Type() {} //�⺻ ������, ��ȯŸ�� ���� (name�� age�� �����ϴ°� �������)
	
	//Step02Type ��ü ��ȯ �޼ҵ�
	Step02Type getObject() { //������ �ϰ����� int getObject() { �̷��� �ϰ�, �ؿ��� return int s �� �;��Ѵ� string�̸� "s"
		Step02Type s = new Step02Type(); // ��ü ���� ����. ȣ���ϴ� ������ �����͸� �ְ� �ͽ��ϴ�.
		// �޼ҵ� ���� �����̱� ������, �̷� ������� ���� ������ ������Ѵ�.
		// �ٸ� Ŭ�������� ������ �޼ҵ带 �ٸ� ���ο��� ���� ���ؼ� �ʿ��� ������
		return s; //������ �޾ƿ� ������ ������. �ѱ�� ���� �޼ҵ��� �ּҰ�
	}
	
	Step02Type getObject2() {
		return new Step02Type(); //new ~�� ���� ����ǰ� return�� �����
	}
	
	
	public static void main(String[] args) { //���� �޼ҵ� ȣ��.
	//step02 - �޼ҵ� ȣ���ؼ� ��ü �޾ƿ���
	//Ŭ���� ���� �����ϴ� ����, �޼ҵ���� ���� �����ϱ� ���ؼ��� �ݵ�� ����, �޼ҵ带 ������ ��ü ������ �켱
	//? getObject() ȣ���غ���
		
	Step02Type s = new Step02Type(); //���⼭ ��ü ������ ���������̴�. �̰� �־�� �޼ҵ带 ȣ������
	Step02Type v = s.getObject(); //s�� v�� ���� �ּҰ��� ������? �ּҰ��� ��ġ��. �ٸ���.
	//new�� ���� �޸𸮸� ���� ��´�. ������ s�� �������� �ٸ� ��.
	
	
	
		//����� ������ �� ������ ����, ȭ�� �ܼ�â�� ��� - �̸� ���� : ��밡���� �޸� Ȯ��, �װ� �����ͼ� ����ؾ���
		/*1. ��ü ���� - new ������()
		 *2. ������ ��ü�� �����ϴ� ������ ȣ���ؼ�
		 *	������ name, age ������ �� ����
		 *3. �� ������ ȣ���ؼ� ���
		 */
		//step01
/*		Step02Type s = new Step02Type(); //��ü����
		s.name = "Ȳ�ι�";
		s.age = 27;
		System.out.print(s.name); //print�� ���� ln�� ���ϱ�, �������� �ٷ� ����
		System.out.println(s.age);*/
	}

}