package dbms_ise;

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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Loginform2 extends JFrame {

	Connection con=null;
	Statement stmt;
	ResultSet rs;
	
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;
	public Loginform2()
	{
		setSize(300,300);
		setLayout(null);
		setTitle("Student Login");
		setLocationRelativeTo(null);
		JLabel l1=new JLabel("User Name :");
	    l1.setBounds(30,30,100,30);
	    add(l1);
	    
	    JLabel l2=new JLabel("PassWord  :");
	    l2.setBounds(30,80,100,30);
	    add(l2);
	    
	    t1= new JTextField();
	    t1.setBounds(140, 30, 100, 30);
	    add(t1);
	    
	    t2= new JPasswordField();
	    t2.setBounds(140, 80, 100, 30);
	    add(t2);
	    
	    b1= new JButton("Login");
	    b1.setBounds(30,150,80,40);
	    add(b1);
	    
	    b2= new JButton("Exit");
	    b2.setBounds(120,150,80,40);
	    add(b2);
	    
	    
	    b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String password= new String(t2.getPassword());
				String username=t1.getText().toString();
				int v=0;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ritindia","root","");
					stmt=con.createStatement();
					ResultSet rs =stmt.executeQuery("select * from ritstudent");
					
					while(rs.next())
					{
						if(username.equals(rs.getString(2)) && password.equals(rs.getString(1)))
						{
							v++;
							dispose();
							int r=Integer.parseInt(t2.getText());
							
							new Quiz(r,username);
							JOptionPane.showMessageDialog(null, "Login Successfully");
						}
						
					}
					if(v!=1)
					{
						JOptionPane.showMessageDialog(null, "Please enter valid Admin Name & Password");
					}
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
	    
	    
	    b2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Welcome();
			}
		});
	    
	    setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		new Loginform2();
	}

}
