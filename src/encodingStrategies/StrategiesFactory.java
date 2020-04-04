package encodingStrategies;

public class StrategiesFactory {
	public encodingStrategy createStrategy(String strat) {
		switch (strat) {
		case "Rot-13":
			
			return new Rot13();

		case "Atbash":
			return new Atbash();
			
		default:
			//use rot13 as the default encoding method
			return new Rot13();
		}
	}
}
