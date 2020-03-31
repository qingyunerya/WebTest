package com.lyz.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyz.wrapper.GZIPResponseWrapper;

@WebFilter(
		description = "内容压缩",
		filterName = "gzipFilter",
		asyncSupported = true,
		urlPatterns = "/*"
		)
public class GZIPFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("压缩过滤");
		HttpServletResponse res=(HttpServletResponse) arg1;
		HttpServletRequest req=(HttpServletRequest)arg0;
		String ae=req.getHeader("Accept-Encoding");
		if(ae!=null&&(ae.toLowerCase().indexOf("gzip")!=-1)) {
			GZIPResponseWrapper wr=new GZIPResponseWrapper(res);
			arg2.doFilter(arg0, arg1);
			wr.finishResponse();
			return;
		}
		arg2.doFilter(req, res);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("压缩过滤初始化");
	}

}
