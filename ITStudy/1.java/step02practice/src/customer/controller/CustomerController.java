package customer.controller;

import customer.domain.CustomerDTO;
import customer.model.CustomerModel;
import customer.view.EndView;

public class CustomerController {

	public static void all() {
		EndView.printAll(CustomerModel.getAll());
	}
	
	public static void getOne(String id) {
		CustomerDTO one = CustomerModel.getOne(id);
			if(one !=null) {
				EndView.printOne(one);
			} else {
				EndView.printMsg();
			}
	}
	
	public static void addOne(CustomerDTO newDTO) {
		int result = CustomerModel.addOne(newDTO);
			if(result != 5) {
				//성공
				EndView.printMsg("회원가입 성공");
			} else {
				EndView.printMsg("회원가입 실패. 메모리가 가득찼습니다");
			}
		}
	}
