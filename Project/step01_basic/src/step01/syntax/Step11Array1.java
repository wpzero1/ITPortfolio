/* 학습내용 - 배열
 * 1. 다수의 데이터를 하나의 변수로 관리
 * 2. 각각의 데이터는 고유한 index로 구분!
 *  - 첫번째 순번의 데이터 시작은 0
 * 3. 모든 배열은 무조건 객체
 * 	 - 배열이 실제 사용 가능하게 생성될 경우 어떤 메모리에 생성?
 * 	  : 객체가 저장되는 메모리인, heap에 저장
 * 4. 한번 생성시킨 배열의 크기는 변경 불가
 *  - 가변적인 데이터 표현을 위해서는 배열이 아닌 list 구조를 권장
 *  - java.util package 학습 예정
 * 5. 생성시킨 배열에는 배열 메모리 크기값을 보유한 length라는 변수가 자동 생성
 * [ ] 대괄호 표현은 배열
 * 우리가 만드는 사용자 타입도 배열로 할 수 있다.
 * 
 * int[] i = {1,2,5,29} : 배열임
 * String[] s = {new String ("a"),"b","c"}
 * Test[] i = {new Test(), }
 * 
 * 
 */

package step01.syntax;

import step01.domain.PeopleDTO;

public class Step11Array1 {

	//int 배열
	public static int[] intArray(){ //인트 배열을 반환
		int [] i = {1,2,3}; //[] 의 위치는 변수 앞 뒤 상관없다. 0번째, 1번째, 2번째 i가 참조하는 배열이 나온다. 4개짜리(1,2,3,그리고 length) -> 주소값을 i에게 준다.
		return i; //호출하는 쪽으로 값 주기
		
	}
	//String 배열
	public static String[] stringArray() {
		String[] s = {"여인덕", "김경남", "이영복"};
		
		return s;
	}
	
	// People DTO 배열
	public static PeopleDTO[] peopleArray() { //반환타입 대괄호 주의
		PeopleDTO [] all = {new PeopleDTO("신동엽", 30),
									new PeopleDTO("이영자", 31)};
		return all;
		
		}
	
	
	public static void main(String[] args) {
		
		int[] i = intArray(); //int[] 를 꼭 선언해줘야한다.
		System.out.println(i[0]);
		//int[] i2 = intArray()[2];
		String[] s= stringArray();
		System.out.println(s[1]); //index 1의 값만 출력
		System.out.println(stringArray()[1]); //근데 이렇게 해도 됨(String[] 선언 안하고)
		
		//index 1번째 친구의 이름값만 출력해보기
		PeopleDTO [] all = peopleArray();
		PeopleDTO p = all[1];
		String name = p.getName(); //문자열로 받기
		System.out.println(name);
		
		//이걸 어떻게 줄일까?
		//PeopleDTO p1 = peopleArray()[1]; //위에 두 라인을 줄임
	
		String p1 = peopleArray()[0].getName(); 	//-> 3줄을 한줄로하면?..  []는 배열 안 어떤 인덱스를 호출할 때, .은 객체 내에 있는 것 호출
		System.out.println(p1);
		
		/* peopleArray(): PeopleDTO 배열 반환
		 * peopleArray()[1] : 배열 내에 있는 Index 1번째 객체인 PeopleDTO 객체 반환
		 * peopleArray()[1].getName() : 객체의 getName() 호출
		 */
		
	
	
	}

}
