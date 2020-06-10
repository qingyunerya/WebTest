package com.eshore;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

public class PreparedStatementBatch {
	
    public static void main(String[] args){
    	String sql = "insert into Person(name,age,sex,birthday,description) values(?,?,?,?,?)";
        Connection con = null;
        PreparedStatement prest = null;
    	try {
			Class.forName("com.mysql.jdbc.Driver");          //ע�����ݿ�
			con = DriverManager.getConnection(               //��ȡ���ݿ�����
					"jdbc:mysql://localhost:3306/testWeb","root","admin");
			prest = con.prepareStatement(sql);               //��ȡPreparedStatement,����Ԥ����SQL���
			for(int i=0;i<=10;i++){
				prest.setString(1, "����"+i);                //�趨��1������
				prest.setInt(2, 30);                         //�趨��2������
				prest.setString(3, "��");                    //�趨��3������
				prest.setDate(4,                             //�趨��4������
						new Date(System.currentTimeMillis()));
				prest.setString(5, "PreparedStatement ��������"); //�趨��5������
				prest.addBatch();                            //���SQL���
			}
			int[] result = prest.executeBatch();             //ִ���������룬���ؽ����
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//��ס�ر�����
			try {
				prest.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
    }
}
