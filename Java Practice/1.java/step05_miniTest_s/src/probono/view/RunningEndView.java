package probono.view;

import probono.model.dto.ProbonoProject;

public class RunningEndView {
	
	//특정 프로젝트 출력 
	public static void projectView(ProbonoProject project){
		System.out.println(project);		
	}
	
	//모든 프로젝트 출력
	public static void projectListView(ProbonoProject [] allProbonoProject){
		for(int index = 0; index < allProbonoProject.length; index++){			
			if(allProbonoProject[index] != null){
				System.out.println("[프로젝트 " + (index+1) + "]\n" + allProbonoProject[index]);
			}
		}
	}
}
