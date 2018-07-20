package customer.view;

import customer.controller.CustomerController;

public class StartView {

	public static void main(String[] args) {

		System.out.println("*모두검색*");
		CustomerController.all();
		
		System.out.println("*ID로 검색*");
		CustomerController.getOne("guess");
		CustomerController.getOne("a");
	}

}
