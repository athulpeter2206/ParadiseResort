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

public class CottagesAdminModule extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CottagesAdminModule frame = new CottagesAdminModule();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public CottagesAdminModule() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCottageManagement = new JLabel("Cottage Management");
		lblCottageManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblCottageManagement.setBounds(202, 108, 304, 49);
		contentPane.add(lblCottageManagement);
		
		JButton btn_AddCottage = new JButton("Add Cottage");
		btn_AddCottage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCottage ac = new AddCottage();
				setVisible(false);
				ac.setVisible(true);
			}
		});
		btn_AddCottage.setFont(new Font("Stencil", Font.PLAIN, 20));
		btn_AddCottage.setBackground(new Color(170, 223, 240));
		btn_AddCottage.setBounds(245, 183, 218, 43);
		contentPane.add(btn_AddCottage);
		
		JButton btn_UpdateCottage = new JButton("Update Cottage");
		btn_UpdateCottage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCottage uc = new UpdateCottage();
				setVisible(false);
				uc.setVisible(true);
			}
		});
		btn_UpdateCottage.setFont(new Font("Stencil", Font.PLAIN, 20));
		btn_UpdateCottage.setBackground(new Color(170, 223, 240));
		btn_UpdateCottage.setBounds(245, 254, 218, 43);
		contentPane.add(btn_UpdateCottage);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDashboardView adv = new AdminDashboardView();
				setVisible(false);
				adv.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(304, 353, 100, 34);
		contentPane.add(btnNewButton);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				setVisible(false);
				l.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogout.setBounds(583, 10, 120, 24);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Programming\\Java\\ParadiseResortManagement\\Images\\RS2Resized.jpg"));
		lblNewLabel.setBounds(0, 0, 713, 447);
		contentPane.add(lblNewLabel);
	}

}
