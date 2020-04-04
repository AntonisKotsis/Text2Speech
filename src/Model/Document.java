package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.sun.speech.freetts.*;
//import com.sun.speech.freetts.VoiceManager;

import GUI.EditorView;
import TextToSpeechAPI.*;
import encodingStrategies.StrategiesFactory;
import encodingStrategies.encodingStrategy;

public class Document {

	private String author,title,filename;
	private Date creationDate,saveDate;
	private static ArrayList<Document>documents=new ArrayList<Document>();
	EditorView ev=new EditorView();
	//the following bool is true only if it's the first time user creates or opens a file 
	private static boolean first_time_save=true;
	
	//following vars are responsible for the audio tuning
	private static int volume=1,pitch=100,rate=150;
	private static float volume_=(float) 10.0;
	//default encoding method is Rot-13
	private static String encoding_method="Rot-13";
	
	private Text2SpeechAPIFactory apiFact=new Text2SpeechAPIFactory();
	private StrategiesFactory strat =new StrategiesFactory();
	
	public Document(String author,String title,String filename) {
		this.author=author;
		this.title=title;
		this.filename=filename;
		creationDate=new Date();
		saveDate=null;
	}
	
	//Default constructor
	public Document() {}
	
	
	public void  createNewEmptyDocument(Document doc) {
		documents.add(doc);
	   
	}
	
	public boolean editDocument(Document doc) {
		boolean editedDoc=false;
		try {
			//System.out.println(ev.getEditorText());
			File file=new File(doc.filename);
			FileWriter Fwriter=new FileWriter(file);
			Fwriter.write(ev.text_file_input.getText());
			Fwriter.close();
			editedDoc=true;
		} catch (Exception e) {
			System.out.println("Exception happened in edit");
			e.printStackTrace();
		}
		
		return editedDoc;
	}
	
	
	public boolean saveNewDocument(String newfilename) {
		boolean savedDoc=false;
		documents.get(0).filename=newfilename;
		//get the save date
		documents.get(0).saveDate=new Date();
		try {
			File file=new File(documents.get(0).filename);
			FileWriter Fwriter=new FileWriter(file,true);
			Fwriter.write(ev.getEditorText());
			Fwriter.close();
			savedDoc=true;
		    
		}catch (Exception e) {
			System.out.println("Exception happened in save");
			e.printStackTrace();

		}	
		return savedDoc;
		
	}
	public void saveExistedDocument() {
		//get the save date
		documents.get(0).saveDate=new Date();
		try {
			File file=new File(documents.get(0).filename);
			FileWriter Fwriter=new FileWriter(file);
			Fwriter.write(ev.getEditorText());
			Fwriter.close();
		}catch (Exception e) {
			System.out.println("Exception happened in save");
			e.printStackTrace();

		}	
	
	}
	
	
	public boolean openDocument(File openFile,Document doc) throws FileNotFoundException  {
		boolean openedFile=false;
		documents.clear();//clear the current list we want to process only one doc
		documents.add(doc);
		Scanner in =new Scanner(openFile);
		openedFile=true;
		StringBuilder sb=new StringBuilder();
		EditorView ev=new EditorView();
		while(in.hasNext()) {
			
			sb.append(in.nextLine()).append("\n");
			
		}
		//System.out.println(sb.toString());
		//we used a string builder to take the text from the file and 
		//we changed the content of the editor using this string builder
		ev.setTextArea(sb.toString());
		in.close();
		return openedFile;

	}
	//converts document to speech
	public boolean playContent(String content) {
		//in the following string we store the content of the document which
		//is currently open
		boolean speechCompleted=false;
		String docContent=content;//ev.getEditorText();
		Text2SpeechAPI apiInter=apiFact.createTTSAPI("");
		apiInter.setPitch(pitch);
		apiInter.setRate(rate);
		apiInter.setVolume(volume_);
		apiInter.play(docContent);
		
//		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
//	    Voice voice =VoiceManager.getInstance().getVoice("kevin16");
//	    if (voice != null && docContent!=null) {
//	             voice.allocate();//Allocating Voice
//	             voice.setRate(rate);
//	             voice.setPitch(pitch);
//	             voice.setVolume(volume_);
//	             voice.speak(docContent);
////	             System.out.println(voice.getRate()+" Rate");
////	             System.out.println(voice.getPitch()+" Pitch");
////	             System.out.println(voice.getVolume()+" Volume");
//	             voice.deallocate();
//	             speechCompleted=true;
//	    }
	    return speechCompleted;
	}
	//converts line to speech
	public boolean playLine(String content) {
		boolean speechCompleted=false;
		String lineContent=content;//ev.getEditorSelectedLine();
		Text2SpeechAPI apiInter=apiFact.createTTSAPI("");
		apiInter.setPitch(pitch);
		apiInter.setRate(rate);
		apiInter.setVolume(volume_);
		apiInter.play(lineContent);
//		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
//	    Voice voice =VoiceManager.getInstance().getVoice("kevin16");
//	    if (voice != null && lineContent!=null) {
//	             voice.allocate();//Allocating Voice
//	             voice.setRate(rate);
//	             voice.setPitch(pitch);
//	             voice.setVolume(volume_);
//	             voice.speak(lineContent);
//	             voice.deallocate();
//	             speechCompleted=true;
//	    }
//	    System.out.println(lineContent);
	    return speechCompleted;
	}
	
