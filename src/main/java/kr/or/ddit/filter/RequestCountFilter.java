package kr.or.ddit.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class RequestCountFilter implements Filter {
	// key : value
	// /jsp/login : 10번
	// /jsp/userList : 20번
	private Map<String, Integer> requestMap;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		// 요청이 올때마다 uri를 체크해서 requestMap에 데이터를 한건씩 증가시켜준다.
		String uri = ((HttpServletRequest)request).getRequestURI();
		int reqCount = requestMap.getOrDefault(uri, 0);
		reqCount++;
		requestMap.put(uri, reqCount);
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		requestMap = new HashMap<String, Integer>();
		requestMap.put("testNum", 7);
		fConfig.getServletContext().setAttribute("requestMap", requestMap);
	}

}
