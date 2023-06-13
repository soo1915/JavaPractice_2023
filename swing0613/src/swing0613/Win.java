package swing0613;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Win extends JFrame {
	
	JLabel la = new JLabel("검색");
	JButton bt = new JButton("클릭");
	JTextField tf = new JTextField("여기에");

	Win() {
		Container c = this.getContentPane();
		this.setLayout(null);
		this.setTitle("처음 윈도우");
		this.setSize(300,300);
		this.setLocation(100,500);	
		this.setVisible(true);
		la.setSize(50,20);
		la.setLocation(30, 30);
		c.add(la);
		bt.setSize(60, 20);
		bt.setLocation(100,30);
		c.add(bt);
		tf.setSize(60,20);
		tf.setLocation(180,30);
		c.add(tf);
		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(tf.getText());
			}
			
		});
	}
	
//	class MyActionListener implements ActionListener{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			System.out.println("클릭!");
//			
//		}
//		
//	}
	
	public static void main(String[] args) {
		
		
		new Win();
		
	}

}
