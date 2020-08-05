package com.mingrisoft;
//�������(MenuBar+ToolBar+DesktopPanel)��LoginDialog(LoginPanel+����MainFrame����+Dao.checkLogin())����
//ToolBar(getFrameMenuBar()����ť��MenuBar.����)
//MenuBar����������������
//�˺����룺admin 123

//ɾ��Menubar 215
//��׼ JinHuoDan_IFrame
import static java.awt.BorderLayout.*;
import static javax.swing.border.BevelBorder.*;
import java.awt.*;
import java.util.Date;
import javax.swing.*;

import com.mingrisoft.login.LoginDialog;

public class MainFrame extends JFrame {		// ������
	private static final long serialVersionUID = 1L;
	private JPanel frameContentPane = null;	// ���������
	private MenuBar frameMenuBar = null;	// �����˵������������ࣩ
	private ToolBar toolBar = null;			// ���湤����(��ť������������)
	private DesktopPanel desktopPane = null;// �м�������壨�����Զ����࣬����ͼƬ��
	private JPanel statePanel = null;		// �ײ�״̬��壨�ں�ѡ������״̬������Ա����ǰ���ڡ���˾���Ƶ���Ϣ��

	private JLabel stateLabel = null;		// ѡ������״̬��ǩ
	private static JLabel czyStateLabel = null;// ������Ա����ǩ
	private JSeparator jSeparator2 = null;	// �ָ���
	private JLabel nowDateLabel = null;		// ����ǰ���ڡ���ǩ
	private JSeparator jSeparator1 = null;	// �ָ���
	private JLabel nameLabel = null;		// ����˾���ơ���ǩ


	/**
	 * ���������������г�������
	 * 
	 * @param args
	 * #����ʹ����ʹ��@Paramע������������ʱ�����ʹ�� #{} �� ${} �ķ�ʽ�����ԡ�
	 * ����#{}�ķ�ʽ��@Paramע�������ڵĲ����������ã������ڲ�����Ӧ�����β��� userName��Ӧ����name����
	 * ������xmlӳ��
	 */
	public static void main(String[] args) {
		/*
			��Java�������JVM������֮ǰ��������Ļ������Ӧ�ó�������ʱ��ʾ��
			������Ļ��ʾΪ����ͼ���δװ�δ��ڡ� ������Ϊͼ��ʹ��GIF��JPEG��PNG�ļ���
			����֧��GIF��ʽ����GIF��PNGҲ֧��͸���ȡ� ����λ����Ļ�����ġ� �������ϵͳ�ϵ�λ��δָ����
			����ƽ̨��ʵ�������ġ� һ��Swing / AWT��ʾ��һ�����ڣ�������Ļ���ھͻ��Զ��ر�
		 *///������Ļ����
		SplashScreen splashScreen = SplashScreen.getSplashScreen();// ����������Ļ����
		JFrame login = new LoginDialog();	// ��¼����
		if (splashScreen != null) {			// ������Ļ����Ϊ��
			try {
				login.setDefaultCloseOperation(EXIT_ON_CLOSE);
				Thread.sleep(3000);		// �߳�����3�루���ȴ�(����)���ڳ�������ȴ�3����ص�¼���ڣ�
			} catch (InterruptedException e) {

			}
		}
		login.setVisible(true);				// ʹ��¼����ɼ�
	}




	/**
	 * ��ʼ���������ķ���
	 * 
	 * @return JDesktopPane
	 */
	private DesktopPanel getDesktopPane() {
		if (desktopPane == null) {				// ����������Ϊ��
			desktopPane = new DesktopPanel();	// ��������������
		}
		return desktopPane;
	}

