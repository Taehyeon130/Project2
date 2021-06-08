package com.workin.main;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class HomeMain extends Page{
	AppMain appMain;
	
	JPanel p_super; //전체 패널
	
	JPanel p_north; //북쪽 패널
	JButton bt_prev; //저번주로 이동
	JLabel date; //현재 년도와 월을 나타냄
	JButton bt_next; //다음주로 이동
	
	JPanel p_t; //테이블 올려놓을 패널
	JTable w_table; //테이블



	public HomeMain(AppMain appMain) {
		super(appMain);
		
		p_super = new JPanel();
		p_north = new JPanel();
		date = new JLabel();
		p_t = new JPanel();
		w_table = new JTable();
		
		
		
		
		setBackground(Color.WHITE);
		setVisible(true);
	}
}