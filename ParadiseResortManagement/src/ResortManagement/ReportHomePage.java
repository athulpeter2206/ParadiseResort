package ResortManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ReportHomePage extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportHomePage frame = new ReportHomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ReportHomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReports = new JLabel("Reports");
		lblReports.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblReports.setBounds(271, 65, 109, 49);
		contentPane.add(lblReports);
		
		JButton btn_emp = new JButton("View Employee");
		btn_emp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeView ev = new EmployeeView();
				setVisible(false);
				ev.setVisible(true);
			}
		});
		btn_emp.setFont(new Font("Stencil", Font.PLAIN, 20));
		btn_emp.setBackground(new Color(170, 223, 240));
		btn_emp.setBounds(222, 142, 218, 43);
		contentPane.add(btn_emp);
		
		JButton btnViewCottages = new JButton("View Cottages");
		btnViewCottages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CottagedView c = new CottagedView();
				setVisible(false);
				c.setVisible(true);
			}
		});
		btnViewCottages.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnViewCottages.setBackground(new Color(170, 223, 240));
		btnViewCottages.setBounds(222, 213, 218, 43);
		contentPane.add(btnViewCottages);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				setVisible(false);
				l.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogout.setBounds(576, 10, 120, 24);
		contentPane.add(btnLogout);
		
		JButton btnViewBillings = new JButton("View Billings");
		btnViewBillings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillView b = new BillView();
				setVisible(false);
				b.setVisible(true);
			}
		});
		btnViewBillings.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnViewBillings.setBackground(new Color(170, 223, 240));
		btnViewBillings.setBounds(222, 285, 218, 43);
		contentPane.add(btnViewBillings);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDashboardView adv = new AdminDashboardView();
				setVisible(false);
				adv.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(271, 362, 120, 24);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Programming\\Java\\ParadiseResortManagement\\Images\\RS2Resized.jpg"));
		lblNewLabel.setBounds(0, 0, 706, 445);
		contentPane.add(lblNewLabel);
	}
}
