<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CustomTag</title>
</head>
<body>
	1. 고정문자열 : ==================================================== <br>
	2. loop : <c:forEach begin="1" end="53" >=</c:forEach> <br>
	3. logging(customTag) : <ct:logging/> <br>
	4. loopLogging(customTag) : <ct:loopLogging/> <br>
	5. colorLogging(customTag) : <ct:colorLogging color="red" size="10"/> <br>
	6. colorLogging(customTag) : <ct:colorLogging color="blue"/> <br>
	7. rangers : <ct:rangers rangers="brown,cony,james,sally,moon"/> <br>
	8. code : <ct:code code="P201"/>
</body>
</html>