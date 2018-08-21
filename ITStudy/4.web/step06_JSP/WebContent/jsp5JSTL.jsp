<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.ArrayList, java.util.HashMap, model.domain.CustomerDTO"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>jsp5JSTL.jsp</title>
</head>
<body>
	<h3> JSTL의 핵심 내용</h3>
	1. 반복 tag 학습<br>
	2. ArrayList or HashMap 데이터 출력<br>
	
	<hr>
	<%
		ArrayList<String> a = new ArrayList <String>();
		a.add("data1");
		a.add("data2");
		a.add("data3");
		
		request.setAttribute("d1", a);
	
	%>
	<c:forEach items="${requestScope.d1}" var="data">
	<!--  ArrayList에 루핑돌림. item 속성으로 반영만 해주는 것. data 값을 뽑아온다. -->
		${data}<br>
	
	</c:forEach>
	
	<br>
	<table border="1">
			<c:forEach items="${requestScope.d1}" var="data">
		<tr><td>${data}</td></tr>
		<!-- 매우 함축적인 코드. tr로 로우를 띄우고.. -->
			</c:forEach>
	</table>
	
	<br><hr><br>
	<%
	CustomerDTO c6 = new CustomerDTO("tester","11","동동주");
	CustomerDTO c7 = new CustomerDTO("power","22","막걸리");
	HashMap<String,CustomerDTO> mAll = new HashMap<String,CustomerDTO>();
	mAll.put("tester",c6); 
	mAll.put("admin",c7);
	session.setAttribute("data6",mAll);
	%>
	<%-- HashMap을 forEach에서 사용시 key, value 속성으로 데이터 활용
		key 속성 : HashMap의 key 반환
		value 속성 : HashMap에 저장된 데이터값
		
		비교해보자. key와 value. 그리고 value에서 내부 값을 또 뽑아낼 수 있는가
		--%>
	<c:forEach items="${sessionScope.data6 }" var="data">
		${data.key} - ${data.value.name}<br>
		
		 ${data.value} 
	</c:forEach>
	
</body>
</html>