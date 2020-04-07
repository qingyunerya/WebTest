package com.lyz.dao;

import java.util.List;

import com.lyz.pojo.Product;

public interface ProductDao {
	public boolean addProduct(Product product)throws Exception;
	public List<Product> findAll(String product_name)throws Exception;
	public Product findProductById(String prodcut_id)throws Exception;
}
