package com.mingrisoft.login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.mingrisoft.*;
import com.mingrisoft.dao.*;

public class LoginDialog extends JFrame {// ��¼����
	private static final long serialVersionUID = 1L;
	private LoginPanel loginPanel = null;	// ��¼��壨�����Զ��庯����
	private JLabel jLabel = null;			// ���û�������ǩ
	private JTextField userField = null;	// ���û������ı���
	private JLabel jLabel1 = null;			// �����롱��ǩ
	private JPasswordField passwordField = null;// �����롱�ı���
	private JButton loginButton = null;		// ����¼����ť
	private JButton exitButton = null;		// ���˳�����ť
	private static String userStr;			// ���û������ı����е�����
	private MainFrame mainFrame;			// ������

	public LoginDialog() {// ��¼����Ĺ��췽��
		try {
			// ���õ�¼����ķ��
			/*
					javax.swing.UIManager����Swing���������ģ�����SwingӦ�ó�����ʽ��
					LookAndFeel������
					��javax.swing.UIManager��������صľ���LookAndFeel�����ࡣ�������ṩstatic���������������ĸ��Ի����÷���������ʵ�֡�
					Sun�ṩ������LookAndFeel���ࣺjavax.swing.plaf.metal.MetalLookAndFeel��Metal��ʽ����com.sun.java.swing.plaf.motif.MotifLookAndFeel��Motif��ʽ����com.sun.java.swing.plaf.windows.WindowsLookAndFeel��Windows��ʽ����
				Java�еļ���LookandFeel���˲��ִ�����main������GUI����֮ǰʵ�֣�
				1��Metal���(Ĭ��)
				String lookAndFeel ="javax.swing.plaf.metal.MetalLookAndFeel";
				UIManager.setLookAndFeel(lookAndFeel);

				2��Windows���
				String lookAndFeel ="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
				UIManager.setLookAndFeel(lookAndFeel);

				3��Windows Classic���
				String lookAndFeel ="com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
				UIManager.setLookAndFeel(lookAndFeel);

				4��Motif���
				String lookAndFeel ="com.sun.java.swing.plaf.motif.MotifLookAndFeel";
				UIManager.setLookAndFeel(lookAndFeel);

				5��Mac��� (��Ҫ����صĲ���ϵͳ�Ϸ���ʵ��)
				String lookAndFeel ="com.sun.java.swing.plaf.mac.MacLookAndFeel";
				UIManager.setLookAndFeel(lookAndFeel);

				6��GTK��� (��Ҫ����صĲ���ϵͳ�Ϸ���ʵ��)
				String lookAndFeel ="com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
				UIManager.setLookAndFeel(lookAndFeel);
				7���ɿ�ƽ̨��Ĭ�Ϸ��
				String lookAndFeel =UIManager.getCrossPlatformLookAndFeelClassName();
				UIManager.setLookAndFeel(lookAndFeel);

				8����ǰϵͳ�ķ��
				String lookAndFeel =UIManager.getSystemLookAndFeelClassName();
				UIManager.setLookAndFeel(lookAndFeel);

			 *///UI���
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//ʹ�ñ�ϵͳ�ķ������Ҽ��˵�
			mainFrame = new MainFrame();// ʵ����������
			initialize();				// ��ʼ����¼����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// ��ʼ��loginPanel��¼���ķ���
	private LoginPanel getLoginPanel() {
		if (loginPanel == null) {		// ��¼�����û�����ʱ

			jLabel1 = new JLabel();		// �����롱��ǩ
			//jLabel1.setBounds(new Rectangle(86, 71, 55, 18));	// ���á����롱��ǩ��λ������(���ʼ̳�)
			jLabel1.setBounds(30, 71, 55, 18);
			jLabel1.setForeground(Color.decode("#CDAD00"));
			jLabel1.setFont(new Font("����",Font.BOLD, 12));
			jLabel1.setText("�ܡ��룺");	// ���á����롱��ǩ���ı�����

			jLabel = new JLabel();		// ���û�������ǩ
			jLabel.setBounds(30, 41, 56, 18);
			jLabel.setForeground(Color.decode("#CDAD00"));
			jLabel.setFont(new Font("����",Font.BOLD, 12));
			jLabel.setText("�û�����");	// ���á��û�������ǩ���ı�����


			loginPanel = new LoginPanel();						// ��¼���
			loginPanel.setLayout(null);							// ���Բ���
			loginPanel.setBackground(new Color(0xD8DDC7));	// ���õ�¼���ı���ɫ
			loginPanel.add(jLabel, null);			// ���û�������ǩ
			loginPanel.add(getUserField(), null);	// ���û������ı���
			loginPanel.add(jLabel1, null);			// �����롱��ǩ
			loginPanel.add(getPasswordField(), null);// �����롱�ı���
			loginPanel.add(getLoginButton(), null);	// ����¼����ť
			loginPanel.add(getExitButton(), null);	// ���˳�����ť
		}
		return loginPanel;// ���ص�¼���
	}
	// ��ʼ�����û������ı���
	private JTextField getUserField() {
		if (userField == null) {			// ���û������ı������Ϊ��ʱ
			userField = new JTextField();	// ʵ�������û������ı���
			userField.setBounds(87, 39, 127, 22);// ���á��û������ı����λ�úͿ��
		}
		return userField;					// ���ء��û������ı���
	}
	//����򽹵�س��¼�
	private JPasswordField getPasswordField() {		// ��ʼ�������롱�ı���
		if (passwordField == null) {				// �����롱�ı������Ϊ��ʱ
			passwordField = new JPasswordField();	// ʵ���������롱�ı���
			passwordField.setBounds(new Rectangle(87, 69, 125, 22));// ���á����롱�ı����λ�úͿ��
			passwordField.addKeyListener(new KeyAdapter() {// Ϊ�����롱�ı�����Ӽ���ʱ��ļ���
				public void keyTyped(KeyEvent e) {
					if (e.getKeyChar() == '\n')		// ���µİ����ǻس�ʱ
						loginButton.doClick();		// ���á���¼����ť�ĵ���¼�����ť������
				}
			});
		}
		return passwordField;						// ���ء����롱�ı���
	}
	//��¼��ť
	private JButton getLoginButton() {	// ��ʼ������¼����ť
		if (loginButton == null) {		// ����¼����ť����Ϊ��ʱ
			loginButton = new JButton();// ʵ��������¼����ť
			loginButton.setBounds(73, 104, 48, 20);	// ���á���¼����ť��λ�úͿ��
			loginButton.setIcon(new ImageIcon(getClass().getResource("/res/loginButton.jpg")));// ���á���¼����ť��ͼ��
			loginButton.addActionListener(new ActionListener() {			// Ϊ����¼����ť��Ӷ����¼��ļ�����==doClick()��
				public void actionPerformed(ActionEvent e) {
					try {
						userStr = userField.getText();			// ��á��û������ı����е�����
						String passStr = new String(passwordField.getPassword());// ��á����롱�ı����е�����
						if (!Dao.checkLogin(userStr, passStr)) {// ��֤�û���������ʧ��(�������ݿ������checkLogin()����)

							JOptionPane.showMessageDialog(LoginDialog.this, "�û����������޷���¼", "��¼ʧ��",
									JOptionPane.ERROR_MESSAGE);	// ��������¼ʧ�ܡ��Ի���
							return;
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
					mainFrame.setLocationRelativeTo(null);
					mainFrame.setVisible(true);							// ʹ������ɼ�
					MainFrame.getCzyStateLabel().setText(userStr);		// �����������в���Ա��ǩ��������
					setVisible(false);									// ʹ��¼���岻�ɼ�
				}
			});
		}
		return loginButton;// ���ء���¼����ť
	}
	//�˳���ť
	private JButton getExitButton() {	// ��ʼ�����˳�����ť
		if (exitButton == null) {		// ���˳�����ť����Ϊ��ʱ
			exitButton = new JButton();	// ʵ�������˳�����ť
			exitButton.setBounds(new Rectangle(145, 104, 48, 20));				// ���á��˳�����ť��λ�úͿ��
			exitButton.setIcon(new ImageIcon(getClass().getResource("/res/exitButton.jpg")));// ���á��˳�����ť��ͼ��
			exitButton.addActionListener(new ActionListener() {// Ϊ���˳�����ť�����¼��ļ���
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// �˳���ǰ��Ӧ�ó����˳����а��������壩
				}
			});
		}
		return exitButton;				// ���ء��˳�����ť
	}

	private void initialize() {				// ��ʼ����¼����
		Dimension size = getToolkit().getScreenSize();// �����Ļ�ߴ�(Java AWT��Toolkit�Ƕ�ϵͳ�Ͳ�ʵ��ͼ�οؼ�����������ܵ�һЩ�ӿ�)
		setLocation((size.width - 296) / 2, (size.height - 188) / 2);// ���õ�¼����
		setSize(296, 188);	// ���õ�¼����Ŀ��
		this.setTitle("�û���¼");			// ���õ�¼����ı���
		setContentPane(getLoginPanel());	// ����¼������ڵ�¼������
		setResizable(false);
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/res/0.png"));
		this.setIconImage(imageIcon.getImage());
	}

	public String getUserStr() {// ��á��û������ı����е�����
		return userStr;// ���ء��û������ı����е�����
	}//���������

}
