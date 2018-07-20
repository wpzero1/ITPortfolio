/* �н�����
 * 1. java.util.Set AIP �н�
 * 2. Set Ư¡
 * 		1) �ߺ� ������ ���� (������ �����͸� ����)
 * 		2) �����ϴ� ������ ����, �� ������ �ϳ��ϳ� ��ȯ�� ��� Iterator API Ȱ���ؾ���
 * 		3) ������ ���� ������ ���� ������ �Ұ�
 * 
 */

package step01.util;

import java.util.HashSet;
import java.util.Iterator;

public class Step02SetTest {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>(); //���� ���� ����ؼ� �� ����
		//���׸��� ��µ�...
		
		set.add("a");
		set.add("a");
		set.add("d"	);
		set.add("b"	);
		set.add("e"	);
		set.add("c"	);
		
		
		System.out.println(set.toString()); //[a, b, c, d, e] �ߺ��� �ȵ�
		
		//������ ���� ������ ����. �Է��� ������������ ���ص� ����� ������������ ����...
		/* Set ���ο� �ִ� �����͵��� �ϳ����� ��ȯ�޾� ����ϱ�
		 * 1. Iterator
		 * 		- ��� �����͵��� ������ ���� ���� �����ؼ� �ϳ��� ��밡���ϰ� ���ִ� API
		 * 		- ������ ���� Ȯ�� ���� - hasNext()
		 * 		- ������ ��� ��ȯ�ϴ� ��� - next()
		 * 2. ���� ������ ���� �غ��� (�ǻ� �ڵ�)
		 * 		1�ܰ� - HashSet ��ü�� �����͵��� Iterator�� ��ȯ
		 * 		2�ܰ� - Iterator���� ������ ���� ���� Ȯ��
		 * 				�ݺ��� �ʿ�
		 * 					for ? while? do~while?
		 * 
		 * 		3�ܰ� - ������ ���
		 * 					������ ��ȯ
		 * 				- �������� ���
		 * 					����
		 * 
		 */
		
		Iterator all = set.iterator(); //set�̶�� �ְ� iterator�� ������. import�� �ؾ���.  ������ ����. Iterator��� Ÿ���� all�� �޾��ִ� ��ü �����
		String data = null;
		while(all.hasNext()) {
			//data = all.next(); ��� �ȵ�. ����� �ȵ�. �Ʒ� ���׸� �ݿ��Ѵٸ� �����ϴ�.
			//�����ս� ���鿡�� while�ȿ��� ���� ����
			data = (String)all.next(); //��� ��. ����ȯ �����ϱ�
			System.out.println(data);
			
		}
		//���׸� �ݿ� �� ����ȯ ���� ��ü�� (element) Ȱ��
		Iterator <String> all2 = set.iterator();
		String data2 = null;
		while(all2.hasNext()) {
			data2 = all2.next();
			System.out.println(data2);
		}
	}

}
