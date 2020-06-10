/*
 * Copyright 2003 Jayson Falkner (jayson@jspinsider.com)
 * This code is from "Servlets and JavaServer pages; the J2EE Web Tier",
 * http://www.jspbook.com. You may freely use the code both commercially
 * and non-commercially. If you like the code, please pick up a copy of
 * the book and help support the authors, development of more free code,
 * and the JSP/Servlet/J2EE community.
 */
package com.eshore;

import java.io.*;
import java.util.zip.GZIPOutputStream;
import javax.servlet.*;
import javax.servlet.http.*;

public class GZIPResponseStream extends ServletOutputStream {
	//��ѹ��������ݴ����ByteArrayOutputStream������
  protected ByteArrayOutputStream bArrayOutputStream = null;	
  	//JDK���Դ���GZIPѹ����
  protected GZIPOutputStream gzipOutputStream = null;	
  protected boolean closed = false;
  protected HttpServletResponse response = null;//ԭ�ȵ�response
  protected ServletOutputStream outputStream = null;	//response�е������
  //���췽������ʼ������ֵ
  public GZIPResponseStream(HttpServletResponse response) throws IOException {
    super();
    closed = false;
    this.response = response;
    this.outputStream = response.getOutputStream();
    bArrayOutputStream = new ByteArrayOutputStream();
    gzipOutputStream = new GZIPOutputStream(bArrayOutputStream);
  }
  //ִ��ѹ����������������������
  public void close() throws IOException {
    if (closed) {
      throw new IOException("This output stream has already been closed");
    }
    //ִ��ѹ��������Ҫ�����������
    gzipOutputStream.finish();
    //��ѹ���������������������
    byte[] bytes = bArrayOutputStream.toByteArray();
    //����ѹ���㷨Ϊgzip����������Զ���ѹ����
    response.addHeader("Content-Length",Integer.toString(bytes.length)); 
    response.addHeader("Content-Encoding", "gzip");
    //����������
    outputStream.write(bytes);
    outputStream.flush();
    outputStream.close();
    closed = true;
  }

  public void flush() throws IOException {
    if (closed) {
      throw new IOException("����ˢ�¹رյ�����");
    }
    gzipOutputStream.flush();
  }

  public void write(int b) throws IOException {
    if (closed) {
      throw new IOException("������ر��У�");
    }
    gzipOutputStream.write((byte)b);
  }

  public void write(byte b[]) throws IOException {
    write(b, 0, b.length);
  }

  public void write(byte b[], int off, int len) throws IOException {
    if (closed) {
      throw new IOException("������ر��У�");
    }
    gzipOutputStream.write(b, off, len);
  }

  public boolean closed() {
    return (this.closed);
  }
  
  public void reset() {
    //noop
  }
}
