package ResortManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AdminDashboardView extends JFrame {
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboardView frame = new AdminDashboardView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AdminDashboardView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 487);
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
		btnLogout.setBounds(587, 10, 120, 24);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("Admin Dashboard");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblNewLabel.setBounds(217, 61, 253, 49);
		contentPane.add(lblNewLabel);
		
		JButton btnEmp = new JButton("Employee");
		btnEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeAdminModule emp = new EmployeeAdminModule();
				setVisible(false);
				emp.setVisible(true);
			}
		});
		btnEmp.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnEmp.setBounds(244, 139, 193, 43);
		contentPane.add(btnEmp);
		
		JButton btnCottages = new JButton("Cottages");
		btnCottages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CottagesAdminModule cam = new CottagesAdminModule();
				setVisible(false);
				cam.setVisible(true);
			}
		});
		btnCottages.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnCottages.setBounds(244, 205, 193, 43);
		contentPane.add(btnCottages);
		
		JButton btnReport = new JButton("Report");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ReportHomePage rp = new ReportHomePage();
				setVisible(false);
				rp.setVisible(true);
			}
		});
		btnReport.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnReport.setBounds(244, 270, 193, 43);
		contentPane.add(btnReport);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Programming\\Java\\ParadiseResortManagement\\Images\\RS2Resized.jpg"));
		lblNewLabel_1.setBounds(0, 0, 717, 450);
		contentPane.add(lblNewLabel_1);
	}
}
