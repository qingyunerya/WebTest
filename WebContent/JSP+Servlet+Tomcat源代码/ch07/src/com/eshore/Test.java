package com.eshore;

import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;

import javax.servlet.jsp.JspWriter;

public class Test {
	public void test(JspWriter out,String url) throws Exception{
		URLConnection connGzip = new URL(url).openConnection();
		connGzip.setRequestProperty("Accept-Encoding", "gzip");
		int lengthGzip = connGzip.getContentLength();//��ȡ����
		
		URLConnection connCommon = new URL(url).openConnection();
	    int lengthCommon = connCommon.getContentLength();
	    //ѹ������
	    double rate = new Double(lengthGzip)/lengthCommon;
	    NumberFormat.getPercentInstance().format(rate);
	    
	}
}
