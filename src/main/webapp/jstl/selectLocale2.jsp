<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/common/basicLib.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#selectBox").val("${locale}");
		$("#selectBox").on("change", function() {
			$("#frm").submit();
		});
	});
</script>
</head>
<body>
	
	<form id="frm" action="${cp}/selectLocale2">
		<select id="selectBox" name="locale">
			<option value="ko">한국어</option>
			<option value="en">English</option>
			<option value="ja">日本言</option>
		</select>
	</form>
	
	<fmt:setLocale value="${locale}"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="GREETING"/> <br>
		<fmt:message key="VISITOR"> <br>
			<fmt:param value="범휘"/>
		</fmt:message>
	</fmt:bundle>
	
</body>
</html>