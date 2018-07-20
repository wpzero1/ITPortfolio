package probono.view;

import java.util.ArrayList;

import probono.model.dto.Activist;
import probono.model.dto.Probono;
import probono.model.dto.ProbonoProject;
import probono.model.dto.Recipient;
import probono.service.ProbonoProjectService;

public class RunningStartView {
	
	public static void main(String[] args) {
		
		//기부자
		Activist audrey = new Activist("giver", "오드리", "pw1", "미용");
		//수혜자
		Recipient receive = new Recipient("receivePeople", "나문화", "pw2", "무상컷팅희망");
		//재능 기부 내용
		Probono audreyHepbun 
			= new Probono("audreyHepbun", "오드레햅번 프로젝트", "예술가, 문화관련 프로그램 제공, 전시ㆍ관람 등 기회제공, 미용,환경 캠페인 등 문화ㆍ예술관련 분야");
		//재능 기부 프로젝트
		ProbonoProject audreyHepbunPorject 
		= new ProbonoProject("오드리햅버 프로젝트", audreyHepbun, audrey, receive, "헤어미용분야");
			
		
		ProbonoProjectService service = ProbonoProjectService.getInstance();
		
		System.out.println("***** Project 생성 후 모든 Project 검색 *****");
		service.projectInsert(audreyHepbunPorject);
		ArrayList<ProbonoProject> allProbonoProject = service.getAllProjects();		
		RunningEndView.projectListView(allProbonoProject);	
	
		
		System.out.println("\n***** 기부자 수정 후 해당 Project 검색 *****");
		//새로운 기부자로 해당 project 변경
		Activist newAudrey = new Activist("newGiver", "나미용", "newPw3", "무상파마지원");
		service.projectUpdate("오드리햅버 프로젝트", newAudrey);		
		ProbonoProject project = service.getProbonoProject("오드리햅버 프로젝트");
		RunningEndView.projectView(project);
		

		System.out.println("\n***** 수혜자 수정 후 해당 Project 검색 *****");
		//새로운 수혜자로 해당 Project 변경
		Recipient newReceive = new Recipient("newReceivePeople", "나필요", "newPw4", "무상파마지원받길원함");
		service.projectUpdate("오드리햅버 프로젝트", newReceive);		
		ProbonoProject project2 = service.getProbonoProject("오드리햅버 프로젝트");
		RunningEndView.projectView(project2);
		
	}
}





