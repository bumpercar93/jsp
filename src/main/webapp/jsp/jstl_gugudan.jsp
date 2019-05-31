<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 	<c:set var="userId" value="${USER_INFO.alias}" scope="request"/> --%>
	
	<c:set var="gob" value="${param.gob}"/>
	<c:set var="dan" value="${param.dan}"/>
	
	<c:if test="${param.gob == null}">
		<c:set var="gob" value="9"/>
	</c:if>
	
	<c:if test="${param.dan == null}">
		<c:set var="dan" value="9"/>
	</c:if>
	
	<table border="1">
		<c:forEach var="i" begin="1" end="${gob}" >
			<tr>
			<c:forEach var="j" begin="2" end="${dan}">
				<td>${j} * ${i} = ${j*i}
			</c:forEach>
			</tr>
		</c:forEach>
	</table>

</body>
</html>