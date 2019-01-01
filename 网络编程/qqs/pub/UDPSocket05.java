package com.qq.pub;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPSocket05 {
	private DatagramSocket socket = null;
	private DatagramPacket packet = null;
	public UDPSocket05() {
		try {
			this.socket = new DatagramSocket();
			byte[] pool = new byte[1024];
			this.packet = new DatagramPacket(pool, pool.length);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public UDPSocket05(String id,int port) {
		try {
			this.socket = new DatagramSocket();
			byte[] pool = new byte[1024];
			this.packet = new DatagramPacket(pool, pool.length, InetAddress.getByName(id), port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	public String receive() {
		String info = null;
		try {
			this.socket.receive(this.packet);
			info = new String(this.packet.getData());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	}
	public void send(String info) {
		this.packet.setData(info.getBytes());
		try {
			this.socket.send(this.packet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getPort() {
		return this.socket.getLocalPort();
	}
}
