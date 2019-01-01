package com.qq.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.qq.bean.Qquser;
import com.qq.component.ImgPanel;
import com.qq.pub.CommonUse;
import com.qq.pub.TCPMessage;
import com.qq.pub.TCPSocket;
import com.qq.pub.UDPSocket;

public class LoginFrame extends JFrame implements ActionListener {
	private Qquser logQquser = null;
	
	private TCPSocket tcpSocket = null;
	private UDPSocket udpSocket = null;
	
	//中间面板，用于存放业务组件
    private JPanel centerPanel;
    //底部面板，用于存放按钮
    private JPanel bottomPanel;
    
    //账号
    private JLabel accountLabel; 
    private JTextField accountTextField;
    //口令
    private JLabel passowrdLabel;
    private JPasswordField passwordField;
    //登录按钮
    private JButton loginButton;
    //注册按钮
    private JButton registerButton;
	
    
    private void init() {
    	JPanel bodyPanel = (JPanel)this.getContentPane();
    	bodyPanel.setLayout(new BorderLayout());
    	this.centerPanel = new ImgPanel("./login.jpg");
    	bodyPanel.add(this.centerPanel, BorderLayout.CENTER);
    	this.bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
    	bodyPanel.add(this.bottomPanel, BorderLayout.SOUTH);
    	
    	this.accountLabel = new JLabel("用户名：");
        this.accountTextField = new JTextField(16);
        this.passowrdLabel = new JLabel("口    令：");
        this.passwordField = new JPasswordField(16);
        
        Box box0 = Box.createVerticalBox();
        Box box1 = Box.createHorizontalBox();
        Box box2 = Box.createHorizontalBox();
        
        box1.add(this.accountLabel);
        box1.add(this.accountTextField);
        
        box2.add(this.passowrdLabel);
        box2.add(this.passwordField);
        
        box0.add(Box.createVerticalStrut(90));
        box0.add(box1);
        box0.add(Box.createVerticalStrut(15));
        box0.add(box2);
        
        this.centerPanel.add(box0);
        
        this.loginButton = new JButton("登陆");
        this.loginButton.addActionListener(this);
        this.bottomPanel.add(this.loginButton);
        this.registerButton = new JButton("注册");
        this.registerButton.addActionListener(this);
        this.bottomPanel.add(this.registerButton);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("金智云起点QQ登陆");
        CommonUse.setComponentBounts(this, 414, 307);
    }
    
    public LoginFrame() {
    	this.tcpSocket = new TCPSocket("127.0.0.1", 10088);
    	this.udpSocket = new UDPSocket();
		this.init();
	}

	public static void main(String[] args) {
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setVisible(true);
		loginFrame.setSize(414, 307);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.loginButton) {
			String account = this.accountTextField.getText();
			String password = new String(this.passwordField.getPassword());
			
			if(account.length() <= 0 || password.length() <= 0) {
				JOptionPane.showMessageDialog(this, "用户名密码不能为空！");
				return;
			}
			
			this.logQquser = new Qquser();
			this.logQquser.setAccount(account);
			this.logQquser.setPassword(password);
			this.logQquser.setIp(this.tcpSocket.getIp());
			this.logQquser.setPort(String.valueOf(this.udpSocket.getPort()));
			
			TCPMessage sMessage = new TCPMessage();
			sMessage.setHead(CommonUse.LOGIN);
			sMessage.setBody(CommonUse.QQ_USER, this.logQquser);
			
			TCPMessage rMessage = this.tcpSocket.submit(sMessage);
			
			String back = rMessage.getHead();
			if(CommonUse.SUCCESSFUL.equals(back)) {
				JOptionPane.showMessageDialog(this, "登陆成功！");
				
				Qquser fullQquser = (Qquser)rMessage.getBody(CommonUse.QQ_USER);
				MainFrame mainFrame = new MainFrame(fullQquser, this.tcpSocket, this.udpSocket);
				mainFrame.setVisible(true);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "登陆失败！");
			}
		}
	}

}
