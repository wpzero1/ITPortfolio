<%@ page contentType="text/html; charset=EUC-KR" %>		
<%-- html -> jsp �̷��� ������������ �ִٴ� --%>
${sessionScope.name }<br>

<button onclick="location.href='cont?command=all'"> ��� ���� </button>
	
<button onclick='location.href="cont?command=logout"'>�α׾ƿ�</button>
		
<!-- 
http://ip:port/project/cont
http://ip:port/project/cont/alogin/loginSucc.jsp
�ּҸ� �ű�� ���� ��?
jsp�� ���밡�ɼ��� ���⶧����, �ν��� �ߵǾ��Ѵ�.
�׷��� �ٲ� �ּҰ��� �޵��� �ؾ��Ѵ�.
"location.href='${pageCOntext.request.contextPath}

cont�� ��Ʈ�ѷ�. -->