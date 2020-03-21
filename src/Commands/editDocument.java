package Commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.EditorView;

public class editDocument implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		EditorView ed=new EditorView();
		if(ed.getIsOpenFile()) {
			ed.text_file_input.setEditable(true);
		}
		else {
			System.out.println("There isn't an open file");
		}
	}

}
