<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<%@include file="/common/basicLib.jsp" %>
<title>Request Count</title>
</head>
	<body>
		<!-- header -->
		<%@include file="/common/header.jsp" %>
			
		<div class="container-fluid">
			<div class="row">
				<!-- left -->	
				<%@include file="/common/left.jsp" %>
		
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<div class="row">
						<div class="col-sm-8 blog-main">
							<h2 class="sub-header">Request Count</h2>
							<div class="table-responsive">
								<table class="table table-striped">
									<tr>
										<th>URI</th>
										<th>요청횟수</th>
									</tr>
									<%-- application( (servletContext() : requestMap) ) --%>
									<c:forEach items="${requestMap}" var="map">
										<tr>
											<td>${map.key}</td>
											<td>${map.value}</td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>