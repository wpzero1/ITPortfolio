/* 학습내용
 * 1. 기본 syntax 복습
 * 2. 변수 생성(선언), 변수 초기화(값 대입)
 * 		메소드 생성(구현), 메소드 호출
 *		생성자 구현, 생성자 호출
 *3. 각 구성 요소의 용도
 *		1) 변수 - 데이터 표현
 *		2) 메소드 - 다양한 처리 기능을 구현하는 요소
 *				반환타입 메소드명( [] ) { [..] }
 *		3) 생성자 - 객체 생성시 호출되는 필수 구성 요소
 */

package step01.syntax;

public class Step02Type { 
	//황인범,27
	String name; //선언. 만드는 과정임
	int age;
	public Step02Type() {} //기본 생성자, 반환타입 없음 (name과 age를 관리하는걸 만든거임)
	
	//Step02Type 객체 반환 메소드
	Step02Type getObject() { //정수값 하고프면 int getObject() { 이렇게 하고, 밑에도 return int s 가 와야한다 string이면 "s"
		Step02Type s = new Step02Type(); // 객체 생성 문법. 호출하는 쪽으로 데이터를 주고 싶습니다.
		// 메소드 생성 구문이기 때문에, 이런 내용들이 들어가서 설명을 해줘야한다.
		// 다른 클래스에서 생성한 메소드를 다른 메인에서 쓰기 위해서 필요한 과정임
		return s; //위에서 받아온 정보를 내보냄. 넘기는 값은 메소드의 주소값
	}
	
	Step02Type getObject2() {
		return new Step02Type(); //new ~가 먼저 실행되고 return이 실행됨
	}
	
	
	public static void main(String[] args) { //메인 메소드 호출.
	//step02 - 메소드 호출해서 객체 받아오기
	//클래스 내에 존재하는 변수, 메소드들을 실제 실행하기 위해서는 반드시 변수, 메소드를 보유한 객체 생성이 우선
	//? getObject() 호출해보기
		
	Step02Type s = new Step02Type(); //여기서 객체 생성은 전제조건이다. 이게 있어야 메소드를 호출하지
	Step02Type v = s.getObject(); //s와 v는 같은 주소값을 가질까? 주소값은 위치값. 다르다.
	//new가 들어가면 메모리를 새로 잡는다. 위에랑 s가 같은데도 다른 것.
	
	
	
		//반장님 정보를 각 변수에 저장, 화면 콘솔창에 출력 - 이를 위해 : 사용가능한 메모리 확보, 그걸 가져와서 출력해야함
		/*1. 객체 생성 - new 생성자()
		 *2. 생성한 객체를 참조하는 변수로 호출해서
		 *	각자의 name, age 변수에 값 대입
		 *3. 각 변수값 호출해서 출력
		 */
		//step01
/*		Step02Type s = new Step02Type(); //객체생성
		s.name = "황인범";
		s.age = 27;
		System.out.print(s.name); //print만 쓰고 ln은 빼니까, 다음값이 바로 붙음
		System.out.println(s.age);*/
	}

}
