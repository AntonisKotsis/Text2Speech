/*
 * Written by
 * Mitos-Kotsis Antonios  3028
 * Drougkas Konstantinos  3174
 * Pouboulidis Anastasios 3066
 */

package GUI;
import Commands.*;
import Model.Document;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

import java.util.Scanner;

import javax.swing.*;
public class EditorView {
	private JFrame editorFrame;
	private JMenuBar action_menu_bar;
	private JMenu fileMenu,speechMenu,normalSpeechMenu,reverseSpeechMenu;
	private JMenu blank_menu_1,blank_menu_2,blank_menu_3,blank_menu_4,blank_menu_5;	//use these to create a margin between menus
	public static JTextArea text_file_input;
	
	private String fileTitle,fileAuthor,fileName;
	
	private Document Doc ;
	
	private void createEditorViewFrame() {
		  editorFrame = new JFrame("Text2Speech");
	      editorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      action_menu_bar = new JMenuBar();
	           
	}
	
	private void createEditorViewMenu() {
		CommandsFactory cf=new CommandsFactory();
		//sets the orientation of menu bar to horizontal
		action_menu_bar.setLayout(new GridLayout(1,0));
		
		//File menu
	    fileMenu = new JMenu("File");
	    fileMenu.setMnemonic(KeyEvent.VK_F);
	    action_menu_bar.add(fileMenu);
	    JMenuItem new_file_opt = new JMenuItem("New...", KeyEvent.VK_N);
	    JMenuItem open_file_opt = new JMenuItem("Open File", KeyEvent.VK_O);
	    JMenuItem save_file_opt = new JMenuItem("Save File",KeyEvent.VK_S);
	    JMenuItem edit_file_opt = new JMenuItem("Edit File");
	    JMenuItem exit_file_opt = new JMenuItem("Exit");
	    fileMenu.add(new_file_opt);
	    fileMenu.addSeparator();
	    fileMenu.add(open_file_opt);
	    fileMenu.addSeparator();
	    fileMenu.add(save_file_opt);
	    fileMenu.addSeparator();
	    fileMenu.add(edit_file_opt);
	    fileMenu.addSeparator();
	    fileMenu.add(exit_file_opt);
	    
	    //add actionListeners to File menuItems
	    new_file_opt.addActionListener(cf.createCommand("_new"));
	    open_file_opt.addActionListener(cf.createCommand("_open"));
	    save_file_opt.addActionListener(cf.createCommand("_save"));
	    edit_file_opt.addActionListener(cf.createCommand("_edit"));
	    exit_file_opt.addActionListener(cf.createCommand("_exit"));
	    
	    //Speech Menu
	    speechMenu = new JMenu("Speech");
	    action_menu_bar.add(speechMenu);
	    
	    //submenu options
	    JMenuItem whole_text_opt_norm = new JMenuItem("Entire File");
	    JMenuItem line_opt_norm=new JMenuItem("Single Line");
	    JMenuItem whole_text_opt_rev = new JMenuItem("Entire Reverse File");
	    JMenuItem line_opt_rev=new JMenuItem("Single Reverse Line");
	    
	    //Normal Submenu
	    normalSpeechMenu=new JMenu("Normal");
	    normalSpeechMenu.add(whole_text_opt_norm);
		normalSpeechMenu.add(line_opt_norm);
		speechMenu.add(normalSpeechMenu);
		//add action listeners for normal text
		whole_text_opt_norm.addActionListener(cf.createCommand("_doc2text"));
		line_opt_norm.addActionListener(cf.createCommand("_line2text"));
		
		//Reverse Submenu
		reverseSpeechMenu=new JMenu("Reverse");
		reverseSpeechMenu.add(whole_text_opt_rev);
		reverseSpeechMenu.add(line_opt_rev);
		speechMenu.add(reverseSpeechMenu);   
		//add action listeners for reversed text
		whole_text_opt_rev.addActionListener(cf.createCommand("_revdoc2text"));
		line_opt_rev.addActionListener(cf.createCommand("_revline2text"));
		
		//Complete the following in sprint 2 
		blank_menu_1=new JMenu("    			");
		blank_menu_1.disable();
		blank_menu_2=new JMenu("    			");
		blank_menu_2.disable();
		blank_menu_3=new JMenu("    			");
		blank_menu_3.disable();
		blank_menu_4=new JMenu("    			");
		blank_menu_4.disable();
		blank_menu_5=new JMenu("    			");
		blank_menu_5.disable();
		
		action_menu_bar.add(blank_menu_1);
		action_menu_bar.add(blank_menu_2);
	    action_menu_bar.add(blank_menu_3);
	    action_menu_bar.add(blank_menu_4);
	    action_menu_bar.add(blank_menu_5);
	    
	    action_menu_bar.revalidate();
	    editorFrame.setJMenuBar(action_menu_bar);
	    editorFrame.setSize(800, 800);
	    editorFrame.setVisible(true);
	}
	
	
	private void createEditorViewTextArea(){
		text_file_input=new JTextArea(200,200);
		text_file_input.setEditable(false);
		editorFrame.add(text_file_input);	
	}
	
