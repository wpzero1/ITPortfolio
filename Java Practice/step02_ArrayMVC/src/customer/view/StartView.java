package customer.view;

import customer.controller.CustomerController;
import customer.domain.CustomerDTO;

public class StartView {

	public static void main(String[] args) {
		//모든 검색 - null인 경우는 절대 출력 불가여야 함.
		System.out.println("*** 모두 검색 ***");
		CustomerController.all();
		
		//검색 - id로 검색
		System.out.println("*** id로 검색 ***");
		CustomerController.getOne("tester");
		CustomerController.getOne("a");
		
		//가입 - id가 중복되면 가입불가
		System.out.println("*** 가입 ***");
		CustomerDTO newOne = new CustomerDTO("man","허윤길","77",26,"vip");
		CustomerDTO newOne2 = new CustomerDTO("aa","김한림","13",25,"일반회원");
		CustomerController.addOne(newOne);
		CustomerController.addOne(newOne2); //6번째 데이터는 저장이 안된다.
		
		//수정 - 존재하는 데이터 수정 가능, 미존재하는 데이터 수정시도?
		/* id로 등급을 수정
		 * 단, 정상 수정되었는지 아닌지에 대해서는 반드시 구분 (엔드 유저가 확인 가능해야함)
		 * 
		 */
		System.out.println("***수정***");
		
		CustomerController.updateOne("tester");
		CustomerController.all();
		
		
		//삭제 - 존재하는 데이터 삭제, 미존재하는 데이터 삭제 시도?
		System.out.println("*** 삭제 ***");
		CustomerController.deleteOne("admin");
		CustomerController.deleteOne("admin");
		CustomerController.all();
		
		
	}

}
