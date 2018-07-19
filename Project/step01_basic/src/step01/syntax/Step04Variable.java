/* 학습내용
 * 1. 변수
 * 		1) 타입에 따른 구분
 *  		 1] 기본 타입(built-in)
 *  			- 8가지, 다 소문자
 *  			1 정수형 - byte(8bit), short(16bit), int(32), long(64)
 *  			2 실수형 - float(32), double(64)
 *  			3 문자형 - char(16) 유니코드임. 
 *  			4 논리형 - boolean(8bit, 단 1bit만 사용)
 * 	    	 2] 참조 타입(객체타입, 클래스타입) - 무한대
 * 				1 기본 타입을 제외한 모든 타입
 * 				2 오라클(구 sun)에서 제공하는 클래스와 인터페이스 타입
 * 				3 자바 개발자가 만드는 클래스와 인터페이스 타입
 * 
 * 		2) 선언 위치에 따른 구분
 * 			1] 멤버 변수
 * 			 	1 class {} 바로 하위에 선언된 변수
 * 				2 instance 생성시 메모리에 사용 가능하게 실제 생성되는 변수
 * 				3 생성되는 위치는 heap 이라는 메모리 공간
 * 					heap에서 사용되지 않는 객체들의 회수는 garbage collector(gc)에서 수행
 *			2] 로컬 변수(stack 변수, temporary, automatic)
 *				1 생성자, 메소드의 ()와 {} 내부에 선언되는 변수
 *				2 이 변수들의 사용 영역은? 선언된 메소드 내에서, 선언된 생성자 내에서만 사용
 *				3 생성되어 저장되는 메모리
 *					stack
 *					메소드 또는 생성자 실행시 메모리 점유 ~ 종료시 자동 반환(휘발) 
 * 
 */


package step01.syntax;

public class Step04Variable {
		int no; 
		
		void m1(int no) {
			no = no + 1;
			this.no = no; //멤버변수인 no가 10으로 바뀌었다 (2)
		}
		int m2(int no) {
			no = no-1;
			m1(no); //여기까지는 9값이 나오고 위에 m1으로 올라감 (1)
			return no;	 //하지만 2번 과정 다음에, 여기서는 no가 9라서 리턴 (int no가 9로 다시 바뀜)(3)
		}
		int m3(int no) {
			no = no+1;
			m2(no); 
			m1(no);
			return no;
			
		}
	public static void main(String[] args) {
		Step04Variable s = new Step04Variable();
		s.no = s.m2(10); // s.no = 9 (4)
		System.out.println(s.no);
		s.m3(10);
		System.out.println(s.no);

	}

}