	//following creates the pop up window when user need to create a new file
	public void createNewFilePopUpFrame() {
		//when user creates a new file the text must be set to null("") and the editor must be non-editable  
		text_file_input.setText("");
		text_file_input.setEditable(false);
		
		JTextField titleField =new JTextField(10);
		JTextField authorField =new JTextField(10);
		//JTextField filenameField=new JTextField(10);
		JPanel myPanel=new JPanel();
		myPanel.add(new JLabel("Title:"));
		myPanel.add(titleField);
		myPanel.add(Box.createHorizontalStrut(15));
		myPanel.add(new JLabel("Author:"));
		myPanel.add(authorField);
		int option= JOptionPane.showConfirmDialog(null,myPanel,"New File",JOptionPane.OK_CANCEL_OPTION);
		
		if(option==JOptionPane.OK_OPTION) {
			fileTitle=titleField.getText();
			fileAuthor=authorField.getText();
			fileName="";
			//create new Document 
			Doc =new Document(fileAuthor,fileTitle,fileName);
			
			Doc.createNewEmptyDocument(Doc);
			
		}
	
	}
	
	public void createSaveFilePopUpFrame() {
		Document Doc2=new Document();
		JTextField filenameField=new JTextField(10);
		JPanel myPanel=new JPanel();

		myPanel.add(new JLabel("File name:"));
		myPanel.add(filenameField);
		//create the pop up frame
		int option= JOptionPane.showConfirmDialog(null,myPanel,"Save File",JOptionPane.OK_CANCEL_OPTION);
		
		if(option==JOptionPane.OK_OPTION) {			
			fileName=filenameField.getText();
			
			Doc2.saveNewDocument(fileName);
			Doc2.first_time_save=false;
		}
	
	}
	
	public void createFileBrowser() throws FileNotFoundException {
		Document Doc3;
		File openedFile=null;
		Scanner in=null;
		JFileChooser file_chooser =new JFileChooser();
		if(file_chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			openedFile=file_chooser.getSelectedFile();
			Doc3=new Document("def","def",openedFile.getName());
			//System.out.print(openedFile.getName());
			if(openedFile!=null) {
				System.out.println("Opening file succesfully");
				Doc3.openDocument(openedFile,Doc3);
				
			}
		}
		
	}
	public void setTextArea(String text) {
		text_file_input.setEditable(true);
		text_file_input.setText(text);
		text_file_input.setEditable(false);
	}
	
	
	public static void main(String [] args) {
		EditorView ev=new EditorView();
		ev.createEditorViewFrame();
		ev.createEditorViewMenu();
		ev.createEditorViewTextArea();
	}
	
	public String getEditorText() {
		return text_file_input.getText();
	}
	
	public String getEditorSelectedLine() {
		return text_file_input.getSelectedText();
	}
}
