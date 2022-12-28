package main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ManageForm {
	private JFrame mainFrame;
	 private JPanel northPanel, centerPanel, southPanel, mainPanel, tablePanel, southTop, southBottom, centerTop;
	 private JTable gameTable;
	 private DefaultTableModel dtm;
	 private JScrollPane gameTabelContainerScrollPane;
	 private JLabel manageGameLabel, newGameIdLabel, newGameNameLabel, newGameTypeLabel, newGamePriceLabel, newGameStockLabel, gameIdLabel, gameNameLabel, gameTypeLabel, gamePriceLabel, gameStockLabel, addStockLabel;
	 private JButton insertGameButton, updateGameButton, deleteGameButton, resetButton, addStockButton;
	 private JTextField newGameIdField, newGameNameField, newGamePriceField, gameIdField, gameNameField, gamePriceField, gameStockField;
	 private JComboBox<String> newGameTypeComboBox, gameTypeComboBox;
	 private JSpinner newGameStockSpinner, addStockSpinner;
	 private Vector<String> listGameType, listNewGameType;
	 private JInternalFrame internalFrame;
	 private JMenuBar menuBar;
	 private JMenu profileMenu, manageMenu;
	 private JDesktopPane desktopPane;

	 private void init() {
		  //init Frame
		   mainFrame = new JFrame("Dope Game Store");
		   
		      //init Panel
		   northPanel = new JPanel();
		   centerPanel = new JPanel(new GridLayout(2, 1, 20,10));
		   centerTop = new JPanel(new GridLayout(5,4,20,10));
		   southTop = new JPanel(new GridLayout(1,3,10,10));
		   southBottom = new JPanel(new GridLayout(1,3,10,10));
		   southPanel = new JPanel(new GridLayout(2,6,10,10));
		   tablePanel = new JPanel();
		   mainPanel= new JPanel(new BorderLayout());
		   
		  //init JTextfield
		   newGameIdField = new JTextField();
		   newGameNameField = new JTextField(10);
		   newGamePriceField = new JTextField(10);
		   gameIdField = new JTextField(10);
		   gameNameField = new JTextField(10);
		   gamePriceField = new JTextField(10);
		   gameStockField = new JTextField(10);
		   
		   //set size text field
		   newGameIdField.setSize(5, 5);
		   newGameNameField.setSize(new Dimension(2,2));
		  
		  
		  
		   //init Vector
		   listGameType = new Vector<>();
		   
		   listGameType.add("TPS");
		   listGameType.add("MOBA");
		   listGameType.add("FPS");
		   listGameType.add("RPG");
		   
		   gameTypeComboBox = new JComboBox<String>(listGameType);
		   
		   listNewGameType = new Vector<>();
		   
		   listNewGameType.add("TPS");
		   listNewGameType.add("MOBA");
		   listNewGameType.add("FPS");
		   listNewGameType.add("RPG");
		   
		   newGameTypeComboBox = new JComboBox<String>(listNewGameType);
		   
		   //init Spinner
		   newGameStockSpinner = new JSpinner();
		   addStockSpinner = new JSpinner();
		   
		   //init Button
		   insertGameButton = new JButton("Insert Game");
		   resetButton = new JButton("Reset");
		   updateGameButton = new JButton("Update Game");
		   deleteGameButton = new JButton("Delete Game");
		   addStockButton = new JButton("Add Stock");
		   resetButton.setSize(10,10);
		   
		   Object [] header = new Object[] {"Game Id", "Game Name", "Game Type", "Game Price", "Game Stock"};
		   Object [][] data = new Object [][] {
		    {"GA001", "Minecraft", "RPG", "650000", "82"},
		    {"GA002", "Crossfire", "FPS", "4500000", "178"}
		   };
		   
		   
		   //init dtm 
		   dtm = new DefaultTableModel(data, header) {   
		  
		  
		  };
		  
		   gameTable = new JTable(dtm);
		  
		   gameTable.setRowHeight(30);
		   gameTable.getTableHeader().setReorderingAllowed(false);
		   gameTabelContainerScrollPane = new JScrollPane(gameTable);
		   gameTabelContainerScrollPane.setPreferredSize(new Dimension(500, 50));
		   tablePanel.add(gameTabelContainerScrollPane);
		   centerPanel.add(gameTabelContainerScrollPane);
		  
		   //init Internal Frame
		   internalFrame = new JInternalFrame();
		   internalFrame.setVisible(true);
		   internalFrame.setSize(800, 700);
		   internalFrame.setClosable(true);
		   internalFrame.setMaximizable(true);
		   //internalFrame.setLocation(200, 100);
		   
		   
		   //init menu 
		   profileMenu = new JMenu("Profile");
		   manageMenu = new JMenu("Manage");
		   
		   //init menu bar
		   menuBar = new JMenuBar();
		   menuBar.add(profileMenu);
		   menuBar.add(manageMenu);
		   
		   
		   //init label
		   manageGameLabel = new JLabel("Manage Game");
		   newGameIdLabel = new JLabel("New Game ID");
		   newGameNameLabel = new JLabel("New Game Name");
		   newGameTypeLabel = new JLabel("New Game Type");
		   newGamePriceLabel = new JLabel("New Game Price");
		   newGameStockLabel = new JLabel("New Game Stock");
		   gameIdLabel = new JLabel("Game ID");
		   gameNameLabel = new JLabel("Game Name");
		   gameTypeLabel = new JLabel("Game Type");
		   gamePriceLabel = new JLabel("Game Price");
		   gameStockLabel = new JLabel("Game Stock");
		   addStockLabel = new JLabel("Add Stock");
		   manageGameLabel = new JLabel("Manage Game");
		   
		   
		   //south
		   southTop.add(insertGameButton);
		   southTop.add(updateGameButton);
		   southTop.add(deleteGameButton);
		   southBottom.add(addStockButton);
		   southBottom.add(resetButton);
		   southBottom.add(addStockLabel);
		   southBottom.add(addStockSpinner);
		   southBottom.add(addStockButton);
		   
	
		   mainPanel.add(northPanel, BorderLayout.NORTH);
		   mainPanel.add(centerPanel, BorderLayout.CENTER);
		   mainPanel.add(southPanel, BorderLayout.SOUTH);
		   
		   //add to northPanel
		   northPanel.add(manageGameLabel);
		   
		   //add to centerPanel
		   centerTop.add(newGameIdLabel);
		   centerTop.add(newGameIdField);
		   centerTop.add(gameIdLabel);
		   centerTop.add(gameIdField);
		    centerTop.add(newGameNameLabel);
		   centerTop.add(newGameNameField);
		   centerTop.add(gameNameLabel);
		   centerTop.add(gameNameField);
		   centerTop.add(newGameTypeLabel);
		   centerTop.add(newGameTypeComboBox);
		   centerTop.add(gameTypeLabel);
		   centerTop.add(gameTypeComboBox);
		   centerTop.add(newGamePriceLabel);
		   centerTop.add(newGamePriceField);   
		   centerTop.add(gamePriceLabel);
		   centerTop.add(gamePriceField);
		   centerTop.add(newGameStockLabel);
		   centerTop.add(newGameStockSpinner);
		   centerTop.add(gameStockLabel);
		   centerTop.add(gameStockField);
		   
		   //center panel
		   centerPanel.add(centerTop);
		   
		   //add to southPanel
		   southPanel.add(southTop);
		   southPanel.add(southBottom);
		 
		   internalFrame.add(northPanel, BorderLayout.NORTH);
		   internalFrame.add(centerPanel, BorderLayout.CENTER);
		   internalFrame.add(southPanel, BorderLayout.SOUTH);
		 
		 }
	 
	public ManageForm() {
		  init();
		  
		    mainFrame.setJMenuBar(menuBar);
		    mainFrame.add(internalFrame);
		    mainFrame.setVisible(true);
		    
		    mainFrame.setSize(800, 600);
		    
		    mainFrame.setLocationRelativeTo(null);
		    
		    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ManageForm();

	}
}