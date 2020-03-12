package Commands;
import GUI.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandsFactory {

	
	public ActionListener createCommand(String clickedObj) {
		switch (clickedObj) {
		case "_exit":
			return new exitDocument();
		case "_open":
			return new openDocument();
		case "_new":
			return new newDocument();
		case "_edit":
			return new editDocument();
		case "_save":
			return new saveDocument();
			
		default:
			return new exitDocument();
		}
	}

	
}
