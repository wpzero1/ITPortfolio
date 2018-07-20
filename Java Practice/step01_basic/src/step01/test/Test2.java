/* 학습내용
 * 1. 변수의 타입
 * 		타입 변수명;
 * 2. 메소드의 타입
 * 		반환타입, argument에 선언된 변수타입
 * 		반환타입 메소드명( [타입 변수명, ...]) {}
 * 3. 타입으로 사용 가능한 타입의 수는? 무제한
 * 	1) int와 같은 기본 타입 - 8가지
 * 	2) String처럼 JDK 내부에 class로 제공해주는 타입
 * 	3) 사용자가 직접 개발하는 클래스 
 * 
 */

package step01.test;

import step01.domain.FriendVO;

public class Test2 {
	//String을 argument로 받는 메소드 구현
	void m1(String v) {}
	//String을 반환하는 메소드 구현
	String m2() {
		return "ee";
	}
			
	//FriendVO (ctrl shift O 를 누르면 import자동 추가됨)
	void m3(FriendVO v) {}
	
	public static void main(String[] args) {
	Test2 t = new Test2();
	System.out.println(t.m2()); //반드시 호출할때 소괄호까지 문법자체를 다 적어야한다
	t.m1("문자"); //String으로 선언되었으니.. 문자열을 써넣어야함
	
	t.m3(new FriendVO()); //객체를 호출해야한다. db연동시에 다이렉트로 많이 쓴다
	// 또는 변수를 따로 만드는게 가능
	FriendVO v = new FriendVO();
	t.m3(v);
	
	
	}

}
