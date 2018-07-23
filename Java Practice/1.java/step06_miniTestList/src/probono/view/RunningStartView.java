package probono.view;

import java.util.ArrayList;

import probono.model.dto.Activist;
import probono.model.dto.Probono;
import probono.model.dto.ProbonoProject;
import probono.model.dto.Recipient;
import probono.service.ProbonoProjectService;

public class RunningStartView {
	
	public static void main(String[] args) {
		
		//�����
		Activist audrey = new Activist("giver", "���帮", "pw1", "�̿�");
		//������
		Recipient receive = new Recipient("receivePeople", "����ȭ", "pw2", "�����������");
		//��� ��� ����
		Probono audreyHepbun 
			= new Probono("audreyHepbun", "���巹�ݹ� ������Ʈ", "������, ��ȭ���� ���α׷� ����, ���ä����� �� ��ȸ����, �̿�,ȯ�� ķ���� �� ��ȭ���������� �о�");
		//��� ��� ������Ʈ
		ProbonoProject audreyHepbunPorject 
		= new ProbonoProject("���帮�ݹ� ������Ʈ", audreyHepbun, audrey, receive, "���̿�о�");
			
		
		ProbonoProjectService service = ProbonoProjectService.getInstance();
		
		System.out.println("***** Project ���� �� ��� Project �˻� *****");
		service.projectInsert(audreyHepbunPorject);
		ArrayList<ProbonoProject> allProbonoProject = service.getAllProjects();		
		RunningEndView.projectListView(allProbonoProject);	
	
		
		System.out.println("\n***** ����� ���� �� �ش� Project �˻� *****");
		//���ο� ����ڷ� �ش� project ����
		Activist newAudrey = new Activist("newGiver", "���̿�", "newPw3", "�����ĸ�����");
		service.projectUpdate("���帮�ݹ� ������Ʈ", newAudrey);		
		ProbonoProject project = service.getProbonoProject("���帮�ݹ� ������Ʈ");
		RunningEndView.projectView(project);
		

		System.out.println("\n***** ������ ���� �� �ش� Project �˻� *****");
		//���ο� �����ڷ� �ش� Project ����
		Recipient newReceive = new Recipient("newReceivePeople", "���ʿ�", "newPw4", "�����ĸ������ޱ����");
		service.projectUpdate("���帮�ݹ� ������Ʈ", newReceive);		
		ProbonoProject project2 = service.getProbonoProject("���帮�ݹ� ������Ʈ");
		RunningEndView.projectView(project2);
		
	}
}





