package com.eshore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.eshore.pojo.Address;
import com.eshore.pojo.User;
import com.eshore.pojo.Users;

public class JAXBUnmarshalDemo {

	public static void main(String[] args) {
		//����XML���󣬽���������F����
        File file = new File("F:\\user.xml");
        //����һ��JAXBContext����
        JAXBContext jaxbContext;
        try {
        	//ָ��ӳ����ഴ��JAXBContext�����������
			jaxbContext = JAXBContext.newInstance(User.class);
			//����ת������Marshaller
			Unmarshaller u = jaxbContext.createUnmarshaller();
			User user = (User)u.unmarshal(file);
			//��������е�����
//			System.out.println("����----"+user.getName());
//			System.out.println("Ӣ������----"+user.getEnglish_name());
//			System.out.println("����----"+user.getAge());
//			System.out.println("�Ա�----"+user.getSex());
//			System.out.println("��ַ----"+user.getAddress());
//			System.out.println("����----"+user.getDescription());

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
