<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>TMS - ��ü��ǰ ��ȸ</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans:400,300'>
	<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
	<link rel="stylesheet" href="css/style2.css">
</head>


<body>
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
	
			<br>
			<br>
			<h3>��ü��� ��ȸ</h3>
			<br>
			<p>��ȸ�ϰ� ���� ��ǰ/�Ҹ�ǰ�� �����ϼ���.</p>
			<form action="cont" method="post">
			  	<select name="compo_name">
			    	<option value="��������">��������</option>
			    	<option value="���͸�">���͸�</option>
			    	<option value="�ð���">�ð���</option>
			   	 	<option value="����̼ǿ���">����̼ǿ���</option>
			   	 	<option value="�극��ũ����">�극��ũ����</option>
			  	</select>
			  <br>
			  
			  <input type="hidden" name="command" value="allCompoHist">
			  <button type="submit" value="��ȸ" class="btn_login" onclick="cambiar_login()">��ȸ</button>
			</form>		
			<br>
			<br>			
		</div>
	</div>
	<script>
		// Get the modal
		var modal = document.getElementById('id01');
		
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		    if (event.target == modal) {
		        modal.style.display = "none";
		    }
		}
	</script>
</body>
</html>