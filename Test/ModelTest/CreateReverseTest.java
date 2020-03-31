package ModelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Document;

class CreateReverseTest {

	@Test
	void test() {
		//fail("Not yet implemented");
		Document doc =new Document();
		String reverse_string=doc.createReverseContent("a k");
		//System.out.println(reverse_string);
		assertEquals(reverse_string,"k a ");
	}

}
