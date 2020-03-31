package Commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import GUI.EditorView;
import Model.Document;

public class openDocument implements ActionListener {
	Document doc=new Document();
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
//		doc.first_time_save=false;
		doc.setFirstTimeSave(false);
		EditorView ed=new EditorView();
		try {
			ed.createFileBrowser();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
