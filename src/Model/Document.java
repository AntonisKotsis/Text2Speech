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
	
	public void editDocument(Document doc) {
		try {
			//System.out.println(ev.getEditorText());
			File file=new File(doc.filename);
			FileWriter Fwriter=new FileWriter(file);
			Fwriter.write(ev.text_file_input.getText());
			Fwriter.close();
		} catch (Exception e) {
			System.out.println("Exception happened in edit");
			e.printStackTrace();
		}
		
	}
	
	
	public void saveNewDocument(String newfilename) {
		documents.get(0).filename=newfilename;
		//get the save date
		documents.get(0).saveDate=new Date();
		try {
			File file=new File(documents.get(0).filename);
			FileWriter Fwriter=new FileWriter(file,true);
			Fwriter.write(ev.getEditorText());
			Fwriter.close();
		    
		}catch (Exception e) {
			System.out.println("Exception happened in save");
			e.printStackTrace();

		}	
		
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
	
	
	public void openDocument(File openFile,Document doc) throws FileNotFoundException  {
		documents.clear();//clear the current list we want to process only one doc
		documents.add(doc);
		Scanner in =new Scanner(openFile);
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

	}
	//converts document to speech
	public void playContent(String content,String TTSApi) {
		//in the following string we store the content of the document which
		//is currently open
		String docContent=content;//ev.getEditorText();
		Text2SpeechAPI apiInter=apiFact.createTTSAPI(TTSApi);
		apiInter.play(docContent);

	}
	//converts line to speech
	public void playLine(String content,String TTSApi) {
		String lineContent=content;//ev.getEditorSelectedLine();
		Text2SpeechAPI apiInter=apiFact.createTTSAPI(TTSApi);
		apiInter.play(lineContent);

	}
	
	//converts reverse content to speech
	public void playReversedContent(String content,String TTSApi) {
		String normalContent=content;//ev.getEditorText();
		String reversedContent=createReverseContent(normalContent);
		Text2SpeechAPI apiInter=apiFact.createTTSAPI(TTSApi);
		apiInter.play(reversedContent);

	}
	
	//converts reverse line to speech
	public void playReversedLine(String content,String TTSApi) {
		String lineContent=content;
		String reversedContent=null;
		if(lineContent!=null) {
			reversedContent=createReverseContent(lineContent);
		}
		Text2SpeechAPI apiInter=apiFact.createTTSAPI(TTSApi);
		apiInter.play(reversedContent);

	}
	
	public void playEncodedContent(String content,String TTSApi) {
		String normalContent =content;//ev.getEditorText();
		String encodedContent;
	    //create the encoded text 
	    encodingStrategy enc_strat=strat.createStrategy(encoding_method);
	    encodedContent=enc_strat.encode(normalContent);
	    Text2SpeechAPI apiInter=apiFact.createTTSAPI(TTSApi);
		apiInter.play(encodedContent);

		
	}
	public void playEncodedLine(String content,String TTSApi) {
		String lineContent=content;//ev.getEditorSelectedLine();
		String encodedLineContent=null;
		encodingStrategy enc_strat=strat.createStrategy(encoding_method);
		if(lineContent!=null) {
			encodedLineContent=enc_strat.encode(lineContent);
		}
		Text2SpeechAPI apiInter=apiFact.createTTSAPI(TTSApi);
		apiInter.play(encodedLineContent);

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
	

	
	public void tuneEncoding(encodingStrategy strat) {
		//strat.
	}
	

	
   
	
	//clears the documents list
	public void emptyList() {
		documents.clear();
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
