package com.qq.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {

	public static void main(String[] args) {
		System.out.println("启动一个客户端！");
		
		BufferedReader reader = null;
		BufferedWriter writer = null;
		BufferedReader sysReader = null;
		
		sysReader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			Socket socket = new Socket("127.0.0.1", 10088);
			
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String info = null;
			while(true) {
				info = sysReader.readLine();
				writer.write(info + "\n");
				writer.flush();
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
