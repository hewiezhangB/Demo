package com.qq.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;

import com.qq.bean.Qquser;
import com.qq.dao.IQqUserDao;
import com.qq.dao.IQqUserDaoImpl;
import com.qq.pub.CommonUse;
import com.qq.pub.TCPMessage;
import com.qq.pub.UDPSocket;

public class ServerThread4 extends Thread {
	private Qquser fullQquser = null;
	
	private Socket socket = null;
	private ObjectInputStream in = null;
	private ObjectOutputStream out = null;
	
	private void online(Qquser qquser) {
		IQqUserDao dao = new IQqUserDaoImpl();
		String sql = "select * from qquser where"
				+ " account in (select friendAccount from friend"
				+ " where userAccount = '" + qquser.getAccount() + "') and state = '1'";
		List<Qquser> list = dao.findBySql(sql);
		String udpMessage = CommonUse.ONLINE + CommonUse.UDP_PACKET_SYMBOL
				+ qquser.getAccount() + CommonUse.UDP_PACKET_SYMBOL
				+ qquser.getIp() + CommonUse.UDP_PACKET_SYMBOL
				+ qquser.getPort() + CommonUse.UDP_PACKET_SYMBOL;
		for (Qquser tempQquser : list) {
			UDPSocket udpSocket = new UDPSocket(tempQquser.getIp(), Integer.parseInt(tempQquser.getPort()));
			udpSocket.send(udpMessage);
		}
	}
	
	private List<Qquser> findFriends(Qquser qquser) {
		IQqUserDao dao = new IQqUserDaoImpl();
		String sql = "select * from qquser where"
				+ " account in (select friendAccount from friend"
				+ " where userAccount = '" + qquser.getAccount() + "')";
		List<Qquser> list = dao.findBySql(sql);
		return list;
	}
	
	private Qquser getFullUser(String account) {
		IQqUserDao dao = new IQqUserDaoImpl();
		return dao.findById(account);
	}
	
	private void modifyState(Qquser qquser) {
		qquser.setState("1");
		IQqUserDao dao = new IQqUserDaoImpl();
		dao.update(qquser);
	}
	
	private boolean checkUser(Qquser qquser) {
		boolean flag = false;
		IQqUserDao dao = new IQqUserDaoImpl();
		Qquser findQquser = dao.findById(qquser.getAccount());
		if(findQquser != null && findQquser.getPassword().equals(qquser.getPassword())) {
			flag = true;
		}
		return flag;
	}
	
	private boolean registe(Qquser qquser) {
		boolean flag = false;
		IQqUserDao dao = new IQqUserDaoImpl();
		int n = dao.save(qquser);
		if(n > 0) {
			flag = true;
		}
		return flag;
	}
	
	public ServerThread4() {
		// TODO Auto-generated constructor stub
	}
	public ServerThread4(Socket socket) {
		System.out.println("有一个客户端上线了！");
		try {
			this.socket = socket;
			this.in = new ObjectInputStream(socket.getInputStream());
			this.out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		TCPMessage rMessage = null;
		TCPMessage sMessage = null;
		try {
			while(true) {
				rMessage = (TCPMessage)in.readObject();
				String head = rMessage.getHead();
				if(CommonUse.REGISTER.equals(head)) {
					sMessage = new TCPMessage();
					Qquser regQquser = (Qquser)rMessage.getBody(CommonUse.QQ_USER);
					if(this.registe(regQquser)) {
						sMessage.setHead(CommonUse.SUCCESSFUL);
					} else {
						sMessage.setHead(CommonUse.FAILURE);
					}
				} else if(CommonUse.LOGIN.equals(head)) {
					sMessage = new TCPMessage();
					Qquser logQquser = (Qquser)rMessage.getBody(CommonUse.QQ_USER);
					//验证
					if(this.checkUser(logQquser)) {
						//改状态
						this.modifyState(logQquser);
						//得到最新状态用户
						this.fullQquser = this.getFullUser(logQquser.getAccount());
						
						//通知上线
						this.online(this.fullQquser);
						
						sMessage.setHead(CommonUse.SUCCESSFUL);
						sMessage.setBody(CommonUse.QQ_USER, this.fullQquser);
					} else {
						sMessage.setHead(CommonUse.FAILURE);
					}
				} else if(CommonUse.FIND.equals(head)) {
					sMessage = new TCPMessage();
					Qquser qquser = (Qquser)rMessage.getBody(CommonUse.QQ_USER);
					List<Qquser> list = this.findFriends(qquser);
					sMessage.setBody(CommonUse.FRIENDS_INFO, list);
				}
				
				this.out.writeObject(sMessage);
				this.out.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
