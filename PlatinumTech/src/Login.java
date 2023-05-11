import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;

import java.sql.DriverManager;




public class Login {

	JFrame LoginPage;
	private JTextField txt_username;
	private JTextField txt_password;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.LoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LoginPage = new JFrame();
		LoginPage.setResizable(false);
		LoginPage.setTitle("PLATINUM TECH");
		LoginPage.setBounds(100, 100, 634, 417);
		LoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoginPage.getContentPane().setLayout(null);
		
		JLabel lbl_grpname = new JLabel("GLASS BUDDIES");
		lbl_grpname.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lbl_grpname.setBounds(229, 37, 167, 33);
		LoginPage.getContentPane().add(lbl_grpname);
		
		JLabel lbl_sysname = new JLabel("RESERVATION SYSTEM");
		lbl_sysname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_sysname.setBounds(204, 65, 228, 33);
		LoginPage.getContentPane().add(lbl_sysname);
		
		JLabel lbl_username = new JLabel("Username: ");
		lbl_username.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_username.setBounds(148, 127, 107, 22);
		LoginPage.getContentPane().add(lbl_username);
		
		JLabel lbl_password = new JLabel("Password:");
		lbl_password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_password.setBounds(148, 172, 107, 22);
		LoginPage.getContentPane().add(lbl_password);
		
		
		txt_username = new JTextField();
		txt_username.setColumns(10);
		txt_username.setBounds(241, 127, 188, 24);
		LoginPage.getContentPane().add(txt_username);
		
		txt_password = new JPasswordField();
		txt_password.setName("");
		txt_password.setColumns(10);
		txt_password.setBounds(241, 175, 188, 24);
		
		
	
		LoginPage.getContentPane().add(txt_password);
		
		JButton btn_login = new JButton("LOGIN");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String uname = txt_username.getText();
				String pass = txt_password.getText();
				
				if (uname.equals("") || pass.equals(""))   {
					JOptionPane.showMessageDialog(null, "Invalid Username or Password.");
				}
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/glassbuddies","root","");
					Statement stmt = con.createStatement();
					
					String sql ="Select * from Users where UserName='"+ uname +"' and Password='"+pass.toString()+"' and Type = 'customer'";
					ResultSet rs = stmt.executeQuery(sql);
					
						
					if (rs.next()) {
						//JOptionPane.showMessageDialog(null, "Login Successful!");
						
						LoginPage.setVisible(false);
						Home.main(null);	
					}
					/*else {
						JOptionPane.showMessageDialog(null, "Invalid Username or Password.");
					}*/
					
					
					
					String sql2 ="Select * from Users where UserName='"+ uname +"' and Password='"+pass.toString()+"' and Type = 'admin'";
					ResultSet rs2 =stmt.executeQuery(sql2);
				
					if (rs2.next()) {
						LoginPage.setVisible(false);
						Admin.main(null);	
					}
					
				
				
					
					con.close();
					
					
				}
				catch(Exception x) {System.out.print(x);}
				
				
				
		
			}
		});
		btn_login.setForeground(Color.GREEN);
		btn_login.setBackground(Color.WHITE);
		btn_login.setBounds(170, 249, 112, 33);
		LoginPage.getContentPane().add(btn_login);
		
		JButton btn_signup = new JButton("SIGNUP");
		btn_signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage.setVisible(false);
				Signup.main(null);
			}
		});
		btn_signup.setForeground(Color.RED);
		btn_signup.setBounds(307, 249, 112, 33);
		LoginPage.getContentPane().add(btn_signup);
		
		JLabel lbl_copyright = new JLabel("Copy Right Systems Ltd 2022");
		lbl_copyright.setBounds(237, 339, 195, 13);
		LoginPage.getContentPane().add(lbl_copyright);
		
		JLabel lbl_company = new JLabel("PLATINUM TECH");
		lbl_company.setBounds(261, 353, 112, 13);
		LoginPage.getContentPane().add(lbl_company);
		
		
	}
}
