package com.lyz.test;

import com.lyz.factory.DAOFactory;
import com.lyz.pojo.Product;

public class TestInsertProduct {
	public static void mian(String args[]) {
		Product product=null;
		for(int i=0;i<5;i++) {
			product=new Product();
			product.setProduct_id("123456"+i);
			product.setProduct_name("水杯"+i);
			product.setPrice(12.5);
			product.setInfo("这是一个普通的水杯");
			try {
				DAOFactory.getIEmpDAOInstance().addProduct(product);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
