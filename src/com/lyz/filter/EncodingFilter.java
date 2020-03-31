package com.lyz.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

import com.lyz.wrapper.RequestEncodingWrapper;
@WebFilter(
		description = "ecodingFilter",
		filterName ="encodingFilter",
		asyncSupported = true,
		urlPatterns = {"/*"},
		initParams = {
			@WebInitParam(name="ENCODING",value="UTF-8")					
		}
		)
public class EncodingFilter implements Filter{

	String encoding="";
	String filterName="";
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("filter过滤");
		/*arg0.setCharacterEncoding(encoding);
		arg1.setCharacterEncoding(encoding);
		HttpServletRequest req=(HttpServletRequest) arg0;
		arg2.doFilter(req, arg1);*/
		HttpServletRequest req=(HttpServletRequest) arg0;
		if(req.getMethod().equals("GET")) {
			new RequestEncodingWrapper(req,encoding);
		}else {
			req.setCharacterEncoding(encoding);
		}
		arg1.setCharacterEncoding(encoding);
		System.out.println(req.getRemoteAddr());
		arg2.doFilter(req, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("filter初始化");
		encoding=arg0.getInitParameter("ENCODING");
		filterName=arg0.getFilterName();
		if(encoding!=null&&encoding.equals("")) {
			encoding="UTF-8";
		}
		System.out.println("filter过滤编码"+encoding);
	}

}
