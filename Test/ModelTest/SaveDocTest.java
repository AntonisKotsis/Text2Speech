package ModelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import GUI.EditorView;
import Model.Document;

class SaveDocTest {

	@Test
	void test() {
		EditorView ev=new EditorView();
		String [] args= {" "," "};
		ev.main(args);
		
		Document doc =new Document("test","test1","test1");
		doc.addToDocList(doc);
		boolean res;
		
		res= doc.saveNewDocument("test_save_doc");
		assertEquals(res,true);
	}

}
