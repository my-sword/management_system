package com.mingrisoft.iframe;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.*;

import com.mingrisoft.*;
import com.mingrisoft.dao.Dao;
import com.mingrisoft.dao.model.*;

import static javax.swing.border.BevelBorder.RAISED;

public class JinHuoDan_IFrame extends JInternalFrame {// ����������

	private JPanel jContentPane = null;		// �������

	private JPanel topPanel = null;			// �������
	private JLabel idLabel = null;			// ������Ʊ�š���ǩ
	private JTextField idField = null;		// ������Ʊ�š��ı���
	private JLabel gysLabel = null;			// ����Ӧ�̡���ǩ
	private JComboBox gysComboBox = null;	// ����Ӧ�̡������б�
	private JLabel lxrLabel = null;			// ����ϵ�ˡ���ǩ
	private JTextField lxrField = null;		// ����ϵ�ˡ��ı���
	private JLabel jsfsLabel = null;		// �����㷽ʽ����ǩ
	private JComboBox jsfsComboBox = null;	// �����㷽ʽ�������б�
	private JLabel jhsjLabel = null;		// ������ʱ�䡱��ǩ
	private JTextField jhsjField = null;	// ������ʱ�䡱�ı���
	private JLabel jsrLabel = null;			// �������ˡ���ǩ
	private JComboBox jsrComboBox = null;	// �������ˡ������б�

	private JPanel bottomPanel = null;		// �ײ����
	private JLabel pzslLabel = null;		// ��Ʒ����������ǩ
	private JTextField pzslField = null;	// ��Ʒ���������ı���
	private JLabel hpzsLabel = null;		// ����Ʒ��������ǩ
	private JTextField hpzsField = null;	// ����Ʒ�������ı���
	private JLabel hjjeLabel = null;		// ���ϼƽ���ǩ
	private JTextField hjjeField = null;	// ���ϼƽ��ı���
	private JLabel ysjlLabel = null;		// �����ս��ۡ���ǩ
	private JTextField ysjlField = null;	// �����ս��ۡ��ı���
	private JLabel czyLabel = null;			// ������Ա����ǩ
	private JTextField czyField = null;		// ������Ա���ı���

	private JButton tjButton = null;		// ����ӡ���ť
	private JButton rukuButton = null;		// ����⡱��ť
	private JScrollPane tablePane = null;	// ������
	private JTable table = null;			// ���ģ��
	private JComboBox spComboBox = null;	// �������Ʒ�����б�����ָ����˾�Ƿ��д����

	private Date jhsjDate = new Date();		// �������ڶ���֮������ʱ�䡱

	/**
	 * ����������Ĺ��췽��
	 */
	public JinHuoDan_IFrame() {
		super();		// ���ø���JInternalFrame�Ĺ��췽��
		initialize();	// ��ʼ������������
	}

	/**
	 * ��ʼ������������ķ���
	 */
	private void initialize() {
		this.setSize(600, 320);	// ���ý���������Ŀ��
		this.setIconifiable(true);	// ���ý������������ͼ�껯
		this.setResizable(true);	// ���Ե�������������Ĵ�С
		this.setMaximizable(true);	// ���ý���������������
		this.setTitle("������");	// ���ý���������ı���
		this.setClosable(true);		// ���ý�����������Թر�
		this.setContentPane(getJContentPane());
		// �����������(�̳е���Frame��������add����getJContentPane()�������ó�Ϊframe���������)
	}

