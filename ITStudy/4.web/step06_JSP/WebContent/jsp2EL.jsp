<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>jsp2EL.jsp</title>

<!--기기의 해상도와 무관하게 가로 사이즈를 기준으로 비율이 동일하게 실행되게 설정하는 문장  -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 외부 css 사용 설정문장. 여기서 주소 복사해서 아예 폴더에 오프라인으로 갖고 있어도 좋다. -->
<link rel="stylesheet" href="css/w3.css">


<body>

<div class="w3-container">
  <h2>Expression Language 학습</h2>

  <table class="w3-table-all">
  <!-- tag의 컬렴명 적용 tag (th는 좀더 굵은 글씨) -->
    <thead>
      <tr class="w3-light-grey w3-hover-red">
        <th>EL tag 적용 전</th>
        <th>EL tag 적용 후</th>
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
      <td>"한글" != "한글"</td>
      <td>${"한글" != "한글"}</td>
    </tr>
    
  </table>
</div>
</head>

</body>
</html>