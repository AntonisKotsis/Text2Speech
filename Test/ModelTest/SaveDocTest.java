package ModelTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import GUI.EditorView;
import Model.Document;

class SaveDocTest {

	@Test
	void test() throws FileNotFoundException {
		String text="Save testing text\n";
		String res="";
		EditorView ev=new EditorView();
		String [] args= {" "," "};
		ev.main(args);
		ev.createNewFilePopUpFrame();
		ev.setTextArea(text);
		ev.createSaveFilePopUpFrame();
		ev.createFileBrowser();
		res=ev.getEditorText();
		
	
		assertEquals(res,text);
		
		
	}

}
