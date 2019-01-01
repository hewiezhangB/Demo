package com.qq.ui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.qq.bean.Qquser;
import com.qq.component.ClinetImgCell;
import com.qq.listener.UDPListener;
import com.qq.listener.UDPThread;
import com.qq.pub.CommonUse;
import com.qq.pub.TCPMessage;
import com.qq.pub.TCPSocket;
import com.qq.pub.UDPSocket;

public class MainFrame extends JFrame implements UDPListener {
	private TCPSocket tcpSocket = null;
	private UDPSocket udpSocket = null;
	//看不见的
	private Qquser fullQquser = null;
	private List<Qquser> friends = null;
	//看得见的
	private JLabel nameLabel = null;
	private JList friendList = null;
	private JScrollPane listScrollPane = null;
	private DefaultListModel listModel = null;
	
	private UDPThread udpThread = null;
	
	private List<Qquser> getFriends() {
		TCPMessage sMessage = new TCPMessage();
		sMessage.setHead(CommonUse.FIND);
		sMessage.setBody(CommonUse.QQ_USER, this.fullQquser);
		
		TCPMessage rMessage = this.tcpSocket.submit(sMessage);
		
		List<Qquser> list = (List<Qquser>)rMessage.getBody(CommonUse.FRIENDS_INFO);
		
		return list;
	}
	
	private void refreshFriendList() {
		List<Qquser> afterList = new ArrayList<Qquser>();
		//排序
		for (Qquser tempQquser : this.friends) {
			if("1".equals(tempQquser.getState())) {
				afterList.add(tempQquser);
			}
		}
		for (Qquser tempQquser : this.friends) {
			if("0".equals(tempQquser.getState())) {
				afterList.add(tempQquser);
			}
		}
		//做头像
		for (Qquser tempQquser : afterList) {
			if("1".equals(tempQquser.getState())) {
				tempQquser.setPlace1("./onimg/" + tempQquser.getPic() + ".png");
			} else if("0".equals(tempQquser.getState())) {
				tempQquser.setPlace1("./outimg/" + tempQquser.getPic() + ".png");
			}
		}
		this.friends = afterList;
		
		this.friendList.removeAll();
		this.friendList.repaint();
		this.listModel = new DefaultListModel();
		for (Qquser tempQquser : this.friends) {
			this.listModel.addElement(tempQquser);
		}
		this.friendList.setModel(this.listModel);
	}
	
	private void createFriendList() {
		List<Qquser> beforeList = this.getFriends();
		List<Qquser> afterList = new ArrayList<Qquser>();
		//排序
		for (Qquser tempQquser : beforeList) {
			if("1".equals(tempQquser.getState())) {
				afterList.add(tempQquser);
			}
		}
		for (Qquser tempQquser : beforeList) {
			if("0".equals(tempQquser.getState())) {
				afterList.add(tempQquser);
			}
		}
		//做头像
		for (Qquser tempQquser : afterList) {
			if("1".equals(tempQquser.getState())) {
				tempQquser.setPlace1("./onimg/" + tempQquser.getPic() + ".png");
			} else if("0".equals(tempQquser.getState())) {
				tempQquser.setPlace1("./outimg/" + tempQquser.getPic() + ".png");
			}
		}
		this.friends = afterList;
		
		this.friendList = new JList();
		this.listModel = new DefaultListModel();
		for (Qquser tempQquser : this.friends) {
			this.listModel.addElement(tempQquser);
		}
		this.friendList.setModel(this.listModel);
		this.friendList.setCellRenderer(new ClinetImgCell());
		this.listScrollPane = new JScrollPane(this.friendList);
	}
	
	private void init() {
		JPanel bodyPanel = (JPanel)this.getContentPane();
		bodyPanel.setLayout(new BorderLayout());
		
		this.nameLabel = new JLabel(this.fullQquser.getName());
		bodyPanel.add(this.nameLabel, BorderLayout.NORTH);
		
		this.createFriendList();
		bodyPanel.add(this.friendList, BorderLayout.CENTER);
		
		this.udpThread = new UDPThread(this.udpSocket);
		this.udpThread.addUDPListener(this);
		this.udpThread.start();
		
		this.setTitle("金智QQ" + this.fullQquser.getAccount() + "的界面");
        this.setBounds(100, 20, 200, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public MainFrame() {
		// TODO Auto-generated constructor stub
	}
	public MainFrame(Qquser fullQquser, TCPSocket tcpSocket, UDPSocket udpSocket) {
		this.fullQquser = fullQquser;
		this.tcpSocket = tcpSocket;
		this.udpSocket = udpSocket;
		this.init();
	}

	@Override
	public void execute(String udpMessage) {
		String[] messages = udpMessage.split(CommonUse.UDP_PACKET_SYMBOL);
		String head = messages[0];
		if(CommonUse.ONLINE.equals(head)) {
			String account = messages[1];
			String ip = messages[2];
			String port = messages[3];
			for (Qquser tempQquser : this.friends) {
				if(account.equals(tempQquser.getAccount())) {
					tempQquser.setState("1");
					tempQquser.setIp(ip);
					tempQquser.setPort(port);
					break;
				}
			}
			this.refreshFriendList();
		}
	}

}
