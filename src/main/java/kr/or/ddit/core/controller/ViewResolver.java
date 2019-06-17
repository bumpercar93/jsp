package kr.or.ddit.core.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViewResolver {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ViewResolver.class);
	
	public static void viewResolve(HttpServletRequest request, HttpServletResponse response, String viewName) 
			throws IOException, ServletException {
		// viewName redirect:로 시작할 경우 redirect
		// 그 외에는 forward
		logger.debug("ViewResolver.viewResolve : {}", viewName);
		if(viewName.startsWith("redirect:"))
			response.sendRedirect(viewName.substring("redirect:".length()));
		else
			request.getRequestDispatcher(viewName).forward(request, response);
	}
}
