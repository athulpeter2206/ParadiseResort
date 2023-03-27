package ResortManagement;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class CustomerBooking extends JFrame {
	static CustomerBooking frame = new CustomerBooking();
	String booking_id_db;
	int bidb;
	private JPanel contentPane;
	private JTextField txt_Mob;
	private JTextField txt_Address;
	private JTextField txt_CustName;
	private JTextField txt_BookingID;
	private JTextField txtCheckInDate;
	private JTextField txt_IdNo;
	private JTextField txtCheckOutDate;
	private JTextField txtNoOfPeople;
	private JTextField txtTotal;

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
	public CustomerBooking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBooking = new JLabel("Booking");
		lblBooking.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblBooking.setBounds(407, 22, 112, 49);
		contentPane.add(lblBooking);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogout.setBounds(786, 22, 120, 24);
		contentPane.add(btnLogout);
		
		JLabel lblBooklingId = new JLabel("Bookling Id:");
		lblBooklingId.setForeground(new Color(0, 0, 0));
		lblBooklingId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBooklingId.setBounds(52, 84, 97, 34);
		contentPane.add(lblBooklingId);
		
		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setForeground(new Color(0, 0, 0));
		lblCustomerName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCustomerName.setBounds(21, 143, 128, 34);
		contentPane.add(lblCustomerName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setForeground(new Color(0, 0, 0));
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(514, 84, 66, 34);
		contentPane.add(lblAddress);
		
		JLabel lblNewLabel_3_4 = new JLabel("Mobile Number:");
		lblNewLabel_3_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_4.setBounds(458, 143, 122, 34);
		contentPane.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("Id Type:");
		lblNewLabel_3_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(83, 202, 66, 34);
		contentPane.add(lblNewLabel_3_1);
		
		txt_Mob = new JTextField();
		txt_Mob.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_Mob.setColumns(10);
		txt_Mob.setBounds(590, 143, 252, 34);
		contentPane.add(txt_Mob);
		
		txt_Address = new JTextField();
		txt_Address.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_Address.setColumns(10);
		txt_Address.setBounds(590, 84, 252, 34);
		contentPane.add(txt_Address);
		
		txt_CustName = new JTextField();
		txt_CustName.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_CustName.setColumns(10);
		txt_CustName.setBounds(159, 143, 252, 34);
		contentPane.add(txt_CustName);
		
		txt_BookingID = new JTextField();
		txt_BookingID.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_BookingID.setEditable(false);
		txt_BookingID.setColumns(10);
		txt_BookingID.setBounds(159, 84, 252, 34);
		contentPane.add(txt_BookingID);
		
		txtCheckInDate = new JTextField();
		txtCheckInDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtCheckInDate.setColumns(10);
		txtCheckInDate.setBounds(159, 317, 252, 34);
		contentPane.add(txtCheckInDate);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Check-In:");
		lblNewLabel_3_1_1.setForeground(Color.BLACK);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1.setBounds(75, 317, 74, 34);
		contentPane.add(lblNewLabel_3_1_1);
		
		txt_IdNo = new JTextField();
		txt_IdNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_IdNo.setColumns(10);
		txt_IdNo.setBounds(159, 257, 252, 34);
		contentPane.add(txt_IdNo);
		
		JLabel lblNewLabel_3_4_1 = new JLabel("Id No:");
		lblNewLabel_3_4_1.setForeground(Color.BLACK);
		lblNewLabel_3_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_4_1.setBounds(100, 257, 49, 34);
		contentPane.add(lblNewLabel_3_4_1);
		
		txtCheckOutDate = new JTextField();
		txtCheckOutDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtCheckOutDate.setColumns(10);
		txtCheckOutDate.setBounds(159, 372, 252, 34);
		contentPane.add(txtCheckOutDate);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Check-Out:");
		lblNewLabel_3_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_1.setBounds(63, 372, 86, 34);
		contentPane.add(lblNewLabel_3_1_1_1);
		
		JComboBox cb_IDtype = new JComboBox();
		cb_IDtype.setModel(new DefaultComboBoxModel(new String[] {"None", "Aadhar", "Pan", "Passport"}));
		cb_IDtype.setFont(new Font("Tahoma", Font.BOLD, 13));
		cb_IDtype.setBounds(159, 202, 252, 34);
		contentPane.add(cb_IDtype);
		
		JLabel lblNoOfPeople = new JLabel("No of People:");
		lblNoOfPeople.setForeground(Color.BLACK);
		lblNoOfPeople.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNoOfPeople.setBounds(477, 202, 103, 34);
		contentPane.add(lblNoOfPeople);
		
		txtNoOfPeople = new JTextField();
		txtNoOfPeople.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNoOfPeople.setColumns(10);
		txtNoOfPeople.setBounds(590, 202, 252, 34);
		contentPane.add(txtNoOfPeople);
		
//		JLabel lblAddress_1 = new JLabel("Total:");
//		lblAddress_1.setForeground(Color.BLACK);
//		lblAddress_1.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblAddress_1.setBounds(542, 134, 49, 34);
//		contentPane.add(lblAddress_1);
//		
//		txtTotal = new JTextField();
//		txtTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
//		txtTotal.setColumns(10);
//		txtTotal.setBounds(601, 134, 252, 34);
//		contentPane.add(txtTotal);
		
		JButton AddBookingBtn = new JButton("Select Rooms");
		AddBookingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
					
					Statement st = con.createStatement();
					
					int j= st.executeUpdate("select * from cottages where availability like 'Yes'");
					double NoOfPeople = Double.parseDouble(txtNoOfPeople.getText());
					int RoomsNeeded = (int) Math.ceil(NoOfPeople/3);
					System.out.println(RoomsNeeded);
					System.out.println(j);
					if(j<RoomsNeeded) {
						JOptionPane.showMessageDialog(frame, "Rooms Required -"+RoomsNeeded+"Rooms Not Available");
						AddBookingBtn.disable();
					}
					else if(j>=RoomsNeeded){
						int i = st.executeUpdate("insert into res_customer values('"+String.valueOf(bidb)+"','"+txt_CustName.getText()+"','"+txt_Address.getText()+"','"+txt_Mob.getText()+"','"+cb_IDtype.getItemAt(cb_IDtype.getSelectedIndex())+"','"+txt_IdNo.getText()+"','"+txtCheckInDate.getText()+"','"+txtCheckOutDate.getText()+"','"+txtNoOfPeople.getText()+"','')");
						
						System.out.println("Rows Inserted : "+i);
						
						JOptionPane.showMessageDialog(frame, "Booking Added Successfully - BookingId :"+bidb);
						JOptionPane.showMessageDialog(frame, "Select Rooms for BookingId :"+bidb);
						
						RoomSelect rst = new RoomSelect();
						rst.fetchBookingId(booking_id_db,RoomsNeeded);
						setVisible(false);
						rst.setVisible(true);
					}
				
				}catch(Exception e2) {
					System.out.println(e2);
				
				}
				
			}
		});
		AddBookingBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		AddBookingBtn.setBounds(458, 314, 148, 28);
		contentPane.add(AddBookingBtn);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setBounds(627, 314, 129, 28);
		contentPane.add(btnClear);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.setBounds(777, 314, 129, 28);
		contentPane.add(btnCancel);
		
		//to auto fetch Booking Id
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select booking_Id from res_customer");

			while(rs.next()) {
				booking_id_db=rs.getString(1);
			}
			con.close();
			bidb = Integer.parseInt(booking_id_db);
			bidb++;
			System.out.print(bidb);
			txt_BookingID.setText(String.valueOf(bidb));
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("E:\\Programming\\Java\\ParadiseResortManagement\\Images\\ResortImg1Resized.jpg"));
			lblNewLabel.setBounds(0, 0, 921, 524);
			contentPane.add(lblNewLabel);
			
		}catch(Exception e1) {
			System.out.println(e1);
		}	
		
	}
		
}
