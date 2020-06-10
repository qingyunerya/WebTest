package com.eshore;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class IfTag extends BodyTagSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean value;
    /** *//**
     *�������Ե�ֵ��
     */
    public void setValue(boolean value)
    {
        this.value=value;
    }
    
    /** *//**
     *doStartTag���������valueΪtrue����ô
     *�ͼ���tagbody��ֵ�����򲻼���body��ֵ��
     */
    public int doStartTag() throws JspTagException
    {
        if(value)
        {
           System.out.println("value is true");
           return EVAL_BODY_INCLUDE; 
         }  
         else
         { 
           System.out.println("value is false");
            return SKIP_BODY; 
         } 
    }
    /** *//**
     *����doEndTag����
     */
    public int doEndTag() throws JspTagException 
    {
        try 
        {  
             if(bodyContent != null)  
             {
                 bodyContent.writeOut(bodyContent.getEnclosingWriter()); 
             }
        } 
        catch(java.io.IOException e)
        {
            throw new JspTagException("IO Error: " + e.getMessage());  
        }   
        return EVAL_PAGE;  
    }
}
