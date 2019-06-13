<%@page import="java.util.Date"%>
<%@page import="java.util.TimeZone"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>TimeZone</h2>
	<c:set value="<%=new Date()%>" var="dt"/>
	dt : <fmt:formatDate value="${dt}" type="both"/> <br>
	
	<fmt:setTimeZone value="Poland" var="pol"/>
	dt : <fmt:formatDate value="${dt}" timeZone="${pol}" type="both"/> <br>
	
	<fmt:timeZone value="Poland">
	dt : <fmt:formatDate value="${dt}" type="both"/> <br>
	</fmt:timeZone>
	
<%-- 	<c:forEach items="<%=TimeZone.getAvailableIDs() %>" var="timeZone"> --%>
<%-- 		${timeZone} <br> --%>
<%-- 	</c:forEach> --%>
</body>
</html>