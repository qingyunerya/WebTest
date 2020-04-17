package com.lyz.tag;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
public class TableTag extends BodyTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection items;
	private Iterator it;
	private String var;

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		System.out.println("jjt");

		if(items==null||items.size()==0)return SKIP_BODY;
		it=items.iterator();
		if(it.hasNext()) {
			pageContext.setAttribute(var, it.next());
					}
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		if(it.hasNext()) {
			pageContext.setAttribute(var, it.next());
			System.out.println("ddt");
			return EVAL_BODY_AGAIN;
		}
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}

	public Collection getItems() {
		return items;
	}

	public void setItems(Collection items) {
		this.items = items;
	}

	public Iterator getIt() {
		return it;
	}

	public void setIt(Iterator it) {
		this.it = it;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}
	
}
