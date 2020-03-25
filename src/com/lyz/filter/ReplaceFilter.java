package com.lyz.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;

import com.lyz.wrapper.ResponseReplaceWrapper;


@WebFilter(
	description="内容替换过滤器",
	filterName="replaceFilter",
	urlPatterns = {"/*"},
	initParams = {
			@WebInitParam(name="filePath",value = "replace_ZH.properties")
	}
)
public class ReplaceFilter implements Filter{

	private Properties  pro=new Properties();
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("内容过滤");
		HttpServletResponse res=(HttpServletResponse)arg1;
		ResponseReplaceWrapper resp=new ResponseReplaceWrapper(res);
		arg2.doFilter(arg0, resp);
		String outString=resp.getCharWritter().toString();
		for(Object o:pro.keySet()) {
			String key=(String)o;
			outString=outString.replace(key,pro.getProperty(key));
			System.out.println(key);
		}
		PrintWriter out=res.getWriter();
		out.println(outString);
		//System.out.println(outString);
		//res.getWriter().println("你好");
		/*arg1.getWriter().println("dfdf");*/
		//System.out.println("dfd");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("内容过滤器");
		String path=arg0.getInitParameter("filePath");
		try {
			pro.load(ReplaceFilter.class.getResourceAsStream(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
