/*�н�����
 * 1. static Ű����
 * 2. ���� ����
 * 		1) ��� ���� ����
 * 			- �����Ǵ� ��� ��ü���� �����ϴ� ���� (heap�� ����)
 * 				: �����ڿ��� �ƴ� �����鿡 ��� ����(Ư�� ����������)
 * 			- static ������ �޸𸮿� ���� ��� �����ϰ� �����Ǵ� ������?
 * 
 * 		2) �޼ҵ� ����
 *  - ��ü ���� ���� Ŭ���������� �޼ҵ� ȣ�� ����
 *  
 * 		3) static{} 
 * 			- web server�� ���۵� �� ��� user�� �����ϴ� �ڿ��� �ִٸ� �� �ѹ� ���� ������ �� �� �ִ� ����
 * 				�̸��� ���� ���� �ڵ�� ȣ�� �Ұ�
 * 			- byte code�� �޸𸮿� �ε��� �� �ڵ� ����
 */
 package step01.syntax;

public class Step06static {

	//step 02 - static ���� (��ü ���� �ʿ����) - �ڿ� ������ �ʿ䰡 ���� ��
	
	static int no = 100;
	static String msg = "���ڿ�";
	
	//instance ���� - ��ü ���� �ʿ���. byte �ڵ� ���常 �س���, ���� ���߿� main���� ȣ���ҰŴ�.
	int no2 = 200;
	String msg2 = "���ڿ�2";
	
	
	void m1() {
		System.out.println("�Ϲ� �޼ҵ�");
	}
	//��ü ���� ���̵� class��.m2() �Ǵ� ������ Ŭ������� m2(); ȣ�� ����
	static void m2() {
		System.out.println("static �޼ҵ�");
			
		}
	//>java Step06static		Step06static.main();  static������ ��ü�������� Ŭ���������� ȣ�� �����ϴ�
	public static void main(String[] args) {
		m2(); //������ Ŭ���� ������ ȣ��
		Step06static.m2(); //class��.m2() ȣ��
		
		
		System.out.println(no);
		System.out.println(msg);
		
		Step06static s = new Step06static(); // ��ü ����
		System.out.println(s.no2);
		System.out.println(s.msg2);
		
		System.out.println(Math.random());
		
		/* java.lang.Integer Ŭ������ �޼ҵ� ȣ�� (int�� �⺻ Ÿ��, integer�� Ŭ����Ÿ��)
		 * "3" -> int�� ��ȯ�ϴ� �޼ҵ� ȣ���ؼ� ��ȯ�ϱ�
		 * �ʿ��� ������ - int�� ������ ���ڿ� ������
		 * ��� ������ - int�� ��ȯ�� ������
		 * 
		 * �� ������ � Ŭ�������� ������ ���ΰ�?
		 * String? Integer?
		 * Ȥ ���ڿ� �����͸� ������ �޼ҵ带 ������ ��ü�� �ʿ��Ѱ�?
		 * 
		 * byte : Byte��� Ŭ������ ȣȯ�� - public static byte parseByte(String v) {}
		 * parsexxx 
		 */
		
		
		
		int no3 = Integer.parseInt("3"); //�ڹ�API - Integer���� ã�� �׸�
		System.out.println(no3);
		
		
	
		
		
		
		
	}
}

	//step 01 - static{} �н� ���� (������Ʈ�ÿ� ���� �� ����)
	/*static {
		System.out.println(1);
	}
	public static void main(String[] args) { //���⼭�� ���̵� ���κ��� ����ƽ�� ���� ����ȴ�.
		System.out.println("main");
	}
	
		static {
			System.out.println(2);
			
	}

} */
	
