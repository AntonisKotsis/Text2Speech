package ModelTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Document;
import encodingStrategies.*;

public class EncodeTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Document doc=new Document();
		
		Atbash at=new Atbash();
		String newat=at.encode("test");
		
		Rot13 rot=new Rot13();
		rot.encode("test");
		
		assertEquals(rot.encode("test"),"grfg");
		assertEquals(newat,"GVHG");
	}

}
