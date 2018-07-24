/*학습내용
 * 1. static 키워드
 * 2. 적용 문법
 * 		1) 멤버 변수 선언구
 * 			- 생성되는 모든 객체들이 공유하는 변수 (heap에 저장)
 * 				: 공유자원이 아닌 변수들에 사용 금지(특히 개인정보들)
 * 			- static 변수가 메모리에 실제 사용 가능하게 생성되는 시점은?
 * 
 * 		2) 메소드 선언구
 *  - 객체 생성 없이 클래스명만으로 메소드 호출 가능
 *  
 * 		3) static{} 
 * 			- web server가 시작될 때 모든 user가 공유하는 자원이 있다면 단 한번 실행 보장을 할 수 있는 문법
 * 				이름이 없음 따라서 코드로 호출 불가
 * 			- byte code가 메모리에 로딩될 때 자동 실행
 */
 package step01.syntax;

public class Step06static {

	//step 02 - static 변수 (객체 생성 필요없음) - 자원 공유할 필요가 있을 때
	
	static int no = 100;
	static String msg = "문자열";
	
	//instance 변수 - 객체 생성 필요함. byte 코드 저장만 해놓고, 이제 나중에 main에서 호출할거다.
	int no2 = 200;
	String msg2 = "문자열2";
	
	
	void m1() {
		System.out.println("일반 메소드");
	}
	//객체 생성 없이도 class명.m2() 또는 동일한 클래스라면 m2(); 호출 가능
	static void m2() {
		System.out.println("static 메소드");
			
		}
	//>java Step06static		Step06static.main();  static에서는 객체생성없이 클래스명으로 호출 가능하다
	public static void main(String[] args) {
		m2(); //동일한 클래스 내에서 호출
		Step06static.m2(); //class명.m2() 호출
		
		
		System.out.println(no);
		System.out.println(msg);
		
		Step06static s = new Step06static(); // 객체 생성
		System.out.println(s.no2);
		System.out.println(s.msg2);
		
		System.out.println(Math.random());
		
		/* java.lang.Integer 클래스의 메소드 호출 (int는 기본 타입, integer는 클래스타입)
		 * "3" -> int로 변환하는 메소드 호출해서 변환하기
		 * 필요한 데이터 - int로 변경할 문자열 데이터
		 * 결과 데이터 - int로 변환된 데이터
		 * 
		 * 이 로직을 어떤 클래스에서 제공할 것인가?
		 * String? Integer?
		 * 혹 문자열 데이터를 제외한 메소드를 보유한 객체가 필요한가?
		 * 
		 * byte : Byte라는 클래스와 호환됨 - public static byte parseByte(String v) {}
		 * parsexxx 
		 */
		
		
		
		int no3 = Integer.parseInt("3"); //자바API - Integer에서 찾은 항목
		System.out.println(no3);
		
		
	
		
		
		
		
	}
}

	//step 01 - static{} 학습 내용 (프로젝트시에 쓰게 될 것임)
	/*static {
		System.out.println(1);
	}
	public static void main(String[] args) { //여기서는 보이드 메인보다 스태틱이 먼저 실행된다.
		System.out.println("main");
	}
	
		static {
			System.out.println(2);
			
	}

} */
	
