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
		
		EditorView ev=new EditorView();
		String [] args= {" "," "};
		ev.main(args);
		Document doc =new Document("test","test1","test1");
		boolean res;
		try {
			res=doc.openDocument(new File("test54.txt"), doc);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			res=false;
			e.printStackTrace();
		}
		
		assertEquals(res,true);
	}

}
