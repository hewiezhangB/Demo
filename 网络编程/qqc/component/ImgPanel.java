package com.qq.component;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImgPanel extends JPanel {
	private ImageIcon imageIcon = null;
	
	
	public ImgPanel() {
		
	}
	public ImgPanel(String path) {
		this.imageIcon = new ImageIcon(path);	    
	}
	
    public void paintComponent(Graphics g) {
        g.drawImage(this.imageIcon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
