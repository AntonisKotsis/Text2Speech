package TextToSpeechAPI;

public class FakeTTsAPI implements Text2SpeechAPI{
	private static String textForTest;
	private static int pitch,rate;
	private static float volume;
	@Override
	public void play(String text) {
		// TODO Auto-generated method stub
		textForTest=text;
		
	}
	
	public String getTestText() {
		return textForTest;
	}
	@Override
	public void setVolume(float volume) {
		// TODO Auto-generated method stub
		this.volume=volume;
	}

	@Override
	public void setPitch(int pitch) {
		// TODO Auto-generated method stub
		this.pitch=pitch;
	}

	@Override
	public void setRate(int rate) {
		// TODO Auto-generated method stub
		this.rate=rate;
	}

	@Override
	public int getVolume() {
		// TODO Auto-generated method stub
		return (int)volume;
	}

	@Override
	public int getPitch() {
		// TODO Auto-generated method stub
		return pitch;
	}

	@Override
	public int getRate() {
		// TODO Auto-generated method stub
		return rate;
	}

}
