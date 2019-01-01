package com.qq.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

	public static void main(String[] args) {
		System.out.println("·þÎñÆ÷Æô¶¯£¡");
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(10088);
			
			while(true) {
				Socket socket = serverSocket.accept();
				ServerThread1 serverThread1 = new ServerThread1(socket);
				serverThread1.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
