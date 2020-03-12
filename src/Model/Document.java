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

public class Document {

	private String author,title,filename;
	private Date creationDate,saveDate;
	private static ArrayList<Document>documents=new ArrayList<Document>();
	EditorView ev=new EditorView();
	//the following bool is true only if it's the first time user creates or opens a file 
	public static boolean first_time_save=true;
	
	
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
	    System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice voice =VoiceManager.getInstance().getVoice("kevin16");
        if (voice != null) {
               voice.allocate();//Allocating Voice
               voice.speak("Kosta sai gamao");
               voice.deallocate();
        }
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
			Fwriter.write(ev.text_file_input.getText());
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
			Fwriter.write(ev.text_file_input.getText());
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
		System.out.println(sb.toString());
		ev.setTextArea(sb.toString());
		in.close();

	}
	
	
	//clears the documents list
	public void emptyList() {
		documents.clear();
	}

	
}
