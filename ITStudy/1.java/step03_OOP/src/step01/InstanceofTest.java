package step01;

public class InstanceofTest {

	public static void main(String[] args) {
		//String ��ü�� ���밪 ��
		System.out.println("data".equals("data")); //true "data"�� .���̸� �� �� �ִ� �޼ҵ���� ���´�.
		//Integer ��ü�� ���밪 ��
		
		Integer i = new Integer("3"); //��ü ���� �ʿ���
		Integer i2 = new Integer("33");
		System.out.println(i.equals(i2)); //false
		
		System.out.println(i.equals("���ڿ�")); //false. Ÿ���� �޶� �ٸ��� ���´�. equals()�� parameter�� Object
		/*java.lang.Obejct�� ��� ��ü Ÿ���� �ֻ���
		 * �⺻ Ÿ�� 8������ ������ ��� Ÿ�� �� ���� ����
		 * ������Ÿ��
		 * 	1. �⺻ Ÿ�� - ���� �Ǽ� ���� ��
		 * 2. ���� Ÿ�� - �⺻ ������ ��� Ÿ��
		 * 
		 */
		System.out.println(i.equals("3")); //false
		System.out.println("3".equals(i)); //false. Ÿ���� �ٸ��� �� ��ü�� �Ұ����ϴ�.
		
		//����� ���� ��ü�� ���밪 ��
	
		
		//Object�� �ڽ� String, Integer, ...�� ��� ��
		/* ��ü Ÿ�� �� ������ �н� ����
		 * 1. instanceof
		 * 2. �������� : ��� ���迡���� �� ����
		 * 
		 */
			System.out.println("string" instanceof Object); //true - ���ڿ��� object�� Ÿ�� ��. �񱳴��� ������ ������ ���ϴ� ������ ��.
			System.out.println("string" instanceof String); //true
			//String�� integer�� �������� ��� ���� �� �Ұ�
			// System.out.println("string" instanceof Integer);  ������
			
		System.out.println("--- ������"); //�� �����ؼ� �����ϴ� ���
		AA a = new AA(5);
		AA a2 = new AA(10); // AA ��ü 2�� ����
		System.out.println(a.equals(a2)); //������ �ٸ� ��ü�ϱ� �ּҰ� �񱳸� �ؼ� false�� ����.
														 //but, �ؿ��� class AA�� ����� ������ �ϸ� true. �׸��� �Ŀ��� ���� �����ؼ� �񱳰���.
	
	}

}
class AA extends Object{
	//��ü�� �ּҰ� ���ߴ� �޼ҵ带 ���밪(������) �񱳷� ������
	int data; //�������
	
	AA() {} //�׽�Ʈ�� ���� �����ڸ� ���� -> ���� ������ ��Ʈ���� �� �����ؼ� ����. ���� ���̸� true, �ƴϸ� false
	AA(int d){
		data = d;
	}
	/* AA ��ü�� ��
	 * 1. AA Ÿ�� ���� �� (�� �̰Ÿ���) - instanceof
	 * 2. AA Ÿ���� ��ġ�ȴٸ� AA ��ü���� ������ ��� ������ ��
	 * 		Object Ÿ���� ������ ��ӽ�Ų �޼ҵ常 ȣ���� ����
	 * 		�ڽĸ��� ����� ȣ���ϱ� ���ؼ��� ����ȯ �ʼ�
	 */
	public boolean equals(Object o) {
		if(o instanceof AA) { //o�� AA Ÿ������ ��
			AA a = (AA)o; //����ȯ. data ������� ���ؾ��ϴϱ� o�� Object�� ���ҷ�. �׷��� ����ȯ �ؾ���
			
			//�� �޼ҵ带 ������ ��ü�� data ������ parameter�� ���Ե� ��ü�� data ���� ��
			if(data == a.data) {
					return true;
			}
		}
			return false;
	}
}