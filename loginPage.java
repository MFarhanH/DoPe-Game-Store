package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Connect.Connect;

public class loginPage  {
			JFrame loginPage;
			JPanel northPanel, southPanel, centerPanel, southTop,southBottom;
			JLabel tittle, email, signUp, password;
			JButton submit;
			JTextField emailTextField;
			JPasswordField passwordField;
	private Connect conn = Connect.getInstance();
	
	public void init() {
		
		//init Frame
		loginPage = new JFrame("Login Form"); 
		
		//init Label
		tittle = new JLabel("Login Form");
		tittle.setFont(new Font("Arial", 0, 42));
		
		
		email = new JLabel("Email");
		email.setFont(new Font("Arial", Font.PLAIN, 18));
		email.setBounds(20, 80, 150, 25);
		password = new JLabel("Password");
		password.setFont(new Font("Arial", Font.PLAIN, 18));
		
		password.setBounds(20, 110, 150, 25);
		signUp = new JLabel("Sign Up");
		signUp.setFont(new Font("Arial", Font.PLAIN, 18));
		
		//init textFild
		emailTextField = new JTextField();
		emailTextField.setBounds(150, 80, 150, 25);
		//init password
		passwordField = new JPasswordField();
		passwordField.setBounds(150, 110, 150, 25);
	
		
		//ini button
		submit = new JButton("Submit");
		submit.setFont(new Font("Arial", Font.PLAIN, 18));
		submit.setPreferredSize(new Dimension(100, 40));
		
		
		//init panel
		northPanel = new JPanel();
		centerPanel = new JPanel(new BorderLayout());
		centerPanel.setLayout(new GridLayout(3, 6, 10, 30));
		centerPanel.setBounds(150, 80, 150, 25);
		southPanel = new JPanel(new GridLayout(3, 6));
		southTop = new JPanel(new FlowLayout());
		southBottom = new JPanel(new FlowLayout());

		
		
		//add to northpanel
		northPanel.add(tittle);
		
		//add centerpanel
		centerPanel.add(email);
		centerPanel.add(emailTextField);
		centerPanel.add(password);
		centerPanel.add(passwordField);
		
		
		//add southPanel
		southTop.add(submit);
		southBottom.add(signUp);
		southPanel.add(southTop, BorderLayout.NORTH);
		southPanel.add(southBottom, BorderLayout.SOUTH);
		
		loginPage.add(northPanel, BorderLayout.NORTH);
		loginPage.add(centerPanel,BorderLayout.CENTER);
		loginPage.add(southPanel, BorderLayout.SOUTH);
		

		submit.addActionListener(new ActionListener() {
			
			void insert() {
				
				String email = emailTextField.getText();
				//char [] password = passwordField.getPassword(); diubah jadi ke string kek dibawah
				String password = String.valueOf(passwordField.getPassword());
				boolean validasi = false;
				
				if (email.equals("") || password.equals("")) {
					JOptionPane.showInternalConfirmDialog(null, "Data must be filled");
					
				}else {
					try {
						String query = "SELECT * from users WHERE UserEmail = '"+email+"' and UserPassword = '"+password+"' ";
						ResultSet rs = conn.executeQuery(query);
						if (rs.next() && rs != null) {
							validasi = true;
						} else {
							validasi = false;
						}
					} catch (SQLException e) {
						 System.err.println("Koneksi gagal !!!!");
				         System.err.println(e);
					}
					if (validasi) {
						JOptionPane.showMessageDialog(null, "Login Success");
					} else {
						JOptionPane.showMessageDialog(null, "Wrong email or password");
					}
				}
					
			}		
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				insert();
			}
		});
		
		signUp.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (arg0.getClickCount() == 1) {
					new Register();
					loginPage.dispose();
				}
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
			
	}
	
	public loginPage() {
		init();
		
		
		loginPage.setVisible(true);
		loginPage.setSize(800, 600);
		loginPage.setLocationRelativeTo(null);
		loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginPage.setResizable(false);
		
		
		
	}
	
}
	
