package Commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.EditorView;
import Model.Document;

public class LineToSpeech implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Document doc =new Document();
		EditorView ev =new EditorView();
		System.out.println(arg0.getActionCommand());
		if(arg0.getActionCommand().equals("Single Line")) {
			doc.playLine(ev.getEditorSelectedLine());
		}
		else {
			doc.playReversedLine(ev.getEditorSelectedLine());
		}
		
	}

}
