/*Wrapper class들 학습
 * 1. 필요성
 * 		- 예시 : 객체만 저장 가능한 배열, 객체만 저장 가능한 자료 구조 사용시
 * 				  기본 타입값은 순수하게 저장 및 관리 불가
 * 		- 해결책 : 기본 타입을 보유한 각 타입별 서포트 클래스들 제시
 * 				java.lang에 8가지로 제시
 * 2. 종류
 * 		byte - 2		: Byte - ney Byte(2) 
 * 		short - 3 3이라는 걸 표시하고 싶다 -> Short - new Short(3)
 * 		int : Integer
 * 		long : Long
 * 
 * 3. 객체 타입과 기본 타입간의 호환 문법 jdk 1.5부터 추가
 * 		구버전 : Integer i - new Integer(3);
 * 					int i = 3;
 * 				* 기본 참조 호환 문법 불가 (신버전에서는 가능)
 * 		신버전 : Integer i = 2; - autoboxing
 * 				-> 컴파일 직후 Integer i = new Integer(2); 로 알아서 해줌 
 * 					int = new Integer(2); - unboxing (기본타입으로 바꿔주는 것)
 * 				-> 컴파일 직후 int i = (new Integer(2)).intValue();
 * 
 * 
 */

package step04.API;

public class Step02Wrapper {

	public static void main(String[] args) {
		
	//	public boolean equals(Object o){}
			 String s = "3";
			 System.out.println(s.equals("3"));
			 System.out.println(s.equals(3));
			 System.out.println(s.equals(new Integer(3))); //- 컴파일러가 Object를 parameter로 받아야 하기 때문에 Integer객체로 자동으로 변환해줌

		

	}
}