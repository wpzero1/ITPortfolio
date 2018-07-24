/* Data Transfer Object = Value Object = Java Bean
 * 1. 명명규칙
 * 		- 도메인 이름 형식 : DTO.java / 도메인VO.java / 도메인Bean.java / 도메인 (회사의 룰에 따른다)
 *	2. 구조
 *		- 멤버 변수 : private
 *		- 멤버 메소드 : 변수 즉 데이터값 변환, 데이터 값 수정 로직으로만 구성. 데이터 구성 메소드에는 값의 유효성 검증 구현
 *		- 생성자 : 기본생성자, 멤버 변수들 초기화 생성자
 *		- toString() : 멤버 변수들값 결합해서 변환하는 메소드
 */

  package step01.domain;
 

public class PeopleDTO {
	private String name;
	private int age; 

	//private : 다른 곳에서는 쓸 수 없다. 이 클래스에서만 쓰는 것으로 제한
	
	
	
	public PeopleDTO() {} //기본 생성자. public으로 만듬. 또한 클래스 이름으로 생성. 객체만 생성하는 과정. 여기서는 반환하지 않아 return없음
	public PeopleDTO(String newName, int newage) { //멤버 변수 초기화하는 생성자 (특정 데이터를 새롭게 수정하려는 과정)
	name = newName;
	age = newage;
	}
	public String getName() { //name 값 얻어가는 getName이라는 메소드. 대소문자 주의할 것
		return name;
	}
	public void setName(String name) { //name 변수 수정하는 set 메소드
		this.name = name; //this는 명확하게 이것이 멤버다 라는걸 지칭. 뒤쪽 name은 로컬변수값
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "PeopleDTO [name=" + name + ", age=" + age + "]"; //toString generate 했음
		
		//이것이 데이터를 보여주는 DTO의 형식임
		//로컬변수는 4개. ()안에있는 갈색깔 글씨를 잘 볼것
	}
	
	
	
	
}
