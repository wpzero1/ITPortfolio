/*1. ���� ���ο� �� ��ü ���� �ϳ��� ���������� �����ϴ� ����
 *2. Singleton Design Pattern(�̱��� ������ ����)
 *		1) ��ü ���� ������ �ϳ�
 *		2) ���� ����
 *			1] �����ڴ� �ܺ� Ŭ�������� ����
 *			    private ������([..]){[..]}
 *			2] ������ Ŭ���� ������ ������ ȣ��
 *				��ü ����
 *			3] ������ ��ü�� �ܺ� Ŭ�������� ����ϰ� �Ϸ���?
 *				������ ��ü�� �ּҰ� ��ȯ
 *				�� ����� �޼ҵ�� public
 *				�� �޼ҵ� ȣ�� ������ �ܺ� Ŭ�������� ��ü �������� ȣ�� ���� �޼ҵ�� static(��𿡼��� ȣ�� �����ؾ���)
 */

package probono.service;

import java.util.ArrayList;

import probono.model.dto.Activist;
import probono.model.dto.People;
import probono.model.dto.ProbonoProject;
import probono.model.dto.Recipient;

public class ProbonoProjectService {
	
	private static ProbonoProjectService instance = new ProbonoProjectService();
	
//	private ProbonoProject[] projectList = new ProbonoProject[10];
	ArrayList<ProbonoProject> projectList
	= new ArrayList<ProbonoProject>(); //�ʿ伺 ���� Ȯ��
	
	//private int index;

	private ProbonoProjectService(){}
	
	public static ProbonoProjectService getInstance(){ //�̰� �̱��� ������ ����
		// if(instance ==null) { //�� �� ���� ������ ��ü�� �ܺ� Ŭ�������� ����ϰ� �ϴ� ���, ������������ �����ս��� �������ٰ�.
		//	instance = new ProbonoProjectService();
		return instance;
	}
	
	//��� Project ��ȯ
	public ArrayList<ProbonoProject> getAllProjects() {
		return projectList;
	}

	//Project �˻�
	public ProbonoProject getProbonoProject(String projectName) {
		ProbonoProject project = null;
		for (int i = 0; i < projectList.size(); i++) {
			if (projectList.get(i).getProbonoProjectName().equals(projectName)) {
				project = projectList.get(i);
				break;
			}
		}
		return project;
	}

	//Project �߰�
	public void projectInsert(ProbonoProject project) {
		projectList.add(project);
	}
	
	//??? ������ ���� �޼ҵ�� Ȯ���ϱ�
	//instanceof - ��ü Ÿ�� �� ������ Ȱ��
	//Project ���� - ������Ʈ ������ ��� ����� ���� 
	// -> ��θ� �� ���󰡰� �ľ��� ��. Model ��Ʈ�� ������ ����ִٰ� ���� �ȴ�. ���� Ŭ����. ���⼱ Controller�� ���� ����
	public void projectUpdate(String projectName, People people){
		for (int i =0; i<projectList.size(); i++) {
			if (projectList.get(i).getProbonoProjectName().equals(projectName)) {
				if(people instanceof Activist) {
					Activist a = (Activist)people;
					projectList.get(i).setActivist(a);
					break;
				}
				else if(people instanceof Recipient) {
					Recipient r = (Recipient)people;
					projectList.get(i).setReceive(r);
					
			}

		}
		}
	}
	
	
	
	 //Project ���� - ������Ʈ������ �ش� ������Ʈ ����
	//�ֽô��� index �����ؼ� ������
	
	public void projectDelete(String projectName) { //�����Ͱ��� ��ȯ size()ȣ��
		for (int i = 0; i < projectList.size(); i++) { //int count = projectList.size(); count�� �� ȿ������. �ִ� ���� count�ϴ°� �� ����.
			if (projectList.get(i).getProbonoProjectName().equals(projectName)) {
				projectList= null; //ArrayList�� �޼ҵ�� ���� ���� projectList.remove(i);
				break;
			}
		}
	}
	 //������ ���� ���� ��� ���� ��� �޼ҵ� ȣ���� �����ս��� �� ������. �׷��� ������ �ٲ��ִ� ���� �� ����
	//�޼ҵ� ȣ�� �� ��ɸ� ���⺸�ٴ� ���� performance�� ���. Ʃ���� �ϴ� ����� �� �߿��ϴ�.
	public void projectDelete2(String projectName) {
		int count = projectList.size();
		for (int i = 0; i < count; i++) {
			if (projectList.get(i).getProbonoProjectName().equals(projectName)) {
				projectList.remove(i); //
				break;
			}
		}
	}
	
	
	
	//Project ����
	public int projectListSize(){
		return projectList.size();
	}
}
