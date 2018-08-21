<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <!--  html 주석  	 -->
    
    
     <%-- %>가 있으면 jsp만의 주석임
     
    1. 1line은 jsp를 의미하는 선언구
    2. 각각의 표현식 분석
    <%@ page : page 지시자
    	language="java" : 이 파일은 자바로 되어있다
    	contentType="text/html; charset=EUC-KR"  :  response.setContentType() 메소드와 동일
    	: 응답하는 데이터 형태 및 인코딩 설정 (필수, 중요!!!)
    pageEncoding="EUC-KR" : 이 jsp의 개발 인코딩 설정
    주의할게 \ 써줘야 문자로 나온다.
    	--%>
     
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>jsp1ScriptingTag.jsp</title>
</head>
<body>
	<h3>jsp scripting tag</h3>
	1. 5가지만 존재<br>
	2. 종류 <br>
	<table border="1">
		<tr>
			<td>page 지시자</td>
			<td>jsp 선언구 <\%@ %></td>
			<td>import, 응답 포맷 설정</td>
		</tr>
		<tr>
			<td>선언자</td>
			<td><\%! 멤버변수, 메소드 구현 tag %)]></td>
			<td> jsp에서 멤버 변수와 메소드 구현시 사용되는 tag</td>
		</tr>
		<tr>
			<td>주석</td>
			<td><\% --- jsp만의 주석 --%></td>
			<td> 브라우저에 응답되지 않는 server단에서만 해석되는 주석 </td>
		</tr>
		<tr>
			<td>스클립틀릿</td>
			<td><\% service 메소드 구현부로 자동 반영되는 순수 자바코드 구현  tag %></td>
			<td>부득이한 경우가 아니면 사용 비추</td>
			
		</tr>
		<tr>
			<td>출력(expression)</td>
			<td><\%= service 메소드 구현부 %></td>
			<td>브라우저에 자바 데이터 출력 가능한 tag</td>
		</tr>

	</table>
	
	<br><hr><br>
	<%! //선언자 - 변수, 메소드 구현부
	String name = "멤버변수";
	String getName(){
	return name;
	}
	%>
	1. 출력 tag : <%= name %>
	<br>
	2. 메소드 호출해서 출력 : <%= getName() %>
	<br>
	3. 스클립틀릿 tag로 client 브라우저에 이름 출력 (순수 자바코드 다 사용 가능)
	<% 
	/* out - 출력, PrintWriter의 자식 클래스(참조 변수)
	*/
	 out.println(name);
	%>
</body>
</html>