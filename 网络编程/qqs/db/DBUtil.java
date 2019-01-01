package com.qq.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	private Connection conn = null;
	private Statement sta = null;
	private ResultSet rs = null;
	
	private void connection2DB() {
		String driver = null;
		String url = null;
		String name = null;
		String password = null;
		
		try {
			Properties properties = new Properties();
			properties.load(DBUtil.class.getResourceAsStream("/db.properties"));
			driver = properties.getProperty("driver_class");
			url = properties.getProperty("connection_url");
			name = properties.getProperty("db_user");
			password = properties.getProperty("db_password");
			
			Class.forName(driver);
			this.conn = DriverManager.getConnection(url, name, password);
			System.out.println("链接数据库成功！");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public DBUtil() {
		this.connection2DB();
	}
	
	public int update(String sql) {
		int n = -1;
		try {
			this.sta = this.conn.createStatement();
			n = this.sta.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
	
	public ResultSet query(String sql) {
		try {
			this.sta = this.conn.createStatement();
			this.rs = this.sta.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.rs;
	}
	
	public void close() {
		try {
			if(this.rs != null) {
				this.rs.close();
				this.rs = null;
			}
			if(this.sta != null) {
				this.sta.close();
				this.sta = null;
			}
			if(this.conn != null) {
				this.conn.close();
				this.conn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
