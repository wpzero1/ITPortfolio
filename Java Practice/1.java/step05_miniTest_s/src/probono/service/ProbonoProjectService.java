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

import probono.model.dto.Activist;
import probono.model.dto.People;
import probono.model.dto.ProbonoProject;
import probono.model.dto.Recipient;

public class ProbonoProjectService {
	
	private static ProbonoProjectService instance = new ProbonoProjectService();
	
	private ProbonoProject[] projectList = new ProbonoProject[10];
	private int index;

	private ProbonoProjectService(){}
	
	public static ProbonoProjectService getInstance(){ //�̰� �̱��� ������ ����
		// if(instance ==null) { //�� �� ���� ������ ��ü�� �ܺ� Ŭ�������� ����ϰ� �ϴ� ���, ������������ �����ս��� �������ٰ�.
		//	instance = new ProbonoProjectService();
		return instance;
	}
	
	//��� Project ��ȯ
	public ProbonoProject[] getAllProjects() {
		return projectList;
	}

	//Project �˻�
	public ProbonoProject getProbonoProject(String projectName) {
		ProbonoProject project = null;
		for (int i = 0; i < index; i++) {
			if (projectList[i].getProbonoProjectName().equals(projectName)) {
				project = projectList[i];
				break;
			}
		}
		return project;
	}

	//Project �߰�
	public void projectInsert(ProbonoProject project) {
		projectList[index++] = project;
	}
	
	
	//??? ������ ���� �޼ҵ�� Ȯ���ϱ�
	//instanceof - ��ü Ÿ�� �� ������ Ȱ��
	//Project ���� - ������Ʈ ������ ��� ����� ���� 
	// -> ��θ� �� ���󰡰� �ľ��� ��. Model ��Ʈ�� ������ ����ִٰ� ���� �ȴ�. ���� Ŭ����. ���⼱ Controller�� ���� ����
	public void projectUpdate(String projectName, People people){
		for (int i =0; i<index; i++) {
			if (projectList[i].getProbonoProjectName().equals(projectName)) {
				if(people instanceof Activist) {
					Activist a = (Activist)people;
					projectList[i].setActivist(a);
					break;
				}
				else if(people instanceof Recipient) {
					Recipient r = (Recipient)people;
					projectList[i].setReceive(r);
					
			}

		}
		}
	}
	
	
	
	 //Project ���� - ������Ʈ������ �ش� ������Ʈ ����
	public void projectDelete(String projectName) {
		for (int i = 0; i < index; i++) {
			if (projectList[i].getProbonoProjectName().equals(projectName)) {
				projectList[i] = null;
				break;
			}
		}
	}
	
	//Project ����
	public int projectListSize(){
		return index;
	}
}
