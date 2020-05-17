package ModelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import GUI.EditorView;
import Model.Document;
import TextToSpeechAPI.FakeTTsAPI;
import encodingStrategies.Atbash;
import encodingStrategies.Rot13;

class TuneAudioTest {

	@Test
	void test() {
		EditorView ev=new EditorView();
		Document doc=new Document();
		FakeTTsAPI fake=new FakeTTsAPI();
		String [] args= {" "," "};
		ev.main(args);
		int volume=1,pitch=100,rate=150;
		fake.setVolume((float)volume);
		fake.setPitch(pitch);
		fake.setRate(rate);
		assertEquals(volume,(int)fake.getVolume());
		assertEquals(rate,fake.getRate());
		assertEquals(pitch,fake.getPitch());
		
				
	}

}
