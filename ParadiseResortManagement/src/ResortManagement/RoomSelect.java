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

public class RoomSelect extends JFrame {
	String BookingId;
	static RoomSelect frame = new RoomSelect();
	JComboBox cb1_2 = new JComboBox();
	JComboBox cb1 = new JComboBox();
	JComboBox cb2_2 = new JComboBox();
	JComboBox cb3 = new JComboBox();
	JComboBox cb3_2 = new JComboBox();
	JComboBox cb2 = new JComboBox();
	JComboBox cb4 = new JComboBox();
	JComboBox cb4_2 = new JComboBox();
	JComboBox cb_5 = new JComboBox();
	JComboBox cb5_2 = new JComboBox();
	JPanel Panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	private JPanel contentPane;
	private JTextField txt_BookingId;
	private JTextField txtRoomsReq;
	private final JLabel lblNewLabel = new JLabel("");

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
	public RoomSelect() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				setVisible(false);
				l.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogout.setBounds(579, 11, 120, 24);
		contentPane.add(btnLogout);
		
		JLabel lblRoomSelect = new JLabel("Room Select");
		lblRoomSelect.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblRoomSelect.setBounds(264, 54, 182, 49);
		contentPane.add(lblRoomSelect);
		
		JLabel lblSingleRoom_1 = new JLabel("Booking Id :");
		lblSingleRoom_1.setForeground(Color.BLACK);
		lblSingleRoom_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSingleRoom_1.setBounds(10, 10, 70, 34);
		contentPane.add(lblSingleRoom_1);
		
		txt_BookingId = new JTextField();
		txt_BookingId.setEditable(false);
		txt_BookingId.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_BookingId.setColumns(10);
		txt_BookingId.setBounds(90, 10, 70, 34);
		contentPane.add(txt_BookingId);
		
		
		Panel1.setBounds(100, 113, 441, 39);
		contentPane.add(Panel1);
		Panel1.setLayout(null);
		
		
		cb1_2.setModel(new DefaultComboBoxModel(new String[] {"None"}));
		
		cb1_2.setBounds(150, 0, 120, 39);
		Panel1.add(cb1_2);
		
		
		cb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
					
					Statement st = con.createStatement();
					
