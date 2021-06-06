package com.workin.calendar;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

public class DateLabel extends JLabel{
	
	int width;
	int height;
	Color color;
	String time;
	String title;
	
	CalendarMain calendarmain;
	
	public DateLabel(int width, int height, Color color, String time, String title) {
		this.width = width;
		this.height = height;
		this.color = color;
		this.time = time;
		this.title = title;
		
		setPreferredSize(new Dimension(width,height));
		setOpaque(true);
		setBackground(color);
		
		setText(time + title);
		
	}
	
}
