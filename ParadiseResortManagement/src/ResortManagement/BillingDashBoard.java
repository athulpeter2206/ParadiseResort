package ResortManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class BillingDashBoard extends JFrame {
	String bookingId,billId;
	String bbid;
	int bid;
	private JPanel contentPane;
	private JTextField txtBookingId;
	private JTable table;
	static BillingDashBoard frame = new BillingDashBoard();
	private JTextField txtBillId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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
	public BillingDashBoard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 955, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerName = new JLabel("Booking Id :");
		lblCustomerName.setForeground(Color.BLACK);
		lblCustomerName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCustomerName.setBounds(54, 104, 94, 34);
		contentPane.add(lblCustomerName);
		
		txtBookingId = new JTextField();
		txtBookingId.setEditable(false);
		txtBookingId.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtBookingId.setColumns(10);
		txtBookingId.setBounds(158, 104, 252, 34);
		contentPane.add(txtBookingId);
		
		JLabel lblBooking = new JLabel("Billing");
		lblBooking.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblBooking.setBounds(279, 25, 91, 49);
		contentPane.add(lblBooking);
		
		JLabel lblNewLabel_3_1 = new JLabel("Bill Id:");
		lblNewLabel_3_1.setForeground(Color.BLACK);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(96, 163, 52, 34);
		contentPane.add(lblNewLabel_3_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(466, 104, 453, 219);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex = table.getSelectedRow();
				bookingId = (String) table.getValueAt(rowIndex, 0);
				System.out.println("Selected Value:"+table.getValueAt(rowIndex, 0));
				
				try {
//					Class.forName("oracle.jdbc.driver.OracleDriver");
//					
//					Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
//					
//					Statement st = con.createStatement();
					
//					ResultSet rs = st.executeQuery("select EMPNAME,EMPADDRESS,EMPDESIGNATION,EMPPHONENO,EMPSALARY from RES_EMPLOYEE where EMP_ID='"+EmpId+"'");
//					rs.next();
					billId=fetchBillId();
					bid = Integer.parseInt(billId);
					bid++;
					billId=String.valueOf(bid);
					txtBookingId.setText(bookingId);
					txtBillId.setText(billId);
//					txt_Designation.setText(rs.getString(3));
//					txt_mobNo.setText(rs.getString(4));
//					txt_Salary.setText(rs.getString(5));
					
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Booking_Id", "Customer_Name", "Address", "Phone No"
			}
		));
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select BOOKING_ID,CUST_NAME,ADDRESS,PHONENO FROM RES_CUSTOMER WHERE BILLED=0");
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			txtBillId = new JTextField();
			txtBillId.setEditable(false);
			txtBillId.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtBillId.setColumns(10);
			txtBillId.setBounds(158, 164, 252, 34);
			contentPane.add(txtBillId);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		JButton btnBillGenerate = new JButton("Generate Bill");
		btnBillGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
					
					Statement st = con.createStatement();
					
					int i =st.executeUpdate("INSERT INTO BILL VALUES('"+billId+"','"+bookingId+"','')");
					
					ResultSet rs1 =st.executeQuery("select CHECKOUTDATE-CHECKINDATE from RES_CUSTOMER where BOOKING_ID=2");
					rs1.next();
					int NoOfDays = Integer.parseInt(rs1.getString(1));
					if(NoOfDays==0) {
						NoOfDays++;
						System.out.println("Noofdays"+NoOfDays);
					}
					rs1.close();
					st.close();
					con.close();
					
					con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
					st = con.createStatement();
					Statement st2 = con.createStatement();
					ResultSet rs2 =st.executeQuery("SELECT ROOM_NO,COST FROM COTTAGES WHERE BOOKINGID='"+bookingId+"' order by ROOM_NO asc");
//					int billBreakupId =bid++;
					
					int bbid=0;
					System.out.println(rs2);
					while(rs2.next()) {
						
						bbid = Integer.parseInt(fetchBillBreakUpId());
						bbid=bbid+1;
						System.out.println(bbid);
						
						int amount = Integer.parseInt(rs2.getString(2));
						amount = amount*NoOfDays;
						System.out.println("Amount"+amount);
						
						int j = st2.executeUpdate("INSERT INTO BILL_BREAKUP VALUES('"+bbid+"','"+billId+"','"+rs2.getString(1)+"','"+amount+"','"+NoOfDays+"')");
						if(j==1) {
							System.out.println("Bill BreakUp Generated!!"+bbid);
//							j=0;
						}
					}
					rs2.close();
					JOptionPane.showMessageDialog(frame, "Bill generated"+bbid);
					
					try {
						con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
						Statement st3 = con.createStatement();
						
						ResultSet rs4 = st3.executeQuery("SELECT TTLPRICE FROM BILL_BREAKUP WHERE BILLID='"+billId+"'");
						int totalAmount=0;
						while(rs4.next()){
							totalAmount=totalAmount+Integer.parseInt(rs4.getString(1));
						}
						System.out.println(totalAmount);
						Statement st4 = con.createStatement();
						Statement st5 = con.createStatement();
						int k= st4.executeUpdate("UPDATE BILL SET TOTAL='"+totalAmount+"' WHERE BOOKING_ID='"+bookingId+"'");
						int l = st5.executeUpdate("UPDATE RES_CUSTOMER SET ROOM_CHARGES='"+totalAmount+"',BILLED=1 WHERE BOOKING_ID='"+bookingId+"'");
						
						if(k==1) {
							System.out.println("Total Amount updated in Bill");
						}
						if(l==1) {
							System.out.println("Total Amount updated in Customer table");
						}
						
						try {
							con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
							Statement st6 = con.createStatement();
							
							int m = st6.executeUpdate("UPDATE COTTAGES SET AVAILABILITY='Yes',BOOKINGID='' WHERE BOOKINGID='"+bookingId+"'");
							
							System.out.println("Rooms Reverted:"+m);
						}catch (Exception e4) {
							System.out.println(e4);
						}
						
					} catch (Exception e3) {
						System.out.println(e3);
					}
				} catch (Exception e2) {
					System.out.println(e2);
				}
				
			}
		});
		btnBillGenerate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBillGenerate.setBounds(96, 366, 146, 34);
		contentPane.add(btnBillGenerate);
		
		JButton btnBreakUpbtn = new JButton("View Bill Breakup");
		btnBreakUpbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BillBreakUpView bbv = new BillBreakUpView(bookingId);
				bbv.fetchBookingId(bookingId);
				setVisible(false);
				bbv.setVisible(true);
				
			}
		});
		btnBreakUpbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBreakUpbtn.setBounds(264, 366, 173, 34);
		contentPane.add(btnBreakUpbtn);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeDashboard ed = new EmployeeDashboard();
				setVisible(false);
				ed.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(466, 366, 173, 34);
		contentPane.add(btnBack);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login L= new Login();
				setVisible(false);
				L.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogout.setBounds(799, 10, 120, 24);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Programming\\Java\\ParadiseResortManagement\\Images\\ResortImg1Resized.jpg"));
		lblNewLabel.setBounds(0, 0, 941, 515);
		contentPane.add(lblNewLabel);
	
	}
	public String fetchBillId() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT BILL_NO FROM BILL");
			while(rs.next()) {
				billId = rs.getString(1);
			}	
		} catch (Exception e) {
			System.out.println(e);
		}
		return billId;
	}
	public String fetchBillBreakUpId() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT BILL_B_ID FROM BILL_BREAKUP");
			while(rs.next()) {
				bbid = rs.getString(1);
			}		
		} catch (Exception e) {
			System.out.println(e);
		}
		return bbid;
	}
}
