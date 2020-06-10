package com.eshore;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class JAXBSAXDemo extends DefaultHandler{

	private String preTag;
	 
	//�����ĵ���ʼ��֪ͨ
	@Override
    public void startDocument() throws SAXException {
        preTag = null;

    }
	//����Ԫ�ؿ�ʼ��֪ͨ
	@Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
		if("user".equals(qName)) {
            System.out.println(qName+"�ڵ��country����ֵΪ��"+attributes.getValue("country"));
        }
        if("address".equals(qName)){
        	System.out.println(qName+"�ڵ��state����ֵΪ��"+attributes.getValue("state"));
        }
        preTag = qName;
    }
    
	//����Ԫ�ؽ�����֪ͨ
	@Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        preTag = null;
    }

    //����Ԫ�������ݵ�֪ͨ����ִ����startElement��endElement����֮��ִ��
    public void characters(char ch[], int start, int length)throws SAXException {
        String value = new String(ch, start, length);
        if("name".equals(preTag)) {
            System.out.println("name�ڵ��ֵΪ��"+value);
        } else if("english_name".equals(preTag)) {
        	System.out.println("english_name�ڵ��ֵΪ��"+value);
        }else if("age".equals(preTag)){
        	System.out.println("age�ڵ��ֵΪ��"+value);
        }else if("sex".equals(preTag)){
        	System.out.println("sex�ڵ��ֵΪ��"+value);
        }else if("description".equals(preTag)){
        	System.out.println("description�ڵ��ֵΪ��"+value);
        }
        if("city".equals(preTag)) {
        	System.out.println("city�ڵ��ֵΪ��"+value);
        } else if("area".equals(preTag)) {
        	System.out.println("area�ڵ��ֵΪ��"+value);
        } 
    }

    public static void main(String[] args) throws Exception {
        //��XMLReaderFactory�� ����XMLReaderʵ��
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        //����һ�¼�������
        JAXBSAXDemo handler = new JAXBSAXDemo();
        //XMLReader�������趨�¼�������
        xmlReader.setContentHandler(handler);
        //XMLReader���������XML�ļ�
        xmlReader.parse("F:\\users.xml");
    }
}
