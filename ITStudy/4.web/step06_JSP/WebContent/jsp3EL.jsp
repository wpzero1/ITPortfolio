<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ page import="model.domain.CustomerDTO, java.util.ArrayList, java.util.HashMap" %>   
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>jsp3EL.jsp</title>
</head>
<body>
	<h3>EL tag���� �ڹ� �ڵ� Ȱ���ϱ�</h3>
	
	step01 : EL�� �ܼ� ���ڿ� ����ϱ�<br>
	
	<%-- test�� ���� ������ �ܼ� ���� --%>
	<%
		String data1 = "���ڿ�";
		String [] data2 = {"�迭�ȿ� ù��°��", "�ι�°��"};
		
		request.setAttribute("data1", data1);
		session.setAttribute("data2", data2);
	%>
	<%--	���� �̷��� ������, �ؿ�ó�� ���°� �뼼��.
		out.println(request.getAttribute("data1"));
		 �����Ͱ� ������ ��ũ�� ���
		 --%>
	${requestScope.data1	}<br>
	${sessionScope.data2[0]}<br>
	<br><hr><br>
	step02 : DTO�� EL�� Ȱ���ϱ� <br>
	<% 
		CustomerDTO c1 = new CustomerDTO("tester","11","�ŵ���");
		CustomerDTO c2 = new CustomerDTO("power","22","�̿���");
		request.setAttribute("data3", c1);
		
		CustomerDTO [] c3 = {c1, c2};
		request.setAttribute("data4",c3);
	%>
	${requestScope.data3.id}<br>
	${requestScope.data4[1].name}
	<%-- 
		CustomerDTO data3 = request.getAttribute("data3");
		out.println(data3.getId());
		 --%>
		 
		 <br><hr><br>
		 step03 : �����͸� ArrayList�� �����ؼ� ���<br>
		 <% 
		CustomerDTO c4 = new CustomerDTO("tester","11","������");
		CustomerDTO c5 = new CustomerDTO("power","22","���ɸ�");
		ArrayList<CustomerDTO> all = new ArrayList<CustomerDTO>();
		all.add(c4);
		all.add(c5);
		session.setAttribute("data5", all);
		%>
		${sessionScope.data5[1].name}<br>	<!-- jsp���� ���̴� ���� -->
		${sessionScope.data5.get(1).name }<br> <!-- �ڹ� �������� ���̴� �����ε� ���⼭�� ���� -->
		<%--
		sessionScope - HttpSession
		sessionScope.data5 - ArrayList
		sessionScope.data5[1] - DTO ������ ��ü new CustomerDTO("power","22","���ɸ�");
		sessionScope.data5[1].name - getName�� ���, ���ɸ�
		
		 --%>
	 <br><hr><br>
	 step04 : �����͸� HashMap�� �����ؼ� ���<br>
	<% 
		CustomerDTO c6 = new CustomerDTO("tester","11","������");
		CustomerDTO c7 = new CustomerDTO("power","22","���ɸ�");
		HashMap<String,CustomerDTO> mAll = new HashMap<String,CustomerDTO>();
		mAll.put(c6.getId(),c6); 
		mAll.put(c7.getId(),c7);
		
		session.setAttribute("data6", mAll);
		%>
		${sessionScope.data6.tester.name}
		${sessionScope.data6.get("tester").name}
	
		<%-- ���ʿ� mAll.put("tester",c6); 
		
		${sessionScope.data6.tester.name} �ؼ�
		sessionScope.data6 - session�� ����� HashMap
		sessionScope.data6.tester - HashMap�� tester��� ��Ī���� ����� CustomerDTO
		sessionScope.data6.tester.name - CustomerDTO�� getName()
		
		--%>
</body>
</html>