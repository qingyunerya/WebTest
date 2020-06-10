package com.eshore;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.eshore.pojo.User;

public class JAXBMarshalDemo {

	public static void main(String[] args) {
		//����XML���󣬽���������F����
        File file = new File("F:\\user.xml");
        //����һ��JAXBContext����
        JAXBContext jaxbContext;
        try {
        	//ָ��ӳ����ഴ��JAXBContext�����������
			jaxbContext = JAXBContext.newInstance(User.class);
			//����ת������Marshaller
			Marshaller m = jaxbContext.createMarshaller();
			//����XML�ļ��е�����
//			User user = new User("����", "zhangsan", "30", "��","�����������", "һ�������Ĺ���ʦ");
//			//��Java��User����ת����XML
//			m.marshal(user, file);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
