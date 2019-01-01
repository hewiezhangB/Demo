package com.qq.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerThread1 extends Thread {
	private Socket socket = null;
	private BufferedReader reader = null;
	private BufferedWriter writer = null;
	
	public ServerThread1() {
		// TODO Auto-generated constructor stub
	}
	public ServerThread1(Socket socket) {
		System.out.println("有一个客户端上线了！");
		try {
			this.socket = socket;
			this.reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.writer = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			String info = null;
			while(true) {
				info = this.reader.readLine();
				System.out.println("服务器收到了消息：" + info);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
