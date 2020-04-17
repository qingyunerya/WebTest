package com.lyz.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.lyz.pojo.UserInfo;

public class UserInfoTag extends BodyTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserInfo user;

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		
		try {
			if(user==null) {
				JspWriter out=pageContext.getOut();
				out.print("No User Info Found");
				return SKIP_BODY;
			}
			String content="<td>"+user.getUserName()+"</td>";
			content+="<td>"+user.getAge()+"</td>";
			content+="<td>"+user.getEmail()+"</td>";
			this.pageContext.getOut().println("<tr>"+content+"</tr>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}

	
	@Override
	public void release() {
		// TODO Auto-generated method stub
		super.release();
		this.user=null;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}
	
	
}
