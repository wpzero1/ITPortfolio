/*�н�����
 * 1. ���� ó�� ���� �ͼ�������
 * 2. ó�� ����
 * 		1) try ~ catch
 * 			���� �߻��� ���� �ִ� ���ɼ� �ִ� ���� ��ü�� ���� ó��
 * 		2) throws
 * 			���� �߻��� ���� ó���� ȣ���� ������ ����
 * 		3) ���� �߻� ���ο� �����ϰ� 100% ���� ���� ���
 * 			�ڿ� ��ȯ ���� � ����
 * 			DB���� �ڿ� ����, �����(IO) �ڿ��� ��ȯ�� �ַ� ���
 * 			try~catch~finally
 */
package step01;

public class ExceptionTest2 {

	//step01 - 
	static void m1() {
		try {//���� �߻� ���ɼ� �ִ� �ڵ�� ����
			Class.forName("step01.A");
		} catch (ClassNotFoundException e) { //�ش� ���ܰ� �߻��� ó�����
			e.printStackTrace(); //���� �߻��� �� ��Ȳ �ľ� ������ �޼ҵ�
		}
	}
	//step02- ���� ó���� ȣ���� ������ ���� : ������ ���ܵ� ȣ���� �ʿ��� �ذ��ϵ���
	static void m2() throws ClassNotFoundException { //�ᱹ�� try catch �ؾ���
		
			Class.forName("step01.A");
		
		}
	
	//step03-
	static void m3() {
		try {
			Class.forName("step01.Aaaaafdfa"); //��Ÿ������ ���� ��� �ɱ�?
		} catch (ClassNotFoundException e) { 
			e.printStackTrace(); 
		} finally {
			System.out.println("���� �߻� ���ο� �����ϰ� 100% ���� ����");
		}
	}
	//step04-
	static String m4() {
			try {
				Class.forName("step01.Aee"); //���� ��Ÿ
			} catch (ClassNotFoundException e) {
				e.printStackTrace(); 
				System.out.println("�� �����ϴ� byte code�Դϴ�");
			} finally { //������ �ְ� ���� ������ �����
				System.out.println("���� �߻� ���ο� �����ϰ� 100% ���� ����");
	}	
			return "������ ��ȯ?"; //�̰͵� ������ ��ȯ��
	}
	public static void main(String[] args) {
		m1();
		try { //ȣ���� �ʿ����� �ᱹ�� try catch�� �ؾ���
		m2();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		m3();
		System.out.println(m4());
	}
}
