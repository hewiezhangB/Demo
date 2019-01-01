package com.qq.listener;

import com.qq.pub.UDPSocket;

public class UDPThread02 extends Thread {
	private UDPListener listener = null;
	private UDPSocket socket = null;
	public UDPThread02() {
		
	}
	
	public UDPThread02(UDPSocket socket) {
		this.socket = socket;
	}

	public void addUDPListener (UDPListener listener) {
		this.listener = listener;
	}
	
	@Override
	public void run(){
		while(true){
			String UDPMessge = this.socket.receive();
			this.listener.execute(UDPMessge);
		}
	}
	
}
