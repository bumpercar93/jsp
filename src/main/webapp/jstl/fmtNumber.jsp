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
	<%-- <%pageContext.setAttribute("num", 1000000.55);%> --%>
	
	<h2>formatNumber (number -> String / 1000000 -> 1,000,000)</h2>
	
	<c:set value="1000000.55" var="num"/>
	num : ${num} <br>
	
	<fmt:setLocale value="ko_KR"/>
	ko : <fmt:formatNumber value="${num}"/> <br>
	ko : <fmt:formatNumber value="${num}" type="currency"/> <br>
	ko : <fmt:formatNumber value="${num}" type="percent"/> <br>
	
	<fmt:setLocale value="de_DE"/>
	de : <fmt:formatNumber value="${num}"/> <br>
	de : <fmt:formatNumber value="${num}" type="currency"/> <br>
	de : <fmt:formatNumber value="${num}" type="percent"/> <br>
	
	<h2>parseNumber (String -> number / 1,000,000 -> 1000000)</h2>
	
	<c:set value="1,000,000" var="numStr" />
	numStr : ${numStr} <br>
	
	<fmt:setLocale value="ko"/>
	parseNumber numStr : <fmt:parseNumber value="${numStr}" pattern="0,000"/>
	
</body>
</html>