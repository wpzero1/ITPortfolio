/* ��ǰ ����
 * 1. ���� ��� ���뿡 ���ؼ� 2~3���� �޼ҵ带 ����
 * 2. �ݺ�, ���� � ���� ������ �� �� �ִ� �ϳ��� lab ����
 * 3. �� ¦���� �����ϴ� ����
 */

package step01.syntax;

public class Step10MyArt {
	
	// �޼ҵ� 1
	public static String getResult(int value) {
		String retVal = "";
		
		if(value >= 90) {
			retVal = "������� �ſ� ���׿�. ����";
		}else if(value >=80) {
			retVal = "������� �׷����� �����ϴ�. ���ݸ� �� ��������";
		}else if(value>=70) {
			retVal = "���� �������׿� ���� �ѹ� �԰� ������";
		}else if(value>=60) {
			retVal = "������ �����մϴ�. �� �ѹ� ���ð� ������";
		}else if(value>=50) {
			retVal = "���� �ǰ��Ѱ�����. �ٶ� �� ������";
		}else {
			retVal = "������� �ſ� ���޴ϴ�. ���� �ڼ���.";
		}	
		return retVal;
	}
		// �޼ҵ� 2
		
		public static void forTest2(){
			
			char money = '$';
			String money2 = "";
			for(int i=1; i<=10; i++) {
				for(int t=10; t >= i; t--  ) {
					money2 = money2 + money;	
				}
					System.out.println(money2);
					money2="";
			}
		}			
		public static void forTest3() {
			
		char money ='$';
		String money2 = "";
		for(int i=1; i<=10; i++) {
			money2 = money2 + money;
			System.out.println(money2);		
				}
	}
		
	public static void main(String[] args) {
		//�� ����� ������? 0~100��
		System.out.println("����� ������ �����ϴ�," + getResult(70));
		System.out.println();
		
		//�����
		System.out.println("�� ���");
		forTest2();
		forTest3();
	}
}