	/**
	 * ��ʼ��״̬���ķ���
	 * 
	 * @return JPanel
	 */
	private JPanel getStatePanel() {
		//�����鲼�ַ��� ����������������ʽ+�߽磩
		if (false) {
			//ѡ������
			GridBagConstraints gridBagConstraints = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints.gridx = 0;// ���λ������ĺ�������Ϊ0
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			gridBagConstraints.weightx = 1.0;// ������������Ȩ����1.0
			gridBagConstraints.gridy = 0;// ���λ���������������Ϊ0
			//�ָ������
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints6.gridx = 2;// ���λ������ĺ�������Ϊ2
			gridBagConstraints6.fill = GridBagConstraints.VERTICAL;// �����ֱ������ռ�ݿհ�����
			gridBagConstraints6.insets = new Insets(0, 5, 0, 5);// ����˴˵ļ��
			gridBagConstraints6.gridy = 0;// ���λ���������������Ϊ0
			//����Ա
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints4.gridx = 3;// ���λ������ĺ�������Ϊ3
			gridBagConstraints4.gridy = 0;// ���λ���������������Ϊ0
			//�ָ������
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints3.gridx = 6;// ���λ������ĺ�������Ϊ6
			gridBagConstraints3.fill = GridBagConstraints.VERTICAL;// �����ֱ������ռ�ݿհ�����
			gridBagConstraints3.insets = new Insets(0, 5, 0, 5);// ����˴˵ļ��
			gridBagConstraints3.gridy = 0;// ���λ���������������Ϊ0
			//��ǰ����
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints11.gridx = 5;// ���λ������ĺ�������Ϊ5
			gridBagConstraints11.insets = new Insets(0, 5, 0, 5);// ����˴˵ļ��
			gridBagConstraints11.gridy = 0;// ���λ���������������Ϊ0
			nowDateLabel = new JLabel();// ����ǰ���ڡ���ǩ
			Date now = new Date();// ����Date����
			nowDateLabel.setText(String.format("%tF", now));// ���á���ǰ���ڡ���ǩ���ı�����
			//��˾����
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints2.gridx = 7;// ���λ������ĺ�������Ϊ7
			gridBagConstraints2.weightx = 0.0;// ��������ϲ�����
			gridBagConstraints2.fill = GridBagConstraints.NONE;// ���������
			gridBagConstraints2.gridy = 0;// ���λ���������������Ϊ0
			nameLabel = new JLabel("����ʡ��̩�������޹�˾   ");// ����˾���ơ���ǩ
			//�ָ������
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints1.gridx = 4;// ���λ������ĺ�������Ϊ4
			gridBagConstraints1.fill = GridBagConstraints.VERTICAL;// �����ֱ������ռ�ݿհ�����
			gridBagConstraints1.weighty = 1.0;// ������������Ȩ����1.0
			gridBagConstraints1.insets = new Insets(0, 5, 0, 5);// ����˴˵ļ��
			gridBagConstraints1.gridy = 0;// ���λ���������������Ϊ0

			statePanel = new JPanel();								// ״̬���
			statePanel.setLayout(new GridBagLayout());						// ����״̬���Ĳ���
			statePanel.setBorder(BorderFactory.createBevelBorder(RAISED));	// ����״̬���ı߿�
			statePanel.add(getStateLabel(), gridBagConstraints);	// ��״̬��������ѡ������״̬��ǩ
			statePanel.add(getJSeparator(), gridBagConstraints1);	// ��״̬�������ӷָ���
			statePanel.add(nameLabel, gridBagConstraints2);			// ��״̬�������ӡ���˾���ơ���ǩ
			statePanel.add(getJSeparator1(), gridBagConstraints3);	// ��״̬�������ӷָ���
			statePanel.add(nowDateLabel, gridBagConstraints11);		// ��״̬�������ӡ���ǰ���ڡ���ǩ
			statePanel.add(getCzyStateLabel(), gridBagConstraints4);// ��״̬�������ӡ�����Ա����ǩ
			statePanel.add(getJSeparator2(), gridBagConstraints6);	// ��״̬�������ӷָ���
		}

		//��ʽ+�߽�(����)
		if (statePanel == null) {
			nameLabel = new JLabel("Ŭ���ܶ����޹�˾   ");// ����˾���ơ���ǩ
			JLabel Labelre = new JLabel(" | ");//�ָ�����ǩ //JSeparator()������Ӳ���
			nowDateLabel = new JLabel();// ����ǰ���ڡ���ǩ
			Date now = new Date();// ����Date����
			nowDateLabel.setText(String.format("%tF", now));// ���á���ǰ���ڡ���ǩ���ı�����

			statePanel = new JPanel();								// ״̬���
			statePanel.setLayout(new BorderLayout());
			statePanel.setBorder(BorderFactory.createBevelBorder(RAISED));// ����״̬���ı߿�


			JPanel Panel1 = new JPanel();
			Panel1.setLayout(new FlowLayout(2, 5, 0)); // ��������Ϊ�߽粼�ֹ�����
			Panel1.add(getStateLabel());	// ��״̬��������ѡ������״̬��ǩ

			JPanel Panel2 = new JPanel();
			Panel2.setLayout(new FlowLayout(2, 5, 0)); // ��������Ϊ�߽粼�ֹ�����
			Panel2.add(Labelre);			// ��״̬�������ӷָ���
			Panel2.add(getCzyStateLabel());	// ��״̬�������ӡ�����Ա����ǩ
			Panel2.add(Labelre);			// ��״̬�������ӷָ���
			Panel2.add(nowDateLabel);		// ��״̬�������ӡ���ǰ���ڡ���ǩ
			Panel2.add(Labelre);			// ��״̬�������ӷָ���
			Panel2.add(nameLabel);			// ��״̬�������ӡ���˾���ơ���ǩ

			statePanel.add(Panel1,BorderLayout.WEST);
			statePanel.add(Panel2,BorderLayout.EAST);

		}
		return statePanel;
	}