	/**
	 * ����������ķ���
	 * 
	 * @return �������
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {						// ������岻����
			jContentPane = new JPanel();				// �����������
			jContentPane.setLayout(new BorderLayout());	// �����߽粼��
			jContentPane.add(getTopPanel(), java.awt.BorderLayout.NORTH);	// �Ѷ�����������������ı���
			jContentPane.add(getTablePane(), java.awt.BorderLayout.CENTER);	// �ѱ������������������м�
			jContentPane.add(getBottomPanel(), java.awt.BorderLayout.SOUTH);// �ѵײ�����������������ϲ�
		}
		return jContentPane;
	}

	/**
	 * ��ö������ķ������ں������
	 * 
	 * @return ������壨�ں������
	 */
	private JPanel getTopPanel() {
		if (topPanel == null) {// ���������岻����
			/*
					gridx = 2; 		// ��(x)�ĵ�һ����Ԫ��
					gridy = 0; 		// ��(y)�ĵ�һ����Ԫ��
					gridwidth = 1; 	// ĳһ���е�Ԫ�������
					gridheight = 1; // ĳһ���е�Ԫ�������
					weightx = 0.0; 	// ��ηֲ������ˮƽ�ռ䣨�����ڷŴ�ʱ�����Ȳ��䣩
					weighty = 0.0; 	// ��ηֲ�����Ĵ�ֱ�ռ䣨�����ڷŴ�ʱ���߶Ȳ��䣩
					anchor = GridBagConstraints.NORTH; 	// �����û�пռ��ʱ��ʹ������ڱ���
					fill = GridBagConstraints.BOTH; 	// ��������ʣ��ռ�ʱ�����ռ�
					insert = new Insets(0, 0, 0, 0); 	// ����˴˵ļ��
					ipadx = 0; // ����ڲ����ռ䣬�����������С�����Ӷ��Ŀռ�
					ipady = 0; // ����ڲ����ռ䣬�����������С�߶���Ӷ��Ŀռ�
					new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, insert, ipadx, ipady);
			 *///GridBagConstraints˵��
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints11.gridx = 8;	// ���λ������ĺ�������Ϊ8
			gridBagConstraints11.gridy = 1;	// ���λ���������������Ϊ1
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints12.fill = GridBagConstraints.BOTH;				// ���ˮƽ����ֱͬʱ������ռ�ݿհ�����
			gridBagConstraints12.gridx = 9;		// ���λ������ĺ�������Ϊ9����9����Ԫ��λ�ã�
			gridBagConstraints12.gridy = 1;		// ���λ���������������Ϊ1
			gridBagConstraints12.weightx = 1.0;	// ������������Ȩ����1.0

			jsrLabel = new JLabel();// �������ˣ�����ǩ
			jsrLabel.setText("\u7ecf\u624b\u4eba\uff1a");// ���á������ˣ�����ǩ�е��ı�����

			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints10.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			gridBagConstraints10.gridy = 1;// ���λ���������������Ϊ1
			gridBagConstraints10.weightx = 1.0;// ������������Ȩ����1.0
			gridBagConstraints10.gridx = 5;// ���λ������ĺ�������Ϊ5
			GridBagConstraints gridBagConstraints09 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints09.gridx = 4;// ���λ������ĺ�������Ϊ4
			gridBagConstraints09.gridy = 1;// ���λ���������������Ϊ1

			jhsjLabel = new JLabel();// ������ʱ�䣺����ǩ
			jhsjLabel.setText("����ʱ�䣺");// ���á�����ʱ�䣺����ǩ�е��ı�����

			GridBagConstraints gridBagConstraints08 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints08.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			gridBagConstraints08.gridy = 1;// ���λ���������������Ϊ1
			gridBagConstraints08.weightx = 1.0;// ������������Ȩ����1.0
			gridBagConstraints08.gridx = 1;// ���λ������ĺ�������Ϊ1
			GridBagConstraints gridBagConstraints07 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints07.gridx = 0;// ���λ������ĺ�������Ϊ0
			gridBagConstraints07.gridy = 1;// ���λ���������������Ϊ1

			jsfsLabel = new JLabel();// �����㷽ʽ������ǩ
			jsfsLabel.setText("\u7ed3\u7b97\u65b9\u5f0f\uff1a");// ���á����㷽ʽ������ǩ�е��ı�����

			GridBagConstraints gridBagConstraints06 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints06.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			gridBagConstraints06.gridy = 0;// ���λ���������������Ϊ0
			gridBagConstraints06.weightx = 1.0;// ������������Ȩ����1.0
			gridBagConstraints06.gridx = 9;// ���λ������ĺ�������Ϊ9
			GridBagConstraints gridBagConstraints05 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints05.fill = GridBagConstraints.NONE;// ���������
			gridBagConstraints05.gridy = 0;// ���λ���������������Ϊ0
			gridBagConstraints05.gridx = 8;// ���λ������ĺ�������Ϊ8

			lxrLabel = new JLabel();// ����ϵ�ˣ�����ǩ
			lxrLabel.setText("\u8054\u7cfb\u4eba\uff1a");// ���á���ϵ�ˣ�����ǩ�е��ı�����

			GridBagConstraints gridBagConstraints03 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints03.gridx = 4;// ���λ������ĺ�������Ϊ4
			gridBagConstraints03.gridy = 0;// ���λ���������������Ϊ0
			GridBagConstraints gridBagConstraints04 = new GridBagConstraints();	// �����������ƶ���
			gridBagConstraints04.fill = GridBagConstraints.BOTH;					// ���ˮƽ����ֱͬʱ������ռ�ݿհ�����
			gridBagConstraints04.gridx = 5;		// ���λ������ĺ�������Ϊ5
			gridBagConstraints04.gridy = 0;		// ���λ���������������Ϊ0
			gridBagConstraints04.weightx = 1.0;	// ������������Ȩ����1.0

			gysLabel = new JLabel();// ����Ӧ�̣�����ǩ
			gysLabel.setText("\u4f9b\u5e94\u5546\uff1a");// ���á���Ӧ�̣�����ǩ�е��ı�����

			GridBagConstraints gridBagConstraints01 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints01.gridx = 0;// ���λ������ĺ�������Ϊ0
			gridBagConstraints01.gridy = 0;// ���λ���������������Ϊ0
			GridBagConstraints gridBagConstraints02 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints02.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			gridBagConstraints02.gridx = 1;// ���λ������ĺ�������Ϊ1
			gridBagConstraints02.gridy = 0;// ���λ���������������Ϊ0
			gridBagConstraints02.weightx = 1.0;// ������������Ȩ����1.0
			gridBagConstraints02.insets = new Insets(0, 0, 0, 1);// ����˴˵ļ��

			idLabel = new JLabel();// ������Ʊ�ţ�����ǩ
			idLabel.setText("����Ʊ�ţ�");// ���á�����Ʊ�ţ�����ǩ�е��ı�����

			topPanel = new JPanel();// �����������
			topPanel.setLayout(new GridBagLayout());			// ���ö������Ĳ���Ϊ���񲼾�
			topPanel.add(idLabel, gridBagConstraints01);		// �ѡ�����Ʊ�š���ǩ
			topPanel.add(getIdField(), gridBagConstraints02);	// �ѡ�����Ʊ�š��ı���
			topPanel.add(gysLabel, gridBagConstraints03);		// �ѡ���Ӧ�̡���ǩ
			topPanel.add(getGysComboBox_a(), gridBagConstraints04);	// �ѡ���Ӧ�̡������б�
			topPanel.add(lxrLabel, gridBagConstraints05);		// �ѡ���ϵ�ˡ���ǩ
			topPanel.add(getLxrField(), gridBagConstraints06);	// �ѡ���ϵ�ˡ��ı���
			topPanel.add(jsfsLabel, gridBagConstraints07);		// �ѡ����㷽ʽ����ǩ
			topPanel.add(getJsfsComboBox(), gridBagConstraints08);// �ѡ����㷽ʽ�������б�
			topPanel.add(jhsjLabel, gridBagConstraints09);		// �ѡ�����ʱ�䡱��ǩ
			topPanel.add(getJhsjField(), gridBagConstraints10);	// �ѡ�����ʱ�䡱�ı���
			topPanel.add(jsrLabel, gridBagConstraints11);		// �ѡ������ˡ���ǩ
			topPanel.add(getJsrComboBox(), gridBagConstraints12);//�ѡ������ˡ������б�
		}

		return topPanel;// ���ض������
	}



