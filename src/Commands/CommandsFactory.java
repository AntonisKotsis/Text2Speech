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
		case "_doc2text":
			return new DocumentToSpeech();
		case "_line2text":
			return new LineToSpeech();
		case "_revdoc2text":
			return new DocumentToSpeech();
		case "_revline2text":
			return new LineToSpeech();
		case "_audioSettings" :
			return new TuneAudio();
		case "_tuneAudio":
			return new tuneEncoding();
		default:
			return new exitDocument();
		}
	}

	
}
