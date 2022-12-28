package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainFormCustomer {
	private JFrame mainFrame;
	private JDesktopPane desktopPane;
	private JMenuBar menuBar;
	private JMenu menu1, menu2;
	private JMenuItem EditProfile, Exit, BuyGame, ViewTransactionHistory;
	private JPanel northPanel, centerPanel, southPanel;
	private JInternalFrame internalFrame;
	
	public void init() {
		//inisailiasi Frame
		mainFrame = new JFrame("DoPe Game Store");
		
		//init panel
		centerPanel = new JPanel();
		
		// centerin mainframe
		mainFrame.add(centerPanel, BorderLayout.CENTER);
		
		//init Label
		JLabel welcomeMessage = new JLabel("Welcome to DoPe Game Store");
		
		//add to centerpanel
		centerPanel.add(welcomeMessage);
	
		//init Menu
		menu1 = new JMenu("Profile");
		menu1.add("Edit Profile");
		menu1.add("Exit");
		
		menu2 = new JMenu ("Transaction");
		menu2.add("Buy Game");
		menu2.add("View Transaction History");
		
		//init Menu Bar
		menuBar = new JMenuBar();
		menuBar.add(menu1);
		menuBar.add(menu2);
		
		
		//init Menu Item
		EditProfile = new JMenuItem("Edit Profile");
		Exit = new JMenuItem("Exit");
		BuyGame = new JMenuItem("Buy Game");
		ViewTransactionHistory = new JMenuItem("View Transaction History");
		
		
		
		
		
		
	}
	public MainFormCustomer() {
		init();
		
		mainFrame.getContentPane().setBackground(Color.decode("#fbfbcc"));
		mainFrame.setJMenuBar(menuBar);
		mainFrame.setLayout(new GridBagLayout());
		mainFrame.setVisible(true);
		mainFrame.setSize(800, 600);
		mainFrame.setLocationRelativeTo(null);
		//supaya keterminate
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
	 new MainFormCustomer();

	}

}