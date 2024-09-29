package Enum_Classes;

public enum Difficultylevel {

	easy,moderate,hard; 
	
	public Difficultylevel getDifficulty(String n) {
		n=n.trim();
		if(easy.name().equalsIgnoreCase(n)) {
			return easy;
		}else if(moderate.name().equalsIgnoreCase(n)) {
			return moderate;
		}else if(hard.name().equalsIgnoreCase(n)) {
			return hard;
		}else {
			return null;
		}
	}
}
