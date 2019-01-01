package com.qq.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class RegisterFrame1 extends JFrame implements ActionListener {
	private Qquser regQquser = null;
	
	private Socket socket = null;
	private ObjectInputStream in = null;
	private ObjectOutputStream out = null;
	
	private JPanel bodyPanel = null;
	private JPanel centerPanel = null;
    private JPanel bottomPanel = null;
    
    private JLabel accountLabel = null;
    private JLabel nameLabel = null;
    private JLabel passwordLabel = null;
    private JLabel repasswordLabel = null;
    private JLabel imgLabel = null;
    
    private JTextField accountTextField = null;
    private JTextField nameTextField = null;
    private JPasswordField passwordField = null;
    private JPasswordField repasswordField = null;
    private JComboBox imgComboBox = null;
    
    private JButton registerButton = null;
    private JButton cancelButton = null;
    
    private void addImg() {
    	File[] files = new File("./selectimg").listFiles();
    	for (File file : files) {
			this.imgComboBox.addItem(new ImageIcon("./selectimg/" + file.getName()));
		}
    }
    
    private void init() {
    	this.bodyPanel = (JPanel)this.getContentPane();
    	this.bodyPanel.setLayout(new BorderLayout());
    	
    	this.centerPanel = new ImgPanel("./register.jpg");
    	this.bodyPanel.add(this.centerPanel, BorderLayout.CENTER);
    	this.bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
    	this.bodyPanel.add(this.bottomPanel, BorderLayout.SOUTH);
    	
    	this.accountLabel = new JLabel("账  号：", JLabel.RIGHT);
		this.accountLabel.setPreferredSize(new Dimension(60, 24));
		this.nameLabel = new JLabel("用户名：", JLabel.RIGHT);
		this.nameLabel.setPreferredSize(new Dimension(60, 24));
		this.passwordLabel = new JLabel("口  令：", JLabel.RIGHT);
		this.passwordLabel.setPreferredSize(new Dimension(60, 24));
		this.repasswordLabel = new JLabel("确认口令：", JLabel.RIGHT);
		this.repasswordLabel.setPreferredSize(new Dimension(60, 24));
		this.imgLabel = new JLabel("选择头像：", JLabel.RIGHT);
		this.imgLabel.setPreferredSize(new Dimension(60, 24));
		
		this.accountTextField = new JTextField();
	    this.accountTextField.setPreferredSize(new Dimension(160, 24));
		this.nameTextField = new JTextField();
		this.nameTextField.setPreferredSize(new Dimension(160, 24));
		this.passwordField = new JPasswordField();
		this.passwordField.setPreferredSize(new Dimension(160, 24));
		this.repasswordField = new JPasswordField();
		this.repasswordField.setPreferredSize(new Dimension(160, 24));
		this.imgComboBox = new JComboBox();
		this.addImg();
		this.imgComboBox.setPreferredSize(new Dimension(160, 24));
    	
    	Box box0 = Box.createVerticalBox();
    	
    	Box box1 = Box.createHorizontalBox();
    	Box box2 = Box.createHorizontalBox();
    	Box box3 = Box.createHorizontalBox();
    	Box box4 = Box.createHorizontalBox();
    	Box box5 = Box.createHorizontalBox();
    	
    	box1.add(this.accountLabel);
    	box1.add(this.accountTextField);
    	box2.add(this.nameLabel);
    	box2.add(this.nameTextField);
    	box3.add(this.passwordLabel);
    	box3.add(this.passwordField);
    	box4.add(this.repasswordLabel);
    	box4.add(this.repasswordField);
    	box5.add(this.imgLabel);
    	box5.add(this.imgComboBox);
    	
    	box0.add(Box.createVerticalStrut(70));
    	box0.add(box1);
    	box0.add(Box.createVerticalStrut(10));
    	box0.add(box2);
    	box0.add(Box.createVerticalStrut(10));
    	box0.add(box3);
    	box0.add(Box.createVerticalStrut(10));
    	box0.add(box4);
    	box0.add(Box.createVerticalStrut(10));
    	box0.add(box5);
    	this.centerPanel.add(box0);
    	
    	this.registerButton = new JButton("注  册");
        this.registerButton.addActionListener(this);
        this.cancelButton = new JButton("重  置");
        this.cancelButton.addActionListener(this);
        this.bottomPanel.add(this.registerButton);
        this.bottomPanel.add(this.cancelButton);
        
        this.setResizable(false);
        CommonUse.setComponentBounts(this, 512, 340);
        this.setSize(512, 340);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("金智云起点qq注册");
    }
    
    public RegisterFrame1() {
    	try {
			this.socket = new Socket("127.0.0.1", 10088);
			this.out = new ObjectOutputStream(this.socket.getOutputStream());
			this.in = new ObjectInputStream(this.socket.getInputStream());
			this.init();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		RegisterFrame1 registerFrame1 = new RegisterFrame1();
		registerFrame1.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String account = this.accountTextField.getText();
		String name = this.nameTextField.getText();
		String password = new String(this.passwordField.getPassword());
		
		String itemStr = this.imgComboBox.getSelectedItem().toString();
		int start = itemStr.lastIndexOf("/");
		int end = itemStr.lastIndexOf(".");
		String imgStr = itemStr.substring(start + 1, end);

		this.regQquser = new Qquser();
		this.regQquser.setAccount(account);
		this.regQquser.setName(name);
		this.regQquser.setPassword(password);
		this.regQquser.setState("0");
		this.regQquser.setIp("0");
		this.regQquser.setPort("0");
		this.regQquser.setPic(imgStr);
		
		try {
			TCPMessage sMessage = new TCPMessage();
			sMessage.setHead(CommonUse.REGISTER);
			sMessage.setBody(CommonUse.QQ_USER, this.regQquser);
			
			this.out.writeObject(sMessage);
			this.out.flush();
			//等待服务器处理
			TCPMessage rMessage = (TCPMessage)this.in.readObject();
			String back = rMessage.getHead();
			if(CommonUse.SUCCESSFUL.equals(back)) {
				JOptionPane.showMessageDialog(this, "注册成功！");
			} else {
				JOptionPane.showMessageDialog(this, "注册失败！");
			}
		} catch (HeadlessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
