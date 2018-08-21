학습내용

*** jsp에는 부득이한 경우가 아니면 순수 자바 코드는 최소화 tag 위주로 개발 권장
	  (view 처리 기술에 집중)
	  
ㅡㅡㅡㅡ
1. 실행 환경
	*.class 라는 byte code는 jdk내의 jre가 실행
	serlet -> *.class -> 실행(jre)
	
	html tag
		- client 브라우저
		- 브라우저는 html 해석기, js 해석기, css 해석기
2. 웹상에서 sever <-> client로 통신
	servlet 즉 자바 실행은 서버
	html/css/js 실행은 클라이언트 브라우저
3. 웹 프로그램 실행
	자바(servlet, jsp) & html & css & js
	서버는 client가 요청시 자바는 실행한 결과를 문자열로 응답
		html/css/js는 그냥 전송 브라우저는 문자열 다 받음
		html/css/js는 스펙(w3, 즉 www) 맞다는 인지하면 그에 맞게 실행
		
4. server side[백엔드]/client side[프론트] (데이터 처리 기술을 알아야 분석을 한다)
	server side 언어 - java(servlet/jsp)
	client side 언어 - html/css/java script
	
5. 풀스택
	- 백 & 프론트
	
1. jsp
	1) java server page의 약어
	2) html tag/css/java script/jsp tag/순수 자바 코드가 혼용되어 개발 가능한 파일
	3) 필요성
		- UI에 대한 구성을 보기좋게 하기 위해 서블릿으로부터 파생된 스펙
	4) view 용도로 사용

2. jsp tag 종류
	1) sun에서 제시한 표준 tag
		1] scripting tag
			- 기본 문법 : <%?    %>
			- 5가지 이외에는 미 존재
			
		2] jsp action tag
			- 화면 이동 tag(forward 방식)
			- <jsp:tag명>
			
	2) 산업 표준 tag
		1] EL(expression language)
			- 자바 데이터를 브라우저 화면에 단순하게 출력 가능한 표현 태그
			- ${?}
			- 자바 데이터 출력을 위해서는 반드시 request or session에 setAttribue로 저장한 데이터에 한해서만 사용 가능
		2] jstl(jsp standard tag library)
			- tag만으로 자바의 반복로직, 쿠키 활용 등을 간결하게 개발 가능
			- 자바 코드를 tag로 개발할 수 있음
			- EL tag와 혼용해서 개발
			- JSTL library를 개발 환경에 새롭게 셋팅 필수
				WebProject/WEB-INF/lib/jstl lib 셋팅
			
3. 특징
	1) servlet 관련 API는 자동 Impot
		- java.lang
		- javax.servlet
		- javax.servlet.http
	2) 이미 실행시에 내장된 객체들 존재
		- 객체들 사용을 위해서는 변수로 사용
		- 출력
		   요청
		   응답
		   세션(HttpSession) - 단, 쿠키는 내장객체 자동 생성 x
		   이미 객체들이 존재해서 쉬운데 버그를 잡기가 어려움