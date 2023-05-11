import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;

public class Home {

	JFrame HomePage;
	private JTextField txt_name;
	private JTextField txt_email;
	private JTextField txt_number;
	private JTextField txt_pax;
	private JTextField txt_date;
	private JTextField txt_time;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.HomePage.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();	
		
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		HomePage = new JFrame();
		HomePage.setResizable(false);
		HomePage.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		HomePage.setTitle("CUSTOMER");
		HomePage.setBounds(100, 100, 770, 456);
		HomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HomePage.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabbedPane.setBounds(10, 10, 736, 366);
		HomePage.getContentPane().add(tabbedPane);
		
		JPanel pnl_home = new JPanel();
		tabbedPane.addTab("Home", null, pnl_home, null);
		pnl_home.setLayout(null);
		
	
		
		JLabel lbl_welcome = new JLabel("WELCOME TO");
		lbl_welcome.setForeground(Color.WHITE);
		lbl_welcome.setBounds(411, 75, 243, 45);
		pnl_home.add(lbl_welcome);
		lbl_welcome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 40));
		
		JLabel lbl_name = new JLabel("GLASS BUDDIES");
		lbl_name.setForeground(Color.WHITE);
		lbl_name.setFont(new Font("Berlin Sans FB", Font.PLAIN, 40));
		lbl_name.setBounds(381, 118, 302, 45);
		pnl_home.add(lbl_name);
		
		JLabel lbl_slogan1 = new JLabel("MAKE YOUR PARTY EXTRAORDINARY AND");
		lbl_slogan1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_slogan1.setBounds(381, 185, 302, 17);
		pnl_home.add(lbl_slogan1);
		lbl_slogan1.setForeground(Color.ORANGE);
		
		JLabel lbl_slogan2 = new JLabel("WE WILL MAKE YOUR EXPERIENCE EXTRA FUN.");
		lbl_slogan2.setForeground(Color.ORANGE);
		lbl_slogan2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_slogan2.setBounds(381, 204, 310, 17);
		pnl_home.add(lbl_slogan2);
		
		JLabel lbl_hombg = new JLabel("New label");
		lbl_hombg.setIcon(new ImageIcon("C:\\Users\\Chuchay\\eclipse-workspace\\PlatinumTech\\img\\home bg.jpg"));
		lbl_hombg.setBounds(0, 0, 731, 335);
		pnl_home.add(lbl_hombg);
		
		JPanel pnl_booknow = new JPanel();
		tabbedPane.addTab("Book Now", null, pnl_booknow, null);
		pnl_booknow.setLayout(null);
		
		JLabel lbl_customer = new JLabel("Full Name:");
		lbl_customer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_customer.setBounds(129, 35, 90, 19);
		pnl_booknow.add(lbl_customer);
		
		txt_name = new JTextField();
		txt_name.setBounds(129, 64, 178, 23);
		pnl_booknow.add(txt_name);
		txt_name.setColumns(10);
		/*String name = txt_name.getText();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/glassbuddies","root","");
			Statement stmt = con.createStatement();
			
			String sql ="Select * from Users where Name='"+ name +"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			
			
			con.close();
			
		}
		
		
		catch(Exception x) {System.out.print(x);} */
		
		JLabel lbl_email = new JLabel("Email Address:");
		lbl_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_email.setBounds(129, 113, 111, 13);
		pnl_booknow.add(lbl_email);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(130, 142, 178, 23);
		pnl_booknow.add(txt_email);
		
		JLabel lbl_contact = new JLabel("Contact Number:");
		lbl_contact.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_contact.setBounds(133, 186, 135, 13);
		pnl_booknow.add(lbl_contact);
		
		txt_number = new JTextField();
		txt_number.setColumns(10);
		txt_number.setBounds(130, 215, 178, 25);
		pnl_booknow.add(txt_number);
		
		JLabel lbl_pax = new JLabel("Number of Seats:");
		lbl_pax.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_pax.setBounds(387, 35, 188, 23);
		pnl_booknow.add(lbl_pax);
		
		txt_pax = new JTextField();
		txt_pax.setColumns(10);
		txt_pax.setBounds(387, 68, 188, 25);
		pnl_booknow.add(txt_pax);
		
		JLabel lbl_date = new JLabel("Preferred Date:");
		lbl_date.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_date.setBounds(387, 110, 116, 19);
		pnl_booknow.add(lbl_date);
		
		JLabel lbl_time = new JLabel("Preferred Time:");
		lbl_time.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_time.setBounds(387, 183, 135, 19);
		pnl_booknow.add(lbl_time);
		
		JButton btn_submit = new JButton("SUBMIT");
		btn_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txt_name.getText();
				String email = txt_email.getText();
				String mobile = txt_number.getText();
				String pax = txt_pax.getText();
				String date = txt_date.getText();
				String time = txt_time.getText();
				
				
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/glassbuddies","root","");
					Statement stmt = con.createStatement();
					
					
					if (name.equals("") || email.equals("") || mobile.equals("") || pax.equals("") || date.equals("") || time.equals(""))   {
						JOptionPane.showMessageDialog(null, "Field cannot be empty. Please provide details.");
					}
					
					else {
						
						
						
						
						String query = "INSERT INTO Reservations (Name, Email, Mobile, Pax, Date, Time, Status)  values ('" + name + "','" + email + "','" + mobile + "', '" + pax + "', '" + date + "', '" + time + "', 'Reserved')";		
						stmt.execute(query);
						JOptionPane.showMessageDialog(btn_submit, "Reservation submitted successfully!");
						
						txt_name.setText("");
						txt_email.setText("");
						txt_number.setText("");
						txt_pax.setText("");
						txt_date.setText("");
						txt_time.setText("");
						
					}
					
					
					con.close();
					
				}
				
				
				catch(Exception x) {System.out.print(x);}
			}
		});
		btn_submit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_submit.setBounds(248, 271, 111, 32);
		pnl_booknow.add(btn_submit);
		
		JButton btn_cancel = new JButton("CANCEL");
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_name.setText("");
				txt_email.setText("");
				txt_number.setText("");
				txt_pax.setText("");
				txt_date.setText("");
				txt_time.setText("");
				
			}
		});
		
		btn_cancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_cancel.setBounds(387, 271, 111, 32);
		pnl_booknow.add(btn_cancel);
		
		txt_date = new JTextField();
		txt_date.setToolTipText("YYYY/MM/DD");
		txt_date.setBounds(387, 141, 188, 25);
		pnl_booknow.add(txt_date);
		txt_date.setColumns(10);
		
		txt_time = new JTextField();
		txt_time.setToolTipText("HH: MM AM/PM");
		txt_time.setColumns(10);
		txt_time.setBounds(387, 215, 188, 25);
		pnl_booknow.add(txt_time);
		
		JPanel pnl_products = new JPanel();
		tabbedPane.addTab("Products", null, pnl_products, null);
		
		JLabel lbl_productbg = new JLabel("");
		lbl_productbg.setIcon(new ImageIcon("C:\\Users\\Chuchay\\eclipse-workspace\\PlatinumTech\\img\\products bg.png"));
		pnl_products.add(lbl_productbg);
		
		
		
		
		
		JPanel pnl_contactus = new JPanel();
		tabbedPane.addTab("Contact Us", null, pnl_contactus, null);
		pnl_contactus.setLayout(null);
		
		JLabel lbl_contactus = new JLabel("For questions or inquiries, contact us on:");
		lbl_contactus.setForeground(Color.WHITE);
		lbl_contactus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_contactus.setBounds(30, 21, 277, 30);
		pnl_contactus.add(lbl_contactus);
		
		JLabel lbl_ig = new JLabel(":  @GlassBuddiesPH");
		lbl_ig.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_ig.setForeground(Color.WHITE);
		lbl_ig.setBounds(277, 71, 200, 51);
		pnl_contactus.add(lbl_ig);
		
		JLabel lbl_fbpage = new JLabel(":  Glass Buddies");
		lbl_fbpage.setForeground(Color.WHITE);
		lbl_fbpage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_fbpage.setBounds(277, 122, 200, 30);
		pnl_contactus.add(lbl_fbpage);
		
		JLabel lbl_EmailAd = new JLabel(":  glassbuddies@gmail.com");
		lbl_EmailAd.setForeground(Color.WHITE);
		lbl_EmailAd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_EmailAd.setBounds(277, 162, 258, 30);
		pnl_contactus.add(lbl_EmailAd);
		
		JLabel lbl_contactnum = new JLabel(":  +63 9272413188");
		lbl_contactnum.setForeground(Color.WHITE);
		lbl_contactnum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_contactnum.setBounds(277, 212, 200, 21);
		pnl_contactus.add(lbl_contactnum);
		
		JLabel lbl_iglogo = new JLabel("");
		lbl_iglogo.setIcon(new ImageIcon("C:\\Users\\Chuchay\\eclipse-workspace\\PlatinumTech\\img\\ig logo.png"));
		lbl_iglogo.setBounds(247, 82, 20, 30);
		pnl_contactus.add(lbl_iglogo);
		
		JLabel lbl_fblogo = new JLabel("");
		lbl_fblogo.setIcon(new ImageIcon("C:\\Users\\Chuchay\\eclipse-workspace\\PlatinumTech\\img\\fb logo.png"));
		lbl_fblogo.setBounds(247, 122, 31, 30);
		pnl_contactus.add(lbl_fblogo);
		
		JLabel lbl_maillogo = new JLabel("");
		lbl_maillogo.setIcon(new ImageIcon("C:\\Users\\Chuchay\\eclipse-workspace\\PlatinumTech\\img\\mail logo.png"));
		lbl_maillogo.setBounds(247, 171, 31, 21);
		pnl_contactus.add(lbl_maillogo);
		
		JLabel lbl_numlogo = new JLabel("");
		lbl_numlogo.setIcon(new ImageIcon("C:\\Users\\Chuchay\\eclipse-workspace\\PlatinumTech\\img\\mobile logo.png"));
		lbl_numlogo.setBounds(247, 212, 20, 21);
		pnl_contactus.add(lbl_numlogo);
		
		JLabel lbl_contustusbg = new JLabel("");
		lbl_contustusbg.setIcon(new ImageIcon("C:\\Users\\Chuchay\\eclipse-workspace\\PlatinumTech\\img\\contact us bg.jpg"));
		lbl_contustusbg.setBounds(10, 10, 711, 315);
		pnl_contactus.add(lbl_contustusbg);
		
		JButton btn_logout = new JButton("Log-out");
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(btn_logout, "Are you sure you want to logout?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (a == JOptionPane.YES_OPTION) {
				
					HomePage.setVisible(false);
					Login.main(null);	
				}
				else if (a == JOptionPane.NO_OPTION) {
					
					HomePage.setVisible(true);
					
				}
				
				
			}
		});
		btn_logout.setBounds(635, 386, 98, 23);
		HomePage.getContentPane().add(btn_logout);
		
		
	}

}
