package step01;

public class Child extends Parent{ 
	String job;
	
	Child() {
		super("â��",28); //������ �ÿ� ������ �ȿ� ������ �ڵ����� �������.
		//�� super()�� �̾��� �� �θ��� �⺻ ������. ������ ȣ���� �ǹ̴� ��ü������ ����..
		//��ü ���� ���� : Object -> Parent(name, age) -> Child(job) �� ���� ������ ��밡���ϰ� �������.
		System.out.println("�ڽ��� �⺻ ������");
	
	}
	
	//������
	public void printAll() {
		super.printAll(); //���۸� ����, �θ� ���뵵 �� ������
		//System.out.println(name);
		//System.out.println(age);
		System.out.println(job);
		
	}
	public static void main(String[] args) {
		Child c = new Child(); //�θ� �����ڴ� �ȸ�����µ�, �θ��� �⺻������ �޽����� ���´�.. ��?
		
		//step02 - ������ ���� (�ٸ���� �ڵ� �м��ϱ� ���� ���� �ʿ�)
		Parent p = new Child(); //��ĳ����.
		p.name = "����";
		// p.job = "IT man"; //���� ����. job ������ parent�� �ƴ϶� child�� ����
		//�ڽĸ��� ����� access�� ���� �ʼ� ���� �ʿ��� - ��ü���� ����ȯ �θ�� �ڽ� ������ �����ִµ�, �θ� �ڽ����� ������ (�ٿ�ĳ����)
		Child c2 = (Child)p; //�ٸ� c�� ������ c2. ���� ������ ���� ������ ������. (���⼱ p�� �� ���� ����)
		c2.job = "IT man";
		c2.printAll();
		
		
		
		System.out.println("-------------");
		//step01 - ��Ӱ����� ��ü ���� �н�
		System.out.println(c.name);
		c.name = "��";
		System.out.println(c.name);
		c.printAll();
		
		
	}

}
