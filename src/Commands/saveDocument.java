package Commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.EditorView;
import Model.Document;

public class saveDocument implements ActionListener {
	Document doc=new Document();
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(doc.getFirstTimeSave()) {
			//this is the first time user tries to save the document so we have to ask the name of the file
			EditorView ed=new EditorView();
			ed.createSaveFilePopUpFrame();
			
		}
		else {
			//in this case we've already saved the file once so we just re-save this using the file name from the documents list
			doc.saveExistedDocument();
		}
		
	}

}
