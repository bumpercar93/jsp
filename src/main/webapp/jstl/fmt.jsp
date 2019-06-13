<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<fmt:setLocale value="ko"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="GREETING"/> <br>
		<fmt:message key="VISITOR"> <br>
			<fmt:param value="범휘"/>
		</fmt:message>
	</fmt:bundle>
	
	<hr>
	
	<fmt:setLocale value="en"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="GREETING"/> <br>
		<fmt:message key="VISITOR"> <br>
			<fmt:param value="범휘"/>
		</fmt:message>
	</fmt:bundle>
	
	<hr>
	
	<fmt:setLocale value="ja"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="GREETING"/> <br>
		<fmt:message key="VISITOR"> <br>
			<fmt:param value="범휘"/>
		</fmt:message>
	</fmt:bundle>
	
	<hr>
	
	<fmt:setLocale value="de"/>
	<fmt:setBundle basename="kr.or.ddit.msg.msg" var="msg"/>
	<fmt:message key="GREETING" bundle="${msg}"/> <br>
	<fmt:message key="VISITOR" bundle="${msg}">
		<fmt:param value="범휘"/>
	</fmt:message>
	
	<hr>
	
</body>
</html>