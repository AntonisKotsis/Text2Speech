package TextToSpeechAPI;

public interface Text2SpeechAPI {
	public void play(String text);
	public void setVolume(float volume);
	public void setPitch (int pitch);
	public void setRate(int rate);
	public int getVolume();
	public int getPitch();
	public int getRate();
}
