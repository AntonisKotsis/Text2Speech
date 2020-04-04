package encodingStrategies;

public class Rot13 extends TemplateEncoding {

	@Override
	public String encode(String text) {
		  char[] values = text.toCharArray();
	        for (int i = 0; i < values.length; i++) {
	            char letter = values[i];
	            values[i]= mapCharacter(letter);
	            
	        }
		return new String (values);
	}

	@Override
	public char mapCharacter(char c) {
		if (c >= 'a' && c <= 'z') {
            // Rotate lowercase letters.

            if (c > 'm') {
                c -= 13;
            } else {
                c += 13;
            }
        } else if (c >= 'A' && c <= 'Z') {
            // Rotate uppercase letters.

            if (c > 'M') {
                c -= 13;
            } else {
                c += 13;
            }
        }
		return c;
        
	}

}
