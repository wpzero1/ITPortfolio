학습 내용

1. http 기본 특징
	- client의 정보를 기본적으로 저장 및 관리하지 않음
	- 무상태 연결(비연결 지향형)
	
2. 로그인~로그아웃까지의 상태유지 기술
	- 개발자가 직접 코드로 개발
	
3. 메카니즘
	1) client pc에 상태유지값 저장
		- 문자열만 저장 가능
		- 쿠키 개발 기술
			: javax.servlet.http.Cookie
		- 개발 단계
			1단계 : Cookie 객체를 저장할 문자열 데이터 수만큼 생성
			2단계 : client 시스템에 잔존시킬 시간 설정
			3단계 : client 시스템에 전송해서 쿠키 저장
			4단계 : servlet 이동
			5단계 : client로부터 쿠키 정보에 저장된 데이터 획득
			6단계 : 삭제
			
	2) server에 상태유지 값 저장
		- 객체 타입으로 저장 가능
		- 세션 개발 기술
			: javax.servlet.http.HttpSession
		- 개발 단계
			1단계 : HttpSession 객체를 하나만 생성
			2단계 : server 메모리에 저장할 데이터 수만큼 세션에 데이터 저장
					- setAttribute() (데이터 수만큼 호출)
			3단계 : client 시스템에 전송해서 쿠키 저장
			4단계 : servlet 이동
			5단계 : client로부터 쿠키 정보에 저장된 데이터 획득
					- getAttribute()
			6단계 : 삭제
					- 세션 무효화
						invalidate()
						null 값으로 정리
					- 생략시 발생 문제점 (서버 다운 방지. 예를 들면 인터넷뱅킹 로그아웃을 안하고 그냥 x버튼 누를때..)
					
4. 웹 페이지 이동 방식에 따른 데이터 저장 및 활용 방식
	1) 페이지 이동 방식
		1] html
			- 링크/버튼(일반 or form의 submit)
		2] servlet api
			- forward / redirect
	2) forward의 특징
		- 요청, 응답 객체가 한번 생성이 되서 공유
	3) redirect의 특징
		- 이동되는 page는 새로운 요청으로 인식됨. 요청, 응답 객체가 새롭게 생성
		- client의 새로운 정보를 요청, 객체로부터 정보 획득 가능
	4) 상태유지를 위한 데이터 저장 방식
		1] Cookie
			- client 시스템에 문자열로만 저장
			생성 - 잔존시간 설정 - client 시스템에 전송 - 이동된 servlet에서 Cookie 객체들 한번에 배열로 빼옴 -> getName()/getValue()로 값 획득
		2] HttpSession
			- server 시스템 메모리에 저장
			- page이동 방식과 무관하게 서버 메모리의 데이터를 저장 및 활용 가능

5. 최종 정리
	1] request.setAttribute(key, value)
		- 이 요청 객체에 저장한 데이터를 활용할 수 있는 page 이동 방식? (다음 페이지에서도 해당한 데이터를 써야함)
		- forward
		
	2] session.setAttribute()
		- 이 요청 객체에 저장한 데이터를 활용할 수 있는 page 이동 방식?
		- forward / redirect 상관 무.(invalidate로 끊어주기 때문에 가능하다고..
