<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/sumCalculation" method="post">
		start : <input type="number" name="start"/> <br>
		end : <input type="number" name="end"/> <br>
		<input type="submit" value="submit"/>
	</form>
</body>
</html>