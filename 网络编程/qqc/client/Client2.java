package com.qq.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.qq.bean.Qquser;
import com.qq.pub.CommonUse;

public class Client2 {

	public static void main(String[] args) {
		System.out.println("启动一个客户端！");
		
		ObjectInputStream in = null;
		ObjectOutputStream out = null;;
		BufferedReader sysReader = null;
		
		sysReader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			Socket socket = new Socket("127.0.0.1", 10088);
			
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
			
			String info = sysReader.readLine();
			String[] infos = info.split("/");
			Qquser qquser = new Qquser();
			qquser.setAccount(infos[0]);
			qquser.setPassword(infos[1]);
			
			out.writeObject(qquser);
			out.flush();
			//等待服务器处理
			try {
				String back = in.readObject().toString();
				if(CommonUse.SUCCESSFUL.equals(back)) {
					System.out.println("登陆成功！");
				} else {
					System.out.println("登陆失败！");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
