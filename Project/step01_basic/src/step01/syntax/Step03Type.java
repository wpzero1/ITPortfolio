package step01.syntax;

import step01.domain.FriendVO;

public class Step03Type {

	//FriendVO 반환 메소드
	FriendVO getInstance() { //이거 적고 ctrl shift O하면 임포트 자동으로 됨
		return new FriendVO(); //바로 객체 생성하는 반환
	}
	//FriendVO 를 메소드 parameter(소괄호)로 반영하는 메소드
	void m(FriendVO v) { //a.m(FriendVO 객체) 메소드를 가져온다는 얘기 .  FriendVO 객체는 1개다
		System.out.println(2 + "" + v.name); //황인범
		v.name = "손영정"; //이거로 변수가 바뀜
		
	}
	/*
	void m() {} //a.m();
	void m(int i) {} //a.m(2);
	void m(String i) {} //a.m(String "wew");
	*/
	
	public static void main(String[] args) {
		Step03Type s = new Step03Type();
		FriendVO v = s.getInstance(); //위치값이 0x라 가정
		System.out.println(1+ "" + v.name);
		s.m(v); //0x 메소드 호출했음
		System.out.println(3+ "" + v.name); //이 값은 누가 출력될까?
		
	}
	
	}

