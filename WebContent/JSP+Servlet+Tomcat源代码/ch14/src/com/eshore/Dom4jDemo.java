package com.eshore;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jDemo {

	/**
	 * Dom4j����XML�ļ�
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//������������XML�ļ�����ָ��Ŀ¼
        File file = new File("F:\\users.xml");
        //ָ��XML������SAXReader
		SAXReader saxReader = new SAXReader();
		try {
			//SAXReader����XML�ļ�
			Document document = saxReader.read(file);
			//ָ��Ҫ�����Ľڵ�
			List<Element> list = document.selectNodes("/users/user" );
			for(Element element:list){
				//��ýڵ�country����ֵ
				 System.out.println("country----"+element.attributeValue("country"));;
				 //��ýڵ���ӽڵ�
				 List<Element> childList = element.elements();
				 //�����ڵ���ӽڵ�
				 for(Element childelement:childList){
					 //�����address�ӽڵ㣬����address����Ԫ��
					 if("address".equals(childelement.getName())){
						//��ýڵ�state����ֵ
						System.out.println("state----"+childelement.attributeValue("state"));
						//����addressԪ�ص���Ԫ��
						List<Element> addressElements =  childelement.elements();
						for(Element e:addressElements){
							System.out.println(e.getName()+"----"+e.getText());
						}
					 }
					System.out.println(childelement.getName()+"----"+childelement.getText());
				 }
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