	//converts reverse content to speech
	public boolean playReversedContent(String content) {
		boolean speechCompleted=false;
		String normalContent=content;//ev.getEditorText();
		String reversedContent=createReverseContent(normalContent);
		Text2SpeechAPI apiInter=apiFact.createTTSAPI("");
		apiInter.setPitch(pitch);
		apiInter.setRate(rate);
		apiInter.setVolume(volume_);
		apiInter.play(reversedContent);
//		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
//	    Voice voice =VoiceManager.getInstance().getVoice("kevin16");
//	    if (voice != null) {
//	             voice.allocate();//Allocating Voice
//	             voice.setRate(rate);
//	             voice.setPitch(pitch);
//	             voice.setVolume(volume_);
//	             voice.speak(reversedContent);
//	             voice.deallocate();
//	             speechCompleted=true;
//	    }
	    return speechCompleted;
	}
	
	//converts reverse line to speech
	public boolean playReversedLine(String content) {
		boolean speechCompleted=false;
		String lineContent=content;//ev.getEditorSelectedLine();
		String reversedContent=null;
		if(lineContent!=null) {
			reversedContent=createReverseContent(lineContent);
		}
		Text2SpeechAPI apiInter=apiFact.createTTSAPI("");
		apiInter.setPitch(pitch);
		apiInter.setRate(rate);
		apiInter.setVolume(volume_);
		apiInter.play(reversedContent);
		
//		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
//	    Voice voice =VoiceManager.getInstance().getVoice("kevin16");
//	    if (voice != null && reversedContent!=null) {
//	             voice.allocate();//Allocating Voice
//	             voice.setRate(rate);
//	             voice.setPitch(pitch);
//	             voice.setVolume(volume_);
//	             voice.speak(reversedContent);
//	             voice.deallocate();
//	             speechCompleted=true;
//	    }
	    return speechCompleted;
	}
	
	public boolean playEncodedContent(String content) {
		boolean speechCompleted=false;
		String normalContent =content;//ev.getEditorText();
		String encodedContent;
//		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
//	    Voice voice =VoiceManager.getInstance().getVoice("kevin16");
	    
	    //create the encoded text
	    
	    encodingStrategy enc_strat=strat.createStrategy(encoding_method);
	    encodedContent=enc_strat.encode(normalContent);
	    Text2SpeechAPI apiInter=apiFact.createTTSAPI("");
		apiInter.setPitch(pitch);
		apiInter.setRate(rate);
		apiInter.setVolume(volume_);
		apiInter.play(encodedContent);
	    
//	    if (voice != null) {
//	             voice.allocate();//Allocating Voice
//	             voice.setRate(rate);
//	             voice.setPitch(pitch);
//	             voice.setVolume(volume_);
//	             voice.speak(encodedContent);
//	             voice.deallocate();
//	             speechCompleted=true;
//	    }
	    return speechCompleted;
		
	}
	public boolean playEncodedLine(String content) {
		boolean speechCompleted=false;
		String lineContent=content;//ev.getEditorSelectedLine();
		String encodedLineContent=null;
		encodingStrategy enc_strat=strat.createStrategy(encoding_method);
		if(lineContent!=null) {
			encodedLineContent=enc_strat.encode(lineContent);
		}
		Text2SpeechAPI apiInter=apiFact.createTTSAPI("");
		apiInter.setPitch(pitch);
		apiInter.setRate(rate);
		apiInter.setVolume(volume_);
		apiInter.play(encodedLineContent);
//		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
//	    Voice voice =VoiceManager.getInstance().getVoice("kevin16");
//	    if (voice != null && encodedLineContent!=null) {
//	             voice.allocate();//Allocating Voice
//	             voice.setRate(rate);
//	             voice.setPitch(pitch);
//	             voice.setVolume(volume_);
//	             voice.speak(encodedLineContent);
//	             voice.deallocate();
//	             speechCompleted=true;
//	    }
		return speechCompleted;
	}
	
