package step01.test;

public class Test { //�ڵ��� ������ ũ�� �߿����� �ʴ�. �������� ���� ��
	String message; //����
	int age; //����
		
	public Test() {} //������ (�� ��ü�� ���� �޸𸮵� ���� �⺻��������)
	public Test(String m, int a) { //�������� �����Ϳ� ���� ������
		message = m; //��������� �ʱ�ȭ��Ŵ
		age = a;	
	}
	//��ü ���� ���� message, age ��� ������ �����? ����μ� ����.
	//��밡���� ��ü�� instance
	//���θ޼ҵ� ȣ���� �츮 �ڵ尡 �ƴ϶� �ڹ� ����ȯ���� ���� ���ش�.
	
		public static void main(String[] args) {
	Test t = new Test("������ �� ���׿�", 46);
	System.out.println(t.message); //test ��ü�� �����ϴ� �޼��� ������
	System.out.println(t.age); 
	

	
	/*
	 * ����Ǵ� ����
	 * Test t 1��
	 * new Test (~) 2��
	 * public test(String m, int a) { ~ 3��
	 * }
	 * �̰� ������ Test t = new Test (~) 4�� �̰ŷ� �ٽ� ��.
	 * �� �ܰ�� ;�� ���ؼ� �Ϻ��ϰ� ������ �Ѿ��.
	 */
	
	}

}
/* 
* 1. ������ ���� �ڵ� �߰��Ǵ� �ڵ��?
*	public Test() {}
* 2. "������ �� ���׿�" ��� �����͸� ������ �� �ִ� ������ �����ϱ�(message)
* 3. 46 ���ڰ� ���� ������ ���� ����(age)
* 4. ��ü ���� ������ �������� �����ͷ� ������ ���� �� �� �ִ� 
* 	 parameter(argument,�Ű�����)�� �ִ� ������ �����
* 5. ������ �� ���׿�, 46 �̶�� �����ͷ� ��ü���� �� ������ �� ���
* 	(��Ʈ : ��ü ���� ������ �� �ϳ���.) Ÿ�Ժ����� = new ������ȣ��(..);
*/