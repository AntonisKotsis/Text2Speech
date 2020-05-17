package ModelTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import GUI.EditorView;
import Model.Document;

class NewDocTest {

	@Test
	void test() {	
		EditorView ev=new EditorView();
		String [] args= {" "," "};
		String text;
		ev.main(args);		
		ev.createNewFilePopUpFrame();
		text=ev.getEditorText();
		assertEquals("",text);
	
	}

}
