<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/mulCalculation">
		값1 : <input type="text" name="param1"/> <br>
		값2 : <input type="text" name="param2"/> <br>
		<input type="submit" value="submit"/>
	</form>
</body>
</html>