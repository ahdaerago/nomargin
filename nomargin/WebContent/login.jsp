<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).on("click","#btn",function(){
		$("#frm_login").submit();
		
	});



</script>



</head>
<body>
	<form action = "LoginChk" method = "POST" name="frm_login" id="frm_login">
	<label>아이디 : </label>
	<input type="text" name= "id">
	<br>
	<label>비밀번호 : </label>
	<input type="password" id="pw" name="pw">
	<br>
	<div>
		<button id="btn">로그인</button>
		<button>초기화</button>
	</div>
	</form> 
</body>
</html>