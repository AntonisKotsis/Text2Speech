package TextToSpeechAPI;

public class Text2SpeechAPIFactory {
	
	public Text2SpeechAPI createTTSAPI(String tts) {
		switch (tts) {
		case "fakeTTS":
			//change the following with fakeTTs
			return new FakeTTsAPI();

		default:
			return new FreeTTSAdapter();
			
		}
	}
}
