package Commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.EditorView;
import Model.Document;

public class tuneEncoding implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Document doc =new Document();
		if(arg0.getActionCommand().equals("Entire File")) {
			//doc.setEncodingMethod(arg0.getActionCommand());
			//doc.TuneEncoding();
			doc.playEncodedContent();
		}
		else if(arg0.getActionCommand().equals("Single Line")) {
			//doc.setEncodingMethod(arg0.getActionCommand());
			//doc.TuneEncoding();
			doc.playEncodedLine();
		}
		else {
			EditorView ed=new EditorView();
			ed.createEncodingPopUp();
		}
		
	}

}
