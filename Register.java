package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.PasswordAuthentication;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Connect.Connect;

public class Register {
	String UserId= "";
	private JFrame mainFrame;
	private JInternalFrame internalFrame;
	private JDesktopPane desktopPane;
	private JPanel northPanel, centerPanel, southPanel, southTop, southBottom, genderPanel;
	private JLabel registerFormLabel, iDLabel, usernameLabel, emailLabel, phoneLabel, addressLabel, passwordLabel, genderLabel, roleLabel, signInLabel,DOBlabe;
	private JTextField iDTextField, usernameTextField, emailTextField, phoneTextField,DObTE;
	private JPasswordField passwordField;
	private JRadioButton female, male;
	private ButtonGroup buttonGroup;
	private JComboBox<String> roleComboBox;
	private Vector<String> listRole;
	private JButton registerButton;
	private JTextArea addressTextArea;
	
	private Date date;
	SimpleDateFormat dateOB = new SimpleDateFormat("yyyy-MM-dd");
	
	private Connect conn = Connect.getInstance();
	
	public void initProject() {
		mainFrame = new JFrame("Register Form");
		
		String query = "SELECT * FROM users WHERE UserID = (SELECT max(UserID) FROM users)";
		ResultSet rs = conn.executeQuery(query);

		try {
			while (rs.next()) {
				UserId = rs.getString("UserID");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		iDTextField = new JTextField(setUserID(UserId));
		iDTextField.setEditable(false); 
		
		usernameTextField = new JTextField();
		emailTextField = new JTextField();
		phoneTextField = new JTextField();
		DObTE = new JTextField();
	
		
		passwordField = new JPasswordField();
		
		listRole = new Vector<>();
		listRole.add("Choose the role");
		listRole.add("Admin");
		listRole.add("Customer");

		female = new JRadioButton("Female");
		male = new JRadioButton("Male");
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(female);
		buttonGroup.add(male);
		
		roleComboBox = new JComboBox<String>(listRole);
		
		
		addressTextArea = new JTextArea();
		
		registerButton = new JButton("Register");
		
		northPanel = new JPanel();
		centerPanel = new JPanel(new GridLayout(9, 2));
		southPanel = new JPanel(new GridLayout(3, 6));
		southTop = new JPanel(new FlowLayout());
		southBottom = new JPanel(new FlowLayout());
		genderPanel = new JPanel();
		
		genderPanel.add(female);
		genderPanel.add(male);
		
		internalFrame = new JInternalFrame();
		internalFrame.setVisible(true);
		internalFrame.setSize(400, 400);
		internalFrame.setClosable(true);
		internalFrame.setMaximizable(true);
		internalFrame.setLocation(200, 100);
		
		desktopPane = new JDesktopPane();
		desktopPane.add(internalFrame);
		
		registerFormLabel = new JLabel("Register Form");
		iDLabel = new JLabel("ID");
		usernameLabel = new JLabel("User Name");
		emailLabel = new JLabel("Email");
		phoneLabel = new JLabel("Phone");
		addressLabel = new JLabel("Address");
		passwordLabel = new JLabel("Password");
		DOBlabe = new JLabel("DOB");
		genderLabel = new JLabel("Gender");
		roleLabel = new JLabel("Role");
		signInLabel = new JLabel("Sign In");
		
		northPanel.add(registerFormLabel);
		
		centerPanel.add(iDLabel);
		centerPanel.add(iDTextField);
		centerPanel.add(usernameLabel);
		centerPanel.add(usernameTextField);
		centerPanel.add(emailLabel);
		centerPanel.add(emailTextField);
		centerPanel.add(phoneLabel);
		centerPanel.add(phoneTextField);
		centerPanel.add(addressLabel);
		centerPanel.add(addressTextArea);
		centerPanel.add(passwordLabel);
		centerPanel.add(passwordField);
		centerPanel.add(DOBlabe);
		centerPanel.add(DObTE);
		centerPanel.add(genderLabel);
		centerPanel.add(genderPanel);
		centerPanel.add(roleLabel);
		centerPanel.add(roleComboBox);
		
		southTop.add(registerButton);
		southBottom.add(signInLabel);
		southPanel.add(southTop, BorderLayout.NORTH);
		southPanel.add(southBottom, BorderLayout.SOUTH);
		
		internalFrame.add(northPanel, BorderLayout.NORTH);
		internalFrame.add(centerPanel, BorderLayout.CENTER);
		internalFrame.add(southPanel, BorderLayout.SOUTH);

		
		registerButton.addActionListener(new ActionListener() {

			void InsertData() {
				
				String userID = iDTextField.getText().toString(),
						userName = usernameTextField.getText(),
						Email = emailTextField.getText(),
						Address = addressTextArea.getText(),
						Password = String.valueOf(passwordField.getPassword()),
						dob = DObTE.getText(),
						gender= null,
						Phone = phoneTextField.getText(),		
						role = roleComboBox.getSelectedItem().toString();
				

				if (userID.equals("") || userName.equals("") || Email.equals("")|| Phone.equals("") || Address.equals("")|| Password.equals("")) {
					JOptionPane.showMessageDialog(null, "Data must be filled");
				}else {
					boolean phoneNumeric = false;
					float newPhone = 0;
					try {
						newPhone = Float.parseFloat(Phone);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Phone Number must be numeric!");
						return;
					}
					if (userName.length()<5 || userName.length()>30) {
						JOptionPane.showMessageDialog(null, "Username must be between 5-30 characters!");
						
					}
					
					else if (Email.startsWith("@") || Email.startsWith(".") || Email.endsWith("@") || !Email.contains(".com") && !Email.contains(".co.id")) {
						JOptionPane.showMessageDialog(null, "Email invalid!");
						
					}

					else if (Phone.length()<12 || Phone.length()>13) { 
						JOptionPane.showMessageDialog(null, "Phone number invalid!");
					} 
					
					if (!dob.isEmpty()) {
						try {
							date = dateOB.parse(dob);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "DOB invalid");
						}
					}
					
					if (!Address.endsWith(" Street")) {
						JOptionPane.showMessageDialog(null, "Address must ends with ' Street'!");
					}
					

					boolean isAlphabet = false; boolean isNumeric = false;
					for (int i = 0; i < Password.length(); i++) {
					    if(Character.isDigit(Password.charAt(i))) {
					        isNumeric = true;
					    }
					    if(Character.isAlphabetic(Password.charAt(i))) {
					        isAlphabet = true;
					    }	
					}
					
					if (isNumeric == false || isAlphabet == false) {
						JOptionPane.showMessageDialog(null, "Password must be alphanumeric!");
					}
					
					
					 else if (!male.isSelected() && !female.isSelected()) {
						JOptionPane.showMessageDialog(null, "Gender must be selected!");
					}
					
					
					if (male.isSelected()) {
						gender = "Male";
					}
					
					if (female.isSelected()) {
						gender = "Female";
					}
					
					if (roleComboBox.getSelectedItem()=="Admin") {
						role = "Admin";
					}if (roleComboBox.getSelectedItem()=="Customer") {
						role = "Customer";
					}

					String query = String.format("INSERT INTO users VALUES (NULL, '%s', '%s', '%s', '%s', '%s', '%s', '%s' , '%s' )", 
							userName, Email,Password, dob ,gender, Address, Phone ,role);
					
					int affected_result = conn.executeUpdate(query);				
					System.out.println(affected_result + "row(s) affected");
					JOptionPane.showMessageDialog(null, "Registrasi berhasil");
//					
				}

				
//				else {
//						String query = String.format("INSERT INTO users VALUES (NULL, '%s', '%s', '%s', '%s', '%s', '%s', '%s' , '%s' )", 
//								userName, Email,Password, DOB ,"Male", Address, Phone ,"admin");
//						
//						int affected_result = conn.executeUpdate(query);				
//						System.out.println(affected_result + "row(s) affected");
//						JOptionPane.showMessageDialog(null, "Registrasi berhasil");
//				}
			}
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				InsertData();
			}
		});
		

		
		signInLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (arg0.getClickCount() == 1) {
					new loginPage();
					mainFrame.dispose();
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
	
	private String setUserID(String id) {

		String x = "" + id.charAt(2) + id.charAt(3) + id.charAt(4); // Digit dari ListID terakhir yang ada di dalam
																	// table headerlist
		int digit1 = 0;
		int digit2 = 0;
		int idCount = Integer.parseInt(x);
		int digit3 = idCount + 1;

		if (digit3 > 9 && digit3 < 100) {
			digit2 = digit3 / 10;
			digit3 = digit3 % 10;

		} else if (digit3 > 99 && digit3 < 1000) {
			digit1 = digit3 / 100;
			digit2 = (digit3 / 10) % 10;
			digit3 = (digit3 % 100) % 10;
		}

		String UserID = "US" + digit1 + digit2 + digit3;

		return UserID;
	}
	



	public  Register() {
		
		initProject();
		
		mainFrame.add(desktopPane);
		mainFrame.setVisible(true);
		
		mainFrame.setSize(800, 600);
		
		mainFrame.setLocationRelativeTo(null);
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}


}

