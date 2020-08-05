package com.mingrisoft;
//程序入口(MenuBar+ToolBar+DesktopPanel)→LoginDialog(LoginPanel+调用MainFrame构造+Dao.checkLogin())→→
//ToolBar(getFrameMenuBar()→按钮←MenuBar.属性)
//MenuBar→→→→→→→→
//账号密码：admin 123

//删除Menubar 215
//标准 JinHuoDan_IFrame
import static java.awt.BorderLayout.*;
import static javax.swing.border.BevelBorder.*;
import java.awt.*;
import java.util.Date;
import javax.swing.*;

import com.mingrisoft.login.LoginDialog;

public class MainFrame extends JFrame {		// 主窗体
	private static final long serialVersionUID = 1L;
	private JPanel frameContentPane = null;	// 总内容面板
	private MenuBar frameMenuBar = null;	// 顶部菜单栏（调用自类）
	private ToolBar toolBar = null;			// 上面工具栏(按钮栏，调用自类)
	private DesktopPanel desktopPane = null;// 中间桌面面板（调用自定义类，背景图片）
	private JPanel statePanel = null;		// 底部状态面板（内含选定窗体状态、操作员、当前日期、公司名称等信息）

	private JLabel stateLabel = null;		// 选定窗体状态标签
	private static JLabel czyStateLabel = null;// “操作员”标签
	private JSeparator jSeparator2 = null;	// 分隔符
	private JLabel nowDateLabel = null;		// “当前日期”标签
	private JSeparator jSeparator1 = null;	// 分隔符
	private JLabel nameLabel = null;		// “公司名称”标签


	/**
	 * 程序主方法，运行程序的入口
	 * 
	 * @param args
	 * #当你使用了使用@Param注解来声明参数时，如果使用 #{} 或 ${} 的方式都可以。
	 * 采用#{}的方式把@Param注解括号内的参数进行引用（括号内参数对应的是形参如 userName对应的是name）；
	 * 作用于xml映射
	 */
	public static void main(String[] args) {
		/*
			在Java虚拟机（JVM）启动之前，启动屏幕可以在应用程序启动时显示。
			启动屏幕显示为包含图像的未装饰窗口。 您可以为图像使用GIF，JPEG或PNG文件。
			动画支持GIF格式，而GIF和PNG也支持透明度。 窗口位于屏幕的中心。 多监视器系统上的位置未指定。
			它是平台和实现依赖的。 一旦Swing / AWT显示第一个窗口，启动屏幕窗口就会自动关闭
		 *///闪现屏幕对象
		SplashScreen splashScreen = SplashScreen.getSplashScreen();// 创建闪现屏幕对象
		JFrame login = new LoginDialog();	// 登录窗体
		if (splashScreen != null) {			// 闪现屏幕对象不为空
			try {
				login.setDefaultCloseOperation(EXIT_ON_CLOSE);
				Thread.sleep(3000);		// 线程休眠3秒（若等待(闪现)窗口出现了则等待3秒加载登录窗口）
			} catch (InterruptedException e) {

			}
		}
		login.setVisible(true);				// 使登录窗体可见
	}




	/**
	 * 初始化桌面面板的方法
	 * 
	 * @return JDesktopPane
	 */
	private DesktopPanel getDesktopPane() {
		if (desktopPane == null) {				// 桌面面板对象为空
			desktopPane = new DesktopPanel();	// 创建桌面面板对象
		}
		return desktopPane;
	}