	/**
	 * ��á�����Ʊ�š��ı���ķ���
	 * 
	 * @return ������Ʊ�š��ı���
	 */
	private JTextField getIdField() {
		if (idField == null) {// ���������Ʊ�š��ı��򲻴���
			idField = new JTextField();
			idField.setEditable(false);// ���á�����Ʊ�š��ı��򲻿ɱ༭
		}
		return idField;
	}

	/**
	 * ��á���ϵ�ˡ��ı���ķ���
	 * 
	 * @return ����ϵ�ˡ��ı���
	 */
	private JTextField getLxrField() {
		if (lxrField == null) {// �������ϵ�ˡ��ı��򲻴���
			lxrField = new JTextField();// ��������ϵ�ˡ��ı���
		}
		return lxrField;
	}

	/**
	 * ��á����㷽ʽ���ı���ķ���
	 * 
	 * @return �����㷽ʽ���ı���
	 */
	private JComboBox getJsfsComboBox() {
		if (jsfsComboBox == null) {// �����㷽ʽ�������б�����
			jsfsComboBox = new JComboBox();// ���������㷽ʽ�������б�
			jsfsComboBox.addItem("�ֽ���");// �򡰽��㷽ʽ�������б�����ӡ��ֽ��ѡ��
			jsfsComboBox.addItem("֧Ʊ���");// �򡰽��㷽ʽ�������б�����ӡ�֧Ʊ��ѡ��
		}
		return jsfsComboBox;
	}

	/**
	 * ��á�����ʱ�䡱�ı���ķ���
	 * 
	 * @return ������ʱ�䡱�ı���
	 */
	private JTextField getJhsjField() {
		if (jhsjField == null) {// ������ʱ�䡱�ı��򲻴���
			jhsjField = new JTextField();// ����������ʱ�䡱�ı���
		}
		return jhsjField;
	}

	/**
	 * ��á�����Ա���ı���ķ���
	 * 
	 * @return ������Ա���ı���
	 */
	private JTextField getCzyField() {
		if (czyField == null) {// ������Ա���ı��򲻴���
			czyField = new JTextField();// ����������Ա���ı���
			czyField.setEditable(false);// ���á�����Ա���ı��򲻿ɱ༭
			czyField.setText(MainFrame.getCzyStateLabel().getText());// ���á�����Ա���ı����е��ı�����
		}
		return czyField;
	}

