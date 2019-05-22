<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 어디로 요청을 보낼지?? form태그 action속성을 이용 
		 어떻게 보낼지 (http method) ?? form태그 method 속성 (get-default/post) -->
	<%-- /login/login.jsp -> /login/loginProcess.jsp --%>
	
	<form action="<%=request.getContextPath()%>/login/loginProcess.jsp" method="post">
		UserID : <input type="text" name="userId" value="sally"/> <br>
		UserID : <input type="text" name="userId" value="셀리"/> <br>
		Password : <input type="password" name="password" value="pass1234"/> <br>
		<input type="submit" value="로그인"/> <br> 
	</form>
	
</body>
</html>