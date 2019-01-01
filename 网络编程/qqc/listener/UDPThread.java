package com.qq.listener;

import com.qq.pub.UDPSocket;

public class UDPThread extends Thread {
	private UDPListener listener = null;
	private UDPSocket udpSocket = null;
	
	public UDPThread() {
		// TODO Auto-generated constructor stub
	}
	public UDPThread(UDPSocket udpSocket) {
		this.udpSocket = udpSocket;
	}
	
	public void addUDPListener(UDPListener listener) {
		this.listener = listener;
	}

	@Override
	public void run() {
		while(true) {
			String udpMessage = this.udpSocket.receive();
			this.listener.execute(udpMessage);
		}
	}

}