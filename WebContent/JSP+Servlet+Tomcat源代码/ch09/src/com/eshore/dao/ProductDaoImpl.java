package com.eshore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.eshore.pojo.Product;

public class ProductDaoImpl implements ProductDao {

	private Connection conn = null; // ���ݿ����Ӷ���
	private PreparedStatement pstmt = null; // ���ݿ��������
	// ͨ�����췽��ȡ�����ݿ�����
	public ProductDaoImpl(Connection conn) { 
		this.conn = conn;  
	}

	public boolean addProduct(Product product) throws Exception {
		boolean flag = false; // �����ʶ
		String sql = "insert into product(product_id,product_name,price,info) values(?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);// ʵ����PrepareStatement����
		this.pstmt.setString(1,product.getProduct_id());// ���ò�Ʒid
		this.pstmt.setString(2,product.getProduct_name());// ���ò�Ʒ����
		this.pstmt.setDouble(3, product.getPrice());// ���ò�Ʒ�۸�
		this.pstmt.setString(4,product.getInfo());// ���ò�Ʒ��Ϣ
		
		if (this.pstmt.executeUpdate() > 0) { // ���¼�¼����������0
			flag = true; // �޸ı�ʶ
		}
		this.pstmt.close(); // �ر�PreparedStatement����
		return flag;
	}

	public List<Product> findAll(String product_name) throws Exception {
		List<Product> list = new ArrayList<Product>();// ���弯�ϣ����ܷ��ص�����
		String sql = "select product_id,product_name,price,info from product ";
		if(product_name!=null&&!"".equals(product_name)){
			sql = "select product_id,product_name,price,info from product where product_name like? ";
			this.pstmt.setString(1, "%" + product_name + "%");// ���ò�ѯ��Ʒ����
		}else{
			this.pstmt = this.conn.prepareStatement(sql);// ʵ����PreparedStatement
		}
		ResultSet rs = this.pstmt.executeQuery();// ִ�в�ѯ����
		Product product = null;
		while (rs.next()) {
			product = new Product();// ʵ�����µ�product����
			product.setProduct_id(rs.getString(1));
			product.setProduct_name(rs.getString(2));
			product.setPrice(rs.getDouble(3));
			product.setInfo(rs.getString(4));
			list.add(product); // �򼯺�������product����
		}
		this.pstmt.close();
		return list; // ����ȫ�����
	}

	public Product findByProductId(String product_id) throws Exception {
		Product product = null;
		String sql = "select product_id,product_name,price,info from product where product_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, product_id); // ���ò�Ʒ���
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			product = new Product();
			product.setProduct_id(rs.getString(1));
			product.setProduct_name(rs.getString(2));
			product.setPrice(rs.getDouble(3));
			product.setInfo(rs.getString(4));
		}
		this.pstmt.close();
		return product; // �����ѯ��������򷵻�null,Ĭ��ֵΪnull
	}

}
