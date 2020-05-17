package ModelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import GUI.EditorView;
import Model.Document;
import TextToSpeechAPI.FakeTTsAPI;
import encodingStrategies.Atbash;
import encodingStrategies.Rot13;

class SpeechTest {

	@Test
	void test() {
		//fail("Not yet implemented");
		EditorView ev=new EditorView();
		Document doc=new Document();
		FakeTTsAPI fake=new FakeTTsAPI();
		String [] args= {" "," "};
		String TestText="Convert this to speech";
		String ReverseTestText="speech to this Convert";
		Atbash at=new Atbash();
		String newat=at.encode(TestText);
		Rot13 rot=new Rot13();
		String newrot=rot.encode(TestText);
		ev.main(args);		
		
		//test each function that uses the SpeechAPI
		doc.playContent(TestText, "fakeTTS");
		assertEquals(TestText,fake.getTestText());
		
		doc.playLine(TestText, "fakeTTS");
		assertEquals(TestText,fake.getTestText());
		
		doc.playReversedContent(TestText, "fakeTTS");
		assertEquals(ReverseTestText,fake.getTestText().trim());
		
		doc.playReversedLine(TestText, "fakeTTS");
		assertEquals(ReverseTestText,fake.getTestText().trim());
		
		doc.playEncodedContent(TestText, "fakeTTS");
		assertEquals(newrot,fake.getTestText());
		
		doc.playEncodedLine(TestText, "fakeTTS");
		assertEquals(newrot,fake.getTestText());
		
		
	}

}
