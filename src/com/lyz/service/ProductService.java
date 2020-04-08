package com.lyz.service;

import java.util.List;

import com.lyz.dao.ProductDao;
import com.lyz.dao.ProductDaoImpl;
import com.lyz.db.DBConnection;
import com.lyz.pojo.Product;

public class ProductService implements ProductDao {
	private DBConnection dbconn=null;
	private ProductDao dao=null;

	public ProductService() throws Exception{
		this.dbconn=new DBConnection();
		this.dao=new ProductDaoImpl(this.dbconn.getConnection());
	}
	@Override
	public boolean addProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			if(this.dao.findProductById(product.getProduct_id())==null) {
				flag=this.dao.addProduct(product);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}finally {
			this.dbconn.close();
		}
		return flag;
	}

	@Override
	public List<Product> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		List<Product> all=null;
		try {
			all=this.dao.findAll(keyWord);
			for(Product product:all )
			System.out.println(
					"产品编号："+product.getProduct_id()+
					"产品名称："+product.getProduct_name()+
					"产品价格："+product.getPrice()+
					"产品信息："+product.getInfo()
					);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}finally {
			this.dbconn.close();
		}
		return all;
	}

	@Override
	public Product findProductById(String prodcut_id) throws Exception {
		// TODO Auto-generated method stub
		Product product;
		try {
			product=this.dao.findProductById(prodcut_id);
			System.out.println(
					"产品编号："+product.getProduct_id()+
					"产品名称："+product.getProduct_name()+
					"产品价格："+product.getPrice()+
					"产品信息："+product.getInfo()
					);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}finally {
			this.dbconn.close();
		}
		return product;
	}

}
