<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		out.write("application.getContextPath() : " + application.getContextPath() + "<br>");
		out.write("application.getServerInfo() : " + application.getServerInfo() + "<br>");
		out.write("application.getMajorVersion() : " + application.getMajorVersion() + "<br>");
		out.write("application.getMinorVersion() : " + application.getMinorVersion() + "<br>");
		out.write("application.getInitParameter(\"ADMIN\") : " + application.getInitParameter("ADMIN") + "<br>");
		
		out.write("application.getRealPath(\"/res/190522.txt\") : " + application.getRealPath("/res/190522.txt") + "<br>");
		
		try {
			
			FileInputStream fin = new FileInputStream(application.getRealPath("/res/190522.txt"));
			InputStreamReader isr = new InputStreamReader(fin, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			char[] buff = new char[512];
			
			int c = -1; // 읽어온 데이터를 저장할 변수
			while((c = br.read(buff)) != -1){ // 한 문자씩 읽어오기
				out.write(buff); // 읽어온 문자를 콘솔에 출력하기
			}

			br.close();

		} catch (IOException e) {
			System.out.println("입출력 오류");
			e.printStackTrace();
		}
	

		
	%>
</body>
</html>