					ResultSet rs= st.executeQuery("select ROOM_NO from cottages where TYPEOFROOM='"+cb1.getItemAt(cb1.getSelectedIndex())+"' and availability like 'Yes'");
					cb1_2.removeAllItems();
					cb1_2.addItem("None");
					while(rs.next()) {
						
						cb1_2.addItem(rs.getString(1));
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		cb1.setBounds(0, 0, 120, 39);
		Panel1.add(cb1);
		
		JButton btnBook1 = new JButton("Book");
		btnBook1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBook1.setBounds(304, 2, 137, 34);
		Panel1.add(btnBook1);
		btnBook1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
					
					Statement st = con.createStatement();
					
					String Roomtype = (String) cb1.getItemAt(cb1.getSelectedIndex());
					String RoomNo = (String) cb1_2.getItemAt(cb1_2.getSelectedIndex());
					
					int i = st.executeUpdate("update cottages set AVAILABILITY='No', BookingId='"+BookingId+"' where ROOM_NO='"+RoomNo+"'");
					
					System.out.println("Rows Updated"+i);
					
					JOptionPane.showMessageDialog(frame, "Room Booked Successfully - BookingId :"+BookingId);
					
					ResultSet rs = st.executeQuery("select COST from cottages where ROOM_NO='"+RoomNo+"'");
					rs.next();
					String Cost = rs.getString(1);
					double billId=Math.random();
					int j = st.executeUpdate("insert into bill values ('"+billId+"','"+BookingId+"','')");
					double billBreakUpId = Math.random();
				
					int k = st.executeUpdate("insert into bill_breakup values('"+billBreakUpId+"','"+billId+"','"+RoomNo+"','"+Cost+"','')");
					System.out.println("Bill Generated"+k);
					System.out.println("Rows Updated"+i);
				} catch (Exception e2) {
						System.out.println(e2);
				}
			}
		});
		
		
		panel2.setBounds(100, 178, 441, 39);
		contentPane.add(panel2);
		panel2.setLayout(null);
		cb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
					
					Statement st = con.createStatement();
					
					ResultSet rs= st.executeQuery("select ROOM_NO from cottages where TYPEOFROOM='"+cb2.getItemAt(cb2.getSelectedIndex())+"' and availability like 'Yes'");
					cb2_2.removeAllItems();
					cb2_2.addItem("None");
					while(rs.next()) {
						
						cb2_2.addItem(rs.getString(1));
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		
		cb2.setBounds(0, 0, 120, 39);
		panel2.add(cb2);
		
		
		cb2_2.setModel(new DefaultComboBoxModel(new String[] {"None"}));
		cb2_2.setBounds(148, 0, 120, 39);
		panel2.add(cb2_2);
		
		JButton btnBook2 = new JButton("Book");
		btnBook2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
					
					Statement st = con.createStatement();
					
					String Roomtype = (String) cb2.getItemAt(cb2.getSelectedIndex());
					String RoomNo = (String) cb2_2.getItemAt(cb2_2.getSelectedIndex());
					
					int i = st.executeUpdate("update cottages set AVAILABILITY='No', BookingId='"+BookingId+"' where ROOM_NO='"+RoomNo+"'");
					
					System.out.println("Rows Updated"+i);
					
					JOptionPane.showMessageDialog(frame, "Room Booked Successfully - BookingId :"+BookingId);
				} catch (Exception e2) {
						System.out.println(e2);
				}
				
			}
		});
		btnBook2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBook2.setBounds(304, 2, 137, 34);
		panel2.add(btnBook2);
		
		
		panel3.setBounds(100, 233, 441, 39);
		contentPane.add(panel3);
		panel3.setLayout(null);
		cb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
					
					Statement st = con.createStatement();
					
					ResultSet rs= st.executeQuery("select ROOM_NO from cottages where TYPEOFROOM='"+cb3.getItemAt(cb3.getSelectedIndex())+"' and availability like 'Yes'");
					cb3_2.removeAllItems();
					cb3_2.addItem("None");
					while(rs.next()) {
						
						cb3_2.addItem(rs.getString(1));
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		
		
		cb3.setBounds(0, 0, 120, 39);
		panel3.add(cb3);
		
		
		cb3_2.setModel(new DefaultComboBoxModel(new String[] {"None"}));
		cb3_2.setBounds(148, 0, 120, 39);
		panel3.add(cb3_2);
		
		JButton btnBook3 = new JButton("Book");
		btnBook3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
					
					Statement st = con.createStatement();
					
					String Roomtype = (String) cb3.getItemAt(cb3.getSelectedIndex());
					String RoomNo = (String) cb3_2.getItemAt(cb3_2.getSelectedIndex());
					
					int i = st.executeUpdate("update cottages set AVAILABILITY='No', BookingId='"+BookingId+"' where ROOM_NO='"+RoomNo+"'");
					
					System.out.println("Rows Updated"+i);
					
					JOptionPane.showMessageDialog(frame, "Room Booked Successfully - BookingId :"+BookingId);
				} catch (Exception e2) {
						System.out.println(e2);
				}
				
			}
		});
		btnBook3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBook3.setBounds(304, 5, 137, 34);
		panel3.add(btnBook3);
		
		
		panel4.setBounds(100, 298, 441, 39);
		contentPane.add(panel4);
		panel4.setLayout(null);
		cb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
					
					Statement st = con.createStatement();
					
					ResultSet rs= st.executeQuery("select ROOM_NO from cottages where TYPEOFROOM='"+cb4.getItemAt(cb4.getSelectedIndex())+"' and availability like 'Yes'");
					cb4_2.removeAllItems();
					cb4_2.addItem("None");
					while(rs.next()) {
						
						cb4_2.addItem(rs.getString(1));
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		
		
		cb4.setBounds(0, 0, 120, 39);
		panel4.add(cb4);
		
		
		cb4_2.setModel(new DefaultComboBoxModel(new String[] {"None"}));
		cb4_2.setBounds(148, 0, 120, 39);
		panel4.add(cb4_2);
		
		JButton btnBook4 = new JButton("Book");
		btnBook4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
					
					Statement st = con.createStatement();
					
					String Roomtype = (String) cb4.getItemAt(cb4.getSelectedIndex());
					String RoomNo = (String) cb4_2.getItemAt(cb4_2.getSelectedIndex());
					
					int i = st.executeUpdate("update cottages set AVAILABILITY='No', BookingId='"+BookingId+"' where ROOM_NO='"+RoomNo+"'");
					
					System.out.println("Rows Updated"+i);
					
					JOptionPane.showMessageDialog(frame, "Room Booked Successfully - BookingId :"+BookingId);
				} catch (Exception e2) {
						System.out.println(e2);
				}
				
			}
		});
		btnBook4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBook4.setBounds(304, 0, 137, 34);
		panel4.add(btnBook4);
		
		
		panel5.setBounds(100, 361, 441, 39);
		contentPane.add(panel5);
		panel5.setLayout(null);
		cb_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
					
					Statement st = con.createStatement();
					
					ResultSet rs= st.executeQuery("select ROOM_NO from cottages where TYPEOFROOM='"+cb_5.getItemAt(cb_5.getSelectedIndex())+"' and availability like 'Yes'");
					cb5_2.removeAllItems();
					cb5_2.addItem("None");
					while(rs.next()) {
						
						cb5_2.addItem(rs.getString(1));
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		
		
		cb_5.setBounds(0, 0, 120, 39);
		panel5.add(cb_5);
		
		
		cb5_2.setModel(new DefaultComboBoxModel(new String[] {"None"}));
		cb5_2.setBounds(148, 0, 120, 39);
		panel5.add(cb5_2);
		
		JButton btnBook5 = new JButton("Book");
		btnBook5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
					
					Statement st = con.createStatement();
					
					String Roomtype = (String) cb_5.getItemAt(cb_5.getSelectedIndex());
					String RoomNo = (String) cb5_2.getItemAt(cb5_2.getSelectedIndex());
					
					int i = st.executeUpdate("update cottages set AVAILABILITY='No', BookingId='"+BookingId+"' where ROOM_NO='"+RoomNo+"'");
					
					System.out.println("Rows Updated"+i);
					
					JOptionPane.showMessageDialog(frame, "Room Booked Successfully - BookingId :"+BookingId);
				} catch (Exception e2) {
						System.out.println(e2);
				}
				
			}
		});
		btnBook5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBook5.setBounds(304, 0, 137, 34);
		panel5.add(btnBook5);
		
		JLabel lblSingleRoom_1_1 = new JLabel("Rooms Required :");
		lblSingleRoom_1_1.setForeground(Color.BLACK);
		lblSingleRoom_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSingleRoom_1_1.setBounds(187, 11, 91, 34);
		contentPane.add(lblSingleRoom_1_1);
		
		txtRoomsReq = new JTextField();
		txtRoomsReq.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtRoomsReq.setEditable(false);
		txtRoomsReq.setColumns(10);
		txtRoomsReq.setBounds(288, 10, 70, 34);
		contentPane.add(txtRoomsReq);
		lblNewLabel.setIcon(new ImageIcon("E:\\Programming\\Java\\ParadiseResortManagement\\Images\\RS2Resized.jpg"));
		lblNewLabel.setBounds(0, 0, 709, 446);
		
		contentPane.add(lblNewLabel);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
			
			Statement st = con.createStatement();
			
			ResultSet rs= st.executeQuery("select TYPEOFROOM from cottages where availability like 'Yes'");
			while(rs.next()) {
				cb1.addItem(rs.getString(1));
				cb2.addItem(rs.getString(1));
				cb3.addItem(rs.getString(1));
				cb4.addItem(rs.getString(1));
				cb_5.addItem(rs.getString(1));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		
	}
	public void fetchBookingId(String bid,int NoOfRooms) {
		BookingId = bid;
		txt_BookingId.setText(BookingId);
		txtRoomsReq.setText(String.valueOf(NoOfRooms));
		
		if(NoOfRooms==1) {
			Panel1.setVisible(true);
			panel2.setVisible(false);
			panel3.setVisible(false);
			panel4.setVisible(false);
			panel5.setVisible(false);
		}
		else if(NoOfRooms==2) {
			Panel1.setVisible(true);
			panel2.setVisible(true);
			panel3.setVisible(false);
			panel4.setVisible(false);
			panel5.setVisible(false);
		}
		else if(NoOfRooms==3) {
			Panel1.setVisible(true);
			panel2.setVisible(true);
			panel3.setVisible(true);
			panel4.setVisible(false);
			panel5.setVisible(false);
		}
		else if(NoOfRooms==4) {
			Panel1.setVisible(true);
			panel2.setVisible(true);
			panel3.setVisible(true);
			panel4.setVisible(true);
			panel5.setVisible(false);
		}
		else if(NoOfRooms==5) {
			Panel1.setVisible(true);
			panel2.setVisible(true);
			panel3.setVisible(true);
			panel4.setVisible(true);
			panel5.setVisible(true);
		}
		
	}

}
