package com.qq.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import com.qq.bean.Qquser;
import com.qq.dao.IQqUserDao;
import com.qq.dao.IQqUserDaoImpl;
import com.qq.pub.CommonUse;

public class ServerThread3 extends Thread {
	private Socket socket = null;
	private ObjectInputStream in = null;
	private ObjectOutputStream out = null;
	
	private boolean register(Qquser qquser) {
		boolean flag = false;
		IQqUserDao dao = new IQqUserDaoImpl();
		int n = dao.save(qquser);
		if(n > 0) {
			flag = true;
		}
		return flag;
	}
	
	private boolean checkUser(Qquser qquser) {
		if("金智学子".equals(qquser.getAccount()) && "123".equals(qquser.getPassword())) {
			return true;
		}
		return false;
	}
	
	public ServerThread3() {
		// TODO Auto-generated constructor stub
	}
	public ServerThread3(Socket socket) {
		System.out.println("有一个客户端上线了！");
		try {
			this.socket = socket;
			this.in = new ObjectInputStream(socket.getInputStream());
			this.out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		Qquser qquser = null;
		try {
			while(true) {
				qquser = (Qquser)in.readObject();
				if(this.register(qquser)) {
					this.out.writeObject(CommonUse.SUCCESSFUL);
				} else {
					this.out.writeObject(CommonUse.FAILURE);
				}
				this.out.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
