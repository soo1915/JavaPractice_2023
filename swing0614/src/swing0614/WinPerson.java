package swing0614;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WinPerson extends JFrame{

	JLabel la1 = new JLabel("id");
	JLabel la2 = new JLabel("name");
	JLabel la3 = new JLabel("addr");
	JLabel la4 = new JLabel("phone");
	
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	
	JButton bt1 = new JButton("검색");
	JButton bt2 = new JButton("입력");
	JButton bt3 = new JButton("수정");
	JButton bt4 = new JButton("삭제");
	
	JTextArea ta = new JTextArea();
	
	Connection conn;
	
	WinPerson() throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:mariadb://localhost:3307/jspdb";
		String user = "root";
		String pass = "maria";
		Class.forName("org.mariadb.jdbc.Driver");
		//System.out.println("드라이버 로딩!");
		conn = DriverManager.getConnection(url, user, pass);
		//System.out.println("접속 성공!");
		
		//윈도우 기초 패널
		Container c = this.getContentPane();
		// 컴포넌트를 임의의 위치에 고정시키려고 
		this.setLayout(null);
		this.setTitle("person");
		this.setSize(545, 400);
		this.setLocation(500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 레이블
		la1.setSize(100, 30);
		la1.setLocation(50,10);
		c.add(la1);
		la2.setSize(100, 30);
		la2.setLocation(160,10);
		c.add(la2);
		la3.setSize(100, 30);
		la3.setLocation(270,10);
		c.add(la3);
		la4.setSize(100, 30);
		la4.setLocation(380,10);
		c.add(la4);
		
		// 텍스트필드
		tf1.setSize(100, 30);
		tf1.setLocation(50, 40);
		c.add(tf1);
		tf2.setSize(100, 30);
		tf2.setLocation(160, 40);
		c.add(tf2);
		tf3.setSize(100, 30);
		tf3.setLocation(270, 40);
		c.add(tf3);
		tf4.setSize(100, 30);
		tf4.setLocation(380, 40);
		c.add(tf4);
		
		// 버튼
		bt1.setSize(100, 30);
		bt1.setLocation(50, 280);
		c.add(bt1);
		bt2.setSize(100, 30);
		bt2.setLocation(160, 280);
		c.add(bt2);
		bt3.setSize(100, 30);
		bt3.setLocation(270, 280);
		c.add(bt3);
		bt4.setSize(100, 30);
		bt4.setLocation(380, 280);
		c.add(bt4);
	
		//textarea에 스크롤 기능 추가
		JScrollPane scrollPane = new JScrollPane(ta);
		ta.setCaretPosition(ta.getDocument().getLength());
		scrollPane.setSize(430, 170);
		scrollPane.setLocation(50, 90);
		c.add(scrollPane);
		
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String s1 = tf1.getText();
				String qstr1 = tf2.getText();;
				String qstr2 = tf3.getText();
				String qstr3 = tf4.getText();
				String sql = "select * from person"
						+ " where name like '%" + qstr1 + "%'"
						+ " and addr like '%" + qstr2 + "%'" 
						+ " and phone like '%" + qstr3 + "%'";
				if(!s1.equals("")) {
					sql = "select * from person where id = " + s1 ;
				}
				try {
					ta.setText("");
					Statement stmt = conn.createStatement();
					
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String addr = rs.getString("addr");
						String phone = rs.getString("phone");
						String str = String.format("%d\t%s\t%s\t%s\n", id, name, addr, phone);
						// 둘 다 가능
						//ta.append(id + "\t" +  name + "\t" + addr + "\t" + phone + "\n");
						ta.append(str);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new WinPerson();
		
	}

}
