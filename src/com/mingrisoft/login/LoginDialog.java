package com.mingrisoft.login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.mingrisoft.*;
import com.mingrisoft.dao.*;

public class LoginDialog extends JFrame {// 登录窗体
	private static final long serialVersionUID = 1L;
	private LoginPanel loginPanel = null;	// 登录面板（调用自定义函数）
	private JLabel jLabel = null;			// “用户名”标签
	private JTextField userField = null;	// “用户名”文本框
	private JLabel jLabel1 = null;			// “密码”标签
	private JPasswordField passwordField = null;// “密码”文本框
	private JButton loginButton = null;		// “登录”按钮
	private JButton exitButton = null;		// “退出”按钮
	private static String userStr;			// “用户名”文本框中的内容
	private MainFrame mainFrame;			// 主窗体

	public LoginDialog() {// 登录窗体的构造方法
		try {
			// 设置登录窗体的风格
			/*
					javax.swing.UIManager类是Swing界面管理核心，管理Swing应用程序样式。
					LookAndFeel抽象类
					与javax.swing.UIManager类密切相关的就是LookAndFeel抽象类。它除了提供static方法，还定义抽象的个性化设置方法由子类实现。
					Sun提供了三个LookAndFeel子类：javax.swing.plaf.metal.MetalLookAndFeel（Metal样式）、com.sun.java.swing.plaf.motif.MotifLookAndFeel（Motif样式）、com.sun.java.swing.plaf.windows.WindowsLookAndFeel（Windows样式）。
				Java中的几种LookandFeel（此部分代码在main方法打开GUI界面之前实现）
				1、Metal风格(默认)
				String lookAndFeel ="javax.swing.plaf.metal.MetalLookAndFeel";
				UIManager.setLookAndFeel(lookAndFeel);

				2、Windows风格
				String lookAndFeel ="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
				UIManager.setLookAndFeel(lookAndFeel);

				3、Windows Classic风格
				String lookAndFeel ="com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
				UIManager.setLookAndFeel(lookAndFeel);

				4、Motif风格
				String lookAndFeel ="com.sun.java.swing.plaf.motif.MotifLookAndFeel";
				UIManager.setLookAndFeel(lookAndFeel);

				5、Mac风格 (需要在相关的操作系统上方可实现)
				String lookAndFeel ="com.sun.java.swing.plaf.mac.MacLookAndFeel";
				UIManager.setLookAndFeel(lookAndFeel);

				6、GTK风格 (需要在相关的操作系统上方可实现)
				String lookAndFeel ="com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
				UIManager.setLookAndFeel(lookAndFeel);
				7、可跨平台的默认风格
				String lookAndFeel =UIManager.getCrossPlatformLookAndFeelClassName();
				UIManager.setLookAndFeel(lookAndFeel);

				8、当前系统的风格
				String lookAndFeel =UIManager.getSystemLookAndFeelClassName();
				UIManager.setLookAndFeel(lookAndFeel);

			 *///UI风格
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//使用本系统的风格包括右键菜单
			mainFrame = new MainFrame();// 实例化主窗体
			initialize();				// 初始化登录窗体
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 初始化loginPanel登录面板的方法
	private LoginPanel getLoginPanel() {
		if (loginPanel == null) {		// 登录面板中没有组件时

			jLabel1 = new JLabel();		// “密码”标签
			//jLabel1.setBounds(new Rectangle(86, 71, 55, 18));	// 设置“密码”标签的位置与宽高(本质继承)
			jLabel1.setBounds(30, 71, 55, 18);
			jLabel1.setForeground(Color.decode("#CDAD00"));
			jLabel1.setFont(new Font("黑体",Font.BOLD, 12));
			jLabel1.setText("密　码：");	// 设置“密码”标签的文本内容

			jLabel = new JLabel();		// “用户名”标签
			jLabel.setBounds(30, 41, 56, 18);
			jLabel.setForeground(Color.decode("#CDAD00"));
			jLabel.setFont(new Font("黑体",Font.BOLD, 12));
			jLabel.setText("用户名：");	// 设置“用户名”标签的文本内容


			loginPanel = new LoginPanel();						// 登录面板
			loginPanel.setLayout(null);							// 绝对布局
			loginPanel.setBackground(new Color(0xD8DDC7));	// 设置登录面板的背景色
			loginPanel.add(jLabel, null);			// “用户名”标签
			loginPanel.add(getUserField(), null);	// “用户名”文本框
			loginPanel.add(jLabel1, null);			// “密码”标签
			loginPanel.add(getPasswordField(), null);// “密码”文本框
			loginPanel.add(getLoginButton(), null);	// “登录”按钮
			loginPanel.add(getExitButton(), null);	// “退出”按钮
		}
		return loginPanel;// 返回登录面板
	}
	// 初始化“用户名”文本框
	private JTextField getUserField() {
		if (userField == null) {			// “用户名”文本框对象为空时
			userField = new JTextField();	// 实例化“用户名”文本框
			userField.setBounds(87, 39, 127, 22);// 设置“用户名”文本框的位置和宽高
		}
		return userField;					// 返回“用户名”文本框
	}
	//密码框焦点回车事件
	private JPasswordField getPasswordField() {		// 初始化“密码”文本框
		if (passwordField == null) {				// “密码”文本框对象为空时
			passwordField = new JPasswordField();	// 实例化“密码”文本框
			passwordField.setBounds(new Rectangle(87, 69, 125, 22));// 设置“密码”文本框的位置和宽高
			passwordField.addKeyListener(new KeyAdapter() {// 为“密码”文本框添加键盘时间的监听
				public void keyTyped(KeyEvent e) {
					if (e.getKeyChar() == '\n')		// 按下的按键是回车时
						loginButton.doClick();		// 调用“登录”按钮的点击事件（按钮方法）
				}
			});
		}
		return passwordField;						// 返回“密码”文本框
	}
	//登录按钮
	private JButton getLoginButton() {	// 初始化“登录”按钮
		if (loginButton == null) {		// “登录”按钮对象为空时
			loginButton = new JButton();// 实例化“登录”按钮
			loginButton.setBounds(73, 104, 48, 20);	// 设置“登录”按钮的位置和宽高
			loginButton.setIcon(new ImageIcon(getClass().getResource("/res/loginButton.jpg")));// 设置“登录”按钮的图标
			loginButton.addActionListener(new ActionListener() {			// 为“登录”按钮添加动作事件的监听（==doClick()）
				public void actionPerformed(ActionEvent e) {
					try {
						userStr = userField.getText();			// 获得“用户名”文本框中的内容
						String passStr = new String(passwordField.getPassword());// 获得“密码”文本框中的内容
						if (!Dao.checkLogin(userStr, passStr)) {// 验证用户名、密码失败(调用数据库自类的checkLogin()方法)

							JOptionPane.showMessageDialog(LoginDialog.this, "用户名与密码无法登录", "登录失败",
									JOptionPane.ERROR_MESSAGE);	// 弹出“登录失败”对话框
							return;
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
					mainFrame.setLocationRelativeTo(null);
					mainFrame.setVisible(true);							// 使主窗体可见
					MainFrame.getCzyStateLabel().setText(userStr);		// 设置主窗体中操作员标签的字体是
					setVisible(false);									// 使登录窗体不可见
				}
			});
		}
		return loginButton;// 返回“登录”按钮
	}
	//退出按钮
	private JButton getExitButton() {	// 初始化“退出”按钮
		if (exitButton == null) {		// “退出”按钮对象为空时
			exitButton = new JButton();	// 实例化“退出”按钮
			exitButton.setBounds(new Rectangle(145, 104, 48, 20));				// 设置“退出”按钮的位置和宽高
			exitButton.setIcon(new ImageIcon(getClass().getResource("/res/exitButton.jpg")));// 设置“退出”按钮的图标
			exitButton.addActionListener(new ActionListener() {// 为“退出”按钮动作事件的监听
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// 退出当前的应用程序（退出所有包括主窗体）
				}
			});
		}
		return exitButton;				// 返回“退出”按钮
	}

	private void initialize() {				// 初始化登录窗体
		Dimension size = getToolkit().getScreenSize();// 获得屏幕尺寸(Java AWT的Toolkit是对系统低层实现图形控件的最基本功能的一些接口)
		setLocation((size.width - 296) / 2, (size.height - 188) / 2);// 设置登录窗体
		setSize(296, 188);	// 设置登录窗体的宽高
		this.setTitle("用户登录");			// 设置登录窗体的标题
		setContentPane(getLoginPanel());	// 将登录面板置于登录窗体中
		setResizable(false);
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/res/0.png"));
		this.setIconImage(imageIcon.getImage());
	}

	public String getUserStr() {// 获得“用户名”文本框中的内容
		return userStr;// 返回“用户名”文本框中的内容
	}//供外包调用

}
