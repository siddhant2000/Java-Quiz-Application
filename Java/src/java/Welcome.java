package dbms_ise;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends JFrame {

	public Welcome()
	{
		setSize(500,600);
		setLayout(null);
		setTitle("Java Online Quiz");
		setLocationRelativeTo(null);
		
		ImageIcon img=new ImageIcon("C:\\Users\\admin\\Desktop\\dbmsise\\Java.jpg");
		JLabel l2=new JLabel("",img,JLabel.CENTER);
		l2.setBounds(0,0,500,600);
		add(l2);
		
		JLabel l1=new JLabel("Java Quiz");
		l1.setBounds(155,0,300,100);
		l1.setFont(new Font("Serif", Font.BOLD, 40));
		l2.add(l1);
		
		JButton b1= new JButton("Admin");
	    b1.setBounds(100,350,120,50);
	    l2.add(b1);
	    

		JButton b2= new JButton("Student");
	    b2.setBounds(300,350,120,50);
	    l2.add(b2);
		
	    b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Admin();
			}
		});
		
      b2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Loginform2();
			}
		});
	    
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Welcome();
		
		
		
	}

}