package step01;

public class Parent extends Object{ //�����Ϸ��� �˾Ƽ� �߰����ִµ�, ����� ���̴� ��� �ǹ�. Object�� ��� Ŭ������ �����

	String name; //������ Ŭ���� �������� ��밡���ϵ��� ����.
	int age;
	public Parent() {
		super(); // Object ��ü�� ����
		System.out.println("�θ��� �⺻ ������");
	} //name, age ���� ������ ��� �����ϰ� heap ��ü ���ο� ����
	//Parent ��ü ����
	
	public Parent(String name, int age) { //�ʵ�
		super();
		this.name = name;
		this.age = age;
		System.out.println("�θ��� ������");
		
	}
	
	public void printAll() {
		System.out.println(name);
		System.out.println(age);
		
	}
	
}
