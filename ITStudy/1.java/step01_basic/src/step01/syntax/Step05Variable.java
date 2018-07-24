/*학습 내용
 * 1. 변수 초기화
 * 		1) 멤버 - 객체 생성시 자동 기본값으로 초기화
 * 		2) 로컬 - 자동 초기화가 불가, 따라서 사용 전 초기화 필수

 * 2. 기본 타입 변수 간의 형변환
 * 		- 타입이 다른 변수들 간에도 "형변환" 문법으로 변환이 가능
 * 		- boolean은 절대 다른 타입으로 변환 불가
 * 		- 실수는 무조건 내부적으로 정수보다 큰 메모리가 관리
 * 
 */
  package step01.syntax;
//멤버변수와 로컬변수와의 차이점을 알아보는 실습 (자동 초기화의 차이점)
  
public class Step05Variable {
	int no; //선언
	String msg;
	
	void localVar() {
		int no = 0; //로컬 변수들은 사용하기 전에 초기화를 해야한다. 값을 주자.
		System.out.println(no);
	}
 //기본타입 형변환 문법 학습
	void typeCasting() {
		byte b = 8; //8bit
		int i = b; //32bit
		byte b5 = (byte)i; //형변환. 변환하는 타입으로 압축해주는 작업. 작은 -> 큰사이즈로 : upcasting 반대는 downcasting
		
		char c = 'B'; //16bit
		int i2 = c;
		System.out.println(c);
		System.out.println(i2); //ASCII 코드로 나옴
		
		//정수의 사칙 연산시 무조건 int로 변환
		byte b1 = 8;
		byte b2 = 10;
		byte b3 = (byte)(b1 + b2);
		
	}
	
	public static void main(String[] args) {
		Step05Variable s = new Step05Variable(); //객체생성
		//객체 생성시 heap에 생성된 no와 msg는 자동 초기화
	//	System.out.println(s.no);
	//	System.out.println(s.msg);
		
		s.typeCasting();
		
	}

}
