package ResortManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class EmployeeAdminModule extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeAdminModule frame = new EmployeeAdminModule();
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
	public EmployeeAdminModule() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				setVisible(true);
				l.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogout.setBounds(589, 10, 120, 24);
		contentPane.add(btnLogout);
		
		JButton EmpAdd = new JButton("Add Employee");
		EmpAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEmployee AddEmp = new AddEmployee();
				setVisible(false);
				AddEmp.setVisible(true);
			}
		});
		EmpAdd.setBackground(new Color(170, 223, 240));
		EmpAdd.setFont(new Font("Stencil", Font.PLAIN, 20));
		EmpAdd.setBounds(251, 183, 218, 43);
		contentPane.add(EmpAdd);
		
		JButton btnUpdateEmployee = new JButton("Update Employee");
		btnUpdateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateEmployee el = new UpdateEmployee();
				setVisible(false);
				el.setVisible(true);
				
			}
		});
		btnUpdateEmployee.setBackground(new Color(170, 223, 240));
		btnUpdateEmployee.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnUpdateEmployee.setBounds(251, 254, 218, 43);
		contentPane.add(btnUpdateEmployee);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDashboardView ad = new AdminDashboardView();
				setVisible(false);
				ad.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(310, 353, 100, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblEmployeeManagement = new JLabel("Employee Management");
		lblEmployeeManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblEmployeeManagement.setBounds(202, 110, 327, 49);
		contentPane.add(lblEmployeeManagement);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Programming\\Java\\ParadiseResortManagement\\Images\\RS2Resized.jpg"));
		lblNewLabel.setBounds(0, 0, 719, 452);
		contentPane.add(lblNewLabel);
	}

}
