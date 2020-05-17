package Commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.EditorView;
import Model.Document;

public class DocumentToSpeech implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Document doc =new Document();
		EditorView ev=new EditorView();
		System.out.println(arg0.getActionCommand());
		if(arg0.getActionCommand().equals("Entire File")) {
			doc.playContent(ev.getEditorText(),"FreeTTS");
		}
		else {
			doc.playReversedContent(ev.getEditorText(),"FreeTTS");
		}
		
		
	}

}
