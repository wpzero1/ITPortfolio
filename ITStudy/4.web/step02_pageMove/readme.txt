학습 내용

1. web page 이동 개발 기술
	- html/jsp/servlet 간의 이동
	- 절대 일반 자바 처럼 단순 메소드 호출로 간주하면 안됨
	참고 : (container는 서버.. tomcat 같은거)
	
2. 이동 기술 종류
	1) html tag를 이용한 방식
		1] 링크 tag : <a> (이것도 링크로 보내면서 주소값이 공개됨)
		2] form의 submit
		3] 일반 button의 onclick
		
	2) servlet api를 이용한 방식
		1] forward 방식
			- 데이터 손실이 없음
			- 서로 다른 servlet이라 하더라도 하나의 servlet처럼 간주 (번호가 바뀌어도 하나로 간주하고 문자나 전화가 오듯이)
				(즉 request가 유지된다는 의미..)
			
		2] redirect 방식(화면 처리 방식)
			- servlet 간에 redirect가 발생시 무조건 새로운 요청으로 간주

3. 주요 API
	1) javax.servlet.http;.HttpServlet
		- public void doGet()
		- public void doPost()	
		- public void service()	
		
	2) javax.servlet.http.HttpServletRequest
		- 접속된 client만의 요청 정보 보유한 객체
		1] String getParameter()  입력데이터 뽑아오기
			- web query string 구조로 전송되는 데이터값 획득
			- String으로만 반환
			- 
		2] getRequestDispatcher()
		3] setAttribute(String key, Object value)
			- 요청 객체에 데이터를 map 형태로 저장
			- map 형태로 데이터 저장
		4] public Object getAttribute(String key)
			- 요청 객체에 setAttribute()로 저장한 데이터만 반환
		
	3) javax.servlet.http.HttpServletResponse
		1] setContentType()
		2] getWriter()
		3] sendRedirect()
		
4. url의 변천사
	실행 process
		1. 유효 : forward 방식
		pageReq.html -> LoginCheckController -> Success
		: http://localhost/step02_pageMove/cont
		보안을 고려할 때, 화면은 바뀌는데 url이 유지된다. ex) 네이버 카페에서 게시글 볼 때.
		
		2. 무효 : redirect 방식
		pageReq.html -> LoginCheckController -> Fail
		: http://localhost/step02_pageMove/fail
		최종 url 주소가 나온다. ex) 네이버 블로그, 메일
		
		get(주소지 달고 전송), post(폐쇄성으로 은닉) 데이터 전송 방식
		forward, redirect servlet 전환 방식
		
	
	