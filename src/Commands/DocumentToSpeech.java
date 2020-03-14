package Commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Document;

public class DocumentToSpeech implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Document doc =new Document();
		System.out.println(arg0.getActionCommand());
		if(arg0.getActionCommand().equals("Entire File")) {
			doc.playContent();
		}
		else {
			doc.playReversedContent();
		}
		
		
	}

}
