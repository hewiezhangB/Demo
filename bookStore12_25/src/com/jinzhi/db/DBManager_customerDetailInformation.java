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
	 * 加载驱动程序，得到数据库连接
	 */
	public Connection getCon() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=yun4jbookSY1";
			con = DriverManager.getConnection(url, "sa", "sa");
			System.out.println("数据库链接成功！");
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
	 * 执行更新操作
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
	 * 执行查询，返回结果集
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
	 * 关闭资源
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
