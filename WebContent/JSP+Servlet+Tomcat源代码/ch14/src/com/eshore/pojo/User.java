package com.eshore.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

 
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	@XmlAttribute
	private String country;       //����
	@XmlElement
    private String name;         //����
	@XmlElement
	private String english_name; //Ӣ����
	@XmlElement
	private String age;          //����
	@XmlElement
	private String sex;          //�Ա�
	@XmlElement
	private Address address;      //��ַ
	@XmlElement
	private String description;  //����
    
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String englishName, String age, String sex,
			Address address, String description,String country) {
		super();
		this.name = name;
		english_name = englishName;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.description = description;
		this.country = country;
	}
	@Override
	public String toString() {
		String str=name+" ������ "+country+" Ӣ������"+english_name+" �Ա�:"+sex+" ���䣺"+age+" ��ס"+address.toString()+","+description;
		return str;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnglish_name() {
		return english_name;
	}
	public void setEnglish_name(String englishName) {
		english_name = englishName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
