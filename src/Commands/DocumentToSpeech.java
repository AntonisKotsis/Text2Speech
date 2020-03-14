package Commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Document;

public class DocumentToSpeech implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Document doc =new Document();
		doc.playContent();
	}

}
