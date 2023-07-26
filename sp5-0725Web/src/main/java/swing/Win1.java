package swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import dao.BoardDto;
import service.BoardService;

public class Win1 extends JFrame {
	
	ApplicationContext ctx ;
	private JFrame frame = this;
	
	JButton bt1 = new JButton("검색");
	JButton bt2 = new JButton("입력");
	JButton bt3 = new JButton("수정");
	JButton bt4 = new JButton("삭제");
	
	JTextArea ta = new JTextArea();

	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	
	JLabel lb1 = new JLabel("num");
	JLabel lb2 = new JLabel("writer");
	JLabel lb3 = new JLabel("title");
	JLabel lb4 = new JLabel("content");
	
	Win1() {
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		BoardService boardService = ctx.getBean("boardService", BoardService.class);
		
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
				ta.setText("");
				ArrayList<BoardDto> list = boardService.findAll();
				for (BoardDto dto : list) {
					ta.append(dto.toString() + "\n");
				}
				
			}
		});
		
		bt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tf1.getText() != "" && ("".equals(tf2.getText()) || "".equals(tf3.getText()) || "".equals(tf4.getText()))) {
					JOptionPane.showMessageDialog(frame, "아래 명령어 사용법을 확인하세요.\n"
							+ "저자명 글제목 글내용");
				} else {
					BoardDto dto = new BoardDto();
					dto.setWriter(tf2.getText());
					dto.setTitle(tf3.getText());
					dto.setContent(tf4.getText());
					boardService.saveOne(dto);
					JOptionPane.showMessageDialog(frame, "등록했습니다");
				}
				
				
			}
		});
		
		bt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if ("".equals(tf1.getText()) ||"".equals(tf2.getText()) || "".equals(tf3.getText()) || "".equals(tf4.getText())) {
					JOptionPane.showMessageDialog(frame, "아래 명령어 사용법을 확인하세요.\n"
							+ "번호 저자명 글제목 글내용");
				}
				Long num = (tf1.getText().length() > 0) ? Long.parseLong(tf1.getText())
		                : 0;
				if (num != 0 && boardService.hasArticle(num)) {
					BoardDto dto = new BoardDto(num, tf2.getText(), tf3.getText(), tf4.getText(), null, 0);
					boardService.modifyOne(dto);
					JOptionPane.showMessageDialog(frame, "글을 수정했습니다.");
				} else {
					JOptionPane.showMessageDialog(frame, "글 번호가 오류입니다.");
				}
			}
		});
		
		bt4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Long num = (tf1.getText().length() > 0) ? Long.parseLong(tf1.getText())
		                : 0;
				if (num != 0) {
					boardService.cancelOne(num);
					JOptionPane.showMessageDialog(frame, "글을 삭제했습니다.");
				}
			}
		});
		
	}

	public static void main(String[] args) {
		Win1 win = new Win1();

	}

}
