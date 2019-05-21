package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Gugudan extends HttpServlet{
	
	private Logger logger = LoggerFactory.getLogger(Gugudan.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		// localhost/jsp/timesTables?param=6
		
		String param1 = req.getParameter("i");
		// trace / debug / info / warn / error
		logger.debug("i : {}", param1);
		String param2 = req.getParameter("j");
		logger.debug("j : {}", param2);
		
		int temp1 = Integer.parseInt(param1);
		int temp2 = Integer.parseInt(param2);
		
		String gugudan = "";
		pw.write("<html>");
		pw.write("	<head>");
		pw.write("		<title>Gugudan</title>");
		pw.write("	</head>");
		pw.write("	<body>");
		pw.write("		<table border=1>");
		for (int i = 1; i < (temp2+1); i++) {
			gugudan += "<tr>";
			for (int j = 2; j < (temp1+1); j++) {
				gugudan += "<td>";
				gugudan += j + " * " + i + " = " + (i*j);
				gugudan += "</td>";
			}
			gugudan += "</tr>";
		}
		pw.write(gugudan);
		pw.write("		</table>");
		pw.write("	</body>");
		pw.write("</html>");
		
		pw.close();
	}
	
}
