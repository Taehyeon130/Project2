package com.workin.calendar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


//패널위의 라벨을 클릭했을 때 보여짐
public class DetailForm extends JDialog{
	
	JPanel p_whole; //전체를 담을 패널
	
	JPanel p_north1; //제목 올라올 패널
	JTextField title; //제목
	
	JPanel p_north2; //시간 올라올 패널
	JLabel l_date; //날짜
	JTextField f_date;
	JLabel l_time; //시간
	JTextField f_time;
	
	JPanel p_center; //내용올라올 패널
	JTextArea content; //내용
	
	JPanel p_south; //버튼 올라올 패널
	JButton bt_modify; //수정
	JButton bt_del; //삭제
	JButton bt_set; //완료
	
	
	String url = "jdbc:mysql://localhost:3306/workinapp?useSSL=false&characterEncoding=UTF-8";
	String user = "root";
	String password = "1234";
	Connection con;
	
	
	public DetailForm() {
		
		try{ //룩앤필이용해서 UI깔끔하게 
			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//LookAndFeel Windows 스타일 적용
			SwingUtilities.updateComponentTreeUI(this) ;
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, e);
		}
		
		//생성
		p_whole = new JPanel();
		
		p_north1 = new JPanel();
		title = new JTextField();
		
		p_north2 = new JPanel();
		l_date = new JLabel("날짜");
		f_date = new JTextField();
		l_time = new JLabel("시간");
		f_time = new JTextField();
		
		p_center = new JPanel();
		content = new JTextArea(18,50);
		
		p_south = new JPanel();
		bt_modify = new JButton("수정");
		bt_del = new JButton("삭제");
		bt_set = new JButton("완료");
		
		//스타일
		p_whole.setLayout(new GridLayout(2,1));
		title.setPreferredSize(new Dimension(350,30));
		f_time.setPreferredSize(new Dimension(100,30));
		f_date.setPreferredSize(new Dimension(120,30));
		l_time.setFont(new Font("Arial-Black", Font.BOLD, 15));
		l_date.setFont(new Font("Arial-Black", Font.BOLD, 15));
		
		//조립
		p_north1.add(title);
		p_north2.add(l_date);
		p_north2.add(f_date);
		p_north2.add(l_time);
		p_north2.add(f_time);
		p_whole.add(p_north1);
		p_whole.add(p_north2);
		
		p_center.add(content);
		
		p_south.add(bt_modify);
		p_south.add(bt_del);
		p_south.add(bt_set);
		
		add(p_whole,BorderLayout.NORTH);
		add(p_center,BorderLayout.CENTER);
		add(p_south,BorderLayout.SOUTH);
		
		
		//이벤트
		bt_modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifyCal();
			}
		});
		
		bt_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delCal();
			}
		});
		bt_set.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
		
		//보여주기
		setSize(520,540);
		setVisible(true);
	}
	
	// DB연결
	public void conn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");//1) 드라이버 로드
			con = DriverManager.getConnection(url,user,password);
			if(con!=null) {
				this.setTitle("접속 성공");
			}else {
				JOptionPane.showMessageDialog(this, "DB에 접속할 수 없습니다");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//db에서 정보 가져오기 - 제목, 내용, (AM or PM), 시간
	public void combolist() {
		String sql = "select cal_title,cal_content,cal_date,cal_time from calendar";
		
	}
	
	//수정
	public void modifyCal() {
		String sql = "";
	}
	
	//삭제
	public void delCal() {
		String sql = "";
	}
	
}
