package com.qq.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server3 {

	public static void main(String[] args) {
		System.out.println("·þÎñÆ÷Æô¶¯£¡");
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(10088);
			
			while(true) {
				Socket socket = serverSocket.accept();
				ServerThread3 serverThread3 = new ServerThread3(socket);
				serverThread3.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
