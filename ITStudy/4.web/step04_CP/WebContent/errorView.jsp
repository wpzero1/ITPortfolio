<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>errorView.jsp</title>
</head>
<body>
 	<h2> [경고] 발생된 예외 상황</h2>
 	<img src = "img/warning.jpg" width = "20%" height = "20%"
 			onclick="location.href='login.html'">
 	<br><hr><br>
 	<p>
 	${requestScope.msg}
 	
 	
</body>
</html>