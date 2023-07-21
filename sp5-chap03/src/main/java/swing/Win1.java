package swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.ChangePasswordService;
import spring.DuplicateMemberException;
import spring.MemberListPrinter;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.WrongIdPasswordException;

public class Win1 extends JFrame {
	
	private ApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
	private JFrame frame = this;
	
	Win1() {
		
		JButton bt1 = new JButton("new");
		JButton bt2 = new JButton("change");
		JButton bt3 = new JButton("list");
		JButton bt4 = new JButton("info");
		
		JTextArea ta = new JTextArea();

		JTextField tf1 = new JTextField();
		JTextField tf2 = new JTextField();
		JTextField tf3 = new JTextField();
		JTextField tf4 = new JTextField();
		
		JLabel lb1 = new JLabel("email");
		JLabel lb2 = new JLabel("name");
		JLabel lb3 = new JLabel("password");
		JLabel lb4 = new JLabel("confirm");
		
		Container c = this.getContentPane();
		this.setLayout(null);
		this.setTitle("person");
		this.setSize(430, 300);
		this.setLocation(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		bt1.setSize(70,  30);              // 폭과 높이 조절
		bt1.setLocation(20, 230);          // 위치 조정
		c.add(bt1);
		bt2.setSize(70,  30);              // 폭과 높이 조절
		bt2.setLocation(120, 230);          // 위치 조정
		c.add(bt2);
		bt3.setSize(70,  30);              // 폭과 높이 조절
		bt3.setLocation(220, 230);          // 위치 조정
		c.add(bt3);
		bt4.setSize(70,  30);              // 폭과 높이 조절
		bt4.setLocation(320, 230);          // 위치 조정
		c.add(bt4);
		
		tf1.setSize(70,  30);              // 폭과 높이 조절
		tf1.setLocation(20, 30);          // 위치 조정
		c.add(tf1);
		tf2.setSize(70,  30);              // 폭과 높이 조절
		tf2.setLocation(120, 30);          // 위치 조정
		c.add(tf2);
		tf3.setSize(70,  30);              // 폭과 높이 조절
		tf3.setLocation(220, 30);          // 위치 조정
		c.add(tf3);
		tf4.setSize(70,  30);              // 폭과 높이 조절
		tf4.setLocation(320, 30);          // 위치 조정
		c.add(tf4);
		
		lb1.setSize(70,  30);              // 폭과 높이 조절
		lb1.setLocation(20, 5);          // 위치 조정
		c.add(lb1);
		lb2.setSize(70,  30);              // 폭과 높이 조절
		lb2.setLocation(120, 5);          // 위치 조정
		c.add(lb2);
		lb3.setSize(70,  30);              // 폭과 높이 조절
		lb3.setLocation(220, 5);          // 위치 조정
		c.add(lb3);
		lb4.setSize(70,  30);              // 폭과 높이 조절
		lb4.setLocation(320, 5);          // 위치 조정
		c.add(lb4);
		
		JScrollPane scrollPane = new JScrollPane(ta);
		ta.setCaretPosition(ta.getDocument().getLength());
		scrollPane.setSize(350,  80);
		scrollPane.setLocation(30,  100);
		c.add(scrollPane);
		
		this.setVisible(true);
		
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("클릭!");
				//ta.append("클릭!\n");
				//JOptionPane.showMessageDialog(frame, "Welcome to Swing!");
				if ("".equals(tf1.getText()) ||
						"".equals(tf2.getText()) ||
						"".equals(tf3.getText()) ||
						"".equals(tf4.getText())) {
					JOptionPane.showMessageDialog(frame, "아래 명령어 사용법을 확인하세요.\n"
							+ "이메일 이름 암호 암호확인 모두 입력하세요");
					return;
				}
				MemberRegisterService regSvc = 
						ctx.getBean("memberRegSvc", MemberRegisterService.class);
				RegisterRequest req = new RegisterRequest();
				req.setEmail(tf1.getText());
				req.setName(tf2.getText());
				req.setPassword(tf3.getText());
				req.setConfirmPassword(tf4.getText());
				
				if (!req.isPasswordEqualToConfirmPassword()) {
					JOptionPane.showMessageDialog(frame, "암호와 확인이 일치하지 않습니다.\n");
					return;
				}
				try {
					regSvc.regist(req);
					JOptionPane.showMessageDialog(frame, "등록했습니다.\n");
				} catch (DuplicateMemberException de) {
					JOptionPane.showMessageDialog(frame, "이미 존재하는 이메일입니다.\n");
				}
			}
		});
	
		bt2.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("클릭!");
				//ta.append("클릭!\n");
				//JOptionPane.showMessageDialog(frame, "Welcome to Swing!");
				if ("".equals(tf1.getText()) ||
						"".equals(tf3.getText()) ||
						"".equals(tf4.getText())) {
					JOptionPane.showMessageDialog(frame, "아래 명령어 사용법을 확인하세요.\n"
							+ "이메일 현재비번 변경비번 모두 입력하세요");
					return;
				}
				ChangePasswordService changePwdSvc = 
						ctx.getBean("changePwdSvc", ChangePasswordService.class);
				RegisterRequest req = new RegisterRequest();
				req.setEmail(tf1.getText());
				req.setPassword(tf3.getText());
				req.setConfirmPassword(tf4.getText());
				
				try {
					changePwdSvc.changePassword(tf1.getText(), tf3.getText(), tf4.getText());
					JOptionPane.showMessageDialog(frame, "암호를 변경했습니다.\n");
				} catch (MemberNotFoundException de) {
					JOptionPane.showMessageDialog(frame, "존재하지 않는 이메일입니다.\n");
				} catch (WrongIdPasswordException me) {
					JOptionPane.showMessageDialog(frame, "이메일과 암호가 일치하지 않습니다.\n");
				}
			}
		});
		
		bt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberListPrinter listPrinter = 
						ctx.getBean("listPrinter", MemberListPrinter.class);
				//ta.setText("");
				ta.setText(listPrinter.printAllS());
			}
		});
	}
	

	public static void main(String[] args) {
		Win1 win = new Win1();

	}

}
