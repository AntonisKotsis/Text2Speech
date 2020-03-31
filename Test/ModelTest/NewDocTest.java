package ModelTest;

import org.junit.jupiter.api.Test;

import Model.Document;

class NewDocTest {

	@Test
	void test() {
	//	fail("Not yet implemented");
		Document doc =new Document("Alexandra","Alexandra's Secret","Alexandra's Secret");
		doc.createNewEmptyDocument(doc);
	
	}

}
