package customer.view;

import customer.controller.CustomerController;

public class StartView {

	public static void main(String[] args) {

		System.out.println("*��ΰ˻�*");
		CustomerController.all();
		
		System.out.println("*ID�� �˻�*");
		CustomerController.getOne("guess");
		CustomerController.getOne("a");
	}

}