	/**
	 * 初始化状态面板的方法
	 * 
	 * @return JPanel
	 */
	private JPanel getStatePanel() {
		//网格组布局方法 比例伸缩（不如流式+边界）
		if (false) {
			//选定窗体
			GridBagConstraints gridBagConstraints = new GridBagConstraints();// 创建网格限制对象
			gridBagConstraints.gridx = 0;// 组件位于网格的横向索引为0
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;// 组件水平扩大以占据空白区域
			gridBagConstraints.weightx = 1.0;// 组件横向扩大的权重是1.0
			gridBagConstraints.gridy = 0;// 组件位于网格的纵向索引为0
			//分隔符面板
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();// 创建网格限制对象
			gridBagConstraints6.gridx = 2;// 组件位于网格的横向索引为2
			gridBagConstraints6.fill = GridBagConstraints.VERTICAL;// 组件垂直扩大以占据空白区域
			gridBagConstraints6.insets = new Insets(0, 5, 0, 5);// 组件彼此的间距
			gridBagConstraints6.gridy = 0;// 组件位于网格的纵向索引为0
			//操作员
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();// 创建网格限制对象
			gridBagConstraints4.gridx = 3;// 组件位于网格的横向索引为3
			gridBagConstraints4.gridy = 0;// 组件位于网格的纵向索引为0
			//分隔符面板
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();// 创建网格限制对象
			gridBagConstraints3.gridx = 6;// 组件位于网格的横向索引为6
			gridBagConstraints3.fill = GridBagConstraints.VERTICAL;// 组件垂直扩大以占据空白区域
			gridBagConstraints3.insets = new Insets(0, 5, 0, 5);// 组件彼此的间距
			gridBagConstraints3.gridy = 0;// 组件位于网格的纵向索引为0
			//当前日期
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();// 创建网格限制对象
			gridBagConstraints11.gridx = 5;// 组件位于网格的横向索引为5
			gridBagConstraints11.insets = new Insets(0, 5, 0, 5);// 组件彼此的间距
			gridBagConstraints11.gridy = 0;// 组件位于网格的纵向索引为0
			nowDateLabel = new JLabel();// “当前日期”标签
			Date now = new Date();// 创建Date对象
			nowDateLabel.setText(String.format("%tF", now));// 设置“当前日期”标签的文本内容
			//公司名称
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();// 创建网格限制对象
			gridBagConstraints2.gridx = 7;// 组件位于网格的横向索引为7
			gridBagConstraints2.weightx = 0.0;// 组件横向上不扩大
			gridBagConstraints2.fill = GridBagConstraints.NONE;// 组件不扩大
			gridBagConstraints2.gridy = 0;// 组件位于网格的纵向索引为0
			nameLabel = new JLabel("吉林省铭泰××有限公司   ");// “公司名称”标签
			//分隔符面板
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();// 创建网格限制对象
			gridBagConstraints1.gridx = 4;// 组件位于网格的横向索引为4
			gridBagConstraints1.fill = GridBagConstraints.VERTICAL;// 组件垂直扩大以占据空白区域
			gridBagConstraints1.weighty = 1.0;// 组件纵向扩大的权重是1.0
			gridBagConstraints1.insets = new Insets(0, 5, 0, 5);// 组件彼此的间距
			gridBagConstraints1.gridy = 0;// 组件位于网格的纵向索引为0

			statePanel = new JPanel();								// 状态面板
			statePanel.setLayout(new GridBagLayout());						// 设置状态面板的布局
			statePanel.setBorder(BorderFactory.createBevelBorder(RAISED));	// 设置状态面板的边框
			statePanel.add(getStateLabel(), gridBagConstraints);	// 向状态面板中添加选定窗体状态标签
			statePanel.add(getJSeparator(), gridBagConstraints1);	// 向状态面板中添加分隔符
			statePanel.add(nameLabel, gridBagConstraints2);			// 向状态面板中添加“公司名称”标签
			statePanel.add(getJSeparator1(), gridBagConstraints3);	// 向状态面板中添加分隔符
			statePanel.add(nowDateLabel, gridBagConstraints11);		// 向状态面板中添加“当前日期”标签
			statePanel.add(getCzyStateLabel(), gridBagConstraints4);// 向状态面板中添加“操作员”标签
			statePanel.add(getJSeparator2(), gridBagConstraints6);	// 向状态面板中添加分隔符
		}

		//流式+边界(主流)
		if (statePanel == null) {
			nameLabel = new JLabel("努力奋斗有限公司   ");// “公司名称”标签
			JLabel Labelre = new JLabel(" | ");//分隔符标签 //JSeparator()对象添加不了
			nowDateLabel = new JLabel();// “当前日期”标签
			Date now = new Date();// 创建Date对象
			nowDateLabel.setText(String.format("%tF", now));// 设置“当前日期”标签的文本内容

			statePanel = new JPanel();								// 状态面板
			statePanel.setLayout(new BorderLayout());
			statePanel.setBorder(BorderFactory.createBevelBorder(RAISED));// 设置状态面板的边框


			JPanel Panel1 = new JPanel();
			Panel1.setLayout(new FlowLayout(2, 5, 0)); // 设置容器为边界布局管理器
			Panel1.add(getStateLabel());	// 向状态面板中添加选定窗体状态标签

			JPanel Panel2 = new JPanel();
			Panel2.setLayout(new FlowLayout(2, 5, 0)); // 设置容器为边界布局管理器
			Panel2.add(Labelre);			// 向状态面板中添加分隔符
			Panel2.add(getCzyStateLabel());	// 向状态面板中添加“操作员”标签
			Panel2.add(Labelre);			// 向状态面板中添加分隔符
			Panel2.add(nowDateLabel);		// 向状态面板中添加“当前日期”标签
			Panel2.add(Labelre);			// 向状态面板中添加分隔符
			Panel2.add(nameLabel);			// 向状态面板中添加“公司名称”标签

			statePanel.add(Panel1,BorderLayout.WEST);
			statePanel.add(Panel2,BorderLayout.EAST);

		}
		return statePanel;
	}

