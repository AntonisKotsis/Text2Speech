package ModelTest;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import GUI.EditorView;
import Model.Document;

class OpenDocTest {

	@Test
	void test() {
		//fail("Not yet implemented");
		String [] args= {" "," "};
		EditorView ev=new EditorView();
		String text="This is a test string\n";
		String res="";
		try {
			ev.main(args);
			ev.createFileBrowser();
			res=ev.getEditorText();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		System.out.println(res);
		System.out.println(text);
		assertEquals(res,text);
	}

}
