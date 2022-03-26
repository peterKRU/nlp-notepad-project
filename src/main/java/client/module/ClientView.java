package client.module;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;


public class ClientView extends JFrame{
	
	private HashMap<String, Integer> configMap;
	
	private GridBagLayout defaultLayout;
	private JToolBar toolBarTop;
	private JPanel fileExplorerPanel;
	private JTree fileExplorerTree;
	private JTabbedPane inputAreaMain;
	private JTextArea inputTextAreaMain;
	private JTextArea inputTextAreaSecondary;
	private JTabbedPane outputAreaMain;
	private JTextArea outputTextAreaMain;
	private JTextArea outputTextAreaTokens;
	private JToolBar toolBarMid;
	private JPanel consoleArea;
	private JTextArea consoleLogArea;
	private JTextField commandTextField;
	private JToolBar toolBarBottom;
	private JMenuBar menuBar;
	
	private JMenuItem detectSentencesItem;
	private JMenuItem tokenizeTextItem;

	
	public ClientView() {
		
		
		this.setBounds(100, 100, 1400, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setupLayout();
		setupToolBarTop();
		setupFileExplorerPanel();
		setupInputArea();
		setupOutputArea();
		setupToolBarMid();
		setupConsolePanel();
		setupToolBarBottom();
		setupMenuBar();
		
		this.setVisible(true);
		
	}
	
	
	public void setupLayout() {
		
		defaultLayout = new GridBagLayout();
		defaultLayout.columnWidths = new int[] {100, 500, 500, 10};
		defaultLayout.rowHeights = new int[]{30, 205, 0, 110, 0, 0, 0, 0};
		defaultLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		defaultLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.getContentPane().setLayout(defaultLayout);
		
	}
	
	public void setupToolBarTop() {
		
		toolBarTop = new JToolBar();
		GridBagConstraints gbc_toolBarTop = new GridBagConstraints();
		gbc_toolBarTop.anchor = GridBagConstraints.WEST;
		gbc_toolBarTop.gridwidth = 2;
		gbc_toolBarTop.insets = new Insets(0, 0, 5, 0);
		gbc_toolBarTop.gridx = 1;
		gbc_toolBarTop.gridy = 0;
		this.getContentPane().add(toolBarTop, gbc_toolBarTop);
		
		JLabel labelIcons = new JLabel("Icons (WiP)");
		toolBarTop.add(labelIcons);
		
	}

	public void setupFileExplorerPanel() {
		
		fileExplorerPanel = new JPanel();
		fileExplorerPanel.setBorder(null);
		GridBagConstraints gbc_fileExplorerPanel = new GridBagConstraints();
		gbc_fileExplorerPanel.weightx = 0.9;
		gbc_fileExplorerPanel.anchor = GridBagConstraints.WEST;
		gbc_fileExplorerPanel.gridheight = 7;
		gbc_fileExplorerPanel.insets = new Insets(0, 5, 0, 5);
		gbc_fileExplorerPanel.fill = GridBagConstraints.BOTH;
		gbc_fileExplorerPanel.gridx = 0;
		gbc_fileExplorerPanel.gridy = 0;
		this.getContentPane().add(fileExplorerPanel, gbc_fileExplorerPanel);
		fileExplorerPanel.setLayout(new BorderLayout(0, 0));
		
		fileExplorerPanel.setVisible(true);
		
		fileExplorerTree = new JTree();
		
		fileExplorerTree.setModel(new DefaultTreeModel(
				new DefaultMutableTreeNode("Folder") {
					{
						DefaultMutableTreeNode node_1;
						node_1 = new DefaultMutableTreeNode("Subfolder");
							node_1.add(new DefaultMutableTreeNode("OLOLO"));
							node_1.add(new DefaultMutableTreeNode("ALALA"));
							node_1.add(new DefaultMutableTreeNode("ELELE"));
							node_1.add(new DefaultMutableTreeNode("LOLOLO"));
						add(node_1);
						node_1 = new DefaultMutableTreeNode("Subfolder 2");
							node_1.add(new DefaultMutableTreeNode("OLOLO"));
							node_1.add(new DefaultMutableTreeNode("OLO"));
							node_1.add(new DefaultMutableTreeNode("OL"));
							node_1.add(new DefaultMutableTreeNode("OLOLO"));
						add(node_1);
						node_1 = new DefaultMutableTreeNode("Subfolder 3");
							node_1.add(new DefaultMutableTreeNode("ELELE"));
							node_1.add(new DefaultMutableTreeNode("ELE"));
							node_1.add(new DefaultMutableTreeNode("ELELE"));
							node_1.add(new DefaultMutableTreeNode("ALALA"));
						add(node_1);
					}
				}
			));
		
		fileExplorerPanel.add(fileExplorerTree, BorderLayout.CENTER);
		
	}
	
	public void setupInputArea() {
		
		inputAreaMain = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_inputAreaMain = new GridBagConstraints();
		gbc_inputAreaMain.fill = GridBagConstraints.BOTH;
		gbc_inputAreaMain.insets = new Insets(0, 5, 5, 5);
		gbc_inputAreaMain.gridx = 1;
		gbc_inputAreaMain.gridy = 1;
		this.getContentPane().add(inputAreaMain, gbc_inputAreaMain);
		
		JScrollPane inputAreaMainScrollPane1 = new JScrollPane();
		inputAreaMainScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		inputAreaMainScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		inputAreaMain.addTab("Input Text Area", null, inputAreaMainScrollPane1, null);
		
		inputTextAreaMain = new JTextArea();
		inputTextAreaMain.setLineWrap(true);
		inputTextAreaMain.setAlignmentX(Component.LEFT_ALIGNMENT);
		inputTextAreaMain.setWrapStyleWord(true);
		inputAreaMainScrollPane1.setViewportView(inputTextAreaMain);
		
		JScrollPane inputAreaMainScrollPane2 = new JScrollPane();
		inputAreaMainScrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		inputAreaMainScrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		inputAreaMain.addTab("Tab 2", null, inputAreaMainScrollPane2, null);
		
		inputTextAreaSecondary = new JTextArea();
		inputTextAreaSecondary.setWrapStyleWord(true);
		inputTextAreaSecondary.setLineWrap(true);
		inputTextAreaSecondary.setAlignmentX(0.0f);
		inputAreaMainScrollPane2.setViewportView(inputTextAreaSecondary);
		
	}
		
	public void setupOutputArea() {
		
		outputAreaMain = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_outputAreaMain = new GridBagConstraints();
		gbc_outputAreaMain.fill = GridBagConstraints.BOTH;
		gbc_outputAreaMain.insets = new Insets(0, 0, 5, 0);
		gbc_outputAreaMain.gridx = 2;
		gbc_outputAreaMain.gridy = 1;
		this.getContentPane().add(outputAreaMain, gbc_outputAreaMain);
		JScrollPane outputAreaMainScrollPane = new JScrollPane();
		outputAreaMainScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		outputAreaMain.addTab("Sentences", null, outputAreaMainScrollPane, null);
		
		outputTextAreaMain = new JTextArea();
		outputTextAreaMain.setEditable(false);
		outputTextAreaMain.setLineWrap(true);
		outputTextAreaMain.setWrapStyleWord(true);
		outputAreaMainScrollPane.setViewportView(outputTextAreaMain);
		
		JScrollPane outputAreaTokens = new JScrollPane();
		outputAreaTokens.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		outputAreaMain.addTab("Tokens", null, outputAreaTokens, null);
		
		outputTextAreaTokens = new JTextArea();
		outputTextAreaTokens.setEditable(false);
		outputTextAreaTokens.setLineWrap(true);
		outputTextAreaTokens.setWrapStyleWord(true);
		outputAreaTokens.setViewportView(outputTextAreaTokens);
		
	}
		
	
	public void setupToolBarMid() {
		
		toolBarMid = new JToolBar();
		GridBagConstraints gbc_toolBarMid = new GridBagConstraints();
		gbc_toolBarMid.fill = GridBagConstraints.HORIZONTAL;
		gbc_toolBarMid.anchor = GridBagConstraints.WEST;
		gbc_toolBarMid.gridwidth = 4;
		gbc_toolBarMid.insets = new Insets(0, 0, 5, 0);
		gbc_toolBarMid.gridx = 1;
		gbc_toolBarMid.gridy = 2;
		this.getContentPane().add(toolBarMid, gbc_toolBarMid);
		
		JCheckBox toggleFileExplorerPanel = new JCheckBox("Show/Hide File Explorer");
		toggleFileExplorerPanel.setHorizontalAlignment(SwingConstants.CENTER);
		toggleFileExplorerPanel.setSelected(true);
		toolBarMid.add(toggleFileExplorerPanel);
		
	}

	public void setupConsolePanel() {
		
		consoleArea = new JPanel();
		GridBagConstraints gbc_consoleArea = new GridBagConstraints();
		gbc_consoleArea.insets = new Insets(0, 5, 5, 0);
		gbc_consoleArea.gridwidth = 2;
		gbc_consoleArea.fill = GridBagConstraints.BOTH;
		gbc_consoleArea.gridx = 1;
		gbc_consoleArea.gridy = 3;
		this.getContentPane().add(consoleArea, gbc_consoleArea);
		consoleArea.setLayout(new BoxLayout(consoleArea, BoxLayout.X_AXIS));
		
		JScrollPane consoleAreaScrollPanel = new JScrollPane();
		consoleAreaScrollPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		consoleAreaScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		consoleAreaScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		consoleArea.add(consoleAreaScrollPanel);
		
		consoleLogArea = new JTextArea();
		consoleLogArea.setEditable(false);
		consoleLogArea.setLineWrap(true);
		consoleAreaScrollPanel.setViewportView(consoleLogArea);
		
		JLabel labelConsole = new JLabel("Console");
		GridBagConstraints gbc_labelConsole = new GridBagConstraints();
		gbc_labelConsole.anchor = GridBagConstraints.WEST;
		gbc_labelConsole.insets = new Insets(0, 5, 5, 5);
		gbc_labelConsole.gridx = 1;
		gbc_labelConsole.gridy = 4;
		this.getContentPane().add(labelConsole, gbc_labelConsole);
		
		commandTextField = new JTextField();
		GridBagConstraints gbc_consoleField = new GridBagConstraints();
		gbc_consoleField.ipady = 20;
		gbc_consoleField.gridwidth = 2;
		gbc_consoleField.insets = new Insets(0, 5, 5, 0);
		gbc_consoleField.fill = GridBagConstraints.HORIZONTAL;
		gbc_consoleField.gridx = 1;
		gbc_consoleField.gridy = 5;
		this.getContentPane().add(commandTextField, gbc_consoleField);
		commandTextField.setColumns(10);
		
	}
	
	public void setupToolBarBottom() {
		
		toolBarBottom = new JToolBar();
		GridBagConstraints gbc_toolBarBottom = new GridBagConstraints();
		gbc_toolBarBottom.anchor = GridBagConstraints.WEST;
		gbc_toolBarBottom.gridwidth = 2;
		gbc_toolBarBottom.gridx = 1;
		gbc_toolBarBottom.gridy = 6;
		this.getContentPane().add(toolBarBottom, gbc_toolBarBottom);
		
		JLabel appVersionLabel = new JLabel("App Version");
		toolBarBottom.add(appVersionLabel);
		
	}
	
	public void setupMenuBar() {
		
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu fileOption = new JMenu("File");
		menuBar.add(fileOption);
		
		JMenuItem openTextFileItem = new JMenuItem("Open Text File");
		fileOption.add(openTextFileItem);
		
		JMenuItem saveTextFileItem = new JMenuItem("Save Text File");
		fileOption.add(saveTextFileItem);
		
		JMenuItem refreshItem = new JMenuItem("Refresh");
		fileOption.add(refreshItem);
		
		JMenuItem exitItem = new JMenuItem("Exit");
		fileOption.add(exitItem);
		
		JMenu processOption = new JMenu("Process");
		menuBar.add(processOption);
		
		tokenizeTextItem = new JMenuItem("Tokenize Text");
		processOption.add(tokenizeTextItem);
		
		detectSentencesItem = new JMenuItem("Detect Sentences");
		//JMenuItem detectSentencesItem = new JMenuItem("Detect Sentences");
		processOption.add(detectSentencesItem);
		
		JMenu toolsOption = new JMenu("Tools");
		menuBar.add(toolsOption);
		
		JMenu findOption = new JMenu("Find");
		menuBar.add(findOption);
		
		JMenuItem regularSearchItem = new JMenuItem("Regular Search");
		findOption.add(regularSearchItem);
		
		JMenuItem findRegExPatternItem = new JMenuItem("Find RegExPattern");
		findOption.add(findRegExPatternItem);
	
		JMenu settingsOption = new JMenu("Settings");
		menuBar.add(settingsOption);
		
		JMenu helpOption = new JMenu("Help");
		menuBar.add(helpOption);
		
		JMenu aboutOption = new JMenu("About");
		menuBar.add(aboutOption);
		
	}
	
	public void addDetectSentencesListener(ActionListener detectSentencesListener){

		detectSentencesItem.addActionListener(detectSentencesListener);
		
	}
	
	public void addTokenizeListener(ActionListener tokenizeListener){

		tokenizeTextItem.addActionListener(tokenizeListener);
		
	}

	public JTextArea getInputTextAreaMain() {
		return inputTextAreaMain;
	}

	public void setInputTextAreaMain(JTextArea inputTextAreaMain) {
		this.inputTextAreaMain = inputTextAreaMain;
	}

	public JTextArea getInputTextAreaSecondary() {
		return inputTextAreaSecondary;
	}

	public void setInputTextAreaSecondary(JTextArea inputTextAreaSecondary) {
		this.inputTextAreaSecondary = inputTextAreaSecondary;
	}

	public JTextArea getOutputTextAreaMain() {
		return outputTextAreaMain;
	}

	public void setOutputTextAreaMain(JTextArea outputTextAreaMain) {
		this.outputTextAreaMain = outputTextAreaMain;
	}

	public JTextArea getOutputTextAreaTokens() {
		return outputTextAreaTokens;
	}

	public void setOutputTextAreaTokens(JTextArea outputTextAreaTokens) {
		this.outputTextAreaTokens = outputTextAreaTokens;
	}

	public JTextArea getConsoleLogArea() {
		return consoleLogArea;
	}

	public void setConsoleLogArea(JTextArea consoleLogArea) {
		this.consoleLogArea = consoleLogArea;
	}

	public JTextField getCommandTextField() {
		return commandTextField;
	}

	public void setCommandTextField(JTextField commandTextField) {
		this.commandTextField = commandTextField;
	}
}