	/**
	 * ��õײ����ķ������ں������
	 * 
	 * @return �ײ���壨�ں������
	 */
	private JPanel getBottomPanel() {
		if (bottomPanel == null) {// ����ײ���岻����
			GridBagConstraints gridBagConstraints29 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints29.gridx = 2;// ���λ������ĺ�������Ϊ2
			gridBagConstraints29.gridy = 1;// ���λ���������������Ϊ1
			GridBagConstraints gridBagConstraints30 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints30.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			gridBagConstraints30.gridy = 1;// ���λ���������������Ϊ1
			gridBagConstraints30.weightx = 1.0;// ������������Ȩ����1.0
			gridBagConstraints30.gridx = 3;// ���λ������ĺ�������Ϊ3

			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();// �����������ƶ��󣿣���
			gridBagConstraints1.fill = GridBagConstraints.BOTH;// ���ˮƽ����ֱͬʱ������ռ�ݿհ�����
			gridBagConstraints1.gridy = 1;// ���λ���������������Ϊ1
			gridBagConstraints1.weightx = 1.0;// ������������Ȩ����1.0
			gridBagConstraints1.gridx = 9;// ���λ������ĺ�������Ϊ9

			GridBagConstraints gridBagConstraints32 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints32.fill = GridBagConstraints.NONE;// ���������
			gridBagConstraints32.gridy = 1;// ���λ���������������Ϊ1
			gridBagConstraints32.weightx = 0.3;// ������������Ȩ����0.3
			gridBagConstraints32.gridx = 6;// ���λ������ĺ�������Ϊ6
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints31.gridx = 5;// ���λ������ĺ�������Ϊ5
			gridBagConstraints31.weightx = 0.3;// ������������Ȩ����0.3
			gridBagConstraints31.gridy = 1;// ���λ���������������Ϊ1


			czyLabel = new JLabel();// ������Ա����ǩ
			czyLabel.setText("\u64cd\u4f5c\u5458\uff1a");// ���á�����Ա����ǩ�е��ı�����

			GridBagConstraints gridBagConstraints28 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints28.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			gridBagConstraints28.gridy = 1;// ���λ���������������Ϊ1
			gridBagConstraints28.weightx = 1.0;// ������������Ȩ����1.0
			gridBagConstraints28.gridx = 1;// ���λ������ĺ�������Ϊ1
			GridBagConstraints gridBagConstraints27 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints27.gridx = 0;// ���λ������ĺ�������Ϊ0
			gridBagConstraints27.gridy = 1;// ���λ���������������Ϊ1

			ysjlLabel = new JLabel();// �����ս��ۣ�����ǩ
			ysjlLabel.setText("\u9a8c\u6536\u7ed3\u8bba\uff1a");// ���á����ս��ۣ�����ǩ�е��ı�����

			GridBagConstraints gridBagConstraints26 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints26.anchor = GridBagConstraints.WEST;// ���������ʾ���������
			gridBagConstraints26.gridwidth = 2;// ������2������
			gridBagConstraints26.gridx = 5;// ���λ������ĺ�������Ϊ5
			gridBagConstraints26.gridy = 0;// ���λ���������������Ϊ0
			gridBagConstraints26.weightx = 0.6;// ������������Ȩ����0.6
			gridBagConstraints26.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			GridBagConstraints gridBagConstraints25 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints25.gridx = 4;// ���λ������ĺ�������Ϊ4
			gridBagConstraints25.gridy = 0;// ���λ���������������Ϊ0

			hjjeLabel = new JLabel();// ���ϼƽ�����ǩ
			hjjeLabel.setText("\u5408\u8ba1\u91d1\u989d\uff1a");// ���á��ϼƽ�����ǩ�е��ı�����

			GridBagConstraints gridBagConstraints24 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints24.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			gridBagConstraints24.gridy = 0;// ���λ���������������Ϊ0
			gridBagConstraints24.weightx = 1.0;// ������������Ȩ����1.0
			gridBagConstraints24.gridx = 3;// ���λ������ĺ�������Ϊ3
			GridBagConstraints gridBagConstraints23 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints23.gridx = 2;// ���λ������ĺ�������Ϊ2
			gridBagConstraints23.gridy = 0;// ���λ���������������Ϊ0

			hpzsLabel = new JLabel();// ����Ʒ����������ǩ
			hpzsLabel.setText("\u8d27\u54c1\u603b\u6570\uff1a");// ���á���Ʒ����������ǩ�е��ı�����

			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints22.fill = GridBagConstraints.HORIZONTAL;// ���ˮƽ������ռ�ݿհ�����
			gridBagConstraints22.gridy = 0;// ���λ���������������Ϊ0
			gridBagConstraints22.weightx = 1.0;// ������������Ȩ����1.0
			gridBagConstraints22.gridx = 1;// ���λ������ĺ�������Ϊ1
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();// �����������ƶ���
			gridBagConstraints21.anchor = GridBagConstraints.WEST;// ���������ʾ���������
			gridBagConstraints21.gridy = 0;// ���λ���������������Ϊ0
			gridBagConstraints21.gridx = 0;// ���λ������ĺ�������Ϊ0

			pzslLabel = new JLabel();// ��Ʒ������������ǩ
			pzslLabel.setText("\u54c1\u79cd\u6570\u91cf\uff1a");// ���á�Ʒ������������ǩ�е��ı�����
			
			bottomPanel = new JPanel();								// �����ײ����
			bottomPanel.setLayout(new GridBagLayout());				// ���õײ����Ĳ���Ϊ���񲼾�
			bottomPanel.add(pzslLabel, gridBagConstraints21);		// �ѡ�Ʒ����������ǩ
			bottomPanel.add(getPzslField(), gridBagConstraints22);	// �ѡ�Ʒ���������ı���
			bottomPanel.add(hpzsLabel, gridBagConstraints23);		// �ѡ���Ʒ����������ǩ
			bottomPanel.add(getHpzsField(), gridBagConstraints24);	// �ѡ���Ʒ�������ı���
			bottomPanel.add(hjjeLabel, gridBagConstraints25);		// �ѡ��ϼƽ�����ǩ
			bottomPanel.add(getHjjeField(), gridBagConstraints26);	// �ѡ��ϼƽ��ı���
			bottomPanel.add(ysjlLabel, gridBagConstraints27);		// �ѡ����ս��ۣ�����ǩ
			bottomPanel.add(getYsjlField(), gridBagConstraints28);	// �ѡ����ս��ۡ��ı���
			bottomPanel.add(czyLabel, gridBagConstraints29);		// �ѡ�����Ա������ǩ
			bottomPanel.add(getCzyField(), gridBagConstraints30);	// �ѡ�����Ա���ı���
			bottomPanel.add(getTjButton(), gridBagConstraints31);	// �ѡ���ӡ���ť
			bottomPanel.add(getRukuButton(), gridBagConstraints32);	// �ѡ���⡱��ť
		}
		return bottomPanel;// ���صײ����
	}

