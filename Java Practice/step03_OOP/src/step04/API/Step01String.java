/* 문자열 클래스들
 * 1. String
 * 		1) 한번 생성된 문자열 객체의 내용은 절대 수정 불가
 * 		2) 기본 타입은 아니지만 "" 표현만으로 내부적으로 객체로 생성
 * 		3) 생성시키는 문법
 * 			"" or new String(" ")
 * 		4) 객체 생성 원리
 * 		  1] ""문법으로 생성시
 * 				- 이미 동일하게 ""으로 생성된 문자열의 값이 같다면 재사용
 * 		  2] new String()
 *  			- 무조건 무조건 무조건 새로 객체 생성
 * 
 */

package step04.API;

public class Step01String {

	public static void main(String[] args) {
		//step01 - String
		String d1 = "이경준";
		String d2 = "이경준";
		String d3 = new String("이경준");
		String d4 = new String("이경준");
		
		System.out.println(d1==d2); //true
		System.out.println(d2==d3); //f 새로운 객체와는 다른 값이지.
		System.out.println(d3==d4); //f
		
		//step02 - String 불변 test
		//String concat(String addValue) { concat : 이 메소드를 보유한 객체의 내용에 parameter로 유입된 문자열을 추가하는 기능} addValue는 변수
		
		d1.concat("시험 출제자");
		System.out.println(d1); //이경준 만 나온다. 한번 생성된 문자열은 수정이 불가능해서.
		
		System.out.println(d1.concat(" 남학생")); //이경준 남학생. d1은 변함이 없다.
		System.out.println(d1); //이경준  으로 그대로 다시 나온다.
		
		
		d1 = d1.concat(" 시험 출제자"); //문자열 추가 내용을 대입을 해서 데이터를 새로 주는 것
		System.out.println(d1); //이경준 시험 출제자
		
		/* String 특징중 불변 구조는 실시간 가변적인 문자열 조합에는 
		 * 실행 속도 문제 발생
		 * 해결책 - java.lang.StringBuffer/StringBuilder 제시
		 * 		- 문자열 관련 API
		 * 		- 가변적인 문자열을 표현하기에 적합
		 * 	참고 - jdk1.6부터는 String 자체의 실행 퍼포먼스를 jdk 자체적으로 향상시킴
	
		 */
		
		System.out.println("a" + 1 + "b" + 2 + "c" + "d");
		/* 이 한문장으로 객체들이 이렇게 많이 만들어짐
		 * a
		 * a1
		 * b
		 * a1b
		 * a1b2
		 * c
		 * a1b2c
		 * d
		 * a1b2cd
		 */
	}

}
