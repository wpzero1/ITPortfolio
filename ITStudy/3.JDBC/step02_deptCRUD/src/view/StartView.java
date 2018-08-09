package view;

import controller.Controller;
import model.domain.DeptDTO;

public class StartView {

	public static void main(String[] args) {
		Controller controller = Controller.getInstance(); //객체부터 받아오기. controller에 있는 메소드 막 쓸 수 있는 거임.
		
		//모든 검색
		//controller.getDeptAll();
		
		//insert
		//controller.insert(new DeptDTO(60,"교육부","역삼동"));
		//controller.insert(new DeptDTO(10,"교육부","역삼동"));
		
		//모든 검색 다시
		//controller.getDeptAll();
		
		//deptno로 검색
		//controller.getDeptInfo(30);
		
		//값 수정
		//controller.updateLoc(30, "부산");
		
		//모든 검색 다시
		//controller.getDeptAll();
		
		controller.deleteDept(10);
		
		controller.getDeptAll();
	}

}
