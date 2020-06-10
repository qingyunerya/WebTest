package com.eshore;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
public class ChildTag extends TagSupport {
	
	private static final long serialVersionUID = 1L;
	//�����ǩ����key��value
	private String key;
	private String value;
	public String getKey(){
		return key;
	}
	public void setKey(String key){
		this.key = key;
	}
	public String getValue(){
		return value;
	}
	public void setValue(String value){
		this.value = value;
	}
	
	public int doStartTag() throws JspException {
		ParentTag pTag = (ParentTag) this.getParent();
		//���ø���ǩ��addValue������������ǩ�е�map��ֵ
		pTag.addValue(key,value);
		return EVAL_BODY_INCLUDE;
	}
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}