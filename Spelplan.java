package SankaSkepp;

import java.lang.reflect.Array;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Spelplan {
	private int lengd = 0;
	Scanner scan = new Scanner(System.in);
	private String namn = null;
	//Skepp skepp = new Skepp(lengd, namn, skeppKoordinater);
	
	LinkedHashMap<Koordinater, Bitar> map = new LinkedHashMap<Koordinater, Bitar>(); 
	final int storlek = 10;
	public Bitar lookup(Koordinater nyckel) {
		return map.get(nyckel);
	}
	
	/*public void skapaSkepp(){
		
		System.out.println("Här skapar du fler skepp!");
		System.out.println("Här kan du skapa ett skepp. Vilken storlek vill du ha?");
		int storlek2 = scan.nextInt();
		skepp.setStorlek(storlek2);
		scan.nextLine();
		System.out.println("Vad ska skeppet heta?");
		String namn2 = scan.nextLine();
		skepp.setNamn(namn2);
		Skepp.addSkepp(skepp);
		Skepp.printSkepp();
	}*/
	
	public void printBoard() {
		
		System.out.println("  | 0 1 2 3 4 5 6 7 8 9");
		System.out.println("--+--------------------");
		
		char K = 'A';
		
		for (Koordinater nycklar : map.keySet()) {
			
			if(nycklar.toString().charAt(1)=='0') {
				System.out.print(K+" | ");
				K++;
			}
			
			System.out.print(map.get(nycklar)+" ");
			
			if(nycklar.toString().charAt(1) == '9') {
				System.out.println("");
			}
			
			System.out.print("");
		}
	}

	public void newBoard() {
		int storlek = 10;
		char temp = 'A';
		String nycklar = "";
		for (int y = 0; y < storlek; y++) {
			for (int x = 0; x < storlek; x++) {
				nycklar = "" + temp +x;
				map.put(new Koordinater(nycklar), new Bitar('~'));
			}
		temp++;
		}
		printBoard();
	}
	
	public void kollaBoard(){
		
	}
	
	public boolean riktning() {
		System.out.println("Ange h för horisontellt eller v för vertikalt: ");
		Scanner scan = new Scanner(System.in);
		String val = scan.nextLine();
		if (val =="h") {
			return true;
		}		
		return false;		
	}

}