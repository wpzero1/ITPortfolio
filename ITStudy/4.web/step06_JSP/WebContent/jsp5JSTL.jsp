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
	<h3> JSTL�� �ٽ� ����</h3>
	1. �ݺ� tag �н�<br>
	2. ArrayList or HashMap ������ ���<br>
	
	<hr>
	<%
		ArrayList<String> a = new ArrayList <String>();
		a.add("data1");
		a.add("data2");
		a.add("data3");
		
		request.setAttribute("d1", a);
	
	%>
	<c:forEach items="${requestScope.d1}" var="data">
	<!--  ArrayList�� ���ε���. item �Ӽ����� �ݿ��� ���ִ� ��. data ���� �̾ƿ´�. -->
		${data}<br>
	
	</c:forEach>
	
	<br>
	<table border="1">
			<c:forEach items="${requestScope.d1}" var="data">
		<tr><td>${data}</td></tr>
		<!-- �ſ� �������� �ڵ�. tr�� �ο츦 ����.. -->
			</c:forEach>
	</table>
	
	<br><hr><br>
	<%
	CustomerDTO c6 = new CustomerDTO("tester","11","������");
	CustomerDTO c7 = new CustomerDTO("power","22","���ɸ�");
	HashMap<String,CustomerDTO> mAll = new HashMap<String,CustomerDTO>();
	mAll.put("tester",c6); 
	mAll.put("admin",c7);
	session.setAttribute("data6",mAll);
	%>
	<%-- HashMap�� forEach���� ���� key, value �Ӽ����� ������ Ȱ��
		key �Ӽ� : HashMap�� key ��ȯ
		value �Ӽ� : HashMap�� ����� �����Ͱ�
		
		���غ���. key�� value. �׸��� value���� ���� ���� �� �̾Ƴ� �� �ִ°�
		--%>
	<c:forEach items="${sessionScope.data6 }" var="data">
		${data.key} - ${data.value.name}<br>
		
		 ${data.value} 
	</c:forEach>
	
</body>
</html>