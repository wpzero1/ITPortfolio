/* 학습내용
 * 1. 메소드 구현(개발, 만들기)
 *  - 사칙연산 로직으로 테스트
 * 2. 메소드 호출(사용)
 * 3. 구현 위치
 *  - class 영역 내에서만 개발 가능
 *  - 메소드 내부에 메소드 구현 불가(파이썬과 다르게)
 *  - 메소드 내부에서 다른 메소드 호출 가능
 * 4. 기본 문법(*)
 *  - 반환타입 메소드명( [arguments] ){ [로직] }  (미리 선언해줘야함)
 *  - 반환값 타입에 맞게 반환타입 설정
 *  - 반환값 없는 메소드인 경우 반환타입에 void에 선언
 * 5. 참고
 *  - 생성자와 문법 비교
 *  	생성자 문법 : 클래스명 ([arguments] ){ [로직] }  (반환타입 존재 x)
 *  
 *  
 */

package step01.syntax;

public class Step01Method {
	public Step01Method() {}
	// + 연산 기능의 메소드 구현
	/* 개발 경우의 수
	 * 경우의 수 1 - 정적 데이터로 더해서 반환
	 * 경우의 수 2 - 동적 데이터(그때그때 달라지는)로 더해서 반환 
	 */
	public int sum(){  //연산 메소드 이름을 그냥 sum이라고 정해봄
		return 3+5; //반환 명령어 필수. 3+5가 1번째 실행, 이걸 return해서 int값이 나옴
	}
	public int sum(int no1, int no2){ //sum2(10, 20) -> sum2에서 alt shift R로 바꿨음.
		//그때그때 데이터 값이 다르다면...
	
		return no1 + no2;
	}
	public void sum(int no1, int no2, int no3){ //void를 해보겠음. 반환 x 일만시키고, 값은 받아오지않음
		System.out.println(no1 + no2 + no3);
	}
	public static void main(String[] args) {
		//1단계 - 메소드 호출하기 위해 객체 생성(메소드를 포함하고있는걸 만들어야함)
		//객체 생성 문법 : 타입변수 명 = new 생성자 ();
		Step01Method s = new Step01Method();
		//그리고 메소드를 이제 호출할거다
		int v1 = s.sum() ; //이 문장은 굳이 한번 쓰는데 메모리를 쓸 필요가 없다. 그래서 sum2에는 그냥 넣어줌
		System.out.println(v1);
		System.out.println(s.sum(100,  200));
		s.sum(3,5,6); //위에서 바로 출력하기에 그냥 이렇게 적어도 값이 나옴
						

	}

	
}

/*
 * 참고내용
 * void a() {}
 * int i = t.a()); 이건 불가능. void는 값을 안받아와서
 * 
 * 다중정의 : 다양한 문법들이 있다.
 */