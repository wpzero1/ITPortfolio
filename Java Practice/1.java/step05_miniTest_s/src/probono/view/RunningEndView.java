package probono.view;

import probono.model.dto.ProbonoProject;

public class RunningEndView {
	
	//Ư�� ������Ʈ ��� 
	public static void projectView(ProbonoProject project){
		System.out.println(project);		
	}
	
	//��� ������Ʈ ���
	public static void projectListView(ProbonoProject [] allProbonoProject){
		for(int index = 0; index < allProbonoProject.length; index++){			
			if(allProbonoProject[index] != null){
				System.out.println("[������Ʈ " + (index+1) + "]\n" + allProbonoProject[index]);
			}
		}
	}
}
