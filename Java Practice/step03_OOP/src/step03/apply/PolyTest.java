//������ �ͼ�������
package step03.apply; 

public class PolyTest extends Object {

	
	public PolyTest() {
		super();
		//�ΰ��� object �޼ҵ尡 �ʿ��ϴ�. tostring, equals
	}
	//���ڿ� ��ü ������ Object(�ֻ���) Ÿ������ ��ȯ
	//Object ���� = "���ڿ�" ; (�ڵ� ����ȯ�� ��)
	
	public static Object getData() {
		return "���ڿ�"; //String ��ü �����Ǿ� -> ��ȯ
	}
	
	public static void main(String[] args) {
		String data = (String)getData(); //(String)�� �տ� �Ἥ ����ȯ��������Ѵ�. �ؿ� ���� ���� data ������ String�̾�߸� �ϴϱ�. 
		System.out.println(data.charAt(0));
		
		System.out.println(( (String)getData() ).charAt(0));
		//���� ������ (String)getData()�� ���� �Ǿ���ؼ�, �Ұ�ȣ�� ���� ���۵Ǵ� ���� ���ְ� charAt ����
		//getData()�� Object�� �����ְ�, charAt(String���� �� �ձ��� ������ ��) API�� ������.
		
		

	}

}
