package probono.view;

import java.util.ArrayList;

import probono.model.dto.ProbonoProject;

public class RunningEndView {
	
	//Ư�� ������Ʈ ��� 
	public static void projectView(ProbonoProject project){
		System.out.println(project);		
	}
	
	//��� ������Ʈ ���
	public static void projectListView(ArrayList<ProbonoProject> allProbonoProject){
		for(int index = 0; index < allProbonoProject.size(); index++){			
			if(allProbonoProject.get(index) != null){
				System.out.println("[������Ʈ " + (index+1) + "]\n" + allProbonoProject.get(index));
			}
		}
	}
}
