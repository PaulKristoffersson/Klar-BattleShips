package SankaSkepp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Skepp{

	public String namn;
	public int storlek;
	List<Koordinater> båtKoordinater;

	public Skepp(int storlek, String namn, List<Koordinater> båtKoordinater2) {
		this.storlek = storlek;
		this.namn = namn;
		this.båtKoordinater = båtKoordinater2;
	}

	public List<Koordinater> getbåtKoordinater() {
		return båtKoordinater;
	}

	public void setbåtKoordinater(List<Koordinater> båtKoordinater) {
		this.båtKoordinater = båtKoordinater;
	}

	public int getStorlek() {
		return storlek;
	}

	public void setStorlek(int storlek) {
		this.storlek = storlek;
	}

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}

	public String toString() {
		if(this.båtKoordinater==null) {
			return ("Namn:" + this.namn + " Storlek: " + this.storlek + "\n");
		}
		else {
			return this.båtKoordinater.toString();
		}
	}


}