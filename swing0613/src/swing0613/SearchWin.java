package swing0613;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SearchWin extends JFrame {

	JLabel la = new JLabel("검색");
	JButton bt = new JButton("클릭");
	JTextField tf = new JTextField("입력");
	
	Connection conn;
	
	public SearchWin() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mariadb://localhost:3307/jspdb";
		String user = "root";
		String pass = "maria";
		Class.forName("org.mariadb.jdbc.Driver");
		System.out.println("드라이버 로딩!");
		conn = DriverManager.getConnection(url, user, pass);
		System.out.println("접속 성공!");
		
		Container c = this.getContentPane();
		this.setLayout(null);
		this.setTitle("검색 기능");
		this.setSize(400, 300);
		this.setLocation(500, 500);
		this.setVisible(true);
		la.setSize(100, 30);
		la.setLocation(30, 30);
		c.add(la);
		tf.setSize(100, 30);
		tf.setLocation(110, 30);
		c.add(tf);
		bt.setSize(100, 30);
		bt.setLocation(210, 30);
		c.add(bt);
		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = tf.getText();
				try {
					Statement stmt = conn.createStatement();
					String sql = "select * from person "
							+ "where name like '%" + str + "%'";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String addr = rs.getString("addr");
						String phone = rs.getString("phone");
						System.out.printf("%d, %s, %s, %s \n", id, name, addr, phone);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		new SearchWin();

		

	}

}
