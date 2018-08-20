<%@ page contentType="text/html; charset=EUC-KR" %>		
<%-- html -> jsp 이렇게 간단해질수가 있다니 --%>
${sessionScope.name }<br>

<button onclick="location.href='cont?command=all'"> 모두 보기 </button>
	
<button onclick='location.href="cont?command=logout"'>로그아웃</button>
		
<!-- 
http://ip:port/project/cont
http://ip:port/project/cont/alogin/loginSucc.jsp
주소를 옮기고 싶을 때?
jsp는 재사용가능성이 높기때문에, 인식이 잘되야한다.
그래서 바뀐 주소값을 받도록 해야한다.
"location.href='${pageCOntext.request.contextPath}

cont는 컨트롤러. -->