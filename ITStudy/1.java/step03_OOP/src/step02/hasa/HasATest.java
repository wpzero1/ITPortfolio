/* �н�����
 *  1. ��ü���� ����� ���(����)�Ǵ� ���踦 "has a" ����
 *  2. ����
 *  	has a [�����, ����]
 *  	���԰���.
 *  3. ����
 *  	- ����� is a[�����, ����] �� ǥ��
 *  	- �� �Ӽ�(������)���� ������ ��쿡�� ��� ����
 *  	���� : ���� Ŭ������ �� Ŭ���� ������ ��� ����
 */

package step02.hasa;

public class HasATest {

	public static void main(String[] args) {
		//String engineName -> Engine -> Car -> Person & String �ؼ� �� 5���� ��ü�� �����ȴ�
		/* �λ���� ��ü, �� ���� Person ��ü ����
		 * ? �����̸�, cc, Person�� �̸��� �� �����ϰ� ����ϴ� ���
		 * 
		 */
		Person p1 = new Person();
			
		p1.myCar.engine.engineName = "�ҽ�����"; //p1.myCar.engine.setEngineName("�ҽ�����"); ����. ������ �ִ°� set
		p1.name = "���缮";
		p1.myCar.engine.cc = 500;
		
		System.out.println(p1.myCar.engine.engineName); //(p1.myCar.engine.getEngineName()); ����. ������ ���(�޴°�) get
		System.out.println(p1.name);
		System.out.println(p1.myCar.engine.cc);
		
		/* �ؼ�
		 * p1 - Person ��ü
		 * p1.myCar - Car ��ü
		 * p1.myCar.engine - Engine ��ü
		 * p1.myCar.engine.setEngineName() - Engine��ü�� �޼ҵ�
		 */
		
		Person p2 = new Person();
		p2.myCar.engine.setEngineName("�α�������");
		p2.name = "����ȣ";
		p2.myCar.engine.setCc(5);
		
		System.out.println(p2.myCar.engine.getEngineName() + "�� ������� " + p2.name + " ���� �����뷮�� " + p2.myCar.engine.getCc() + "�Դϴ�");
		System.out.println(p2.myCar.engine.getEngineName());
		System.out.println(p2.name);
		System.out.println(p2.myCar.engine.getCc());
		
	}

}
