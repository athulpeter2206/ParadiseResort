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

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class UpdateEmployee extends JFrame {
	String EmpId=null;
	static UpdateEmployee frame = new UpdateEmployee();
	private JPanel contentPane;
	private JTextField txt_Salary;
	private JTextField txt_mobNo;
	private JTextField txt_Designation;
	private JTextField txt_address;
	private JTextField txt_EmpName;
	private JTable table;

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
	public UpdateEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdateEmp = new JLabel("Update Employee");
		lblUpdateEmp.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblUpdateEmp.setBounds(348, 41, 250, 49);
		contentPane.add(lblUpdateEmp);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				setVisible(false);
				l.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogout.setBounds(819, 10, 120, 24);
		contentPane.add(btnLogout);
		
		JLabel lblEmployeeName = new JLabel("Name:");
		lblEmployeeName.setForeground(new Color(227, 245, 249));
		lblEmployeeName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmployeeName.setBounds(72, 115, 50, 34);
		contentPane.add(lblEmployeeName);
		
		JLabel lblEmployeeAddress = new JLabel("Address:");
		lblEmployeeAddress.setForeground(new Color(227, 245, 249));
		lblEmployeeAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmployeeAddress.setBounds(56, 174, 66, 34);
		contentPane.add(lblEmployeeAddress);
		
		JLabel lblEmployeeDesignation = new JLabel("Designation:");
		lblEmployeeDesignation.setForeground(new Color(227, 245, 249));
		lblEmployeeDesignation.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmployeeDesignation.setBounds(25, 227, 97, 34);
		contentPane.add(lblEmployeeDesignation);
		
		JLabel lblNewLabel_3_4 = new JLabel("Mobile Number:");
		lblNewLabel_3_4.setForeground(new Color(227, 245, 249));
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_4.setBounds(0, 279, 122, 34);
		contentPane.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("Salary:");
		lblNewLabel_3_1.setForeground(new Color(227, 245, 249));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(69, 339, 53, 34);
		contentPane.add(lblNewLabel_3_1);
		
		txt_Salary = new JTextField();
		txt_Salary.setColumns(10);
		txt_Salary.setBounds(158, 342, 252, 34);
		contentPane.add(txt_Salary);
		
		txt_mobNo = new JTextField();
		txt_mobNo.setColumns(10);
		txt_mobNo.setBounds(158, 282, 252, 34);
		contentPane.add(txt_mobNo);
		
		txt_Designation = new JTextField();
		txt_Designation.setColumns(10);
		txt_Designation.setBounds(158, 230, 252, 34);
		contentPane.add(txt_Designation);
		
		txt_address = new JTextField();
		txt_address.setColumns(10);
		txt_address.setBounds(158, 177, 252, 34);
		contentPane.add(txt_address);
		
		txt_EmpName = new JTextField();
		txt_EmpName.setColumns(10);
		txt_EmpName.setBounds(158, 118, 252, 34);
		contentPane.add(txt_EmpName);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(459, 115, 469, 264);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex = table.getSelectedRow();
				EmpId = (String) table.getValueAt(rowIndex, 0);
				System.out.println("Selected Value:"+table.getValueAt(rowIndex, 0));
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
					
					Statement st = con.createStatement();
					
					ResultSet rs = st.executeQuery("select EMPNAME,EMPADDRESS,EMPDESIGNATION,EMPPHONENO,EMPSALARY from RES_EMPLOYEE where EMP_ID='"+EmpId+"'");
					rs.next();
					txt_EmpName.setText(rs.getString(1));
					txt_address.setText(rs.getString(2));
					txt_Designation.setText(rs.getString(3));
					txt_mobNo.setText(rs.getString(4));
					txt_Salary.setText(rs.getString(5));
					
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
				"Emp_Id", "Emp_Name", "Address", "Designation", "Emp_PhNo", "Emp_Salary"
			}
		));
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select EMP_ID,EMPNAME,EMPADDRESS,EMPDESIGNATION,EMPPHONENO,EMPSALARY from RES_EMPLOYEE");
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			JButton UpdateEmpBtn = new JButton("Update");
			UpdateEmpBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						
						Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
						
						Statement st = con.createStatement();
						
						int i = st.executeUpdate("UPDATE RES_EMPLOYEE SET EMPNAME='"+txt_EmpName.getText()+"',EMPADDRESS='"+txt_address.getText()+"',EMPDESIGNATION='"+txt_Designation.getText()+"',EMPPHONENO='"+txt_mobNo.getText()+"',EMPSALARY='"+txt_Salary.getText()+"' WHERE EMP_ID='"+EmpId+"'");
						
						System.out.println("Rows Update"+i);
						
						JOptionPane.showMessageDialog(frame, "Row Updated!!");
						
						ResultSet rs = st.executeQuery("select EMP_ID,EMPNAME,EMPADDRESS,EMPDESIGNATION,EMPPHONENO,EMPSALARY from RES_EMPLOYEE");
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
						 
					}catch(Exception e2) {
						System.out.print(e2);
					}
					
				}
			});
			UpdateEmpBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
			UpdateEmpBtn.setBounds(159, 417, 129, 28);
			contentPane.add(UpdateEmpBtn);
			
			JButton ClearBtn = new JButton("Clear");
			ClearBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txt_EmpName.setText("");
					txt_address.setText("");
					txt_Designation.setText("");
					txt_mobNo.setText("");
					txt_Salary.setText("");
				}
			});
			ClearBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
			ClearBtn.setBounds(328, 417, 129, 28);
			contentPane.add(ClearBtn);
			
			JButton Btn_cancel = new JButton("Cancel");
			Btn_cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EmployeeAdminModule emp = new EmployeeAdminModule();
					setVisible(false);
					emp.setVisible(true);
				}
			});
			Btn_cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
			Btn_cancel.setBounds(496, 417, 129, 28);
			contentPane.add(Btn_cancel);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("E:\\Programming\\Java\\ParadiseResortManagement\\Images\\ResortImg1Resized.jpg"));
			lblNewLabel.setBounds(0, 0, 939, 493);
			contentPane.add(lblNewLabel);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
