/*학습내용
 * 1. 배열 타입을 이용한 응용력 향상
 * 2. String 데이터값 비교하기
 * 		- public boolean equals(String v) {문자열 비교} - 같으면 True, 다르면 False
 * 3. 동등비교 연산자
 * 		==
 * 		1. 기본 타입 : 순수 값비교
 * 		2. 객체 타입 : 주소값(위치) 비교
 * 		
 * 
 * 
 * d3 시각화 라이브러리
 */

package step01.syntax;

import step01.domain.PeopleDTO;

public class Step12Array2 {

		//문자열 비교
	public static void equalsTest(String v) { //v : 비교하고자 하는 값
		String id ="tester";
		System.out.println(id.equals(v)); //id 변수에 tester가 오면 true, 아니면 false가 나올 것. 새로운 데이터와의 비교
		
	}
		//== 동등 비교 연산자로 비교
	
	public static void operator(int i) {
		int data = 10;
		System.out.println(data== i);
		
	}
	
	//== 객체 타입 비교 : 주소값 비교
	public static void operator(PeopleDTO dto) { //항상 다른데서 끌어쓸때는 ctrl shift O로 임포트
		PeopleDTO p = new PeopleDTO("name", 10); //객체 하나 만들기
		System.out.println(p == dto); //false. 다른 값. 이건 주소값이다. 객체 자체들을 비교하는건데, 서로 다른 주소값을 가지고 있다.
			
		System.out.println(p.getName().equals(dto.getName())); //true 임. 객체 내의 변수값을 비교
		
		//위에 문장을 풀어서 써볼게.
		// p.getName().equals(dto.getName()) 이것과 동일한 코드는 아래와 같음.
		String name = p.getName();
		String name2 = dto.getName();
		name.equals(name2); //string 객체 안에 있는 equals 메소드를 쓰겠다는 의미...
		
		System.out.println(name.equals(name2)); // - true
		
		/*실행 순서
		 * p : PeopleDTO
		 * p.getName() : PeopleDTO의 name String 값 반환된 로직
		 * p.getName().equals() : String의 equals() 호출만.
		 * dto.getName() : dto의 getName() 즉 name 변수값 획득
		 * dto.getName()의 결과값이 확실히 반환되면(dto.getName() 실행하고 나서, 어 비교하는게 있네?
		 *  그러니까 equals() 메소드가 실행.
		 */
	}
	
	//배열의 length 변수 사용 연습
	
	//String[] 여러명의 ID값을 저장할 거야. 그 후에 하나의 ID값 주면서 존재여부를 반환해주는 기능을 짤거야
	public static void lengthTest() {
		int[] i = {1,6,77,7,67};
		for(int index=0; index < i.length; index++) //index는 0부터 시작, 0~4까지 5번 돌림. 인덱스를 증가시켜가면서 비교할 것이다
		System.out.print(i[index] + "\t");
		
	}
	
	public static void main(String[] args) {
		equalsTest("tester"); //true
		equalsTest("e"); //false
		
		operator(10); //true
		operator(9); //false
		
		operator(new PeopleDTO("name", 10)); //false. new는 새로운 객체를 만들기 때문에 위랑 다르다. 안에서 새로운 객체 생성 가능
		
		lengthTest(); //메인에서 메소드 호출 (꼭 메인에서 호출하는걸 잊으면 안된다)		
	}

}
