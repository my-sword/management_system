package com.mingrisoft;
// 桌面面板（主窗体中间面板）
import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class DesktopPanel extends JDesktopPane {

	private static final long serialVersionUID = 1L;
	private final Image backImage;// 背景图片

	public DesktopPanel() {// 桌面面板的构造方法
		super();// 调用父类JDesktopPane的构造器
		URL url = DesktopPanel.class.getResource("/res/back.jpg");// 获得背景图片的路径
		backImage = new ImageIcon(url).getImage();// 获得背景图片
	}

	@Override//重写背景面板图片宽高
	protected void paintComponent(Graphics g) {	// 重写绘制组件的方法
		int width = getWidth();					// 定义桌面面板的宽度
		int height = this.getHeight();			// 定义桌面面板的高度
		g.drawImage(backImage, 0, 0, width, height, this);// 绘制背景图片
	}
}
