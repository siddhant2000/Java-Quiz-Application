package dbms_ise;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Smarks extends JFrame{

	Connection con=null;
	Statement stmt;
	ResultSet rs;
	JPanel panel;
	 public Smarks()
	 {
		 setSize(500,500);
		 setLayout(null);
		 setTitle("Student Marks");
		 setLocationRelativeTo(null);
		 DefaultTableModel model = new DefaultTableModel();
		 JTable jtbl = new JTable(model);
		 Container cnt = this.getContentPane();
		 cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
		 model.addColumn("Roll NO ");
		 model.addColumn("Student Name");
		 model.addColumn("Marks");
		
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ritindia","root","");
				stmt=con.createStatement();
                rs =stmt.executeQuery("select * from smarks");
			
				while(rs.next())
				{ 
					model.addRow(new Object[]{rs.getInt(1),rs.getString(3),rs.getInt(2)});
				}
				
             //System.out.println("hii");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
		 
		           
		 JScrollPane pg = new JScrollPane(jtbl);
		 pg.setSize(320,200);
	        cnt.add(pg);
	        this.pack();
		 
	        
	        panel=new JPanel();
	        panel.setBounds(0,350,500,80);
	        pg.add(panel);
	        JButton back=new JButton("Back");
	        back.setBounds(175,30,100,40);
	        panel.add(back);
	        
	        back.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
					new MyLogin();
				}
			});
	        
		 setVisible(true);
	 }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
            new Smarks();
	}

}
