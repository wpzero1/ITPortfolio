package customer.view;

import customer.domain.CustomerDTO;

public class EndView {
	//모든 고객 정보 출력
	public static void printAll(CustomerDTO[] all) { //근데 5개의 데이터가 다 있는게 아니라서, null값 존재.(하면 안되는데)
		for(int i=0; i < all.length; i++) {
			
			if (all[i] != null) { //중간 데이터가 없어지면 null값이 생기기 때문에 경우의 수를 체크해야함 != : 같지 않다
			System.out.println(all[i].toString());
			}
			
		}
	}
	
	//데이터 null인 경우 단순 메시지 출력
	
	//데이터가 CustomerDTO인 경우 해당 데이터 내용 출력
	public static void printOne(CustomerDTO one) {
		System.out.println(one.toString());
		
	}

	public static void printMsg() {
		System.out.println("요청하신 정보가 미 존재합니다");
	}

	public static void printMsg(String msg) {
		System.out.println(msg);
	}
}
