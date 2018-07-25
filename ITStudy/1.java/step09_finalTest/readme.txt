학습내용

1. 실 현업에서 사용하는 권장 구조 및 파일들

2. 구조
	1) *.properties
		1] 확장자 - properties
		2] 용도 - 프로그램에서 사용되는 sql문장 또는 다양한 데이터를 key=value 구조로 분리해서 관리
			- 데이터용 파일
			- 참고 : WAS와 같은 솔루션의 환경 정보 보유 파일로도 사용됨
		3] 구조
			- key=value
			- 주의사항 : key는 절대 중복 불허 (그래서 map이 많이 쓰인다)
	2) 사용자 정의 Exception 클래스 개발 및 반영
		1] 상황에 따라 자체적인 경우의 수 처리를 의미가 있는 이름의 클래스로 개발
			- ID가 중복된 상황을 예외 처리하고 싶다?
				ID중복문제Exception.java
			- API에서 제공하는 Exception들은 한계가 존재
			- 자체 framework들은 내부적으로 다수의 예외 클래스 개발해서 반영
		2] 개발 코드
			1} java.lang.Exception 상속
			   - 변수, 메소드 상속	
			2} 해당 클래스에 기본 생성자, String값 parameter로 보유한 생성자
	3) 주요 API
		1] 네트워크 상에서 사용되는 데이터의 DTO는 가급적 데이터의 손실을 방지하고자 스펙 하나를 반영
		2] built in 타입은 총 8개 있는데, 데이터 손실 가능성이 극히 드문 안정적인 타입인데,
		   이걸 제외한 객체 타입들은 다수의 데이터들을 멤버로 보유해, 데이터 손실 가능성이 존재
		   	- Person 객체를 전송
		   		전송되는 데이터 수 및 구조를 절대 데이터 손실 없이 관리하기 위한 스펙
		   		java.io.Serializable로 구현
		   		
		   	class Person{
		   	  Car car;
		   	 }
		   	class Car{
		   	   Engine engine;
		   	 }
		   	class Engine{
		   	   String engine;
		   	 }
		 3] Serializable
		 	1} 객체 직렬화
		 	2} 직렬화 : 객체를 byte 단위로 잘게 구분해서 전송
		 	3} 장점 : 데이터 손실 방지
		 	4} class는 아님, interface 구조
		 	
	4) Properties
		1] Map 구조의 일부
		2] key=value 구조
		3] 주용도
			1} *.properties 파일의 내용 관리하는 객체
			2} 시스템 자체의 path값 관리하는 객체
		4] 메소드
			1} load()
				- properties 파일 내용 저장
			2} getProperty()
			 	- key에 매핑된 value값 반환
			3} stringPropertyNames()
				- properties 파일의 모든 key를 Set 객체로 반환
				
3. 숙제 (6시 전까지 할 내용)
	1) 소스 단점 찾으면 수정
	2) 소스 간략 주석 달기
	3) 제네릭 반영 가능한 곳이 있다면 반영하기