	/**
	 * ��á�Ʒ���������ı���ķ���
	 * 
	 * @return ��Ʒ���������ı���
	 */
	private JTextField getPzslField() {
		if (pzslField == null) {// �����Ʒ���������ı��򲻴���
			pzslField = new JTextField();// ������Ʒ���������ı���
			pzslField.setEditable(false);// ���á�Ʒ���������ı��򲻿ɱ༭
		}
		return pzslField;
	}
	/**
	 * ��á���Ʒ�������ı���ķ���
	 * 
	 * @return ����Ʒ�������ı���
	 */
	private JTextField getHpzsField() {
		if (hpzsField == null) {// �������Ʒ�������ı��򲻴���
			hpzsField = new JTextField();// ��������Ʒ�������ı���
			hpzsField.setEditable(false);// ���á���Ʒ�������ı��򲻿ɱ༭
		}
		return hpzsField;
	}
	/**
	 * ��á��ϼƽ��ı���ķ���
	 * 
	 * @return ���ϼƽ��ı���
	 */
	private JTextField getHjjeField() {
		if (hjjeField == null) {// ������ϼƽ��ı��򲻴���
			hjjeField = new JTextField();// �������ϼƽ��ı���
			hjjeField.setEditable(false);// ���á��ϼƽ��ı��򲻿ɱ༭
		}
		return hjjeField;
	}
	/**
	 * ��á����ս��ۡ��ı���ķ���
	 * 
	 * @return �����ս��ۡ��ı���
	 */
	private JTextField getYsjlField() {
		if (ysjlField == null) {// ��������ս��ۡ��ı��򲻴���
			ysjlField = new JTextField();// ���������ս��ۡ��ı���
		}
		return ysjlField;
	}

