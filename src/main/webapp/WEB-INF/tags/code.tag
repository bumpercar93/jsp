<%@tag import="kr.or.ddit.prod.model.ProdVO"%>
<%@tag import="java.util.List"%>
<%@tag import="kr.or.ddit.prod.service.ProdServiceImpl"%>
<%@tag import="kr.or.ddit.prod.service.IProdService"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="code" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

${code}

<% 
// 	String code = (String) jspContext.getAttribute("code");
// 	IProdService prodService = new ProdServiceImpl();
// 	List<ProdVO> prodList = prodService.getProdforLgu(code);
// 	jspContext.setAttribute("prodList", prodList);

	IProdService prodService = new ProdServiceImpl();
	List<ProdVO> prodList = prodService.getProdforLgu(code);
	jspContext.setAttribute("prodList", prodList);
%>

<select>
	<c:forEach items="${prodList}" var="prodVO">
		<option id="${prodVO.prod_id}">${prodVO.prod_name}</option>		
	</c:forEach>
</select>