	public static JLabel getCzyStateLabel() {		// 获得“操作员”标签的方法（不见了？？？应该是其它部分代码或数据库）
		if (czyStateLabel == null) {				// “操作员”标签对象为空
			czyStateLabel = new JLabel();			// 创建“操作员”标签
			czyStateLabel.setText("操作员：");		// 设置选定窗体状态标签的文本内容
		}
		return czyStateLabel;
	}


	//只适合网格布局
	private JSeparator getJSeparator() {// 获得分隔符
		JSeparator jSeparator = new JSeparator();// 创建分隔符对象
		jSeparator.setOrientation(JSeparator.VERTICAL);// 竖直分隔符
		return jSeparator;
	}
	private JSeparator getJSeparator1() {// 获得分隔符
		if (jSeparator1 == null) {// 分隔符对象为空
			jSeparator1 = new JSeparator();// 创建分隔符对象
			jSeparator1.setOrientation(SwingConstants.VERTICAL);// 竖直分隔符
		}
		return jSeparator1;
	}
	private JSeparator getJSeparator2() {// 获得分隔符
		if (jSeparator2 == null) {// 分隔符对象为空
			jSeparator2 = new JSeparator();// 创建分隔符对象
			jSeparator2.setOrientation(SwingConstants.VERTICAL);// 竖直分隔符
		}
		return jSeparator2;
	}

	public MainFrame() {	// 缺省构造函数
		super();			// 调用父类JFrame的构造器
		initialize();		// 初始化主窗体的方法
	}



	private void initialize() {					// 初始化主窗体的方法
		this.setSize(800, 600);	// 设置主窗体的宽高
		this.setJMenuBar(getFrameMenuBar());	// 设置菜单栏
		this.setContentPane(getFrameContentPane());// 设置内容面板
		this.setTitle("商品出入库管理系统");		// 设置窗体的题目
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/res/0.png"));
		this.setIconImage(imageIcon.getImage());
	}

	public JLabel getStateLabel() {					// 获得选定窗体状态标签的方法
		if (stateLabel == null) {					// 选定窗体状态标签对象为空
			stateLabel = new JLabel();				// 创建选定窗体状态标签
			stateLabel.setText("当前没有选定窗体");	// 设置选定窗体状态标签的文本内容
		}
		return stateLabel;
	}
	/**
	 * 初始化窗体菜单栏的方法
	 *
	 * @return JMenuBar
	 */
	protected MenuBar getFrameMenuBar() {           //调用自类 MenuBar
		if (frameMenuBar == null) {
			frameMenuBar = new MenuBar(getDesktopPane(), getStateLabel());// 创建菜单栏对象（父组件，第二个参数是修改标签文字）
		}
		return frameMenuBar;
	}

	/**
	 * 初始化工具栏
	 *
	 * @return JToolBar	#java注解，一般写在方法的上面，说明该方法有返回值。只是起到一个说明作用（给程序猿预览）
	 */
	private ToolBar getJJToolBar() {
		if (toolBar == null) {									// 工具栏对象为空（避免重复和空指针）
			toolBar = new ToolBar(getFrameMenuBar());			// 创建工具栏对象
			toolBar.setCursor(new Cursor(Cursor.HAND_CURSOR));	// 设置光标图像（本机光标）
		}
		return toolBar;
	}

	private JPanel getFrameContentPane() {		// 获得内容面板的方法
		if (frameContentPane == null) {			// 内容面板对象为空
			frameContentPane = new JPanel();	// 创建内容面板
			frameContentPane.setLayout(new BorderLayout());	// 设置内容面板的布局
			frameContentPane.add(getStatePanel(), SOUTH);	// 状态面板置于内容面板的南部
			frameContentPane.add(getJJToolBar(), NORTH);	// 工具栏置于内容面板的南部
			frameContentPane.add(getDesktopPane(), CENTER);	// 背景面板置于内容面板的南部
		}

		return frameContentPane;
	}
}