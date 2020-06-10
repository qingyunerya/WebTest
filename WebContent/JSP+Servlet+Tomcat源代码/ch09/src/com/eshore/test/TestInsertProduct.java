package com.eshore.test;

import com.eshore.factory.DAOFactory;
import com.eshore.pojo.Product;

public class TestInsertProduct {
	public static void main(String[] args){
		Product product = null;
		try{
			for(int i=0;i<5;i++){
				product = new Product();
				product.setProduct_id("350115001010"+i);
				product.setProduct_name("ˮ��"+i);
				product.setPrice(100+i);
				product.setInfo("����һ�������ı���"+i);
				DAOFactory.getIEmpDAOInstance().addProduct(product);
			}
		}catch(Exception e){
			e.printStackTrace();
			e.printStackTrace();
		}
	}
}
