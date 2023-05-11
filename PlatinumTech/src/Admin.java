import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Admin {

	private JFrame AdminPage;

	private JTable table2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
					window.AdminPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 */
	public Admin() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AdminPage = new JFrame();
		AdminPage.setResizable(false);
		AdminPage.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
		});
		AdminPage.setTitle("ADMINISTRATOR");
		AdminPage.setBounds(100, 100, 803, 509);
		AdminPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AdminPage.getContentPane().setLayout(null);

		
		JLabel lbl_title = new JLabel("RESERVATION LIST");
		lbl_title.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_title.setBounds(311, 23, 199, 23);
		AdminPage.getContentPane().add(lbl_title);
		
		JButton btn_logout = new JButton("LOGOUT");
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(btn_logout, "Are you sure you want to logout?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (a == JOptionPane.YES_OPTION) {
				
					AdminPage.setVisible(false);
					Login.main(null);	
				}
				else if (a == JOptionPane.NO_OPTION) {
					
					AdminPage.setVisible(true);
					
				}
			}
		});
		btn_logout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_logout.setBounds(668, 432, 98, 30);
		AdminPage.getContentPane().add(btn_logout);
		
		JButton btn_load = new JButton("LOAD DATA");
		btn_load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = new DefaultTableModel();
				
				model.addColumn("Name");
				model.addColumn("Email");
				model.addColumn("Contact");
				model.addColumn("No. of Pax");
				model.addColumn("Date");
				model.addColumn("Time");
				model.addColumn("Status");
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/glassbuddies","root","");
					java.sql.Statement stmt = con.createStatement();
					
					String sql ="Select * from Reservations";
					ResultSet rs = stmt.executeQuery(sql);
					
					
					while (rs.next()) {
					
						
						model.addRow (new Object[] {
								rs.getString("Name"),
								rs.getString("Email"), 
								rs.getString("Mobile"), 
								rs.getString("Pax"), 
								rs.getString("Date"), 
								rs.getString("Time"),
								rs.getString("Status")}
							);
							
						table2.setModel(model);
					}
					
					con.close();
					
					
				}
				catch(Exception x) {System.out.print(x);}
				
				
			}
		});
		btn_load.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_load.setBounds(534, 432, 122, 30);
		AdminPage.getContentPane().add(btn_load);
		
		JScrollPane scrollPane = new JScrollPane();
		AdminPage.getContentPane().add(scrollPane);
		scrollPane.setBounds(32, 68, 734, 354);
		
		
		table2 = new JTable();
		table2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Email", "Contact", "No. of Pax", "Date", "Time", "Status"
			}
		));
		table2.setBackground(new Color(176, 196, 222));
		scrollPane.setViewportView(table2);
		
	}
}
