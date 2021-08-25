package dbms_ise;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Quiz extends JFrame {

	Connection con=null;
	Statement stmt;
	ResultSet rs;
	
	
     JLabel l1,l2;
     JRadioButton rb[]=new JRadioButton[5];
     ButtonGroup bg=new ButtonGroup();
     JButton b1,b2;
     int q[]=new int[5];
     int count=0,current=0,j;
     int rollno;
     String name;
	public Quiz(int roll,String sname)
	{
	      rollno=roll;
	      name=sname;
		setSize(600,400);
		setTitle("GK Quiz");
		setLayout(null);
		setLocationRelativeTo(null);
		l1=new JLabel("Quiz Form");
		l1.setBounds(150, 10,100, 40);
		add(l1);
		
		l2=new JLabel();
		l2.setBounds(30,70,500,30);
		add(l2);
		
		for(int i=0;i<4;i++)
		{
			rb[i]=new JRadioButton();
			add(rb[i]);
			bg.add(rb[i]);
		}
		setQesopt();
		
		b1=new JButton("Next"); 
		b1.setBounds(100,300,80,30);
		add(b1);
		
		b2=new JButton("Submit");
		
		b2.setBounds(250,300,80,30);
		add(b2);
		
		rb[0].setBounds(50,110,100,20);  
		rb[1].setBounds(50,150,100,20);
		rb[2].setBounds(50,190,100,20);
		rb[3].setBounds(50,230,100,20);
		
		setLocation(250,100);  
		setVisible(true);
		
		
		
				
		
		
		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(check())
				{
					count=count+1;
				}
				current++;
				setQesopt();
				if(current==4)
				{
					b1.setEnabled(false);
					b2.setText("Submit");
				}				
				
			}
		});
		
	 
		b2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(check())
				{
					count=count+1;
				}
				current++;
				JOptionPane.showMessageDialog(null,"Your Score : "+count);
                dispose();
                
                 int marks=count;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ritindia","root","");
					stmt=con.createStatement();
	                stmt.executeUpdate("insert into smarks values('"+rollno+"','"+marks+"','"+name+"')");
				
					
	             
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
			 
                new Welcome();
			}
		});
		
		
		
	
	}

	 void setQesopt() {
		// TODO Auto-generated method stub
		
		
		if(current==0)
		{
			 l2.setText("Q1:Which among the following is also popular as ‘Winter Planet?");  
	            rb[0].setText("Saturn");rb[1].setText("Venus");rb[2].setText("Jupiter");  
	                        rb[3].setText("Earth");
		}
		
		if(current==1)
		{
			 l2.setText("Q2:Which one of the following oceans has the busiest trade route?");  
	            rb[0].setText("Atlantic");rb[1].setText("Pacific");rb[2].setText("Indian");rb[3].setText("Arctic");  
			
		}
		
		if(current==2)
		{
			 l2.setText("Q3: Victoria Memorial is located in …………");  
	            rb[0].setText("Mumbai");rb[1].setText("Kolkata");rb[2].setText(" Mount Abu");rb[3].setText("Allahabad");  
			
		}
		
		if(current==3)
		{
			l2.setText("Q4:The Intelligence Department i.e. ‘Inter-Services Intelligence’ belongs to …");  
                   rb[0].setText("Korea");rb[1].setText("Pakistan");rb[2].setText("Spain");rb[3].setText("Bangladesh");  
		}
		if(current==4)
		{
			 l2.setText("Q5: Electronic Corporation of India is located in …");  
	            rb[0].setText("Jadugoda");rb[1].setText("Mumbai");rb[2].setText("Hyderabad");rb[3].setText("Trombay");  
		}
			
		  l2.setBounds(30,70,500,30);  
	        for(int i=0,j=0;i<=120;i+=40,j++)  
	            rb[j].setBounds(50,110+i,100,20);
		
	}
	 
	
	
	
	boolean check()  
	{
		 if(current==0)  
	            return(rb[2].isSelected());
		 if(current==1)  
	            return(rb[0].isSelected());
		 if(current==2)  
	            return(rb[1].isSelected());
		 if(current==3)  
	            return(rb[1].isSelected());
		 if(current==4)  
	            return(rb[2].isSelected());
		
		 return false;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
				
	}

}

