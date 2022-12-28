package main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class BuyGameForm {
 private JFrame mainFrame;
  private JPanel northPanel,northTop,centertop1, centerPanel,centerTop,centerButtom, southPanel, mainPanel, centerPanelNorth,southTop,southBottom,southBottomUp,southBottomDown ;
  private JTable gameTable, gameTable1;
  private DefaultTableModel dtm,dtmbott;
  private JScrollPane gameTabelContainerScrollPane, gcsp;
  private JLabel manageGameLabel, newGameIdLabel, newGameNameLabel, newGameTypeLabel, newGamePriceLabel, newGameStockLabel, gameIdLabel, gameNameLabel, gameTypeLabel, gamePriceLabel, gameStockLabel, addStockLabel,quantitylbl;
  private JButton  removeCartButton,clearButton,checkoutButton,addStockButton;
  private JTextField GameType, newGameIdField, newGameNameField, newGamePriceField, gameIdField, gameNameField, gamePriceField, gameStockField;
//  private JComboBox<String> newGameTypeComboBox, gameTypeComboBox;
  private JSpinner newGameStockSpinner, addStockSpinner,gameQtty;
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
     centerPanel = new JPanel(new GridLayout(3, 1, 20, 20));
     centerTop = new JPanel(new GridLayout(3, 6, 20, 20));
     centerButtom = new JPanel();
     southPanel = new JPanel(new GridLayout(2, 1, 10,10));
     southTop = new JPanel(new GridLayout(1	, 2, 20,20));

     mainPanel= new JPanel(new BorderLayout());
     
     Object [] header = new Object[] {"Game Id", "Game Name", "Game Type", "Game Price", "Game Stock"};
     Object [][] data = new Object [][] {
      {"GA001", "Minecraft", "RPG", "650000", "82"},
      {"GA002", "Crossfire", "FPS", "4500000", "178"}
     };
     
     
     //init dtm 
     dtm = new DefaultTableModel(data, header) {   
    	 @Override
			public boolean isCellEditable(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return false;
			}
    
    };
    
     gameTable = new JTable(dtm);
    
     gameTable.setRowHeight(30);
     gameTable.getTableHeader().setReorderingAllowed(false);
     gameTabelContainerScrollPane = new JScrollPane(gameTable);
     gameTabelContainerScrollPane.setPreferredSize(new Dimension(500, 50));
     
     
     Object [] header1 = new Object[] {"Game Id", "Game Name", "Game Type", "Game Price", "Game Stock"};
     
     dtmbott = new DefaultTableModel(data,header1){   
    	 @Override
			public boolean isCellEditable(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return false;
			}
    
    };
    
    gameTable1 = new JTable(dtmbott);
    gameTable1.setRowHeight(30);
    gameTable1.getTableHeader().setReorderingAllowed(false);
    gcsp = new JScrollPane(gameTable1);
    gcsp.setPreferredSize(new Dimension(500,50)); 
    
    //init JTextfield

     gameIdField = new JTextField("GA003");
     gameNameField = new JTextField();
     GameType = new JTextField();
     gamePriceField = new JTextField();
     gameStockField = new JTextField();
     
     gameIdField.setEditable(false);
     
     gameQtty = new JSpinner();
     
     //init Button
		removeCartButton = new JButton("Remove Selected Cart");
		removeCartButton.setPreferredSize(new Dimension(300, 10));
		clearButton = new JButton("Clear Cart");
		clearButton.setPreferredSize(new Dimension(300, 10));
		checkoutButton= new JButton("Checkout");
		checkoutButton.setPreferredSize(new Dimension(300, 10));
		addStockButton = new JButton("Add to Cart");
		addStockButton.setPreferredSize(new Dimension(150, 25));
    
    
     //init Internal Frame
     internalFrame = new JInternalFrame();
     internalFrame.setVisible(true);
     internalFrame.setSize(400, 400);
     internalFrame.setClosable(true);
     internalFrame.setResizable(true);
	 internalFrame.setMaximizable(true);
     
     
     //init menu 
     profileMenu = new JMenu("Profile");
     manageMenu = new JMenu("Manage");
     
     //init menu bar
     menuBar = new JMenuBar();
     menuBar.add(profileMenu);
     menuBar.add(manageMenu);
     
     //init desktop pane
     desktopPane = new JDesktopPane();
     desktopPane.add(internalFrame);
     
     //init label
     manageGameLabel = new JLabel("Buy Game");
     gameIdLabel = new JLabel("Game ID");
     gameNameLabel = new JLabel("Game Name");
     gameTypeLabel = new JLabel("Game Type");
     gamePriceLabel = new JLabel("Game Price");
     gameStockLabel = new JLabel("Game Stock");
     quantitylbl = new JLabel("Game Quantity");
     addStockLabel = new JLabel("Add to Cart");

     //south    

     mainPanel.add(northPanel, BorderLayout.NORTH);
     mainPanel.add(centerPanel, BorderLayout.CENTER);
     mainPanel.add(southPanel, BorderLayout.SOUTH);

     //add to northPanel

     northPanel.add(manageGameLabel);

     //add to centerPanel
  
     centerPanel.add(gameTabelContainerScrollPane);
     centerTop.add(gameIdLabel);
     centerTop.add(gameIdField);
     centerTop.add(gamePriceLabel);
     centerTop.add(gamePriceField);
     centerTop.add(gameNameLabel);
     centerTop.add(gameNameField);
     centerTop.add(gameStockLabel);
     centerTop.add(gameStockField);
     centerTop.add(gameTypeLabel);
     centerTop.add(GameType);
     centerTop.add(quantitylbl);
     centerTop.add(gameQtty);
     
     centerButtom.add(addStockButton);
     
     centerPanel.add(centerTop);
     centerPanel.add(centerButtom);

     //add to southPanel

	 southPanel.add(gcsp);
	 southTop.add(removeCartButton);
	 southTop.add(clearButton);
	 southTop.add(checkoutButton);
	 southPanel.add(southTop);

     internalFrame.add(northPanel, BorderLayout.NORTH);
     internalFrame.add(centerPanel, BorderLayout.CENTER);
     internalFrame.add(southPanel, BorderLayout.SOUTH);

   
   }
  
 public BuyGameForm() {
    init();
    
    	mainFrame.add(internalFrame);

      mainFrame.setVisible(true);
      
      mainFrame.setSize(800, 600);
      
      mainFrame.setLocationRelativeTo(null);
      
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }

 public static void main(String[] args) {
  new BuyGameForm();

 }

}