package customer.controller;

import customer.domain.CustomerDTO;
import customer.model.CustomerModel;
import customer.view.EndView;

public class CustomerController { //Controller는 결과를 모델, EndView에 주는 것. 모든 메소드는 반환값이 없는 void다. (출력 위주)
	//모든 검색
	public static void all() {
		EndView.printAll(CustomerModel.getAll()); //printAll에 출력하게 시킴.
		
		//CustomerDTO[] all = CustomerModel.getAll();
		//EndView.printAll(all);
		//위 두 줄을 정리한게 EndView.printAll(CustomerModel.getAll());
	}
	
	//grade로 해당 등급들만 검색
	
	// id로 해당 고객 정보만 검색
	/* Model의 getOne()의 반환값
	 *  - CustomerDTO or null
	 *   - EndView에게 출력을 위임할 때 이 두가지 데이터를 어떻게 출력 요청?
	 *   개발 방법의 경우의 수
	 *   1. 경우의 수 1
	 *    - EndView의 메소드에 무조건 출력 위임
	 *			: EndView는 null 여부 검증
	 *	  2. 경우의 수 2 -> 이거로 진행할거임
	 *		- Controller에서 null 검증
	 *		- null인 경우 다른 출력 메소드 호출, null 아닌 경우 또다른 메소드 호출
	 *
	 */
	
	public static void getOne(String id) {
		CustomerDTO one = CustomerModel.getOne(id);
		if(one != null) { //검색된 데이터 존재하는 경우 true
			EndView.printOne(one);
		  } else {
			  EndView.printMsg(); //이 메소드가 존재하지 않을때는, 오류를 따라가서 더블클릭하면 EndView에 만들어진다.
		  }
	}
	
	//가입
	public static void addOne(CustomerDTO newDTO) {
		int result = CustomerModel.addOne(newDTO);
		if(result != 5) {
			EndView.printMsg("회원가입 완료");
		}else {
			EndView.printMsg("회원가입 실패. 고객님 영역 점유는 불가입니다");
		}
	}
	
	//수정 - id를 기준으로 grade 수정
	public static void updateOne(String id) {
		boolean result = CustomerModel.updateOne(id);
		if(result) {
			
			EndView.printMsg(id + " 님의 등급이 " + CustomerModel.getOne(id).getGrade() + "등급으로 변경되었습니다");
		}
		else {
			EndView.printMsg(id + " 님의 등급 변경에 실패하였습니다");
			}
		}

	
	//삭제 - id
	public static void deleteOne(String id) {
		boolean result = CustomerModel.deleteOne(id);
		if(result) {
			EndView.printMsg(id+" 회원님 삭제 성공");
		}else {
			EndView.printMsg("삭제 실패");
		}
	}
	
	//

}

