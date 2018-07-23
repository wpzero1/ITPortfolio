/* �н�����
 * 1. ����
 * 		1) Ÿ�Կ� ���� ����
 *  		 1] �⺻ Ÿ��(built-in)
 *  			- 8����, �� �ҹ���
 *  			1 ������ - byte(8bit), short(16bit), int(32), long(64)
 *  			2 �Ǽ��� - float(32), double(64)
 *  			3 ������ - char(16) �����ڵ���. 
 *  			4 ���� - boolean(8bit, �� 1bit�� ���)
 * 	    	 2] ���� Ÿ��(��üŸ��, Ŭ����Ÿ��) - ���Ѵ�
 * 				1 �⺻ Ÿ���� ������ ��� Ÿ��
 * 				2 ����Ŭ(�� sun)���� �����ϴ� Ŭ������ �������̽� Ÿ��
 * 				3 �ڹ� �����ڰ� ����� Ŭ������ �������̽� Ÿ��
 * 
 * 		2) ���� ��ġ�� ���� ����
 * 			1] ��� ����
 * 			 	1 class {} �ٷ� ������ ����� ����
 * 				2 instance ������ �޸𸮿� ��� �����ϰ� ���� �����Ǵ� ����
 * 				3 �����Ǵ� ��ġ�� heap �̶�� �޸� ����
 * 					heap���� ������ �ʴ� ��ü���� ȸ���� garbage collector(gc)���� ����
 *			2] ���� ����(stack ����, temporary, automatic)
 *				1 ������, �޼ҵ��� ()�� {} ���ο� ����Ǵ� ����
 *				2 �� �������� ��� ������? ����� �޼ҵ� ������, ����� ������ �������� ���
 *				3 �����Ǿ� ����Ǵ� �޸�
 *					stack
 *					�޼ҵ� �Ǵ� ������ ����� �޸� ���� ~ ����� �ڵ� ��ȯ(�ֹ�) 
 * 
 */


package step01.syntax;

public class Step04Variable {
		int no; 
		
		void m1(int no) {
			no = no + 1;
			this.no = no; //��������� no�� 10���� �ٲ���� (2)
		}
		int m2(int no) {
			no = no-1;
			m1(no); //��������� 9���� ������ ���� m1���� �ö� (1)
			return no;	 //������ 2�� ���� ������, ���⼭�� no�� 9�� ���� (int no�� 9�� �ٽ� �ٲ�)(3)
		}
		int m3(int no) {
			no = no+1;
			m2(no); 
			m1(no);
			return no;
			
		}
	public static void main(String[] args) {
		Step04Variable s = new Step04Variable();
		s.no = s.m2(10); // s.no = 9 (4)
		System.out.println(s.no);
		s.m3(10);
		System.out.println(s.no);

	}

}
