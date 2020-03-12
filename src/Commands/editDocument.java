package Commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.EditorView;

public class editDocument implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		EditorView ed=new EditorView();
		ed.text_file_input.setEditable(true);
	}

}
