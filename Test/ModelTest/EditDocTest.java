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
		ev.main(args);
		Document doc =new Document("test","test2","test2");
		boolean res=doc.editDocument(doc);
		assertEquals(res,true);
	}

}
