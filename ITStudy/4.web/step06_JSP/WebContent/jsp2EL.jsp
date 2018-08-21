<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>jsp2EL.jsp</title>

<!--����� �ػ󵵿� �����ϰ� ���� ����� �������� ������ �����ϰ� ����ǰ� �����ϴ� ����  -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- �ܺ� css ��� ��������. ���⼭ �ּ� �����ؼ� �ƿ� ������ ������������ ���� �־ ����. -->
<link rel="stylesheet" href="css/w3.css">


<body>

<div class="w3-container">
  <h2>Expression Language �н�</h2>

  <table class="w3-table-all">
  <!-- tag�� �÷Ÿ� ���� tag (th�� ���� ���� �۾�) -->
    <thead>
      <tr class="w3-light-grey w3-hover-red">
        <th>EL tag ���� ��</th>
        <th>EL tag ���� ��</th>
      </tr>
    </thead>
    <tr class="w3-hover-green">
      <td>2+3</td>
      <td>${2+3}</td>
    </tr>
    <tr class="w3-hover-blue">
      <td>6/2</td>
      <td>${6/2}</td>
    </tr>
    <tr class="w3-hover-black">
      <td>'a' == 'a'</td>
      <td>${'a' == 'a' }</td>
    </tr>
    <tr class="w3-hover-text-green">
      <td>'a' != 'a'</td>
      <td>${'a' != 'a'}</td>
    </tr>
    
    <tr class="?">
      <td>"�ѱ�" != "�ѱ�"</td>
      <td>${"�ѱ�" != "�ѱ�"}</td>
    </tr>
    
  </table>
</div>
</head>

</body>
</html>