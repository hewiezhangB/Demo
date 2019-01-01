package com.qq.listener;

import com.qq.pub.UDPSocket;

public class UDPThread03 extends Thread {
	private UDPListener03 listener03 = null;
	private UDPSocket socket = null;
	
	public UDPThread03() {
		
	}
	
	public UDPThread03(UDPSocket socket) {
		this.socket = socket;
	}
	
	public void addUDPListener (UDPListener03 listener03) {
		this.listener03 = listener03;
	}
	@Override
	public void run(){
		while(true){
			String udpMessage = this.socket.receive();
			this.listener03.excute(udpMessage);
		}
	}
	
}
