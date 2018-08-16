학습 내용

* 꼭 외워야할 용어
	1. WAS[Web Application Server]
		- www(인터넷) 상에서 브라우저와 요청, 응답기능을 하는 서버
	2. servlet
		- java 기반의 웹 개발 스펙
		- http 통신이 가능한 자바 스펙
	3. tomcat
		- 아파치 비 영리 재단에서 제공하는 무료 was
		- servlet과 jsp 실행 engine
		- web container
		- was=server
		(참고 : 상용 서버 종류 : 웹로직(오라클), 웹스피어(ibm), 오라클서버..)
	4. 웹프로젝트 = [web] context = 웹 어플리케이션

1. 학습 순서
	servlet -> jsp -> java script -> Ajax (여기까지 하면 시각화가 가능)
	
2. Servlet 주요 학습 내용
	1) 실행 환경에 대한 이해
	2) servlet의 주요 API
	3) web page 이동 API에 대한 이해 및 개발 스킬
	4) client 상태 유지를 위한 개발 기술
		세션
		쿠키
3. jsp
	* 1번 암기 
	1) 최초 client가 해당 jsp를 요청 시 tomcat이 servlet으로 자동 변환 및 컴파일 및 byte code 메모리에 로딩
		(*.java -> *.class -> 메모리에 로딩)
		- jsp는 servlet이다.
	2) 개발 코드는 tag 위주
		1] java / html tag / java script
		2] jsp tag
			jsp scripting tag
			jsp action tag
			EL
			JSTL
			
		
	