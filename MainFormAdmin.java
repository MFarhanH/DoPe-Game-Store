package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainFormAdmin {
	private JFrame mainFrame;
	private JDesktopPane desktopPane;
	private JMenuBar menuBar;
	private JMenu menu1, menu2;
	private JMenuItem EditProfile, Exit, ManageGame;
	private JPanel northPanel, centerPanel, southPanel;
	//private JLabel welcomeMessage, adduserLabel;
	private JInternalFrame internalFrame;
	

	public MainFormAdmin() {
		init();
		
		mainFrame.getContentPane().setBackground(Color.decode("#fbfbcc"));
		mainFrame.setLayout(new GridBagLayout());
		mainFrame.setJMenuBar(menuBar);
		mainFrame.setVisible(true);
		mainFrame.setSize(800, 600);
		mainFrame.setLocationRelativeTo(null);
		//supaya keterminate
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	void init() {
		//inisailiasi Frame
				mainFrame = new JFrame("DoPe Game Store");
				
				//init panel
				centerPanel = new JPanel();
				
				
				
				// centerin mainframe
				mainFrame.add(centerPanel, BorderLayout.CENTER);
			
				
				//init Label
				JLabel welcomeMessage = new JLabel("Welcome to DoPe Game Store");
				
				welcomeMessage.setBackground(Color.decode("#fbfbcc"));
				welcomeMessage.setFont(new Font("Arial", Font.PLAIN, 18));
				
				
				//add to centerpanel
				centerPanel.add(welcomeMessage);
			
				
					
				//init Menu
				menu1 = new JMenu("Profile");
				menu1.add("Edit Profile");
				menu1.add("Exit");
				
				menu2 = new JMenu ("Manage");
				menu2.add("Manage Game");
				
				
				//init Menu Bar
				menuBar = new JMenuBar();
				menuBar.add(menu1);
				menuBar.add(menu2);
				
				
				//init Menu Item
				EditProfile = new JMenuItem("Edit Profile");
				Exit = new JMenuItem("Exit");
				ManageGame = new JMenuItem("Manage Game");
				
				
				
		
	}

	public static void main(String[] args) {
		new MainFormAdmin();
	}

}
