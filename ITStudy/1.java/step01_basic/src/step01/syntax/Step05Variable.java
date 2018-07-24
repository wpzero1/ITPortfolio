/*�н� ����
 * 1. ���� �ʱ�ȭ
 * 		1) ��� - ��ü ������ �ڵ� �⺻������ �ʱ�ȭ
 * 		2) ���� - �ڵ� �ʱ�ȭ�� �Ұ�, ���� ��� �� �ʱ�ȭ �ʼ�

 * 2. �⺻ Ÿ�� ���� ���� ����ȯ
 * 		- Ÿ���� �ٸ� ������ ������ "����ȯ" �������� ��ȯ�� ����
 * 		- boolean�� ���� �ٸ� Ÿ������ ��ȯ �Ұ�
 * 		- �Ǽ��� ������ ���������� �������� ū �޸𸮰� ����
 * 
 */
  package step01.syntax;
//��������� ���ú������� �������� �˾ƺ��� �ǽ� (�ڵ� �ʱ�ȭ�� ������)
  
public class Step05Variable {
	int no; //����
	String msg;
	
	void localVar() {
		int no = 0; //���� �������� ����ϱ� ���� �ʱ�ȭ�� �ؾ��Ѵ�. ���� ����.
		System.out.println(no);
	}
 //�⺻Ÿ�� ����ȯ ���� �н�
	void typeCasting() {
		byte b = 8; //8bit
		int i = b; //32bit
		byte b5 = (byte)i; //����ȯ. ��ȯ�ϴ� Ÿ������ �������ִ� �۾�. ���� -> ū������� : upcasting �ݴ�� downcasting
		
		char c = 'B'; //16bit
		int i2 = c;
		System.out.println(c);
		System.out.println(i2); //ASCII �ڵ�� ����
		
		//������ ��Ģ ����� ������ int�� ��ȯ
		byte b1 = 8;
		byte b2 = 10;
		byte b3 = (byte)(b1 + b2);
		
	}
	
	public static void main(String[] args) {
		Step05Variable s = new Step05Variable(); //��ü����
		//��ü ������ heap�� ������ no�� msg�� �ڵ� �ʱ�ȭ
	//	System.out.println(s.no);
	//	System.out.println(s.msg);
		
		s.typeCasting();
		
	}

}
