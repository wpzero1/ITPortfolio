/*�н�����
 * 1. �ݺ���
 * 		1) for : �ݺ� Ƚ���� ��Ȯ�� �� �ַ� ���
 * 				���ǽ��� true�� ��츸 ����
 * 		2) while : ���� ����, �ݺ� Ƚ���� �Ҹ�Ȯ�� ��
 * 				���ǽ��� true�� ��츸 ����
 * 		3) do~while : �ݺ� Ƚ���� �Ҹ�Ȯ�� �� �ַ� ���, ������ 1�� �̻� �����ؾߵ� ���.
 * 
 */

package step01.syntax;

public class Step08Loop { //(��ü ������ �ʿ� ����. static ����)
	//for 1~5 ���	Ű������ tab�� ������ Ű���� "\t" W(��)Ű..

	/* 1~5���� �������� ������ �����ϰ� �Ǵ� ����
	 * 1 ~1 �� ������Ű�� ����
	 * �������� 5�� ���ؼ� 6�̶�� ����... �� ���ǽ�
	 * for(�ʱ��; ���ǽ�; ������){
	 * 		���ǽ��� true�� ��� ����Ǵ� ���
	 * 
	 */
	public static void forTest() {
		for(int i=1; i<=5; i++) { // i= i +1; �̰Ͱ� i++ ���� ���� ����
			System.out.print(i +"\t"); //println�� ���� ���� ���� ���ο�. print�� �̾. ��� tab ����� �־��� ��.
			}
	}
	
	public static void forTest2(){
		for(int i=1; i<=5; i++) {
			System.out.print("*" +"\t");
		}
	}
	//�ݺ��ϴ� �� ��ŭ ������ ����(����, ����)�ؼ� ���
	public static void forTest3(){
		char star = '*';
		String star2 = ""; //����! ""�� �� ��. null�̶�� �ϸ� ���������� ������, null�̶�� ���ڿ��� �ν��ع�����. 
		for(int i=1; i<=5; i++) {
			star2 = star2+star; //*, **, ***.... �̷������� �����Ͱ� ���簡 �ȴ�
			System.out.println(star2 + "-"); //���� �ݺ��ߴ��� �� �� �ְ� ���б�ȣ�� �־����� (���� �ٿ� ���ٸ�)
	
		}
	}
	
	//�̹��� �� �Ųٷ� ���
	public static void forTest4(){
		char star = '*';
		//�ټ� ������ �����ϱ� ���� �ݺ���
		for(int lineCount=1; lineCount <=5; lineCount++) { //lineCount�� �����ϻ�. �̸��� �ٲ㵵 �ȴ�.
			//�� ���ο��� ���� ��� ���� ���� �ݺ���
			for(int starCount=5; starCount >= lineCount; starCount--) {
				System.out.print(star);
			
			} //���� for�� ����. ���� for���� ������ false�� ������ ���� ������ ������.
			System.out.println();
			}//�ٱ��� for�� ����
		}			
	
	public static void forTest5(){ //test 3�� 4�� «���� ��
		char star = '*';
		String star2 = "";
		
		for(int lineCount=1; lineCount <=5; lineCount++) { 
			
			//*->**->***->****->*****
			//*->**->***->****
			//*->**->***
			//*->**
			//*
			//����� �Ẹ��, �����ض�.
			
			for(int starCount=5; starCount >= lineCount; starCount--) { 
				star2 = star2 + star; //����. �� �κ��� ������ �ݴ��.
			}
				System.out.println(star2);
			star2="";  //�� ������ ���� �߿��ϴ�. �ʱ�ȭ ������
						} 
			//System.out.println(); �� �κ��� ����
		
	}
	//while
	
	public static void whileTest() { //�޼ҵ� ���ο� ���� ������.
		int no = 1; //�ʱ��
	while(no<6) { //���ǽ�
		System.out.println(no + "\t");
		no = no + 1; //������ (�Ǵ� no++; �� ǥ�� ����). ������ ���ѷ���
		}
	}
	
		//do_while
	
	public static void doWhileTest() { //�޼ҵ� ���ο� ���� ������. ��Ÿü�� ����ؼ� �̷���..�߰� �빮�� ������
		int no = 1; //�ʱ��
	do{
		System.out.println(no + "\t"); //���� ���� �� ���
		no = no + 1; //������
		}while(no<6); //���� ������ ���߿�
	
	}
	
	

	public static void main(String[] args) {
		
		//step01- for
		Step08Loop.forTest();
		System.out.println("\n--- 2. * ���"); //\n : ���ο� ���ο� ����
		forTest2();
		System.out.println("\n--- 3. * �������");
		forTest3();
		System.out.println("\n--- 4. * �Ųٷ����");
		forTest4();
		System.out.println("\n--- 5. * �Ųٷ����2");
		forTest5();
	
		
		
		
	}

}
