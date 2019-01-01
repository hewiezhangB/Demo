package com.qq.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server4 {

	public static void main(String[] args) {
		System.out.println("·þÎñÆ÷Æô¶¯£¡");
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(10088);
			
			while(true) {
				Socket socket = serverSocket.accept();
				ServerThread4 serverThread4 = new ServerThread4(socket);
				serverThread4.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
