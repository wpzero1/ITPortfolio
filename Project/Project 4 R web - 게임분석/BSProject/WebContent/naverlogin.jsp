<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div id="naverIdLogin"></div>
<script type="text/javascript">
	var naverLogin = new naver.LoginWithNaverId(
		{
			clientId: "RFyildn4uMI8i7iHXz4C",
			callbackUrl: "http://localhost:8080/upload/callback.jsp",
			isPopup: true, /* �˾��� ���� ����ó�� ���� */
			loginButton: {color: "green", type: 3, height: 60} /* �α��� ��ư�� Ÿ���� ���� */
		}
	);
	
   /* ���������� �ʱ�ȭ�ϰ� ������ �غ� */
	naverLogin.init();
   
	naverLogin.getLoginStatus(function (status) {
		if (status) {
			var email = naverLogin.user.getEmail();
			var name = naverLogin.user.getNickName();
			var profileImage = naverLogin.user.getProfileImage();
			var birthday = naverLogin.user.getBirthday();			var uniqId = naverLogin.user.getId();
			var age = naverLogin.user.getAge();
		} else {
			console.log("AccessToken�� �ùٸ��� �ʽ��ϴ�.");
		}
	});
</script>
</body>
</html>