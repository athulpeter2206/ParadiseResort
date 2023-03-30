package ResortManagement;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class AddEmployee extends JFrame {
	String emp_id_db;
	static AddEmployee frame = new AddEmployee();
	private JPanel contentPane;
	private JTextField txt_EmpName;
	private JTextField txt_address;
	private JTextField txt_Designation;
	private JTextField txt_mobNo;
	private JTextField txt_Salary;
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
	public AddEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddEmployee = new JLabel("Add Employee");
		lblAddEmployee.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblAddEmployee.setBounds(244, 42, 214, 49);
		contentPane.add(lblAddEmployee);
		
		JLabel lblEmployeeName = new JLabel("Name:");
		lblEmployeeName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmployeeName.setBounds(126, 115, 50, 34);
		contentPane.add(lblEmployeeName);
		
		JLabel lblEmployeeAddress = new JLabel("Address:");
		lblEmployeeAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmployeeAddress.setBounds(110, 174, 66, 34);
		contentPane.add(lblEmployeeAddress);
		
		JLabel lblEmployeeDesignation = new JLabel("Designation:");
		lblEmployeeDesignation.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmployeeDesignation.setBounds(79, 227, 97, 34);
		contentPane.add(lblEmployeeDesignation);
		
		JLabel lblNewLabel_3_1 = new JLabel("Salary:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(123, 339, 53, 34);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_4 = new JLabel("Mobile Number:");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_4.setBounds(54, 279, 122, 34);
		contentPane.add(lblNewLabel_3_4);
		
		txt_EmpName = new JTextField();
		txt_EmpName.setBounds(212, 118, 252, 34);
		contentPane.add(txt_EmpName);
		txt_EmpName.setColumns(10);
		
		txt_address = new JTextField();
		txt_address.setColumns(10);
		txt_address.setBounds(212, 177, 252, 34);
		contentPane.add(txt_address);
		
		txt_Designation = new JTextField();
		txt_Designation.setColumns(10);
		txt_Designation.setBounds(212, 230, 252, 34);
		contentPane.add(txt_Designation);
		
		txt_mobNo = new JTextField();
		txt_mobNo.setColumns(10);
		txt_mobNo.setBounds(212, 282, 252, 34);
		contentPane.add(txt_mobNo);
		
		txt_Salary = new JTextField();
		txt_Salary.setColumns(10);
		txt_Salary.setBounds(212, 342, 252, 34);
		contentPane.add(txt_Salary);
		
		JButton AddEmpBtn = new JButton("Add");
		AddEmpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EmpId = fetchEmpId();
				int Emp=Integer.valueOf(EmpId);
				Emp++;
				int empType=2;
				
				if(txt_EmpName.getText().equals("") || txt_address.getText().equals("") || txt_Designation.getText().equals("") || txt_mobNo.getText().equals("") || txt_Salary.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, " Fields Empty!!");
				}else {
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						
						Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
						
						Statement st = con.createStatement();
						
						int i = st.executeUpdate("insert into res_employee values('"+Emp+"','"+txt_EmpName.getText()+"','"+txt_address.getText()+"','"+txt_Designation.getText()+"','"+txt_mobNo.getText()+"','"+txt_Salary.getText()+"','"+empType+"','ABCDEF')");
						
						System.out.println("Rows Inserted : "+i);
						
						JOptionPane.showMessageDialog(frame, "Employee Added Successfully - EmpId :"+Emp);
						
						Thread.sleep(1500);
						
						txt_EmpName.setText("");
						txt_address.setText("");
						txt_Designation.setText("");
						txt_mobNo.setText("");
						txt_Salary.setText("");
						
					}catch(Exception e2) {
						System.out.println(e2);
					
					}
}
				
			}
		});
		AddEmpBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		AddEmpBtn.setBounds(548, 232, 129, 28);
		contentPane.add(AddEmpBtn);
		
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
		ClearBtn.setBounds(548, 288, 129, 28);
		contentPane.add(ClearBtn);
		
		JButton Btn_cancel = new JButton("Cancel");
		Btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EmployeeAdminModule eam = new EmployeeAdminModule();
				setVisible(false);
				eam.setVisible(true);
				
			}
		});
		Btn_cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Btn_cancel.setBounds(548, 348, 129, 28);
		contentPane.add(Btn_cancel);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				setVisible(false);
				l.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogout.setBounds(586, 10, 120, 24);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Programming\\Java\\ParadiseResortManagement\\Images\\RS2Resized.jpg"));
		lblNewLabel.setBounds(0, 0, 716, 458);
		contentPane.add(lblNewLabel);
		
	}
	public String fetchEmpId() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select emp_id from res_employee");

			while(rs.next()) {
				emp_id_db=rs.getString(1);
			}
			con.close();
			return emp_id_db;
		}catch(Exception e1) {
			System.out.println(e1);
			return emp_id_db;
		}
		
	}
}
