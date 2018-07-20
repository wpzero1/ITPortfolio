package customer.model;

import customer.domain.CustomerDTO;

public class CustomerModel {

	static CustomerDTO[] all = new CustomerDTO[5];
	static {
	all[0] = new CustomerDTO("abc", "123", "이순신", 15, "브론즈회원");
	all[1]	 = new CustomerDTO("babo","456","최맹구", 40, "골드회원");
	all[2]	= 	new CustomerDTO("guess", "789", "김명품", 35, "다이아회원");
	all[3] = new CustomerDTO("azae", "002","박아재",30, "실버회원");
	
	}
	
	public static CustomerDTO[] getAll() {
		return all;
		
	}
//가입
	//배열에 빈 null값이 있을 경우만 가입 가능하게 하기 위하여 이과정을 거침
	//경우의 수를 따지는 것.
	
 public static int addOne(CustomerDTO one) {
	 int index = all.length; //5로 시작
	 
	 for(int i=0; i<all.length;i++) {
		 if(all[i] == null) {
			 all[i] = one;
			 index = i;
			 break;
			 		 }
	 }
	 return index; //5 또는 저장된 배열 값
 }
 
 //id 값으로 정보 반환하기(getOne)
 
 public static CustomerDTO getOne(String id) {
	 CustomerDTO dto = null;
	 for(int i=0; i<all.length;i++) {
		 dto = all[i];
		 if(dto != null && dto.getId().equals(id)) {
			 break;
		 }else {
			 dto = null;
		 }
	 }
	 return dto;
 }
}
