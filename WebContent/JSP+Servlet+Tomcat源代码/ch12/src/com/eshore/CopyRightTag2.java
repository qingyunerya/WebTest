package com.eshore;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class CopyRightTag2 extends BodyTagSupport{
	
	private String user;
	private String startY;
    @Override
    public int doStartTag(){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    	String endY = sdf.format(new Date());
    	String copyRight = user+"&nbsp;��Ȩ����&nbsp;&nbsp;"+startY+"-"+endY;
    	try {
			pageContext.getOut().print(copyRight);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return EVAL_PAGE; 
    }
    public int doAfterBody(){
    	//ȡ�ñ�ǩ��
    	BodyContent bc = getBodyContent();
    	JspWriter out = getPreviousOut();
    	try{
    		//����ǩ���е�����д�뵽JSPҳ����
    		out.write(bc.getString());
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    	return EVAL_BODY_AGAIN;
    }
    public int doEndTag(){
    	return EVAL_PAGE;
    }
	public void setUser(String user) {
		this.user = user;
	}
	public void setStartY(String startY) {
		this.startY = startY;
	}
    
}
