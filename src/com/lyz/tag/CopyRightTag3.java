package com.lyz.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class CopyRightTag3 extends BodyTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user;
	private String startY;
	private int time;

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		System.out.println("jjd");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String endY=sdf.format(new Date());
		String copyRight=user+"&nbsp;版权所有 &nbsp;&nbsp;"+startY+"-"+endY;
		try {
			pageContext.getOut().print(copyRight);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return EVAL_PAGE;
	}
	
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		BodyContent bc=getBodyContent();
		JspWriter out=getPreviousOut();
		System.out.println("jjc");
		try {
			out.write(bc.getString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(time>1) {
			time--;
			return EVAL_BODY_AGAIN;
		}
		return SKIP_BODY;
	}

	public void setUser(String user) {
		this.user=user;
	}
	public void setStartY(String startY) {
		this.startY=startY;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
}
