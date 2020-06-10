package com.eshore;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

@WebFilter(
		asyncSupported = true,
		description = "�ַ����������", 
		filterName = "encodingFilter", 
		urlPatterns = { "/*" },
		initParams = { 
			@WebInitParam(name = "ENCODING", value = "UTF-8")
		} 
	)
public class EncodingFilter implements Filter{

	private static Logger log = Logger.getLogger("EncodingFilter");
	private String encoding="";
	private String filterName="";
	
	public void init(FilterConfig filterConfig) throws ServletException {
		//ͨ��filterConfig��ó�ʼ���б���ֵ
		encoding = filterConfig.getInitParameter("ENCODING");
		filterName = filterConfig.getFilterName();
		if(encoding==null||"".equals(encoding)){
			encoding="UTF-8";
		}
		log.debug("��ñ���ֵ");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//�ֱ���������Ӧ���б�������
		HttpServletRequest req = (HttpServletRequest)request;
		log.debug("����"+filterName+"����");
		if("GET".equals(req.getMethod())){
			req = new RequestEncodingWrapper(req,encoding);
		}else{
			request.setCharacterEncoding(encoding);
		}
		response.setCharacterEncoding(encoding);
		//�����������������
		chain.doFilter(req, response);
		log.debug("��Ӧ��"+filterName+"����");
	}

	public void destroy() {
		log.debug("��������");
	}
}
