package util;

public class InstanceTest {

	public static void main(String[] args) {
		//�߰��ܰ踦 Ȯ���� �� �ִ� �ڵ带 ¥����
		D d = new D(); //�޼ҵ� ȣ��
		System.out.println(d.c.b.a.no);
		/* d = D ��ü
		 * d.c = C��ü
		 * d.c.b = B��ü
		 * d.c.b.a = A��ü
		 * d.c.b.a.no = 
		 * 
		 * CustomerModel�� new CustomerDTO �� ���ٸ�, �� Ŭ���� ������ ������ �����͸� ������� ����.
		 * ���⼭�� ��ü �������� ȣ���ؾ��Ѵ�.
		 * ����� �����ϰ� �ִٸ�(������ ������ ������) ������ ���ؼ� ��ü ���� ������ �ҷ��� �� �ִ�
		 */
	}

}
class A{
	int no = 20;
	A(){ //������ : �޼ҵ��ε�, Ŭ���� �̸��� ������ �����ڶ�� �θ���. ��� A() {}�� �ȸ��� �ڵ������� ���������.
		//super(); - �̰͵� �ȸ��� �ڵ����� �������.
		System.out.println("A"); //�߰��ܰ� Ȯ���غ��°Ŵ�. �̰� ������ �����ڰ� �ʿ���
			}
	}
class B{
	A a = new A();
	B(){
		System.out.println("B");
		
	}
	}
class C{
	C(){
		System.out.println("C");
	}
	B b = new B(); //A ��ü ���������, B��ü �������
}
class D{
	D(){
		System.out.println("D");
	}
	C c = new C(); // A,B,C,D ���ʷ� �������
}

