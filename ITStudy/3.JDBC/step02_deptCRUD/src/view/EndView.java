package view;

import java.util.ArrayList;

import model.domain.DeptDTO;

public class EndView {

	public static void printAll(ArrayList<DeptDTO> datas) { //<> 제네릭을 쓰고 있어서 형변환도 필요없다. 안쓴다면 밑에 Object dto를 쓰게됨
		//jdk1.5부터 추가된 반복문 for(   :   ){}
		for(DeptDTO dto : datas) { //이러면 size고 int타입 초기화고 필요없다. 오른쪽 datas를 dto에다 넣어주는 루핑방식.
			System.out.println(dto.toString()); //toString 재정의 한 내용 호출함. 한줄로 쫙
		}
	}
	public static void printAll(DeptDTO datas) { 
			System.out.println(datas.toString()); 
		}
	
	public static void succMsg(String msg) {
		System.out.println("정상 실행 : " + msg);
	}

	public static void errorMsg(String msg) {
		System.out.println("비정상 실행 : " + msg);
	}

}
