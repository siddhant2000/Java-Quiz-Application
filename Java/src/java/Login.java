package dbms_ise;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

class MyLogin extends JFrame
{
	Connection con=null;
	Statement stmt;
	ResultSet rs;
	
	
	JTextField t1,t2,t3,t4;
	JButton b1,b2,b3,b4,b5,b6,b7;
	public MyLogin() 
	{
		
		setSize(400,500);
		setLayout(null);
		setTitle("Admin Page");
		setLocationRelativeTo(null);
		JLabel l1=new JLabel("Enter Roll no :");
	    l1.setBounds(30,30,100,30);
	    add(l1);
	    
	    JLabel l2=new JLabel("Enter Name :");
	    l2.setBounds(30,80,100,30);
	    add(l2);
	    
	    JLabel l3=new JLabel("Enter Address :");
	    l3.setBounds(30,150,100,30);
	    add(l3);
	    
	    JLabel l4=new JLabel("Enter Mobile no :");
	    l4.setBounds(30,230,100,30);
	    add(l4);
	    
	    t1= new JTextField();
	    t1.setBounds(140, 30, 100, 30);
	    add(t1);
	    
	    t2= new JTextField();
	    t2.setBounds(140, 80, 100, 30);
	    add(t2);
	    
	    t3= new JTextField();
	    t3.setBounds(140, 150, 100, 30);
	    add(t3);
	    
	    t4= new JTextField();
	    t4.setBounds(140, 230, 100, 30);
	    add(t4);
	    
	    
	     b1= new JButton("Add Student");
	    b1.setBounds(10,300,110,40);
	    add(b1);
	    
	    b2= new JButton("S_Marks");
	    b2.setBounds(135,300,110,40);
	    add(b2);
	    
	    b3= new JButton("Clear");
	    b3.setBounds(260,300,110,40);
	    add(b3);
	    
	    b4= new JButton("Delete");
	    b4.setBounds(10,350,110,40);
	    add(b4);
	    
	    b5= new JButton("Update");
	    b5.setBounds(135,350,110,40);
	    add(b5);
	    
	    b7= new JButton("View student");
	    b7.setBounds(260,350,110,40);
	    add(b7);
	    
	    b6= new JButton("LogOut");
	    b6.setBounds(120,400,150,40);
	    add(b6);
	    
	    
	    b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=t2.getText().toString();
				String address=t3.getText().toString();
				int rollno=Integer.parseInt(t1.getText());
				String mobile=t4.getText().toString();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ritindia","root","");
					stmt=con.createStatement();
					
					stmt.executeUpdate("insert into ritstudent values('"+rollno+"','"+name+"','"+address+"','"+mobile+"')");
					
					JOptionPane.showMessageDialog(null, "Submite Successfully");
					
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
				new Smarks();
				dispose();
			}
		});
	    
	    b3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				
			}
		});
	    
	    b4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int rollno=Integer.parseInt(t1.getText());
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ritindia","root","");
					stmt=con.createStatement();
					
					stmt.executeUpdate("delete from ritstudent where rollno='"+rollno+"' ");
					stmt.executeUpdate("delete from smarks where rollno='"+rollno+"' ");
					JOptionPane.showMessageDialog(null, "Delete Successfully");
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	    b5.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String newname=t2.getText().toString();
				int rollno=Integer.parseInt(t1.getText());
				String address=t3.getText().toString();
				String mobile=t4.getText().toString();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ritindia","root","");
					stmt=con.createStatement();
					
					stmt.executeUpdate("update ritstudent set name='"+newname+"', address='"+address+"', mobile='"+mobile+"' where rollno='"+rollno+"' ");
					stmt.executeUpdate("update smarks set name='"+newname+"' where rollno='"+rollno+"' ");
					JOptionPane.showMessageDialog(null, "Updated Successfully");
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	    
	    
	    b6.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Welcome();
			}
		});
		
	    
	    b7.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new StudentList();
			}
		});
	    
		setVisible(true);
	}
	
}




public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 new MyLogin();
		
	}

}

