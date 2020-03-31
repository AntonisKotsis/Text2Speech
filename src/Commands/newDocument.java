package Commands;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GUI.EditorView;

public class newDocument implements ActionListener {
	Document doc=new Document();
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
//		doc.first_time_save=true;
		doc.setFirstTimeSave(true);
		EditorView ed=new EditorView();	
		
		ed.createNewFilePopUpFrame();
	}

}
