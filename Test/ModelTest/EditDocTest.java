package ModelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import GUI.EditorView;
import Model.Document;

class EditDocTest {

	@Test
	void test() {
		EditorView ev=new EditorView();
		String [] args= {" "," "};
		String editText="This is a testing phrase";
		String res;
		ev.main(args);
		ev.createNewFilePopUpFrame();
		ev.setTextArea(editText);
		res=ev.getEditorText();
		assertEquals(res,editText);
	}

}
