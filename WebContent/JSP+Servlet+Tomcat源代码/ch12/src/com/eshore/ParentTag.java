package com.eshore;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
public class ParentTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	
	private Map<String,String> map = new HashMap<String,String>();
	//��ǩ����id
	private String id ;
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	//�÷������ӱ�ǩ�е��ã�������ǩ�е�map��ֵ
	public void addValue(String key,String value){
		map.put(key,value);
	}
	/**
	 *  doStartTag()��������һ������ֵ��������������ĺ������̡� 
	 *��A.Tag.SKIP_BODY����ʾ��ǩ֮������ݱ����� 
	 *��B.Tag.EVAL_BODY_INCLUDE����ʾ��ǩ֮������ݱ�����ִ�� 
	 */
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			Set<String> keySet = map.keySet();
			Iterator<String> it = keySet.iterator();
			while(it.hasNext()){
				String key = it.next();
				String value = map.get(key);
				out.write(id +": <input type='text' name="+key+" value="+value+" /><br>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}
	/** 
	 *  doEndTag����JSP���������Զ����ǩ�Ľ�����־���ͻ����doEndTag()������doEndTag()����Ҳ����һ������ֵ��������������������̡� 
����	 *	A.Tag.SKIP_PAGE����ʾ����ִֹͣ����ҳ����ҳ��δ����ľ�̬���ݺ�JSP������������κ����е�����������̷��ص��ͻ���������ϡ� 
����	 *	B.Tag.EVAL_PAGE����ʾ�������������̼���ִ��JSP��ҳ 
	 */
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}