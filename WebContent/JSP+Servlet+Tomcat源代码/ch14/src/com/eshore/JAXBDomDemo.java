package com.eshore;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JAXBDomDemo {

	/**
	 * ��dom����XML�ļ�
	 */
	public static void main(String[] args) {
		//������������XML�ļ�����ָ��Ŀ¼
        File file = new File("F:\\users.xml");
        //�õ���ģʽ����DocumentBuilderFactory����
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //����һ��DocumentBuilder����
        DocumentBuilder documentBuilder =null;
        try {
        	 //ͨ��DocumentBuilderFactory����DocumentBuilder����
			 documentBuilder = factory.newDocumentBuilder();
			 //DocumentBuilder����xml�ļ�
			 Document document = documentBuilder.parse(file);
			 //���xml�ĵ��еĸ�Ԫ��
			 Element root = document.getDocumentElement();
			 //�����Ԫ�ص�����
			 System.out.println("��Ԫ�أ�"+root.getNodeName());
			 //��ø�Ԫ���µ��ӽڵ�
			 NodeList childNodes = root.getChildNodes();
			 //������Ԫ���µ��ӽڵ�
			 for(int i=0;i<childNodes.getLength();i++){
				 //��ø�Ԫ���µ��ӽڵ�
				 Node node = childNodes.item(i);
				 System.out.println("�ڵ������Ϊ"+node.getNodeName());
				 //����ӽڵ��country����ֵ
				 String attributeV = node.getAttributes().
				 getNamedItem("country").getNodeValue();
				 System.out.println(node.getNodeName()+"�ڵ��country����ֵΪ"+attributeV);
				 //���node�ӽڵ��¼���
				 NodeList nodeChilds = node.getChildNodes();
				 //����node�ӽڵ��¼���
				 for(int j=0;j<nodeChilds.getLength();j++){
					 Node details = nodeChilds.item(j);
					 String name = details.getNodeName();
					 //�ж������addressԪ�أ���ȡ���ӽڵ�
					 if("address".equals(name)){
						 NodeList addressNodes = details.getChildNodes();
						//����addressԪ�ص��ӽڵ�
						 for(int k=0;k<addressNodes.getLength();k++){
							 Node addressDetail = addressNodes.item(k);
							 System.out.println(node.getNodeName()+"�ڵ���ӽڵ�"+name+"�ڵ���ӽڵ�"+
							addressDetail.getNodeName()+" �ڵ�����Ϊ��"+addressDetail.getTextContent());
						 }
						 String addressAtt = details.getAttributes().getNamedItem("state").getNodeValue();
						 System.out.println(name+"�ڵ��state����ֵΪ"+addressAtt);
					 }
					 System.out.println(node.getNodeName()+"�ڵ���ӽڵ�"+details.getNodeName()+
							 " �ڵ�����Ϊ��"+details.getTextContent());
				 }
			 }
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (SAXException e) {
			e.printStackTrace();
		}
	}
}
