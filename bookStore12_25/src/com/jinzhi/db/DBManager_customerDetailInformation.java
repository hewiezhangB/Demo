package com.jinzhi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager_customerDetailInformation {
	private Connection con;
	private Statement sta;
	private ResultSet res;

	/*
	 * �����������򣬵õ����ݿ�����
	 */
	public Connection getCon() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=yun4jbookSY1";
			con = DriverManager.getConnection(url, "sa", "sa");
			System.out.println("���ݿ����ӳɹ���");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	/*
	 * ִ�и��²���
	 */
	public int update(String sql) {
		System.out.println(sql);
		int count = 0;
		con = getCon();
		try {
			sta = con.createStatement();
			count = sta.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return count;
	}

	/*
	 * ִ�в�ѯ�����ؽ����
	 */
	public ResultSet query(String sql) {
		System.out.println(sql);
		con = getCon();
		try {
			sta = con.createStatement();
			res = sta.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	/*
	 * �ر���Դ
	 */
	public void close(){
		try {
			if(res!=null){
				res.close();
				res=null ;
			}
			if(sta!=null){
				sta.close();
				sta=null ;
			}
			if(con!=null){
				con.close();
				con=null ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
