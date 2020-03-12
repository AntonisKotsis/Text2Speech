package Commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import Model.Document;

public class exitDocument implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Document doc=new Document();
		doc.emptyList();		//clear the document list when exiting program
		System.out.println("Terminating process...");
		System.exit(1);
	}
	

}
