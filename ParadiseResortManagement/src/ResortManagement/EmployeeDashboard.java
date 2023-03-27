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

public class EmployeeDashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeDashboard frame = new EmployeeDashboard();
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
	public EmployeeDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmp = new JLabel("Employee Dashboard");
		lblEmp.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblEmp.setBounds(188, 63, 296, 49);
		contentPane.add(lblEmp);
		
		JButton btn_Booking = new JButton("Booking");
		btn_Booking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerBooking cb = new CustomerBooking();
				setVisible(false);
				cb.setVisible(true);
			}
		});
		btn_Booking.setFont(new Font("Stencil", Font.PLAIN, 20));
		btn_Booking.setBackground(new Color(170, 223, 240));
		btn_Booking.setBounds(226, 142, 218, 43);
		contentPane.add(btn_Booking);
		
		JButton btnBilling = new JButton("Billing");
		btnBilling.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnBilling.setBackground(new Color(170, 223, 240));
		btnBilling.setBounds(226, 213, 218, 43);
		contentPane.add(btnBilling);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				setVisible(false);
				l.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogout.setBounds(580, 10, 120, 24);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Programming\\Java\\ParadiseResortManagement\\Images\\RS2Resized.jpg"));
		lblNewLabel.setBounds(0, 0, 710, 447);
		contentPane.add(lblNewLabel);
	}

}
