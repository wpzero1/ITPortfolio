/* Data Transfer Object = Value Object = Java Bean
 * 1. 명명규칙
 * 		- 도메인 이름 형식 : DTO.java / 도메인VO.java / 도메인Bean.java / 도메인 (회사의 룰에 따른다)
 *	2. 구조
 *		- 멤버 변수 : private
 *		- 멤버 메소드 : 변수 즉 데이터값 변환, 데이터 값 수정 로직으로만 구성. 데이터 구성 메소드에는 값의 유효성 검증 구현
 *		- 생성자 : 기본생성자, 멤버 변수들 초기화 생성자
 *		- toString() : 멤버 변수들값 결합해서 변환하는 메소드
 */

  package step01;
 

public class PeopleDTO {
	private String name;
	private int age; 


		//
	
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
	/* @Override
	 *  - 주석보다 더 강한 명시적인 명령어
	 *  - 해당 스펙에 맞게 구현을 안하면 문법 오류가 발생
	 *  
	 *  @명령어 (@는 at 이라고 읽는다)
	 *   - @Override : 이 메소드는 반드시 재정의 하세요 라는 명령(우리가 바꿀 수가 없다)
	 
	@Override
	public String toString() {
		return "PeopleDTO [name=" + name + ", age=" + age + "]"; //toString generate 했음
		
		//이것이 데이터를 보여주는 DTO의 형식임
		//로컬변수는 4개. ()안에있는 갈색깔 글씨를 잘 볼것
		
		*/
		
		//Source에서 toString, 여기서 Code Style Builder/Buffer 선택
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PeopleDTO [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
		
		//결과값은 같으나, 내부적으로 메모리 처리 퍼포먼스가 더 좋다
		//string은 계속 만들지만 StringBuilder는 밑의 변수들을 StringBuilder 객체에 적재한다.
		//+로 붙여가는 toString의 경우에는 예시에서 봤듯이, 객체가 너무 많이 생성되버린다.
	}

	
	/* equals() 재정의 코드 순서
	 * PeopleDTO 타입 여부 비교
	 * 경우의 수 1 - PeopleDTO인 경우
	 * 		형변환
	 * 			형변환 후 해당 객체의 변수들 비교 : 주의사항(문자열 내용은 equals()로 비교)
	 * 			경우의 수 1 - 데이터가 다르다 false 반환
	 * 			경우의 수 2 - 데이터가 같다 true 반환
	 * 	경우의 수 2 - false 반환 
	 * 
	 */
	public boolean equals(Object dto) {
		if(dto instanceof PeopleDTO) {
			PeopleDTO abc = (PeopleDTO)dto;
			if(getName().equals(abc.getName()) && getAge() == abc.getAge()) { //String에서 ==하면 주소값 비교기 떄문에 equals 해줘야함
			return true;
			}
		}
		return false;
	
	}
}
