<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <!--  html �ּ�  	 -->
    
    
     <%-- %>�� ������ jsp���� �ּ���
     
    1. 1line�� jsp�� �ǹ��ϴ� ����
    2. ������ ǥ���� �м�
    <%@ page : page ������
    	language="java" : �� ������ �ڹٷ� �Ǿ��ִ�
    	contentType="text/html; charset=EUC-KR"  :  response.setContentType() �޼ҵ�� ����
    	: �����ϴ� ������ ���� �� ���ڵ� ���� (�ʼ�, �߿�!!!)
    pageEncoding="EUC-KR" : �� jsp�� ���� ���ڵ� ����
    �����Ұ� \ ����� ���ڷ� ���´�.
    	--%>
     
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>jsp1ScriptingTag.jsp</title>
</head>
<body>
	<h3>jsp scripting tag</h3>
	1. 5������ ����<br>
	2. ���� <br>
	<table border="1">
		<tr>
			<td>page ������</td>
			<td>jsp ���� <\%@ %></td>
			<td>import, ���� ���� ����</td>
		</tr>
		<tr>
			<td>������</td>
			<td><\%! �������, �޼ҵ� ���� tag %)]></td>
			<td> jsp���� ��� ������ �޼ҵ� ������ ���Ǵ� tag</td>
		</tr>
		<tr>
			<td>�ּ�</td>
			<td><\% --- jsp���� �ּ� --%></td>
			<td> �������� ������� �ʴ� server�ܿ����� �ؼ��Ǵ� �ּ� </td>
		</tr>
		<tr>
			<td>��Ŭ��Ʋ��</td>
			<td><\% service �޼ҵ� �����η� �ڵ� �ݿ��Ǵ� ���� �ڹ��ڵ� ����  tag %></td>
			<td>�ε����� ��찡 �ƴϸ� ��� ����</td>
			
		</tr>
		<tr>
			<td>���(expression)</td>
			<td><\%= service �޼ҵ� ������ %></td>
			<td>�������� �ڹ� ������ ��� ������ tag</td>
		</tr>

	</table>
	
	<br><hr><br>
	<%! //������ - ����, �޼ҵ� ������
	String name = "�������";
	String getName(){
	return name;
	}
	%>
	1. ��� tag : <%= name %>
	<br>
	2. �޼ҵ� ȣ���ؼ� ��� : <%= getName() %>
	<br>
	3. ��Ŭ��Ʋ�� tag�� client �������� �̸� ��� (���� �ڹ��ڵ� �� ��� ����)
	<% 
	/* out - ���, PrintWriter�� �ڽ� Ŭ����(���� ����)
	*/
	 out.println(name);
	%>
</body>
</html>