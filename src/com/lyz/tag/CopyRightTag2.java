package com.lyz.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.TagSupport;

public class CopyRightTag2 extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user;
	private String startY;

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
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

	public void setUser(String user) {
		this.user=user;
	}
	public void setStartY(String startY) {
		this.startY=startY;
	}
}
