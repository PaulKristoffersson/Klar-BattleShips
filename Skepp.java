package SankaSkepp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Skepp{
	/*
	 * private String [] batett; private String [] battva; private String [] battre;
	 * private String [] batfour; private String [] batfem;
	 */
	public String namn;
	public int storlek;
	List<Koordinater> båtKoordinater;
	LinkedList<Skepp> skeppar = new LinkedList<Skepp>();
	LinkedList<Skepp> skeppar2 = new LinkedList<Skepp>();
	//LinkedList<Koordinater> skeppKoordinater = new LinkedList<Koordinater>();
	//LinkedList<Koordinater> båtKoordinater = new LinkedList<Koordinater>();

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

/**
 * public static void addSkepp(Skepp c) {
		skeppar.add(c);
	}
 * @param c
 */
	

/**
 * public static void printSkepp() {
		for (Skepp obj : skeppar) {
			System.out.println(obj);
		}
	}
 */
	
	

/**
 * public String toString() {
		return ("Namn:" + this.namn + " Storlek: " + this.storlek + "\n");
	}
 */
	
	public String toString() {
		if(this.båtKoordinater==null) {
			return ("Namn:" + this.namn + " Storlek: " + this.storlek + "\n");
		}
		else {
			return this.båtKoordinater.toString();
		}
	}

	/**
	 * public void placeraSkepp(Skepp c, boolean val) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nu ska du placera dina skepp. Välj koordinater a-j och sedan position 0-9! ");
		for(Skepp obj : skeppar) {
			System.out.println("Vart vill du placera " + getNamn() + "?");
			String koordinat = scan.nextLine();
			if (val = true) {
			//	kollaBoard(koordinat);
				char yLed = koordinat.charAt(0);
				//char yBak = yLed-1;
				char xLed = koordinat.charAt(1);
				
			}
			
		}
	}
	 * @param c
	 * @param val
	 */
	
	/**
	 * public boolean kollaBoard(String koordinater, boolean val) {
		char yLed = koordinater.charAt(0);
		char yBak = (char) (koordinater.charAt(0)-1);
		char xLed = koordinater.charAt(1);
		char xBak = (char) (koordinater.charAt(1)-1);
		
		if (val = true) {
			if (xLed + getStorlek()>10) {
				System.out.println("Båten är för stor");
				return false;
			}
		//	for (Koordinater nycklar : map.keySet()) {
						
		//	}
		}
		else {
		
		}
		return true;
		
	}
	 * @param koordinater
	 * @param val
	 * @return
	 */
	
	

	


}