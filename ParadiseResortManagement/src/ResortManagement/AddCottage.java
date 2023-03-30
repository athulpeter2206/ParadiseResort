package ResortManagement;

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
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class AddCottage extends JFrame {
	String room_no_db;
	private JPanel contentPane;
	private JTextField txt_room_cost;
	static AddCottage frame = new AddCottage();
	private JTextField txt_RoomNo;
	private JTextField cb_roomtype;
	private JTextField txtAvailability;
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
	public AddCottage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 485);
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
		btnLogout.setBounds(582, 10, 120, 24);
		contentPane.add(btnLogout);
		
		JLabel lblAddCottages = new JLabel("Add Cottages");
		lblAddCottages.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblAddCottages.setBounds(253, 96, 191, 49);
		contentPane.add(lblAddCottages);
		
		JLabel lblTypeOfRoom = new JLabel("Type of Room:");
		lblTypeOfRoom.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTypeOfRoom.setBounds(63, 229, 112, 34);
		contentPane.add(lblTypeOfRoom);
		
		JLabel lblCost = new JLabel("Cost:");
		lblCost.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCost.setBounds(135, 282, 40, 34);
		contentPane.add(lblCost);
		
		JLabel lblNewLabel_3_4 = new JLabel("Availability:");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_4.setBounds(85, 341, 91, 34);
		contentPane.add(lblNewLabel_3_4);
		
		txt_room_cost = new JTextField();
		txt_room_cost.setColumns(10);
		txt_room_cost.setBounds(211, 285, 252, 34);
		contentPane.add(txt_room_cost);
		
		txt_RoomNo = new JTextField();
		txt_RoomNo.setColumns(10);
		txt_RoomNo.setBounds(211, 174, 252, 34);
		contentPane.add(txt_RoomNo);
		
		txtAvailability = new JTextField();
		txtAvailability.setBounds(209, 341, 254, 34);
		contentPane.add(txtAvailability);
		txtAvailability.setColumns(10);
		
		JButton ClearBtn = new JButton("Clear");
		ClearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtAvailability.setText("");
				txt_room_cost.setText("");
				txt_RoomNo.setText("");
				cb_roomtype.getText();
				
			}
		});
		ClearBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		ClearBtn.setBounds(552, 245, 129, 28);
		contentPane.add(ClearBtn);
		
		JButton AddEmpBtn = new JButton("Add");
		AddEmpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(txt_RoomNo.getText().equals("") ||  txt_room_cost.getText().equals("")) {
						JOptionPane.showMessageDialog(frame, "Fields Empty!!");
					}
					else {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						
						Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
						
						Statement st = con.createStatement();
						
						ResultSet rs = st.executeQuery("select ROOM_NO from cottages");
						int flag=0;
						while(rs.next()) {
							if(rs.getString(1).equals(txt_RoomNo.getText())) {
								flag++;
							}
						}
//						rs.next();
						if(flag==0) {
							int i = st.executeUpdate("insert into cottages values('"+txt_RoomNo.getText()+"','"+cb_roomtype.getText()+"','"+txt_room_cost.getText()+"','"+txtAvailability.getText()+"','')");
							
							System.out.println("Rows Inserted : "+i);
							
							JOptionPane.showMessageDialog(frame, "Cottage Added Successfully - RoomNo :"+txt_RoomNo.getText());
							
							Thread.sleep(1500);
							txt_RoomNo.setText("");
							txtAvailability.setText("");
							txt_room_cost.setText("");
							cb_roomtype.setText("");
							
						}else {
							JOptionPane.showMessageDialog(frame, " Room No Already Exists!!");
							Thread.sleep(1500);
							txt_RoomNo.setText("");
						}
					}


				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		AddEmpBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		AddEmpBtn.setBounds(552, 189, 129, 28);
		contentPane.add(AddEmpBtn);
		
		JButton Btn_cancel = new JButton("Cancel");
		Btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CottagesAdminModule cdm =new CottagesAdminModule();
				setVisible(false);
				cdm.setVisible(true);
			}
		});
		Btn_cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Btn_cancel.setBounds(552, 305, 129, 28);
		contentPane.add(Btn_cancel);
		
		JLabel lblRoomNo = new JLabel("Room No:");
		lblRoomNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRoomNo.setBounds(98, 171, 77, 34);
		contentPane.add(lblRoomNo);
		
		cb_roomtype = new JTextField();
		cb_roomtype.setBounds(211, 229, 252, 34);
		contentPane.add(cb_roomtype);
		cb_roomtype.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Programming\\Java\\ParadiseResortManagement\\Images\\RS2Resized.jpg"));
		lblNewLabel.setBounds(0, 0, 712, 448);
		contentPane.add(lblNewLabel);	
	}
}
