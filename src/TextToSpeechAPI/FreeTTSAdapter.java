package TextToSpeechAPI;
import com.sun.speech.freetts.*;
public class FreeTTSAdapter implements Text2SpeechAPI {
	Voice voice;
	private static int volume=1,pitch=100,rate=150;
	private static float volume_=(float) 10.0;
	
	//This class creates the speech functions from the freeTTS library
	@Override
	public void play(String text) {
		
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		voice =VoiceManager.getInstance().getVoice("kevin16");
		//voice=VoiceManager.getInstance().getVoice("kevin16");
		 if (voice != null && text!=null) {
             voice.allocate();//Allocating Voice
             voice.setVolume(volume_);
             voice.setPitch(pitch);
             voice.setRate(rate);	
             voice.speak(text);
             voice.deallocate();
    }
		
	}

	@Override
	public void setVolume(float volume) {
		this.volume_=(float)volume/10;
		
	}
	@Override
	public int getVolume() {
		float vol=volume_*10;
		System.out.println("Vol in tts="+(int)vol);
		return (int)vol;
	}

	@Override
	public void setPitch(int pitch) {
		this.pitch=pitch;
	}
	@Override
	public int getPitch() {
		return pitch;
	}
	

	@Override
	public void setRate(int rate) {
		this.rate=rate;
	}
	@Override
	public int getRate() {
		return rate;
	}
	
    
}
