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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUname;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	static Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 541);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(170, 223, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Paradise Resort");
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 25));
		lblNewLabel.setBounds(562, 67, 198, 57);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Programming\\Java\\ParadiseResortManagement\\Images\\ResortBackground1.jpeg"));
		lblNewLabel_1.setBounds(0, 0, 479, 504);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User Name :");
		lblNewLabel_2.setFont(new Font("Segoe Script", Font.BOLD, 20));
		lblNewLabel_2.setBounds(489, 152, 155, 45);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password :");
		lblNewLabel_2_1.setFont(new Font("Segoe Script", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(504, 225, 118, 45);
		contentPane.add(lblNewLabel_2_1);
		
		txtUname = new JTextField();
		txtUname.setBounds(630, 160, 203, 34);
		contentPane.add(txtUname);
		txtUname.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(632, 235, 201, 35);
		contentPane.add(txtPass);
		
		JButton LoginBtn = new JButton("Login");
		LoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca2223","mca2223");
					
					Statement st = con.createStatement();
					
					String uName = txtUname.getText();
					String pwd = txtPass.getText();
					
					boolean i = st.execute("select * from res_employee where emp_id='"+uName+"' and password = '"+pwd+"'");
					
					
					
//					boolean i = st.execute("select * from res_employee where emp_id='"+uName+"' and password = '"+pwd+"'");
//					ResultSet rs = st.executeQuery("select * from res_employee where emp_id='"+uName+"' and password = '"+pwd+"'");
//					System.out.println(uName);
//					System.out.println(pwd);
//					System.out.println(i);
					if(i==true) {
						ResultSet rs = st.executeQuery("select * from res_employee where emp_id='"+uName+"' and password = '"+pwd+"'");
						
						System.out.println(rs.next());
						int empType;
						
						empType = rs.getInt("emptype");
						System.out.println(empType);
						rs.next();
						if(empType==1) {
							AdminDashboardView adv = new AdminDashboardView();
							setVisible(false);
							adv.setVisible(true);
							
						}
						else if(empType==2) {
							EmployeeDashboard ED = new EmployeeDashboard();
							setVisible(false);
							ED.setVisible(true);
						}
					}else {
						JOptionPane.showMessageDialog(frame, "Invalid Username or Password!");
					}

					
				} catch (Exception e2) {
					System.err.println(e2);
				}
			}
		});
		LoginBtn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		LoginBtn.setBounds(598, 315, 124, 45);
		contentPane.add(LoginBtn);
	}
}
