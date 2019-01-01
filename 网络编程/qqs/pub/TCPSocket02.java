package com.qq.pub;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPSocket02 {
	private Socket socket = null;
	private ObjectOutputStream out = null;
	private ObjectInputStream in = null;
	
	public TCPSocket02() {
		
	}
	
	public TCPSocket02(String ip,int port) {
		try {
			this.socket = new Socket(ip,port);
			this.out = new ObjectOutputStream(this.socket.getOutputStream());
			this.in = new ObjectInputStream(this.socket.getInputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public TCPMessage submit(TCPMessage sMessage) {
		TCPMessage rMessage = null;
		try {
			this.out.writeObject(sMessage);
			this.out.flush();
			//等待服务器处理
			rMessage = (TCPMessage)this.in.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rMessage;
	}
	
	public String getIp() {
		return this.socket.getLocalAddress().getHostAddress();
	}
}
