package com.lyz.factory;

import com.lyz.dao.ProductDao;
import com.lyz.service.ProductService;

public class DAOFactory {
	public static ProductDao getIEmpDAOInstance() throws Exception {
		return new ProductService();
	}
}
