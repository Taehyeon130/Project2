package com.workin.calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import com.workin.main.AppMain;

//날짜 1개를 표현할 박스
public class DateBox  extends JPanel{
	int width;
	int height;
	String day;
	Color color;
	Color c_date;
	String d;
	ScheduleForm sch;
	DetailForm dt;
	CalendarMain calendarmain;
	int year;
	int month;
	boolean have;
	//AppMain appMain;
	
	public DateBox(String day,Color color, int width, int height,Color c_date,int year, int month,boolean have) {
		this.width = width;
		this.height = height;
		this.day = day;
		this.color = color;
		this.c_date = c_date;
		this.year = year;
		this.month = month;
		this.have = have;
		setPreferredSize(new Dimension(width,height));
	
	}
	
	public void paint(Graphics g) {
		//배경색도 여기서 처리
		g.setColor(color); //그래픽 객체의 물감색
		g.fillRect(0, 0, width,height);
		g.setColor(c_date); //그래픽 객체의 물감색 = 검정
		g.setFont(new Font("Arial-Black",100,18));
		g.drawString(day, 10, 30);
		//g.drawRect(20, 40, 100, 100);
	}
	

	public void click(AppMain appMain) {
		this.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				d=day;
				sch = new ScheduleForm(appMain, "신규 일정 등록",appMain,d,year,month);
				System.out.println("day의 값"+day);
				System.out.println("date에서 회원값"+appMain.getMember().getUser_name());
				//System.out.println("choose의 값"+sch.choose);
				if(have) {
					dt.setVisible(true);
				}else {
					sch.setVisible(true);
					
				}
			}
		});
	}	
}
