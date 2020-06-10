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

public class JAXBComplexUnmarshalDemo {

	public static void main(String[] args) {
		//����XML���󣬽���������F����
		File file = new File("F:\\users.xml");
		//����һ��JAXBContext����
		JAXBContext jaxbContext;
		try {
			//ָ��ӳ����ഴ��JAXBContext�����������
			jaxbContext = JAXBContext.newInstance(Users.class);
			//����ת������Unmarshaller 
			Unmarshaller u = jaxbContext.createUnmarshaller();
			//ת��ָ��XML�ĵ�ΪJava����
			Users users = (Users)u.unmarshal(file);
			List<User> list = users.getList();
			for(User user:list){
				//��������е�����
				System.out.println("���----"+user.toString());
			}
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
