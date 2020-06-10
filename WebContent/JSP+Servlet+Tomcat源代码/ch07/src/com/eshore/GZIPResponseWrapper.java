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
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GZIPResponseWrapper extends HttpServletResponseWrapper {
  //ԭʼ��response
  private HttpServletResponse response = null;
  //�Զ����outputStream,������ѹ�����������
  private ServletOutputStream outputStream = null;
  //�Զ���PrintWriter,�����������ServletOutputStream
  private PrintWriter printWriter = null;

  public GZIPResponseWrapper(HttpServletResponse response) {
    super(response);
    this.response = response;
  }

  //��GZIPResponseStream���������
  public ServletOutputStream createOutputStream() throws IOException {
    return (new GZIPResponseStream(response));
  }
  //ִ��������������ݽ���GZIPѹ������������������
  public void finishResponse() {
    try {
      if (printWriter != null) {
    	  printWriter.close();
      } else {
        if (outputStream != null) {
        	outputStream.close();
        }
      }
    } catch (IOException e) {}
  }
  //ˢ��ServletOutputStream�����
  public void flushBuffer() throws IOException {
	  outputStream.flush();
  }
  //����getOutputStream�������������������
  public ServletOutputStream getOutputStream() throws IOException {
    if (printWriter != null) {
      throw new IllegalStateException("getWriter() has already been called!");
    }

    if (outputStream == null)
    	outputStream = createOutputStream();
    return (outputStream);
  }
  //����getWriter�����������ַ�����
  public PrintWriter getWriter() throws IOException {
    if (printWriter != null) {
      return (printWriter);
    }

    if (outputStream != null) {
      throw new IllegalStateException("getOutputStream() has already been called!");
    }

    outputStream = createOutputStream();
    printWriter = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"));
   return (printWriter);
  }
  //ѹ�������ݳ����б仯�����Բ�����д�÷���
  public void setContentLength(int length) {}
}
