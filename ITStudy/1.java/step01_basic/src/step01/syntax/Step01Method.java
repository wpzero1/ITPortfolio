/* �н�����
 * 1. �޼ҵ� ����(����, �����)
 *  - ��Ģ���� �������� �׽�Ʈ
 * 2. �޼ҵ� ȣ��(���)
 * 3. ���� ��ġ
 *  - class ���� �������� ���� ����
 *  - �޼ҵ� ���ο� �޼ҵ� ���� �Ұ�(���̽�� �ٸ���)
 *  - �޼ҵ� ���ο��� �ٸ� �޼ҵ� ȣ�� ����
 * 4. �⺻ ����(*)
 *  - ��ȯŸ�� �޼ҵ��( [arguments] ){ [����] }  (�̸� �����������)
 *  - ��ȯ�� Ÿ�Կ� �°� ��ȯŸ�� ����
 *  - ��ȯ�� ���� �޼ҵ��� ��� ��ȯŸ�Կ� void�� ����
 * 5. ����
 *  - �����ڿ� ���� ��
 *  	������ ���� : Ŭ������ ([arguments] ){ [����] }  (��ȯŸ�� ���� x)
 *  
 *  
 */

package step01.syntax;

public class Step01Method {
	public Step01Method() {}
	// + ���� ����� �޼ҵ� ����
	/* ���� ����� ��
	 * ����� �� 1 - ���� �����ͷ� ���ؼ� ��ȯ
	 * ����� �� 2 - ���� ������(�׶��׶� �޶�����)�� ���ؼ� ��ȯ 
	 */
	public int sum(){  //���� �޼ҵ� �̸��� �׳� sum�̶�� ���غ�
		return 3+5; //��ȯ ���ɾ� �ʼ�. 3+5�� 1��° ����, �̰� return�ؼ� int���� ����
	}
	public int sum(int no1, int no2){ //sum2(10, 20) -> sum2���� alt shift R�� �ٲ���.
		//�׶��׶� ������ ���� �ٸ��ٸ�...
	
		return no1 + no2;
	}
	public void sum(int no1, int no2, int no3){ //void�� �غ�����. ��ȯ x �ϸ���Ű��, ���� �޾ƿ�������
		System.out.println(no1 + no2 + no3);
	}
	public static void main(String[] args) {
		//1�ܰ� - �޼ҵ� ȣ���ϱ� ���� ��ü ����(�޼ҵ带 �����ϰ��ִ°� ��������)
		//��ü ���� ���� : Ÿ�Ժ��� �� = new ������ ();
		Step01Method s = new Step01Method();
		//�׸��� �޼ҵ带 ���� ȣ���ҰŴ�
		int v1 = s.sum() ; //�� ������ ���� �ѹ� ���µ� �޸𸮸� �� �ʿ䰡 ����. �׷��� sum2���� �׳� �־���
		System.out.println(v1);
		System.out.println(s.sum(100,  200));
		s.sum(3,5,6); //������ �ٷ� ����ϱ⿡ �׳� �̷��� ��� ���� ����
						

	}

	
}

/*
 * ��������
 * void a() {}
 * int i = t.a()); �̰� �Ұ���. void�� ���� �ȹ޾ƿͼ�
 * 
 * �������� : �پ��� �������� �ִ�.
 */