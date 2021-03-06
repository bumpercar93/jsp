<%@page import="java.util.Date"%>
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
	<h2>formatDate</h2>
	<c:set var="dt" value="<%=new Date()%>"/>
	dt : ${dt} <br>
	dt : <fmt:formatDate value="${dt}"/> <br>
	dt(pattern) : <fmt:formatDate value="${dt}" pattern="yyyy-MM-dd a hh:mm:ss"/> <br>
	dt(full) : <fmt:formatDate value="${dt}" type="date" dateStyle="full"/> <br>
	dt(long) : <fmt:formatDate value="${dt}" type="date" dateStyle="long"/> <br>
	dt(medium) : <fmt:formatDate value="${dt}" type="date" dateStyle="medium"/> <br>
	dt(short) : <fmt:formatDate value="${dt}" type="date" dateStyle="short"/> <br>
	dt(time) : <fmt:formatDate value="${dt}" type="time"/> <br>
	dt(both) : <fmt:formatDate value="${dt}" type="both"/> <br>
	
	<h3>de</h3>
	<fmt:setLocale value="de_DE"/>
	dt : <fmt:formatDate value="${dt}"/> <br>
	
	<h2>parseDate (String -> Date / 2019.6.13 -> Date)</h2>
	<fmt:setLocale value="ko_KR"/>
	<c:set value="2019.6.13" var="dtStr"/>
	dtStr : ${dtStr} <br>
	dtStr : <fmt:parseDate value="${dtStr}" pattern="yyyy.MM.dd"/> <br>
	
</body>
</html>