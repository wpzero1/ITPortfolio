<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>TMS - ��ü��ǰ ��ȸ</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans:400,300'>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="css/style.css">
</head>


<body>
<c:if test="${sessionScope.cust_email == null}">
	alert("�α��� �� �̿밡���մϴ�.");
		location.href='loginindex.html';
</c:if>

<c:if test="${not empty sessionScope.cust_email}">
	<div class="cont_principal">
    	<div class="cont_back_info">
    
			<form action="cont" method="post">
				<br><h3>��ü��ǰ ���</h3>
				<br>
				<p> ��ü��ǰ���� ����, ��ü��¥�� �����ϼ���. </p>
				<br>
				<b>��ü��ǰ��</b>
				<br>
				<select name="compo_name">
			    	<option value="��������">��������</option>
			    	<option value="���͸�">���͸�</option>
			    	<option value="�ð���">�ð���</option>
			   	 	<option value="����̼ǿ���">����̼ǿ���</option>
			   	 	<option value="�극��ũ����">�극��ũ����</option>
			  	</select>
  	
  				<br>
				<b>��ü��¥</b>
				<br>
				<input type="date" name="replacedate"><br>
				<input type="hidden" name="command" value="replaceCompo">
			    <button type="submit" value="��ü��¥���" class="btn_login" onclick="cambiar_login()">��ü��¥���</button>
			</form>
			<c:if test="${requestScope.result == 'success'}">
				<script>
					alert("��ǰ ��ü ����"); 
					location.href='${pageContext.request.contextPath}/cont?command=allCompoState';
				</script>
			</c:if>
			
			<c:if test="${requestScope.result == 'fail'}">
				<script>alert("��ǰ ��ü ����");</script>
			</c:if>
			
			<br>
			<h3>��ü��� ��ȸ</h3>
			<br>
			<p>��ȸ�ϰ� ���� ��ǰ/�Ҹ�ǰ�� �����ϼ���.</p>
			<!-- <form action="cont" method="post">
			  	<select name="compo_name">
			    	<option value="��������">��������</option>
			    	<option value="���͸�">���͸�</option>
			    	<option value="�ð���">�ð���</option>
			   	 	<option value="����̼ǿ���">����̼ǿ���</option>
			   	 	<option value="�극��ũ����">�극��ũ����</option>
			  	</select>
			  <br>
			  <div class="w3-container">
			  <input type="hidden" name="command" value="allCompoHist">
			  <button type="submit" value="��ȸ" class="btn_login" onclick="cambiar_login()">��ȸ</button>
			  
			  </form> -->
			  
			  	<select name="compo_name" id="compo_name">
			    	<option value="��������">��������</option>
			    	<option value="���͸�">���͸�</option>
			    	<option value="�ð���">�ð���</option>
			   	 	<option value="����̼ǿ���">����̼ǿ���</option>
			   	 	<option value="�극��ũ����">�극��ũ����</option>
			  	</select>
			  <br>
			  <div class="w3-container">
			  <button type="submit" value="��ȸ" class="btn_login" onclick="reqAjax()">��ȸ</button>
			  
			  <script type="text/javascript">
			  	function reqAjax(){
			  		var xhttp = new XMLHttpRequest();
					xhttp.onreadystatechange = function() {
						if (this.readyState == 4 && this.status == 200) {
							var data = this.responseText;
							document.getElementById('id01').style.display='block';
							
							document.getElementById("dataAll").innerHTML = data;
							
							
							
							
						}
					};
					//xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
					reqData = encodeURIComponent(document.getElementById("compo_name").value);
					xhttp.open("get", "cont?command=allCompoHist&compo_name=" + reqData, true);
					
					xhttp.send();
			  		
			  	}
			  </script>
			  
			  
			  
			  
			  <div id="id01" class="w3-modal">
   				 <div class="w3-modal-content">
     				 <div class="w3-container">
     				   <!-- <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-display-topright">&times;</span> -->
       					<span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-display-topright">&times;</span>
       					
       					 <p><b>��ü��� ��ȸ ���</b></p>
       				
       					 	<div id="dataAll"></div>
    				  </div>
   	 			</div>
 			 </div>
		</div>
  
	</div>
	</div>
</c:if>
	</body>
	
</html>