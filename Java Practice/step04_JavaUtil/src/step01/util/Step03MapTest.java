/*�н� ����
 * 1. ������ key�� value�����ؼ� ���� �� Ȱ��
 * 2. ���ǻ���
 * 		1) key�� ���� �ߺ� ����
 * 		2) listó�� index ��ü�� ������
 * 		3) �����ϰ��� �ϴ� ���׸�(Ÿ�� ����) ����
 * 3. �ǽ� �ܰ�
 * 		1) �ܼ� ���ڿ� ����
 * 		2) PeopleDTO ����
 * 		3) ProbonoProject ����
 * 		4) ProbonoProject���� ����� ArrayList�� ����
 * 
 */

package step01.util;

import java.util.ArrayList;
import java.util.HashMap; //����Ʈ ����! 
import java.util.Iterator;
import java.util.Set;

import probono.model.dto.Activist;
import probono.model.dto.Probono;
import probono.model.dto.ProbonoProject;
import probono.model.dto.Recipient;

public class Step03MapTest {
	
	public static void m1() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("one","����"); //������ put
		map.put("one","�Ѹ�"); //�ߺ��ȰŴ� �������� ������ ����
		map.put("a","����");
		map.put("b","�Ѹ�");
		map.put("c","����");
		map.put("d","�Ѹ�");
		
		
		System.out.println(map); //������ ���Ŀ��� map.toString()
		System.out.println(map.get("one")); //get�� ������ ��ȯ
		map.remove("one"); //������ �̷���
		System.out.println(map.get("one")); //API ����Ʈ �����ؼ� �����ϴ°� ã�ƺ���
		
		/* ������ �����ڿ� ������ Ȱ���ڴ� �ٸ�
		 * �����ڴ� HashMap��ȯ, �� ��� key�� �ִ��� ���� ��� ���� ��ȯ
		 * �޾Ƽ� ����ϴ� Ȱ���ڴ� ���� key�� ����
		 * ��, API �޼ҵ�� key Ȯ�� ����
		 * (hint) ��, key�� set ������ ���� 
		 */
		
		Set keys = map.keySet(); //keySet API ����. ����Ʈ
		System.out.println(keys);
		
		Iterator allKey = keys.iterator(); //�ϳ��ϳ� ������ ��������? //���׸� �����ϸ� Iterator <String> all key = keys.iterator();
		String k = null;
		while(allKey.hasNext()) {
			k = (String) allKey.next(); //���׸� �����ϸ� (String) ����ȯ ���ص� ��
			System.out.println(k + " " + map.get(k));
		}
	}
	
	public static void m2() {
		HashMap<String, PeopleDTO> all = new HashMap <String, PeopleDTO>();
		all.put("a", new PeopleDTO("����", 25)); //���ڿ� ������ �ƴ϶� new PeopleDTO�� �־���
		all.put("b", new PeopleDTO("�泲", 28));
		
		//�泲�� �̸��� ��µǰ� ���ּ���. - b�� ���εǾ�����
		
		PeopleDTO man = all.get("b");
		String name = man.getName();
		System.out.println(name);
		
		System.out.println(all.get("b").getName());
	}
		
		//ProbonoProject ��ü�� ArrayList<E>�� 
		
		public static void m3() {
			ArrayList<ProbonoProject> all = new ArrayList <ProbonoProject>(); //all�� ArrayList.
			//�����
			Activist audrey = new Activist("giver", "���帮", "pw1", "�̿�");
			//������
			Recipient receive = new Recipient("receivePeople", "����ȭ", "pw2", "�����������");
			//��� ��� ����
			Probono audreyHepbun 
				= new Probono("audreyHepbun", "���巹�ݹ� ������Ʈ", "������, ��ȭ���� ���α׷� ����, ���ä����� �� ��ȸ����, �̿�,ȯ�� ķ���� �� ��ȭ���������� �о�");
			//��� ��� ������Ʈ
			ProbonoProject audreyHepbunProject 
			= new ProbonoProject("���帮�ݹ� ������Ʈ", audreyHepbun, audrey, receive, "���̿�о�");
			
			
			
			//�����
			Activist audrey2 = new Activist("giver2", "���帮", "pw1", "�Ǻΰ���");
			//������
			Recipient receive2 = new Recipient("receivePeople2", "����ȭ", "pw2", "�����������");
			//��� ��� ����
			Probono audreyHepbun2 
				= new Probono("������ó", "������ó ������Ʈ", "������, ��ȭ���� ���α׷� ����, ���ä����� �� ��ȸ����, �̿�,ȯ�� ķ���� �� ��ȭ���������� �о�");
			//��� ��� ������Ʈ
			ProbonoProject audreyHepbunProject2
			= new ProbonoProject("������ó ������Ʈ", audreyHepbun2, audrey2, receive2, "���̿�о�");
			
			all.add(audreyHepbunProject);
			all.add(audreyHepbunProject2);
			
			 //HashMap���� ArrayList ��ȯ, 	����� �̸��� ���, ����Ǵ� ������Ʈ �̸��� ���
			 
			HashMap<String, ArrayList> allProject = new HashMap<String, ArrayList>();
			allProject.put("project1", all); //��ü�� ��ü�� �����ִ� ���԰���. ���� ArrayList�� ���� �ִµ�...
						
			ArrayList datas = allProject.get("project1");
			int count = datas.size();
			ProbonoProject project3 = null;
			//ArrayList�� ����� ProbonoProject �� ��ŭ �ݺ��ϸ鼭 ������� Activist ��ȯ, ����� ��ü�� getName()ȣ�� ��� ���
				for(int i=0 ; i<count; i++) {
					project3 = (ProbonoProject)datas.get(i);
								
					System.out.println(project3.getActivist().getName());
				}
		}
				
				
				
				//ArrayList��ü�� ���׸����� �޾ƿ��� ��� -> �������� ����. ����ȯ �ʿ� ����
			/*	
				HashMap<String, ArrayList<ProbonoProject>> allProject = new HashMap<>();
				allProject.put("Project1", all);
				
				ArrayList<ProbonoProject> datas = allProject.get("project1");
				int count = datas.size();
				for(int i=0 ; i<count; i++) {
							
					System.out.println(datas.get(i).getActivist().getName());
			*/
				
				
				
				
				
		
			
			//�̸� ȣ���ϱ�
				
			/*ProbonoProject project = all.get(0);
			
			Activist person = project.getActivist();
			String name = person.getName();
			System.out.println(name);
			
			System.out.println(all.get(0).getActivist().getName()); //���ٷ� ���̴� ���� �캯�� �� ���캸�� �ȴ�.
			
			ProbonoProject project2 = all.get(1);
			Activist person2 = project2.getActivist();
			String name2 = person2.getName();
			System.out.println(name2);
			
			System.out.println(all.get(1).getActivist().getName());
			*/
	
	
		
		
		
	
	public static void main(String[] args) {
		m1();
		m2();
		m3();
	}

}