	//�¼�����
	/**
	 * ��á���ӡ���ť�ķ���
	 * 
	 * @return ����ӡ���ť
	 */
	private JButton getTjButton() {
		if (tjButton == null) {
			tjButton = new JButton();
			tjButton.setText("���");
			tjButton.addActionListener(new ActionListener() {	// Ϊ����ӡ���ť��Ӷ����¼��ļ���
				public void actionPerformed(ActionEvent e) {
					java.sql.Date date = new java.sql.Date(jhsjDate.getTime());// �������ݿ����ڶ���jhsjDate���ڶ���
					jhsjField.setText(date.toString());			// ���á�����ʱ�䡱�ı����е��ı�����
					String maxId = Dao.getRuKuMainMaxId(date);	// ��ȡ���ġ�����Ʊ�š���ͨ�����ݿ����ڶ����ݿ������
					idField.setText(maxId);// ���á�����Ʊ�š��ı����е��ı�����
					// ���������û�б�д�ĵ�Ԫ
					stopTableCellEditing();
					// �������в��������У����������
					for (int i = 0; i <= table.getRowCount() - 1; i++) {
						if (table.getValueAt(i, 0) == null)
							return;
					}
					DefaultTableModel model = (DefaultTableModel) table.getModel();// ����������
					model.addRow(new Vector());// ������ӿ���
				}
			});
		}
		return tjButton;
	}
	/**
	 * ��á���⡱��ť�ķ���
	 * 
	 * @return ����⡱��ť
	 */
	private JButton getRukuButton() {
		if (rukuButton == null) {// �������⡱��ť������
			rukuButton = new JButton();// ��������⡱��ť
			rukuButton.setText("���");// ���á���⡱��ť�е��ı�����
			rukuButton.addActionListener(new java.awt.event.ActionListener() {// Ϊ����⡱��ť��Ӷ����¼��ļ���
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// ֹͣ���Ԫ�ı༭������༭������
					stopTableCellEditing();
					// �������
					clearEmptyRow();
					String pzsStr = pzslField.getText();// Ʒ����
					String jeStr = hjjeField.getText();// �ϼƽ��
					String jsfsStr = jsfsComboBox.getSelectedItem().toString();// ���㷽ʽ
					String jsrStr = jsrComboBox.getSelectedItem() + "";// ������
					String czyStr = jsrComboBox.getSelectedItem() + "";// ����Ա
					String rkDate = jhsjField.getText();// ���ʱ��
					String ysjlStr = ysjlField.getText().trim();// ���ս���
					String id = idField.getText();// Ʊ��
					String gysName = gysComboBox.getSelectedItem() + "";// ��Ӧ������
					if (jsrStr == null || jsrStr.isEmpty()) {// ����������ˡ������б����ڻ򡰾����ˡ������б�Ϊ��
						JOptionPane.showMessageDialog(JinHuoDan_IFrame.this, "����д������");
						return;
					}
					if (ysjlStr == null || ysjlStr.isEmpty()) {// ��������ս��ۡ��ı��򲻴��ڻ����ս��ۡ��ı���Ϊ��
						JOptionPane.showMessageDialog(JinHuoDan_IFrame.this, "��д���ս���");
						return;
					}
					if (table.getRowCount() <= 0) {// ������ģ�͵�����С�ڵ���0
						JOptionPane.showMessageDialog(JinHuoDan_IFrame.this, "��������Ʒ");
						return;
					}

					TbRukuMain ruMain = new TbRukuMain(id, pzsStr, jeStr, ysjlStr, gysName, rkDate, czyStr, jsrStr,
							jsfsStr);// �������
					Set<TbRukuDetail> set = ruMain.getTabRukuDetails();// �����ϸ
					int rows = table.getRowCount();// ��ñ��ģ���е�����
					for (int i = 0; i < rows; i++) {
						TbSpinfo spinfo = (TbSpinfo) table.getValueAt(i, 0);// ��Ʒ��Ϣ
						if (spinfo == null || spinfo.getId() == null || spinfo.getId().isEmpty())// ��Ʒ��Ϣ�����ڡ���Ʒ��Ų����ڻ���Ʒ���Ϊ��
							continue;// ��������ѭ����ִ����һ��ѭ��
						String djStr = (String) table.getValueAt(i, 6);// ����
						String slStr = (String) table.getValueAt(i, 7);// ����
						Double dj = Double.valueOf(djStr);// ��String���͵ġ����ۡ�ת��Ϊint��
						Integer sl = Integer.valueOf(slStr);// ��String���͵ġ�������ת��Ϊint��
						TbRukuDetail detail = new TbRukuDetail();// �����ϸ
						detail.setTabSpinfo(spinfo.getId());// ��Ʒ��Ϣ
						detail.setTabRukuMain(ruMain.getRkId());// �������(�����)
						detail.setDj(dj);// ����
						detail.setSl(sl);// ����
						set.add(detail);// ��������ϸ
					}
					boolean rs = Dao.insertRukuInfo(ruMain);// �Ƿ�ɹ���������Ϣ
					if (rs) {// �ɹ���������Ϣ
						JOptionPane.showMessageDialog(JinHuoDan_IFrame.this, "������");// ������ʾ��
						DefaultTableModel dftm = new DefaultTableModel();// �������Ĭ��ģ�Ͷ���
						table.setModel(dftm);// ����������ģ������Ϊdftm
						pzslField.setText("0");// ���á�Ʒ���������ı����е�����Ϊ0
						hpzsField.setText("0");// ���á���Ʒ�������ı����е�����Ϊ0
						hjjeField.setText("0");// ���á��ϼƽ��ı����е�����Ϊ0
					}
				}
			});
		}
		return rukuButton;
	}

	/**
	 * ��ñ�����ķ���
	 * 
	 * @return ������
	 */
	private JScrollPane getTablePane() {
		if (tablePane == null) {// ��������岻����
			tablePane = new JScrollPane();// ����������
			tablePane.setViewportView(getTable());// �������ģ�ʹ���
		}
		return tablePane;
	}

	/**
	 * ��ñ��ģ�͵ķ���
	 * 
	 * @return ���ģ��
	 */
	private JTable getTable() {
		if (table == null) {// ������ģ�Ͳ�����
			String[] columnNames = { "��Ʒ����", "��Ʒ���", "����", "��λ", "���", "��װ", "����", "����", "����", "��׼�ĺ�" };// ��ͷ
			table = new JTable();// �������ģ��
			table.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));// ���ñ��ģ�͵ı߿���ʽ
			table.setShowGrid(true);// ����������
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���Զ������еĿ�ȣ�ʹ�ù�����
			// ����¼����Ʒ����������Ʒ�������ϼƽ��ļ���
			table.addContainerListener(new computeInfo());//��������¼�

			((DefaultTableModel) table.getModel()).setColumnIdentifiers(columnNames);// �������ģ�Ͷ�����������ӱ�ͷ
			TableColumn column = table.getColumnModel().getColumn(0);// �Ա��ģ��������Ϊ0����������
			final DefaultCellEditor editor = new DefaultCellEditor(getSpComboBox());// ������Ԫ��༭���������Է�����
			column.setCellEditor(editor);// ��ͷ����һ����Ԫ����������Ʒ���༭�������е�Ԫ��ʱ���õı༭��

			table.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(java.beans.PropertyChangeEvent e) {// Ϊ�����Ӹ������Եļ����¼�
					if ((e.getPropertyName().equals("tableCellEditor"))) {
						new computeInfo();// �¼����������ô��������ڼ����Ʒ�������ϼƽ�����Ϣ���Է�����
					}
				}
			});
		}
		return table;
	}

	/**
	 * ��á���Ʒ�������б�ķ���
	 * 
	 * @return ����Ʒ�������б�
	 */
	private JComboBox getSpComboBox() {
		if (spComboBox == null) {				// �������Ʒ�������б�����
			spComboBox = new JComboBox();		// ��������Ʒ�������б�
			spComboBox.addItem(new TbSpinfo());	// ����Ʒ�������б��������Ʒ��Ϣ��TbSpinfo��modelĿ¼��λ�ã����÷�װ��Ʒ�����Է�����
			spComboBox.addActionListener(new ActionListener() {// Ϊ����Ʒ�������б���Ӷ����¼��ļ���
				public void actionPerformed(ActionEvent e) {//��ȡ��Ӧ��Ӧ����Ϣ����Ʒ�����б���
					ResultSet set = Dao//'"+...+"'�Ǳ��ʽ���ӷ���
							.query("select * from tb_spinfo where gysName='" + getGysComboBox_a().getSelectedItem() + "'");// ���Է�����
					updateSpComboBox_a(set);// ������Ʒ�����б����Է�����
				}
			});
			spComboBox.addItemListener(new java.awt.event.ItemListener() {// Ϊ����Ʒ�������б����ѡ���¼��ļ���
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					TbSpinfo info = (TbSpinfo) spComboBox.getSelectedItem();// ��á���Ʒ�������б��б�ѡ�е���Ʒ��Ϣ
					// ���ѡ����Ч�͸��±��
					if (info != null && info.getId() != null) {
						updateTable();// ���±��ǰ�е����ݣ����Է�����
					}
				}
			});
		}
		return spComboBox;
	}

	/**
	 * ��á���Ӧ�̡������б�ķ���
	 *
	 * @return ����Ӧ�̡������б�
	 *///�ϲ����
	private JComboBox getGysComboBox_a() {
		if (gysComboBox == null) {				// �������Ӧ�̡������б�����
			gysComboBox = new JComboBox();		// ��������Ӧ�̡������б�
			List gysInfos = Dao.getGysInfos();	// ��ù�Ӧ����Ϣ�ļ���
			for (Iterator iter = gysInfos.iterator(); iter.hasNext();) {// ������Ӧ����Ϣ�ļ���
				List list = (List) iter.next();	// ��õ�������һ������
				Item item = new Item();			// ���ݱ�����
				item.setId(list.get(0).toString().trim());	// �������
				item.setName(list.get(1).toString().trim());// ������Ϣ
				gysComboBox.addItem(item);		// �򡰹�Ӧ�̡������б������ѡ��
			}
			Item item = (Item) gysComboBox.getSelectedItem();// ��á���Ӧ�̡������б��б�ѡ�е�ѡ��
			TbGysinfo gysInfo = Dao.getGysInfo(item);// ��Ӧ����Ϣ
			getLxrField().setText(gysInfo.getLian());// ���á���ϵ�ˡ��ı�����ı�����
		}

		return gysComboBox;
	}
	/**
	 * ������Ʒ�����б�ķ���
	 * 
	 * @param set��JDBC���ص�ResultSet�����
	 */
	private void updateSpComboBox_a(ResultSet set) {
		try {
			while (set.next()) {// �ƶ���ļ�¼ָ��ָ��һ����Ч�ļ�¼
				TbSpinfo spinfo = new TbSpinfo();// ��Ʒ��Ϣ
				spinfo.setId(set.getString("id").trim());// ��Ʒ���  trim()ȥ���ַ������˵Ķ���Ŀո�
				spinfo.setSpname(set.getString("spname").trim());// ��Ʒ����
				spinfo.setCd(set.getString("cd").trim());// ����
				spinfo.setJc(set.getString("jc").trim());// ��Ʒ���
				spinfo.setDw(set.getString("dw").trim());// ��Ʒ������λ
				spinfo.setGg(set.getString("gg").trim());// ��Ʒ���
				spinfo.setBz(set.getString("bz").trim());// ��װ
				spinfo.setPh(set.getString("ph").trim());// ����
				spinfo.setPzwh(set.getString("pzwh").trim());// ��׼�ĺ�
				spinfo.setMemo(set.getString("memo").trim());// ��ע
				spinfo.setGysname(set.getString("gysname").trim());// ��Ӧ������
				DefaultComboBoxModel model = (DefaultComboBoxModel) spComboBox.getModel();// ����Ʒ�������б��Ĭ��ģ��
				if (model.getIndexOf(spinfo) < 0)// ����Ʒ�������б���������Ʒ
					spComboBox.addItem(spinfo);// �����ѡ��յı�������б���Ӹ�����Ʒ�����б���ӿ��õ�������Ϣ��
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * ������Ʒ�����б��ѡ�񣬸��±��ǰ�е�����
	 */
	private synchronized void updateTable() {
		TbSpinfo spinfo = (TbSpinfo) spComboBox.getSelectedItem();// ��á���Ʒ�������б��б�ѡ�е�ѡ��
		int row = table.getSelectedRow();// ��ñ��ģ���б�ѡ�е���
		if (row >= 0 && spinfo != null) {// ���ģ���б�ѡ�е��д��ڵ���0�ҡ���Ʒ�������б��б�ѡ�е�ѡ�Ϊ��
			// ���ñ�ģ���е�Ԫ���ֵ
			table.setValueAt(spinfo.getId(), row, 1);// ��Ʒ���
			table.setValueAt(spinfo.getCd(), row, 2);// ����
			table.setValueAt(spinfo.getDw(), row, 3);// ��Ʒ������λ
			table.setValueAt(spinfo.getGg(), row, 4);// ��Ʒ���
			table.setValueAt(spinfo.getBz(), row, 5);// ��װ
			table.setValueAt("0", row, 6);// ����
			table.setValueAt("0", row, 7);// ����
			table.setValueAt(spinfo.getPh(), row, 8);// ����
			table.setValueAt(spinfo.getPzwh(), row, 9);// ��׼�ĺ�
			table.editCellAt(row, 6);// ���ۿɱ༭
		}
	}



	/**
	 * �÷�������ֹͣ���Ԫ�ı༭
	 */
	private void stopTableCellEditing() {
		TableCellEditor cellEditor = table.getCellEditor();// �������Ԫ�༭��
		if (cellEditor != null)// ���Ԫ�༭������
			cellEditor.stopCellEditing();// ֹͣ���Ԫ�ı༭
	}

	/**
	 * ��á������ˡ������б�ķ���
	 * 
	 * @return �������ˡ������б�
	 */
	private JComboBox getJsrComboBox() {
		if (jsrComboBox == null) {// ����������ˡ������б�����
			jsrComboBox = new JComboBox();// �����������ˡ������б�
			List<List> czyList = Dao.getJsrs();// ��ñ����õľ����˼��ϣ����ݿ��Է�����
			for (List<String> list : czyList) {// ���������õľ����˼���
				String id = list.get(0);		// �����˱��id
				String name = list.get(1);		// ����������
				Item item = new Item(id, name);	// ���ݱ�����
				item.setId(id + "");			// �������
				item.setName(name);				// ������Ϣ
				jsrComboBox.addItem(item);		// �򡰾����ˡ������б�����Ӿ�����
			}
		}
		return jsrComboBox;
	}

	/**
	 * �¼����������ô��������ڼ����Ʒ�������ϼƽ�����Ϣ��
	 */
	private final class computeInfo implements ContainerListener {
		@Override
		public void componentRemoved(ContainerEvent e) {
			clearEmptyRow();		// �������
			int rows = table.getRowCount();// ��ñ��ģ���е�����
			int count = 0;			// ����Ʒ������
			double money = 0.0;		// ���ϼƽ�
			TbSpinfo column = null;	// ����Ʒ��Ϣ����ʵ��
			if (rows > 0)			// ���ģ���е���������0
				column = (TbSpinfo) table.getValueAt(rows - 1, 0);// Ϊ����Ʒ��Ϣ����ʵ����ֵ
			if (rows > 0 && (column == null || column.getId().isEmpty()))// ���ģ���е���������0�ҡ���Ʒ��Ϣ����ʵ�������ڻ���Ʒ���Ϊ��
				rows--;// ���ģ���е�������һ
			// �����Ʒ�����ͺϼƽ��
			for (int i = 0; i < rows; i++) {
				String column7 = (String) table.getValueAt(i, 7);// ��ñ���С�������
				String column6 = (String) table.getValueAt(i, 6);// ��ñ���С����ۡ�
				int c7 = (column7 == null || column7.isEmpty()) ? 0 : Integer.parseInt(column7);// ��String���͵ġ�������ת��Ϊint��
				float c6 = (column6 == null || column6.isEmpty()) ? 0 : Float.parseFloat(column6);// ��String���͵ġ����ۡ�ת��Ϊfloat��
				count += c7;				// �����Ʒ����
				money += c6 * c7;			// ����ϼƽ�������Ʒ��
			}
			//����ʱ����д����
			pzslField.setText(rows + "");	// ���á�Ʒ���������ı����е��ı�����
			hpzsField.setText(count + "");	// ���á���Ʒ�������ı����е��ı�����
			hjjeField.setText(money + "");	// ���á��ϼƽ��ı����е��ı�����
		}
		@Override
		public void componentAdded(ContainerEvent e) {
		}
		
	}
	// �������
	private synchronized void clearEmptyRow() {
		DefaultTableModel dftm = (DefaultTableModel) table.getModel();// ���Ĭ�ϵı��ģ��
		for (int i = 0; i < table.getRowCount(); i++) {
			TbSpinfo spinfo = (TbSpinfo) table.getValueAt(i, 0);// �����Ʒ��Ϣ
			if (spinfo == null || spinfo.getId() == null || spinfo.getId().isEmpty()) {// ��Ʒ��ϢΪ��
				dftm.removeRow(i);// �Ƴ�Ĭ�ϵı��ģ���еĸ���
			}
		}
	}
}
