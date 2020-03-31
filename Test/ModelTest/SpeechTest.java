package ModelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Document;

class SpeechTest {

	@Test
	void test() {
		//fail("Not yet implemented");
		Document doc =new Document();
		String line_content="Check Line";
		Boolean res=doc.playLine(line_content);
		assertEquals(res, true);
		
		String doc_content="Check whole document";
		res=doc.playContent(doc_content);
		assertEquals(res,true);
		
		String rev_doc_content="Read that in reverse mode";
		res=doc.playReversedContent(rev_doc_content);
		assertEquals(res,true);
		
		String rev_line_content="Read this line in reverse mode";
		res=doc.playReversedLine(rev_line_content);
		assertEquals(res,true);
		
		String enc_doc_content="Encode this text";
		res=doc.playEncodedContent(enc_doc_content);
		assertEquals(res,true);
		
		String enc_line_content="Encode this line";
		res=doc.playEncodedLine(enc_line_content);
		assertEquals(res,true);
		
	}

}
