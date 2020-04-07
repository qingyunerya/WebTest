package com.lyz.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String Driver ="com.mysql.jdbc.Driver";
	private static final String URL ="jdbc:mysql://localhost:3306/webtest?useUnicode=true&amp;characterEncoding=UTF-8";
	private static final String USER="root";
	private static final String PASSWORD="123456";
	private Connection conn=null;
	public DBConnection() throws Exception {
		
		try {
			Class.forName(Driver);
			this.conn=DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
		
	}
	public Connection getConnection() {
		return this.conn;
	}
	public void close() throws SQLException {
		if(this.conn!=null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw e;
			}
		}
	}
}
