package SankaSkepp;

public class Bitar {
	char text;
	public Bitar(char text) {
		this.text = text;
	}
	
	public char toChar() {
		return text;
	}
	
	public String toString() {
		String textToString = "";
		textToString = "" + text;
		return textToString;
	}	
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Bitar)) {
			return false;
		}
		Bitar objWord = (Bitar) obj;
		if(this.text == (objWord.text)) {
			return true;
		}
			return false;
	}	
}