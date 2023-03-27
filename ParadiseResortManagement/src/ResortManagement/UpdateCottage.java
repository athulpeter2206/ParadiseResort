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
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class UpdateCottage extends JFrame {
	String RoomNo;
	static UpdateCottage frame = new UpdateCottage();
	private JPanel contentPane;
	private JTextField txt_RoomType;
	private JTextField txtRoom_No;
	private JTextField txt_Cost;
	private JTextField txt_Availability;
	private JTable table;
	private JLabel lblRoomNo;
	private JLabel lblTypeOfRoom;
	private JLabel lblCost;
	private JLabel lblNewLabel_3;
	private JButton btnLogout;
	private JLabel lblNewLabel;

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
	public UpdateCottage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_RoomType = new JTextField();
		txt_RoomType.setColumns(10);
		txt_RoomType.setBounds(179, 158, 252, 34);
		contentPane.add(txt_RoomType);
		
		txtRoom_No = new JTextField();
		txtRoom_No.setEditable(false);
		txtRoom_No.setColumns(10);
		txtRoom_No.setBounds(179, 99, 252, 34);
		contentPane.add(txtRoom_No);
		
		txt_Cost = new JTextField();
		txt_Cost.setColumns(10);
		txt_Cost.setBounds(179, 211, 252, 34);
		contentPane.add(txt_Cost);
		
		txt_Availability = new JTextField();
		txt_Availability.setColumns(10);
		txt_Availability.setBounds(179, 263, 252, 34);
		contentPane.add(txt_Availability);
		
		JButton UpdateEmpBtn = new JButton("Update");
		UpdateEmpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
					
					Statement st = con.createStatement();
					
					int i = st.executeUpdate("UPDATE COTTAGES SET TYPEOFROOM='"+txt_RoomType.getText()+"',COST='"+txt_Cost.getText()+"',AVAILABILITY='"+txt_Availability.getText()+"' WHERE ROOM_NO='"+RoomNo+"'");
					
					System.out.println("Rows Update"+i);
					
					JOptionPane.showMessageDialog(frame, "Row Updated!!");
					
					ResultSet rs = st.executeQuery("select ROOM_NO,TYPEOFROOM,COST,AVAILABILITY from COTTAGES");
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					 
				}catch(Exception e2) {
					System.out.print(e2);
				}
			}
		});
		UpdateEmpBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		UpdateEmpBtn.setBounds(180, 398, 129, 28);
		contentPane.add(UpdateEmpBtn);
		
		JButton ClearBtn = new JButton("Clear");
		ClearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtRoom_No.setText("");
				txt_RoomType.setText("");
				txt_Cost.setText("");
				txt_Availability.setText("");
				
			}
		});
		ClearBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		ClearBtn.setBounds(349, 398, 129, 28);
		contentPane.add(ClearBtn);
		
		JLabel lblUpdateCottage = new JLabel("Update Cottage");
		lblUpdateCottage.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblUpdateCottage.setBounds(369, 22, 219, 49);
		contentPane.add(lblUpdateCottage);
		
		JButton Btn_cancel = new JButton("Cancel");
		Btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CottagesAdminModule cdm = new CottagesAdminModule();
				setVisible(false);
				cdm.setVisible(true);
			}
		});
		Btn_cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Btn_cancel.setBounds(517, 398, 129, 28);
		contentPane.add(Btn_cancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(463, 96, 418, 258);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex = table.getSelectedRow();
				RoomNo = (String) table.getValueAt(rowIndex, 0);
				System.out.println("Selected Value:"+table.getValueAt(rowIndex, 0));
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
					
					Statement st = con.createStatement();
					
					ResultSet rs = st.executeQuery("select ROOM_NO,TYPEOFROOM,COST,AVAILABILITY from COTTAGES where ROOM_NO='"+RoomNo+"'");
					rs.next();
					txtRoom_No.setText(rs.getString(1));
					txt_RoomType.setText(rs.getString(2));
					txt_Cost.setText(rs.getString(3));
					txt_Availability.setText(rs.getString(4));
					
					
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
				"Room_No", "Type of Room", "Cost", "Availability"
			}
		));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select ROOM_NO,TYPEOFROOM,COST,AVAILABILITY from COTTAGES");
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			lblRoomNo = new JLabel("Room No:");
			lblRoomNo.setForeground(new Color(255, 255, 255));
			lblRoomNo.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblRoomNo.setBounds(66, 99, 77, 34);
			contentPane.add(lblRoomNo);
			
			lblTypeOfRoom = new JLabel("Type of Room:");
			lblTypeOfRoom.setForeground(new Color(255, 255, 255));
			lblTypeOfRoom.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblTypeOfRoom.setBounds(31, 155, 112, 34);
			contentPane.add(lblTypeOfRoom);
			
			lblCost = new JLabel("Cost:");
			lblCost.setForeground(new Color(255, 255, 255));
			lblCost.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblCost.setBounds(103, 208, 40, 34);
			contentPane.add(lblCost);
			
			lblNewLabel_3 = new JLabel("Availability:");
			lblNewLabel_3.setForeground(new Color(255, 255, 255));
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_3.setBounds(52, 260, 91, 34);
			contentPane.add(lblNewLabel_3);
			
			btnLogout = new JButton("Logout");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Login l = new Login();
					setVisible(false);
					l.setVisible(true);
				}
			});
			btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnLogout.setBounds(775, 10, 120, 24);
			contentPane.add(btnLogout);
			
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("E:\\Programming\\Java\\ParadiseResortManagement\\Images\\ResortImg1Resized.jpg"));
			lblNewLabel.setBounds(0, 0, 905, 473);
			contentPane.add(lblNewLabel);
			
			
			
		}catch(Exception e1) {
			System.out.println(e1);
		}
	}
}
