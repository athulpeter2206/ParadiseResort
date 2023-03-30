package ResortManagement;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class BillBreakUpView extends JFrame {
	static String bid;
	
	private JPanel contentPane;
	private JTextField txtBookingId;
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillBreakUpView frame = new BillBreakUpView(bid);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BillBreakUpView(String bid) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBillBreakup = new JLabel("Bill Break-Up");
		lblBillBreakup.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblBillBreakup.setBounds(263, 36, 191, 49);
		contentPane.add(lblBillBreakup);
		
		JLabel lblCustomerName = new JLabel("Booking Id :");
		lblCustomerName.setForeground(Color.BLACK);
		lblCustomerName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCustomerName.setBounds(10, 9, 94, 34);
		contentPane.add(lblCustomerName);
		
		txtBookingId = new JTextField();
		txtBookingId.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtBookingId.setEditable(false);
		txtBookingId.setColumns(10);
		txtBookingId.setBounds(114, 10, 66, 34);
		contentPane.add(txtBookingId);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 115, 572, 256);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Bill_BreakUpId", "BillId", "RoomNo", "TtlPrice", "NoOfDays"
			}
		));
		


		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT BILL_B_ID,BILLID,ROOMNO,TTLPRICE,NOOFDAYS FROM BILL_BREAKUP WHERE BILLID IN (SELECT BILL_NO FROM BILL WHERE BOOKING_ID='"+bid+"')");
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			JButton btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					EmployeeDashboard ed = new EmployeeDashboard();
					setVisible(false);
					ed.setVisible(true);
				}
			});
			btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnBack.setBounds(250, 381, 173, 34);
			contentPane.add(btnBack);
			
			JButton btnLogout = new JButton("Logout");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Login l = new Login();
					setVisible(false);
					l.setVisible(true);
				}
			});
			btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnLogout.setBounds(588, 18, 120, 24);
			contentPane.add(btnLogout);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("E:\\Programming\\Java\\ParadiseResortManagement\\Images\\RS2Resized.jpg"));
			lblNewLabel.setBounds(0, 0, 718, 448);
			contentPane.add(lblNewLabel);
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(bid);
	
	}

	public void fetchBookingId(String BookingId) {
		bid=BookingId;
		System.out.println("Inside fnc"+bid);
		txtBookingId.setText(bid);
		

	}
	
}
