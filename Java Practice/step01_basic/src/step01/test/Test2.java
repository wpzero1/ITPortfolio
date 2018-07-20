/* �н�����
 * 1. ������ Ÿ��
 * 		Ÿ�� ������;
 * 2. �޼ҵ��� Ÿ��
 * 		��ȯŸ��, argument�� ����� ����Ÿ��
 * 		��ȯŸ�� �޼ҵ��( [Ÿ�� ������, ...]) {}
 * 3. Ÿ������ ��� ������ Ÿ���� ����? ������
 * 	1) int�� ���� �⺻ Ÿ�� - 8����
 * 	2) Stringó�� JDK ���ο� class�� �������ִ� Ÿ��
 * 	3) ����ڰ� ���� �����ϴ� Ŭ���� 
 * 
 */

package step01.test;

import step01.domain.FriendVO;

public class Test2 {
	//String�� argument�� �޴� �޼ҵ� ����
	void m1(String v) {}
	//String�� ��ȯ�ϴ� �޼ҵ� ����
	String m2() {
		return "ee";
	}
			
	//FriendVO (ctrl shift O �� ������ import�ڵ� �߰���)
	void m3(FriendVO v) {}
	
	public static void main(String[] args) {
	Test2 t = new Test2();
	System.out.println(t.m2()); //�ݵ�� ȣ���Ҷ� �Ұ�ȣ���� ������ü�� �� ������Ѵ�
	t.m1("����"); //String���� ����Ǿ�����.. ���ڿ��� ��־����
	
	t.m3(new FriendVO()); //��ü�� ȣ���ؾ��Ѵ�. db�����ÿ� ���̷�Ʈ�� ���� ����
	// �Ǵ� ������ ���� ����°� ����
	FriendVO v = new FriendVO();
	t.m3(v);
	
	
	}

}
