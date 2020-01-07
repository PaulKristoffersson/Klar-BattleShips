package SankaSkepp;

public class Koordinater {
	String text;

	public Koordinater(String text) {
		this.text = text;
	}

	public String toString() {
		return text;
	}
	public int hashCode() {
		return text.hashCode();
	}
	public boolean equals(Object obj) {
		boolean x = false;
		if (!(obj instanceof Koordinater)) {
			return false;
		}
		Koordinater objWord = (Koordinater) obj;
		if (this.text.equals(objWord.text)) {
			return true;
		}
		return x;
	}
	
	/*public boolean contains(Object obj) {
		boolean x = false;
		if(!(obj instanceof Koordinater)) {
			x =  false;
		}
		Koordinater objWord = (Koordinater) obj;
		if(this.text.contains(objWord.text)) {
			x =  true;
		}
		return x;
	}*/

}