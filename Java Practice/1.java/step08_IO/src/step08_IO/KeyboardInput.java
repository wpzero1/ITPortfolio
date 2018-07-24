/*�н�����
 * 1. �ǽð� Ű����� �Է��� �����͸� �ǽð� �ܼ�â�� ���
 * 2. ���� ���
 * 		Ű���� �Է�(System.in) -> ���� -> �ֿܼ� ���(System.out)
 * 		1) �ǽð� : �ݺ���
 * 		2) read/write �޼ҵ�
 * 		3) ������ ���� ���� ����
 * 			- String ������ ���� ���� ����
 * 			- �� ���� null
 * 			- readLine() : Line ������ read
 * 3. IO�� ���� performance�� ����� ���� API�� ����
 * 		1) �ӵ��� ���
 * 			BufferedReader / BufferedWriter (���پ�)
 * 			�ý��� ���� �ϵ���� ��� ���� �޸� ���
 * 			��� �Ŀ� �ڵ�� �ڿ� ��ȯ �ʼ�
 * 		2) �ɼ�
 * 4. �������� ���ǻ���
 * 		- ��� API�� �ݵ�� �ڿ� ��ȯ ���� �����͸� �޸𸮰� ������ ���·� �������� ����� ���� ���� ����
 * 		��? ���� �޸� ũ�⸸ŭ �����Ͱ� �������� ������ ���� �޸𸮿� �����͸� �����ϰ� �ְ� �ȴ�.
 * 		��, ���� ������ ��ŭ �����Ͱ� �����ִٸ� �ڵ� ���(autoflush),
 * 		���� ������ �ս� ������ ���� auto flush ����� �޼ҵ� �ڵ�
 */

package step08_IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class KeyboardInput {

	/*
	//step01 Ű����� �о���� ������ �ܼ� â�� ���
	public static void main(String[] args) {
		BufferedReader in //input �ǹ��ϴ� ������ in�̶�� ���� �Ἥ �������
		= new BufferedReader(new InputStreamReader(System.in)); //Ű����� 1byte�� �޾Ƶ��̴°� 2����Ʈ ������ �޾Ƶ��̴� ��Ȳ���� ������ִ� ��
		// BufferedReader �� ���ξ� �ҷ���
		try {
			String data = in.readLine();  //������ ������� �׻� �Ҿ����ؼ� �׻� try catch ó��(����) �������
			while(data != null) { //���ǹ��� �־������. �׸��� ������Ʈ�� �ʿ���(�� �о����)
				System.out.println(data); //�ܼ�â�� �Է��ϰ� ����ġ�� ���ư�
				data = in.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();  //����ߴ� �ý��� �ڿ� ��ȯ. �ٵ� ����ó��
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
*/
	
	/*//step02 : Ű���� -> data.txt ���Ϸ� ���
	public static void main(String[] args) {
		
		//read ��ü
		BufferedReader in
		= new BufferedReader(new InputStreamReader(System.in));
		
		//data.txt ���Ͽ� 2byte�� ���
		BufferedWriter out = null; //try ��� �ۿ��� ���� ����
		
		try {
			out = new BufferedWriter(new FileWriter("data.txt")); //����ٰ� �ؾ���. out���� �����ϸ� �ȵ�? �ڿ���ȯ�� �ȵȴٰ� �Ѵ�.
			//�� close�� �ȵȴٰ�. ��? ���ܰ� �߻��� �� �ִٰ� �Ѵ�.
			
			String data = in.readLine();  //������ ������� �׻� �Ҿ����ؼ� �׻� try catch ó��(����) �������
			while(data != null) { //���ǹ��� �־������. �׸��� ������Ʈ�� �ʿ���(�� �о����)
				out.write(data);
				out.newLine(); //���ο� ���� �߰�(����Ű �ݿ�). �׸��� �������� ĥ �� ���� 2�� ġ��
				data = in.readLine();
				out.flush(); //������ �ս� ������ ���ؼ� �������� ������ ��� ����
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();  //����ߴ� �ý��� �ڿ� ��ȯ. �ٵ� ����ó��
				out.close(); //out���� �߰��ؾ���
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	*/
	
	//step03 - File�� ���� read�ؼ� ���

	//split �޼ҵ带 �̿��ؼ�, data�� �ִ� �������� ������ ������ Ȯ���غ���
	
	public static void main(String[] args) {
			
			//read ��ü
			//BufferedReader in
			//= new BufferedReader(new FileReader("data.txt")); //data.txt���� ������ �����;��ϴµ�, ������ ����ó�� �ؾ���. try�������
			
			BufferedReader in = null;
			BufferedWriter out = null;
						
			try {
				in = new BufferedReader(new FileReader("data.txt"));
				out = new BufferedWriter(new FileWriter("newData.txt")); //���ο� newdata.txt�� ���
				
				String data = in.readLine();  //������ ������� �׻� �Ҿ����ؼ� �׻� try catch ó��(����) �������
				while(data != null) { //���ǹ��� �־������. �׸��� ������Ʈ�� �ʿ���(�� �о����)
					out.write(data);
					out.newLine(); //���ο� ���� �߰�(����Ű �ݿ�). �׸��� �������� ĥ �� ���� 2�� ġ��
					
					System.out.println(data); //�ܼ�â ���
					
					data = in.readLine();
					out.flush(); //������ �ս� ������ ���ؼ� �������� ������ ��� ����
				}
			
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();  //����ߴ� �ý��� �ڿ� ��ȯ. �ٵ� ����ó��
					out.close(); //out���� �߰��ؾ���
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
		}
		
}
