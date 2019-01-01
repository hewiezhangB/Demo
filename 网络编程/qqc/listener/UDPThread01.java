package com.qq.listener;

import com.qq.pub.UDPSocket;

public class UDPThread01 extends Thread {
	private UDPListener listener = null;
	private UDPSocket socket = null;
	
	
	public UDPThread01() {
		
	}

	public UDPThread01(UDPSocket socket) {
		this.socket = socket;
	}

	public void addUDPListener(UDPListener listener) {
		this.listener = listener;
	}
	
	@Override
	public void run() {
		while(true){
			String UDPMessage = this.socket.receive();
			this.listener.execute(UDPMessage);
		}
	}
	
}
