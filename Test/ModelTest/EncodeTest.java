package ModelTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Document;

public class EncodeTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Document doc=new Document();
		String atbash_res=doc.atbash("test");
		assertEquals(atbash_res,"GVHG");
		
		String rot13_res=doc.rot13("test");
		assertEquals(rot13_res,"grfg");
	}

}
