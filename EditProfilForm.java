package main;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;

public class EditProfilForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtEmail;
	private JTextField txtPhone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditProfilForm frame = new EditProfilForm();
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
	public EditProfilForm() {
		setTitle("DoPe  Game Store");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 586);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Profile");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Transaction");
		menuBar.add(mnNewMenu_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JInternalFrame internalFrame = new JInternalFrame("");
		internalFrame.setBackground(new Color(250, 250, 210));
		internalFrame.setBounds(0, 0, 700, 605);
		contentPane.add(internalFrame);
		
		JLabel lblNewLabel = new JLabel("Update Profile");
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		
		JTextArea txtAddress = new JTextArea();
		
		JLabel lblNewLabel_1_1 = new JLabel("User Email");
		
		JLabel lblNewLabel_1_2 = new JLabel("User Phone");
		
		JLabel lblNewLabel_1_3 = new JLabel("User Address");
		
		JLabel lblNewLabel_1_3_1 = new JLabel("User Gender");
		
		JButton btnUpdate = new JButton("Update Profile");
	JRadioButton rdFemale = new JRadioButton("Female");
	JRadioButton rdMale = new JRadioButton("Male");
	rdFemale.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			rdMale.setSelected(false);
		}
	});
		
		
		rdMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdFemale.setSelected(false);
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pattern pattern;
			    Matcher matcher;
			    String USERNAME_PATTERN =  "^[a-zA-Z]{5,30}$";
			    String PHONE_PATTERN = "^\\d{12,}$";
			    String ADDRESS_PATTERN = "^\\w{10,}\\sStreet$";
				String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				if(!txtUsername.getText().matches(USERNAME_PATTERN)) {
					
					JOptionPane.showMessageDialog(null, "Username must be between 5 - 30 characters", "Hey!", JOptionPane.ERROR_MESSAGE);
				}
				else if(!txtEmail.getText().matches(EMAIL_PATTERN)) {
			
					JOptionPane.showMessageDialog(null, "Email must be in valid format", "Hey!", JOptionPane.ERROR_MESSAGE);
				}
				else if(!txtPhone.getText().matches(PHONE_PATTERN)) {
					JOptionPane.showMessageDialog(null, "Phone number must be numeric and more than equals 12 digits", "Hey!", JOptionPane.ERROR_MESSAGE);
			
				}else if(!txtAddress.getText().matches(ADDRESS_PATTERN)) {
					JOptionPane.showMessageDialog(null, "Address must consist of 10 or more characters and ends with ‘ Street’", "Hey!", JOptionPane.ERROR_MESSAGE);
				
				}else if(!rdMale.isSelected()&& !rdFemale.isSelected()) {
					
					JOptionPane.showMessageDialog(null, "Gender must be selected either “Male” or “Female”", "Hey!", JOptionPane.ERROR_MESSAGE);
				}
				else {
					JOptionPane.showConfirmDialog(null, "Are you sure want to update profile?", "Warning", JOptionPane.YES_NO_OPTION);
				}
				
				
			}
		});
		
	
		GroupLayout groupLayout = new GroupLayout(internalFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(298)
					.addComponent(lblNewLabel)
					.addContainerGap(318, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_1_2)
						.addComponent(lblNewLabel_1_3)
						.addComponent(lblNewLabel_1_3_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
					.addGap(237)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdMale)
							.addPreferredGap(ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
							.addComponent(rdFemale)
							.addGap(100))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtUsername)
								.addComponent(txtAddress)
								.addComponent(txtEmail)
								.addComponent(txtPhone, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
							.addContainerGap())))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(107, Short.MAX_VALUE)
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
					.addGap(68))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2)
						.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(52)
							.addComponent(lblNewLabel_1_3))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdMale)
						.addComponent(lblNewLabel_1_3_1)
						.addComponent(rdFemale))
					.addGap(40)
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(134, Short.MAX_VALUE))
		);
		internalFrame.getContentPane().setLayout(groupLayout);
		
		JRadioButtonMenuItem radioButtonMenuItem = new JRadioButtonMenuItem("New radio item");
		radioButtonMenuItem.setBounds(148, 332, 133, 26);
		contentPane.add(radioButtonMenuItem);
		internalFrame.setVisible(true);
	}
}
