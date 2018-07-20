package customer.view;

import customer.domain.CustomerDTO;

public class EndView {
	
	public static void printAll(CustomerDTO[] all) {
		for(int i=0; i<all.length; i++) {
			if(all[i] != null) {
				System.out.println(all[i].toString());
			}
		}
	}
	
	public static void printOne(CustomerDTO one) {
		System.out.println(one.toString());
	}
	public static void printMsg() { //getOne에 대한 메시지
		System.out.println("요청하신 정보는 존재하지 않습니다");
	}
	
	public static void printMsg(String addmsg) { //addOne에 대한 메시지
		System.out.println(addmsg);
	}
}
