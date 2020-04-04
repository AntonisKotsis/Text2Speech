package encodingStrategies;

public class Atbash extends TemplateEncoding {

	@Override
	public String encode(String text) {

		
		text=text.replaceAll(" ", "");
		text=text.toUpperCase();
		
		String cipher="";
		int len=text.length();
		for(int i=0;i<len;i++) {
			char b=text.charAt(i);
			cipher+=mapCharacter(b);
		}
		
		
		return cipher;
	}

	@Override
	public char mapCharacter(char b) {
		String allchar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int alphabetLen=allchar.length();
		
		for(int j=0; j<alphabetLen; j++)
        {
            char c=allchar.charAt(j);
            if(c == b)
            {
            	int index=allchar.indexOf(c);
            	int position=(alphabetLen-1)-index;
                //cipher+= allchar.charAt(position);
                //break;
            	return allchar.charAt(position);
                  
            } 
            else if(b==' ') {
            	return ' ';
            }
        }
		return 'E';
	}

}
