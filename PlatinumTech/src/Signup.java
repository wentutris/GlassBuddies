import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Signup {

	private JFrame SignupPage;
	private JTextField txt_name;
	private JTextField txt_pass1;
	private JTextField txt_email;
	private JTextField txt_mobile;
	private JTextField txt_username;
	private JTextField txt_pass2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup window = new Signup();
					window.SignupPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		SignupPage = new JFrame();
		SignupPage.setResizable(false);
		SignupPage.setTitle("Platinum Tech");
		SignupPage.setBounds(200, 200, 686, 431);
		SignupPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SignupPage.getContentPane().setLayout(null);
		
		JLabel lbl_grpname = new JLabel("GLASS BUDDIES");
		lbl_grpname.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lbl_grpname.setBounds(253, 27, 167, 33);
		SignupPage.getContentPane().add(lbl_grpname);
		
		JLabel lbl_sysname = new JLabel("RESERVATION SYSTEM");
		lbl_sysname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_sysname.setBounds(228, 47, 228, 33);
		SignupPage.getContentPane().add(lbl_sysname);
		
		JButton btn_create = new JButton("CREATE ACCOUNT");
		btn_create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txt_name.getText();
				String email = txt_email.getText();
				String mobile = txt_mobile.getText();
				//int len = txt_mobile.length();
				String username = txt_username.getText();
				String pass1 = txt_pass1.getText();
				String pass2 = txt_pass2.getText();
				
				
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/glassbuddies","root","");
					Statement stmt = con.createStatement();
					
					
					if (name.equals("") || email.equals("") || mobile.equals("") || username.equals("") || pass1.equals("") || pass2.equals(""))   {
						JOptionPane.showMessageDialog(null, "Field cannot be empty. Please provide details.");
					}
					else if (!pass1.equals(pass2)) {
						JOptionPane.showMessageDialog(null, "Mismatched Password!");
						
					}
					else if (pass1.equals(pass2)){
						String query = "INSERT INTO Users (Name, Email, Mobile, UserName, Password, Password2, Type)  values ('" + name + "','" + email + "','" + mobile + "', '" + username + "', '" + pass1 + "', '" + pass2 + "', 'customer')";		
						stmt.execute(query);
						JOptionPane.showMessageDialog(btn_create, "Account successfully created! Login to continue.");
						SignupPage.setVisible(false);
						Login.main(null);
					}
					
					
					con.close();
					
				}
				
				
				catch(Exception x) {System.out.print(x);}
				
				
				
			}
		});
		btn_create.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_create.setForeground(Color.RED);
		btn_create.setBounds(145, 253, 167, 41);
		SignupPage.getContentPane().add(btn_create);
		
		JLabel lbl_copyright = new JLabel("Copy Right Systems Ltd 2022");
		lbl_copyright.setBounds(264, 344, 192, 13);
		SignupPage.getContentPane().add(lbl_copyright);
		
		JLabel lbl_company = new JLabel("PLATINUM TECH");
		lbl_company.setBounds(288, 358, 132, 13);
		SignupPage.getContentPane().add(lbl_company);
		
		JLabel lbl_name = new JLabel("Full Name: ");
		lbl_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_name.setBounds(33, 123, 107, 22);
		SignupPage.getContentPane().add(lbl_name);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(139, 121, 188, 24);
		SignupPage.getContentPane().add(txt_name);
		
		JLabel lbl_pass1 = new JLabel("Password:");
		lbl_pass1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_pass1.setBounds(349, 153, 107, 22);
		SignupPage.getContentPane().add(lbl_pass1);
		
		txt_pass1 = new JPasswordField();
		txt_pass1.setColumns(10);
		txt_pass1.setBounds(476, 153, 167, 24);
		SignupPage.getContentPane().add(txt_pass1);
		
		JLabel lbl_email = new JLabel("Email Address:");
		lbl_email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_email.setBounds(33, 154, 107, 22);
		SignupPage.getContentPane().add(lbl_email);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(139, 152, 188, 24);
		SignupPage.getContentPane().add(txt_email);
		
		JLabel lbl_mobile = new JLabel("Mobile Number:");
		lbl_mobile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_mobile.setBounds(33, 188, 107, 22);
		SignupPage.getContentPane().add(lbl_mobile);
		
		txt_mobile = new JTextField();
		txt_mobile.setColumns(10);
		txt_mobile.setBounds(139, 186, 188, 24);
		SignupPage.getContentPane().add(txt_mobile);
		
		JLabel lbl_username = new JLabel("Username:");
		lbl_username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_username.setBounds(349, 121, 107, 22);
		SignupPage.getContentPane().add(lbl_username);
		
		txt_username = new JTextField();
		txt_username.setColumns(10);
		txt_username.setBounds(476, 119, 167, 24);
		SignupPage.getContentPane().add(txt_username);
		
		JLabel lbl_pass2 = new JLabel("Confirm Password:");
		lbl_pass2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_pass2.setBounds(349, 187, 118, 22);
		SignupPage.getContentPane().add(lbl_pass2);
		
		txt_pass2 = new JPasswordField();
		txt_pass2.setColumns(10);
		txt_pass2.setBounds(476, 187, 167, 24);
		SignupPage.getContentPane().add(txt_pass2);
		
		JButton btn_cancel = new JButton("CANCEL");
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignupPage.setVisible(false);
				Login.main(null);	
			}
		});
		btn_cancel.setForeground(Color.BLACK);
		btn_cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_cancel.setBounds(337, 253, 167, 41);
		SignupPage.getContentPane().add(btn_cancel);
	}
}
