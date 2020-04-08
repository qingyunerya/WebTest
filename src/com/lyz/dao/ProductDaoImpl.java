package com.lyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lyz.pojo.Product;

public class ProductDaoImpl implements ProductDao {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	public ProductDaoImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn=conn;
	}

	@Override
	public boolean addProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="insert into product(product_id,product_name,price,info) values(?,?,?,?)";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, product.getProduct_id());
		this.pstmt.setString(2, product.getProduct_name());
		this.pstmt.setDouble(3, product.getPrice());
		this.pstmt.setString(4, product.getInfo());
		if(this.pstmt.executeUpdate()>0) {
			flag=true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Product> findAll(String product_name) throws Exception {
		// TODO Auto-generated method stub
		List<Product> list=new ArrayList<>();
		String sql="select product_id,product_name,price,info from product";
		if(product_name!=null&&!"".equals(product_name)) {
			sql="select product_id,product_name,price,info from product where product_name like ?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1, "%"+product_name+"%");
		}else {
			this.pstmt=this.conn.prepareStatement(sql);
		}
		ResultSet rs=this.pstmt.executeQuery();
		Product product=null;
		while(rs.next())
		{
			product=new Product();
			product.setProduct_id(rs.getString(1));
			product.setProduct_name(rs.getString(2));
			product.setPrice(rs.getDouble(3));
			product.setInfo(rs.getString(4));
			list.add(product);
		}
		return list;
	}

	@Override
	public Product findProductById(String product_id) throws Exception {
		// TODO Auto-generated method stub
		Product product =null;
		String  sql="select product_id,product_name,price,info from  product where product_id=?";
		if(product_id!=null&&!"".equals(product_id))
		{
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1, product_id);
			ResultSet rs=this.pstmt.executeQuery();
			if(rs.next()) {
				product=new Product();
				product.setProduct_id(rs.getString(1));
				product.setProduct_name(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setInfo(rs.getString(4));
			}
			this.pstmt.close();
			return product;
		}
		else return new Product();
		
	}

}