	//creates the reverse text
	//we can use it for the lines too
	public String createReverseContent(String text) {
		StringBuilder sb=new StringBuilder();
		//replace all new lines ('\n') with spaces
		String replaceNewLines=text.replaceAll("[\\t\\n\\r]+"," ");
		//split the content using spaces
		String [] normalContentTokens= replaceNewLines.split(" ");
		int j=normalContentTokens.length;
		String [] reverseContentTokens=new String [j];
		for(int i=0;i<normalContentTokens.length;i++) {
			//System.out.println(normalContentTokens[i]);
			reverseContentTokens[j-1]=normalContentTokens[i];
			j--;
		}
		for(int k=0;k<reverseContentTokens.length;k++) {
			//System.out.println(reverseContentTokens[k]);
			sb.append(reverseContentTokens[k]).append(" ");
		}
		//System.out.println(sb.toString());
		return sb.toString();
	}
	
	public String CreateEncoding(String TextOrLine) {
		String cipher_text="";
		
		if(encoding_method.equals("Rot-13")) {
			cipher_text=rot13(TextOrLine);
			System.out.println(cipher_text);

		}
		else {
			cipher_text=atbash(TextOrLine);
			System.out.println(cipher_text);
		}
		return cipher_text;
		
	}
	
	public void tuneEncoding(encodingStrategy strat) {
		//strat.
	}
	
	public String atbash (String textToEncode) {
		String allchar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		textToEncode=textToEncode.replaceAll(" ", "");
		textToEncode=textToEncode.toUpperCase();
		
		String cipher="";
		int len=textToEncode.length();
		int alphabetLen=allchar.length();
		for(int i=0; i<len; i++)
        {
            char b=textToEncode.charAt(i);
            for(int j=0; j<alphabetLen; j++)
            {
                char c=allchar.charAt(j);
                if(c == b)
                {
                	int index=allchar.indexOf(c);
                	int position=(alphabetLen-1)-index;
                    cipher+= allchar.charAt(position);
                    break;
                      
                }          
            }
        }
		System.out.println("cipher:"+cipher);
		return cipher;
	}
	
    public  String rot13(String value) {

        char[] values = value.toCharArray();
        for (int i = 0; i < values.length; i++) {
            char letter = values[i];

            if (letter >= 'a' && letter <= 'z') {
                // Rotate lowercase letters.

                if (letter > 'm') {
                    letter -= 13;
                } else {
                    letter += 13;
                }
            } else if (letter >= 'A' && letter <= 'Z') {
                // Rotate uppercase letters.

                if (letter > 'M') {
                    letter -= 13;
                } else {
                    letter += 13;
                }
            }
            values[i] = letter;
        }
        // Convert array to a new String.
        return new String(values);
    }
	
	//clears the documents list
	public void emptyList() {
		documents.clear();
	}
	
	
	public void setVolume(int sliderVolumeValue) {
		//devide volume with 10 cause TTS volume  has values in range 0.0-1.0
		//volume=sliderVolumeValue;
		volume_=(float)sliderVolumeValue/10;
		System.out.println("Volume is f="+volume_);
	}
	public int getVolume() {
		float vol=volume_*10;
		System.out.println("Vol="+(int)vol);
		return (int)vol;
	}

	public void setRate(int sliderRateValue) {
		rate=sliderRateValue;
		System.out.println("Rate is ="+rate);
	}
	public int getRate() {
		return rate;
	}
	
	public void setPitch(int sliderPitchValue) {
		pitch=sliderPitchValue;
		System.out.println("Pitch is ="+pitch);
	}
	public int getPitch() {
		return pitch;
	}
	
	public void setEncodingMethod(String encodingMethod) {
		encoding_method=encodingMethod;
		System.out.println("Method="+encoding_method);
	}
	public String getEncodingMethod() {
		return encoding_method;
	}
	
	public void setFirstTimeSave(boolean res) {
		first_time_save=res;
	}
	
	public boolean getFirstTimeSave() {
		return first_time_save;
	}
	
	public void addToDocList(Document doc) {
		documents.add(doc);
	}
}
