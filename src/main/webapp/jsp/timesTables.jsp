<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- localhost/jsp/jsp/timesTables.jsp -->
	<!-- 9*9단 출력 (2~9단) -->
	<% 
		String param1 = request.getParameter("i");
		String param2 = request.getParameter("j");
		int num1 = Integer.parseInt(param1);
		int num2 = Integer.parseInt(param2);
	%>
	<table border="1">
		<% for(int i = 1 ; i < num1+1; i++){ %>
			<tr>
				<% for(int j = 2 ; j < num2+1 ; j++){
					String temp = j + " * " + i + " = " + (i*j); %>
					<td> <%= temp %> </td>
				<% } %>
			</tr>
		<% } %>
	</table>
</body>
</html>