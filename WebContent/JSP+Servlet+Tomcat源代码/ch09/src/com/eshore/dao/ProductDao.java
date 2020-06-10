package com.eshore.dao;

import java.util.List;

import com.eshore.pojo.Product;

public interface ProductDao {
	/**     
     * ���ݿ� ��������  
     *@param product Ҫ���ӵ����ݶ���     
     *@return �Ƿ����ӳɹ��ı��     
     *@throws Exception ������쳣��ֱ���׳�     
     */ 
    public boolean addProduct(Product product)throws Exception ;     
     /**     
     * ��ѯȫ����Product����
     *@param product_name ��Ʒ���� 
     *@return ����ȫ���Ĳ�ѯ�����ÿһ��product�����ʾ���һ�м�¼     
     *@throws Exception ������쳣��ֱ���׳�       
     */ 
    public List<Product> findAll(String product_name)throws Exception;     
     /**     
     * ���ݲ�Ʒ��Ų�ѯ��Ʒ    
     *@param  product_id ��Ʒ���     
     *@return  ��Ʒ��vo����     
     *@throws Exception ������쳣��ֱ���׳�         
     */ 
    public Product findByProductId(String product_id)throws Exception;
}
