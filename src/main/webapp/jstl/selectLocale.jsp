<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/common/basicLib.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {
		
		var hiVal = $("#hi1").val();
		if(hiVal == null)
			$("#ko").attr("selected", "selected");
		else
			$("#" + hiVal).attr("selected", "selected");
		
		
		$("#selectBox").on("change", function() {
			var sbVal = $("#selectBox").val();
			$("#hi2").val(sbVal);
			$("#frm").submit();
		});
		
	});
</script>
</head>
<body>
	<h2>select locale</h2>
	
	<form id="frm" action="${pageContext.request.contextPath}/selectLocale" method="post">
		<input id="hi1" type="hidden" value="${locale}" />
		<input id="hi2" type="hidden" name="hi2" />
		
		<select id="selectBox">
			<option id="ko" value="ko">한국어</option>
			<option id="en" value="en">English</option>
			<option id="ja" value="ja">日本言</option>
		</select>
		
		<br>
		
		<c:choose>
			<c:when test="${locale == null}">
				<fmt:setLocale value="ko"/>
			</c:when>
			<c:otherwise>
				<fmt:setLocale value="${locale}"/>
			</c:otherwise>
		</c:choose>
		
		<fmt:bundle basename="kr.or.ddit.msg.msg">
			<fmt:message key="GREETING"/> <br>
			<fmt:message key="VISITOR"> <br>
				<fmt:param value="범휘"/>
			</fmt:message>
		</fmt:bundle>
	</form>
	
</body>
</html>