package step01.test;

public class Test { //코드의 순서는 크게 중요하지 않다. 가독성을 위한 것
	String message; //변수
	int age; //변수
		
	public Test() {} //생성자 (단 객체도 없고 메모리도 없는 기본문법구성)
	public Test(String m, int a) { //가변적인 데이터에 대한 생성자
		message = m; //멤버변수를 초기화시킴
		age = a;	
	}
	//객체 생성 없이 message, age 사용 가능한 방법은? 현재로선 없다.
	//사용가능한 객체는 instance
	//메인메소드 호출은 우리 코드가 아니라 자바 실행환경이 직접 해준다.
	
		public static void main(String[] args) {
	Test t = new Test("오늘은 비가 오네요", 46);
	System.out.println(t.message); //test 객체가 참조하는 메세지 변수값
	System.out.println(t.age); 
	

	
	/*
	 * 실행되는 순서
	 * Test t 1번
	 * new Test (~) 2번
	 * public test(String m, int a) { ~ 3번
	 * }
	 * 이게 끝나면 Test t = new Test (~) 4번 이거로 다시 옴.
	 * 각 단계는 ;에 의해서 완벽하게 끝나야 넘어간다.
	 */
	
	}

}
/* 
* 1. 컴파일 직후 자동 추가되는 코드는?
*	public Test() {}
* 2. "오늘은 비가 오네요" 라는 데이터를 저장할 수 있는 변수를 선언하기(message)
* 3. 46 숫자값 저장 가능한 변수 선언(age)
* 4. 객체 생성 시점에 가변적인 데이터로 변수값 저장 할 수 있는 
* 	 parameter(argument,매개변수)가 있는 생성자 만들기
* 5. 오늘은 비가 오네요, 46 이라는 데이터로 객체생성 후 변수들 값 출력
* 	(힌트 : 객체 생성 문법은 단 하나임.) 타입변수명 = new 생성자호출(..);
*/