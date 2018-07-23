/*�н�����
 * 1. ���ǽ�
 * 2. ����
 * 		1) ���� ��Ȳ�� �ϳ��� ���
 * 			if(���ǽ�){} 			1�� ����
 * 		2) ���� ��Ȳ�� �ټ��� ���
 * 			if(���ǽ�){ 			1�� ����
 * 				}else if(���ǽ�2){		0~*�� ���� ����
 * 					}else{} <- � ���ǵ� �ش� �ȵǴ� ���. �̰��� �Ұ�ȣ ����			1�� ����
 * 		3) ���� ��Ȳ���� �ƴ� ��쵵 ����ؾ��ϴ� ���
 * 			if(){}else{}
 * 
 * 
 * ����.
 * if(���ǽ�){}
 * if(���ǽ�){}
 * if(���ǽ�){}
 *  ������ if�� ��������
 *  
 *   if(���ǽ�){
 *    }else if(���ǽ�2){}
 *    }else if(���ǽ�2){}
 *    }else if(���ǽ�2){}
 *    ...
 *    
 *    if���ǽ��� true��� else if �κ��� ��� �Ѿ�Ե�
 */

package step01.syntax;

public class Step09If {
	public static char getGrade(int value) {
		char retVal = 'A'; //�⺻�� (returnValue��� �ǹ̷� ������ ������.), char�� ' ' �� ó��
		if(value >= 90) { //���ú����� �ڱⰡ ������ {} �������� �۵��Ѵ�. ���� �� char retVal������ ������ �����������.
			retVal = 'A';
		}else if(value >=80) {
			retVal = 'B';
		}else if(value>=70) {
			retVal = 'C';
			
		}else {
			retVal = 'F';
			
		}
		return retVal;
		
	}

		public static char getGrade2(String value) {
			char retVal = 'A'; //�⺻�� (returnValue��� �ǹ̷� ������ ������.), char�� ' ' �� ó��
			int value2 = Integer.parseInt(value); //string ���� int ������ �޾��ִ� ��.
			
			
			if(value2 >= 90) { //���ú����� �ڱⰡ ������ {} �������� �۵��Ѵ�. ���� �� char retVal������ ������ �����������.
				retVal = 'A';
			}else if(value2 >=80) {
				retVal = 'B';
			}else if(value2>=70) {
				retVal = 'C';
				
			}else {
				retVal = 'F';
				
			}
			return retVal;
		}
		
	public static void main(String[] args) {
		System.out.println(getGrade(91));
		System.out.println(getGrade(50));
		System.out.println(getGrade2("91"));
		System.out.println(getGrade2("50"));
		
	}

}
