package com.eshore.service;

import java.util.List;

import com.eshore.dao.ProductDao;
import com.eshore.dao.ProductDaoImpl;
import com.eshore.db.DBConnection;
import com.eshore.pojo.Product;

public class ProductService implements ProductDao{
	private DBConnection dbconn = null; // �������ݿ�������
	private ProductDao dao = null; // ����DAO����
	// �ڹ��췽����ʵ�������ݿ����ӣ�ͬʱʵ����dao����
	public ProductService() throws Exception { 
		this.dbconn = new DBConnection();
		this.dao = new ProductDaoImpl(this.dbconn.getConnection());// ʵ����ProductDao��ʵ����
	}

	public boolean addProduct(Product product) throws Exception {
		boolean flag = false; // ��ʶ
		try {
			if (this.dao.findByProductId(product.getProduct_id()) == null) {// ���Ҫ����Ĳ�Ʒ��Ų�����
				flag = this.dao.addProduct(product);// ����һ����Ʒ��Ϣ
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return flag;
	}

	public List<Product> findAll(String keyWord) throws Exception {
		List<Product> all = null; // �����Ʒ���صļ���
		try {
			all = this.dao.findAll(keyWord);// ����ʵ�ַ���
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return all;
	}

	public Product findByProductId(String product_id) throws Exception {
		Product product = null;
		try {
			product = this.dao.findByProductId(product_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return product;
	}

}
