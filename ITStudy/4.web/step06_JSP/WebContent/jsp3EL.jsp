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
	<h3>EL tag에서 자바 코드 활용하기</h3>
	
	step01 : EL로 단순 문자열 출력하기<br>
	
	<%-- test를 위한 데이터 단순 셋팅 --%>
	<%
		String data1 = "문자열";
		String [] data2 = {"배열안에 첫번째값", "두번째값"};
		
		request.setAttribute("data1", data1);
		session.setAttribute("data2", data2);
	%>
	<%--	원래 이렇게 쓰지만, 밑에처럼 쓰는게 대세다.
		out.println(request.getAttribute("data1"));
		 데이터가 없으면 블랭크로 뜬다
		 --%>
	${requestScope.data1	}<br>
	${sessionScope.data2[0]}<br>
	<br><hr><br>
	step02 : DTO를 EL로 활용하기 <br>
	<% 
		CustomerDTO c1 = new CustomerDTO("tester","11","신동엽");
		CustomerDTO c2 = new CustomerDTO("power","22","이영자");
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
		 step03 : 데이터를 ArrayList에 저장해서 출력<br>
		 <% 
		CustomerDTO c4 = new CustomerDTO("tester","11","동동주");
		CustomerDTO c5 = new CustomerDTO("power","22","막걸리");
		ArrayList<CustomerDTO> all = new ArrayList<CustomerDTO>();
		all.add(c4);
		all.add(c5);
		session.setAttribute("data5", all);
		%>
		${sessionScope.data5[1].name}<br>	<!-- jsp에서 쓰이는 문법 -->
		${sessionScope.data5.get(1).name }<br> <!-- 자바 문법에서 쓰이는 문장인데 여기서도 가능 -->
		<%--
		sessionScope - HttpSession
		sessionScope.data5 - ArrayList
		sessionScope.data5[1] - DTO 데이터 객체 new CustomerDTO("power","22","막걸리");
		sessionScope.data5[1].name - getName의 결과, 막걸리
		
		 --%>
	 <br><hr><br>
	 step04 : 데이터를 HashMap에 저장해서 출력<br>
	<% 
		CustomerDTO c6 = new CustomerDTO("tester","11","동동주");
		CustomerDTO c7 = new CustomerDTO("power","22","막걸리");
		HashMap<String,CustomerDTO> mAll = new HashMap<String,CustomerDTO>();
		mAll.put(c6.getId(),c6); 
		mAll.put(c7.getId(),c7);
		
		session.setAttribute("data6", mAll);
		%>
		${sessionScope.data6.tester.name}
		${sessionScope.data6.get("tester").name}
	
		<%-- 위쪽에 mAll.put("tester",c6); 
		
		${sessionScope.data6.tester.name} 해석
		sessionScope.data6 - session에 저장된 HashMap
		sessionScope.data6.tester - HashMap에 tester라는 별칭으로 저장된 CustomerDTO
		sessionScope.data6.tester.name - CustomerDTO의 getName()
		
		--%>
</body>
</html>