	public static JLabel getCzyStateLabel() {		// ��á�����Ա����ǩ�ķ����������ˣ�����Ӧ�����������ִ�������ݿ⣩
		if (czyStateLabel == null) {				// ������Ա����ǩ����Ϊ��
			czyStateLabel = new JLabel();			// ����������Ա����ǩ
			czyStateLabel.setText("����Ա��");		// ����ѡ������״̬��ǩ���ı�����
		}
		return czyStateLabel;
	}


	//ֻ�ʺ����񲼾�
	private JSeparator getJSeparator() {// ��÷ָ���
		JSeparator jSeparator = new JSeparator();// �����ָ�������
		jSeparator.setOrientation(JSeparator.VERTICAL);// ��ֱ�ָ���
		return jSeparator;
	}
	private JSeparator getJSeparator1() {// ��÷ָ���
		if (jSeparator1 == null) {// �ָ�������Ϊ��
			jSeparator1 = new JSeparator();// �����ָ�������
			jSeparator1.setOrientation(SwingConstants.VERTICAL);// ��ֱ�ָ���
		}
		return jSeparator1;
	}
	private JSeparator getJSeparator2() {// ��÷ָ���
		if (jSeparator2 == null) {// �ָ�������Ϊ��
			jSeparator2 = new JSeparator();// �����ָ�������
			jSeparator2.setOrientation(SwingConstants.VERTICAL);// ��ֱ�ָ���
		}
		return jSeparator2;
	}

	public MainFrame() {	// ȱʡ���캯��
		super();			// ���ø���JFrame�Ĺ�����
		initialize();		// ��ʼ��������ķ���
	}



	private void initialize() {					// ��ʼ��������ķ���
		this.setSize(800, 600);	// ����������Ŀ��
		this.setJMenuBar(getFrameMenuBar());	// ���ò˵���
		this.setContentPane(getFrameContentPane());// �����������
		this.setTitle("��Ʒ��������ϵͳ");		// ���ô������Ŀ
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/res/0.png"));
		this.setIconImage(imageIcon.getImage());
	}

	public JLabel getStateLabel() {					// ���ѡ������״̬��ǩ�ķ���
		if (stateLabel == null) {					// ѡ������״̬��ǩ����Ϊ��
			stateLabel = new JLabel();				// ����ѡ������״̬��ǩ
			stateLabel.setText("��ǰû��ѡ������");	// ����ѡ������״̬��ǩ���ı�����
		}
		return stateLabel;
	}
	/**
	 * ��ʼ������˵����ķ���
	 *
	 * @return JMenuBar
	 */
	protected MenuBar getFrameMenuBar() {           //�������� MenuBar
		if (frameMenuBar == null) {
			frameMenuBar = new MenuBar(getDesktopPane(), getStateLabel());// �����˵������󣨸�������ڶ����������޸ı�ǩ���֣�
		}
		return frameMenuBar;
	}

	/**
	 * ��ʼ��������
	 *
	 * @return JToolBar	#javaע�⣬һ��д�ڷ��������棬˵���÷����з���ֵ��ֻ����һ��˵�����ã�������ԳԤ����
	 */
	private ToolBar getJJToolBar() {
		if (toolBar == null) {									// ����������Ϊ�գ������ظ��Ϳ�ָ�룩
			toolBar = new ToolBar(getFrameMenuBar());			// ��������������
			toolBar.setCursor(new Cursor(Cursor.HAND_CURSOR));	// ���ù��ͼ�񣨱�����꣩
		}
		return toolBar;
	}

	private JPanel getFrameContentPane() {		// ����������ķ���
		if (frameContentPane == null) {			// ����������Ϊ��
			frameContentPane = new JPanel();	// �����������
			frameContentPane.setLayout(new BorderLayout());	// �����������Ĳ���
			frameContentPane.add(getStatePanel(), SOUTH);	// ״̬����������������ϲ�
			frameContentPane.add(getJJToolBar(), NORTH);	// �������������������ϲ�
			frameContentPane.add(getDesktopPane(), CENTER);	// ��������������������ϲ�
		}

		return frameContentPane;
	}
}