<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="color" type="java.lang.String" required="true" %>
<%@ attribute name="size" type="java.lang.Integer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <c:if test="${size == null}"> --%>
<%-- 	<c:set value="5" var="size" /> --%>
<%-- </c:if> --%>

<font color="${color}" >
	<c:forEach begin="1" end="${size == null ? 5 : size}">=</c:forEach>
</font>