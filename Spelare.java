package SankaSkepp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Spelare {
	private int lengd = 0;
	private String namn = null;
	private int träffar = 0;
	private int liv = 0;
	private int totalLiv = 0;

	List<Koordinater> båtKoordinater;
	Skepp skepp = new Skepp(lengd, namn, båtKoordinater);
	List<Skepp> spelarSkepp = new ArrayList<Skepp>();
	LinkedList<Koordinater> träffadeKoordinater = new LinkedList<Koordinater>();
	private LinkedList<Skepp> skeppar = new LinkedList<Skepp>();
	private LinkedList<Skepp> skeppar2 = new LinkedList<Skepp>();
	Spelplan plan = new Spelplan();
	Scanner scan = new Scanner(System.in);
	LinkedHashMap<Koordinater, Bitar> map = new LinkedHashMap<Koordinater, Bitar>();
	LinkedHashMap<Koordinater, Bitar> map2 = new LinkedHashMap<Koordinater, Bitar>();

	public Spelare(int liv, String namn, int träffar, int totalLiv) {
		this.liv = liv;
		this.namn = namn;
		this.träffar = träffar;
		this.totalLiv = totalLiv;
	}

	public String skapaNamn(int x) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Döp spelare " + x);
		String namn = scan.nextLine();
		return namn;
	}

	public int spelareLiv() {
		int liv = 0;
		for (Skepp obj : skeppar) {
			liv = liv + obj.getStorlek();
		}
		return liv;
	}

	public int gettotalLiv() {
		return totalLiv;
	}

	public void settotalLiv(int totalLiv) {
		this.totalLiv = totalLiv;
	}

	public int getTräffar() {
		return träffar;
	}

	public void setTräffar(int träffar) {
		this.träffar = träffar;
	}

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}

	public int getLiv() {
		return liv;
	}

	public void setLiv(int liv) {
		this.liv = liv;
	}

	public void printSkepp() {
		for (Skepp obj : skeppar) {
			System.out.println(obj);
		}
	}

	public void addSkepp(Skepp c) {
		skeppar.add(c);

	}

	public void skapaSkepp() {
		System.out.println("Hur många skepp vill du spela med?");
		int antalskepp = scan.nextInt();
		try {

			if (antalskepp > 5) {
				System.out.println("Kan inte ha fler än 5 skepp - du får nöja dig med 5");
				antalskepp = 5;
			} else if (antalskepp < 0) {
				System.out.println("Kan inte ha negativt antal - du får ett");
				antalskepp = 1;
			}
		} catch (InputMismatchException error) {
			System.out.println("Ange giltig siffra");
		}

		for (int i = 0; i <= (antalskepp - 1); i++) {
			Skepp skepp = new Skepp(lengd, namn, båtKoordinater);
			System.out.println("Här skapar du fler skepp!");
			System.out.println("Här kan du skapa ett skepp. Vilken storlek vill du ha?");
			int storlek2 = scan.nextInt();
			while (storlek2 < 1 || storlek2 > 10) {
				System.out.println("Båten har ej en giltlig storlek, välj om den: ");
				storlek2 = scan.nextInt();
			}
			skepp.setStorlek(storlek2);
			scan.nextLine();
			System.out.println("Vad ska skeppet heta?");
			String namn2 = scan.nextLine();
			skepp.setNamn(namn2);
			addSkepp(skepp);
			printSkepp();
		}
	}

	public String toString() {
		if (this.båtKoordinater == null) {
			return ("Namn:" + this.namn + " Liv: " + this.liv + "\n");
		} else {
			return this.båtKoordinater.toString();
		}
	}

	public LinkedList<Skepp> kopieraSkepp() {
		return skeppar;
	}

	public void kopieraSkepp2(LinkedList<Skepp> skeppar) {
		for (Skepp obj : skeppar) {
			addSkepp(obj);
		}
		skeppar.clear();
	}

	public void printBoard() {
		System.out.println("  | 0 1 2 3 4 5 6 7 8 9");
		System.out.println("--+--------------------");
		char K = 'A';
		for (Koordinater nycklar : map.keySet()) {

			if (nycklar.toString().charAt(1) == '0') {
				System.out.print(K + " | ");
				K++;
			}

			System.out.print(map.get(nycklar) + " ");

			if (nycklar.toString().charAt(1) == '9') {
				System.out.println("");
			}

			System.out.print("");
		}
	}

	public Bitar lookup(Koordinater nyckel) {
		return map.get(nyckel);
	}

	public void newBoard() {
		int storlek = 10;
		char temp = 'A';
		String nycklar = "";
		for (int y = 0; y < storlek; y++) {
			for (int x = 0; x < storlek; x++) {
				nycklar = "" + temp + x;
				map.put(new Koordinater(nycklar), new Bitar('~'));
			}
			temp++;
		}
	}

	public void newEnemyBoard() {
		int storlek = 10;
		char temp = 'A';
		String nycklar = "";
		for (int y = 0; y < storlek; y++) {
			for (int x = 0; x < storlek; x++) {
				nycklar = "" + temp + x;
				map2.put(new Koordinater(nycklar), new Bitar('~'));
			}
			temp++;
		}
	}

	public void printEnemyBoard() {
		System.out.println("  | 0 1 2 3 4 5 6 7 8 9");
		System.out.println("--+--------------------");
		char K = 'A';
		for (Koordinater nycklar : map2.keySet()) {

			if (nycklar.toString().charAt(1) == '0') {
				System.out.print(K + " | ");
				K++;
			}

			System.out.print(map2.get(nycklar) + " ");

			if (nycklar.toString().charAt(1) == '9') {
				System.out.println("");
			}

			System.out.print("");
		}
	}

	public boolean riktning() {
		System.out.println("Ange h för horisontellt eller v för vertikalt: ");
		Scanner scan = new Scanner(System.in);
		String val = scan.nextLine();
		if (val.equals("h")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean riktning2() {
		System.out.println("Ange h för horisontellt eller v för vertikalt: ");
		Random f = new Random();
		int a = f.nextInt(2);

		if (a == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int markeraSkott(boolean c, boolean d, boolean e, Koordinater replaceCoords) {
		char hashtag = '#';
		char miss = '0';
		char träff = '1';
		int x = 0;
		Bitar boatpiece = new Bitar(hashtag);
		Bitar boatpiece2 = new Bitar(miss);
		Bitar boatpiece3 = new Bitar(träff);

		if (c == true) {
			System.out.println("Du träffade!");
			map.put(replaceCoords, boatpiece3);
			map2.put(replaceCoords, boatpiece3);
			x = 1;

		}

		if (d == true) {
			System.out.println("Du missade!");
			map.put(replaceCoords, boatpiece2);
			map2.put(replaceCoords, boatpiece2);
			x = 0;

		}

		if (e == true) {
			System.out.println("Du har redan skjutit här. Skjut igen");
			String koordinater = scan.nextLine();
			skjutSkepp(koordinater);
			x = 0;

		}
		return x;
	}

	public int markeraSkott2(boolean c, boolean d, boolean e, Koordinater replaceCoords) {

		char hashtag = '#';
		char miss = '0';
		char träff = '1';
		int x = 0;
		Bitar boatpiece = new Bitar(hashtag);
		Bitar boatpiece2 = new Bitar(miss);
		Bitar boatpiece3 = new Bitar(träff);

		if (c == true) {
			System.out.println("Du träffade!");
			map.put(replaceCoords, boatpiece3);
			map2.put(replaceCoords, boatpiece3);
			x = 1;

		}

		if (d == true) {
			System.out.println("Du missade!");
			map.put(replaceCoords, boatpiece2);
			map2.put(replaceCoords, boatpiece2);
			x = 0;

		}

		if (e == true) {
			System.out.println("Du har redan skjutit här. Skjut igen");
			skjutKoordinat2();
			x = 0;

		}

		// printEnemyBoard();
		return x;
	}

	public int skjutKoordinat() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ange vart du vill skjuta");
		String koordinat = scan.nextLine();
		int x = skjutSkepp(koordinat);
		return x;
	}

	public int skjutKoordinat2() {
		System.out.println("Ange vart du vill skjuta");
		Random r = new Random();
		char xko = (char) (r.nextInt(10) + 'A');
		Random f = new Random();
		int a = f.nextInt(10);
		String koordinat = xko + String.valueOf(a);
		System.out.println(koordinat);
		int x = skjutSkepp2(koordinat);
		return x;
	}

	public boolean slaktatSkepp(LinkedList<Koordinater> träffadeKoordinater) {
		boolean x = false;
		for (Skepp obj : skeppar2) {
			if (obj.toString().equals(träffadeKoordinater.toString())) {
				x = true;
				break;
			} else {
				x = false;
			}
		}
		return x;
	}

	public LinkedList<Koordinater> clearKoordinater(LinkedList<Koordinater> träffadeKoordinater) {
		träffadeKoordinater.clear();
		return träffadeKoordinater;
	}

	public void kollaSkepp(String kollaNyckel) {
		for (Skepp obj : skeppar2) {
			if (obj.toString().contains(kollaNyckel)) {
				träffadeKoordinater.add(new Koordinater(kollaNyckel));
				if (slaktatSkepp(träffadeKoordinater) == true) {
					System.out.println("Båt " + obj.getNamn() + " Är sänkt");
					clearKoordinater(träffadeKoordinater);
					// System.out.println(träffadeKoordinater+ "rensade Koordinater");
				}
			}
		}
	}

	public int skjutSkepp(String koordinater) {
		char yLed = koordinater.charAt(0);
		int xLed = koordinater.charAt(1) - 48;
		int x = 0;

		for (Koordinater nycklar : map.keySet()) {
			String kollaNyckel = "" + yLed + xLed;
			if (kollaNyckel.equals(nycklar.toString())) {
				Koordinater replaceCoords = new Koordinater(kollaNyckel);

				if (lookup(nycklar).toString().contains("#")) {
					boolean c = true;
					boolean d = false;
					boolean e = false;
					x = markeraSkott(c, d, e, replaceCoords);

					kollaSkepp(kollaNyckel);

				} else if (lookup(nycklar).toString().contains("~")) {
					boolean c = false;
					boolean d = true;
					boolean e = false;
					markeraSkott(c, d, e, replaceCoords);
					x = 0;
				} else {
					boolean c = false;
					boolean d = false;
					boolean e = true;
					markeraSkott(c, d, e, replaceCoords);
					x = 0;
				}
			}
		}
		return x;
	}

	public int skjutSkepp2(String koordinater) {
		char yLed = koordinater.charAt(0);
		int xLed = koordinater.charAt(1) - 48;
		int x = 0;
		for (Koordinater nycklar : map.keySet()) {
			String kollaNyckel = "" + yLed + xLed;
			// System.out.println(kollaNyckel);
			if (kollaNyckel.equals(nycklar.toString())) {
				Koordinater replaceCoords = new Koordinater(kollaNyckel);

				if (lookup(nycklar).toString().contains("#")) {
					boolean c = true;
					boolean d = false;
					boolean e = false;
					x = markeraSkott2(c, d, e, replaceCoords);

					kollaSkepp(kollaNyckel);

				} else if (lookup(nycklar).toString().contains("~")) {
					// map.put(replaceCoords, boatpiece2);
					boolean c = false;
					boolean d = true;
					boolean e = false;
					markeraSkott2(c, d, e, replaceCoords);
					x = 0;
				} else {
					boolean c = false;
					boolean d = false;
					boolean e = true;
					markeraSkott2(c, d, e, replaceCoords);
					x = 0;
				}
			}
		}
		return x;

		// printBoard();

	}

	public void printKoordinater() {
		for (Koordinater obj : båtKoordinater) {
			System.out.println(obj);
		}
	}

	public boolean kollaBoard(String koordinater, boolean val, int storlek) {

		char yLed = koordinater.charAt(0);
		char yBak = (char) (koordinater.charAt(0) - 1);
		char xLed = koordinater.charAt(1);
		char xBak = (char) (koordinater.charAt(1) - 1);

		if (koordinater.toString().charAt(0) == 'A') {
			yBak = 'A';
		}

		if (koordinater.toString().charAt(1) == '0') {
			xBak = '0';
		}

		if (val == true) {
			if (xLed + storlek - 48 > 10) {
				System.out.println("Båten är för stor");
				return false;
			}
			for (Koordinater nycklar : map.keySet()) {
				String kollaYled = "" + yBak + xBak;
				if (kollaYled.equals(nycklar.toString())) {
					if (lookup(nycklar).toString().contains("#")) {
						System.out.println("Du har närliggande båtar. Båtarna måste ha minst 1 ruta emellan varandra");
						return false;
					}
					xBak++;
					if (xBak == storlek + 1 + xLed) {
						yBak++;
						for (int i = 0; i < storlek; i++) {
							xBak--;
						}
					}
				}
			}
		}

		else {
			if (storlek + yLed - 65 > 10) {
				System.out.println("Please place the boats on the board");
				return false;
			}
			for (Koordinater nycklar : map.keySet()) {
				String kollaXled = "" + yBak + xBak;

				if (kollaXled.equals(nycklar.toString())) {
					if (lookup(nycklar).toString().contains("#")) {
						System.out.println("Please place the boat further away from the other boats");
						return false;
					}

					xBak++;

					if (xBak == (char) (xLed + 2)) {
						yBak++;
						for (int i = 0; i < 3; i++) {
							if (xBak == '0') {
								break;
							}
							xBak--;
						}
					}

				}

				if (yBak == (char) (yLed + storlek + 1)) {
					break;
				}
			}

		}

		return true;

	}

	public void addBoat(String koordinater, boolean riktning, int storlek, Skepp obj, String namn) {
		List<Koordinater> båtKoordinater = new ArrayList<Koordinater>();
		char yLed = koordinater.charAt(0);
		int xLed = koordinater.charAt(1);
		char hashtag = '#';
		Bitar boatPiece = new Bitar(hashtag);

		if (riktning == true) {
			int boatLength = storlek + xLed;
			for (Koordinater nycklar : map.keySet()) {

				if (xLed == boatLength) {
					break;
				}
				String kollaNycklar = nycklar.toString();

				if ((kollaNycklar.charAt(0) == yLed) && (nycklar.toString().charAt(1) == xLed)) {
					Koordinater replaceCoords = new Koordinater(kollaNycklar);
					map.put(replaceCoords, boatPiece);
					båtKoordinater.add(new Koordinater(kollaNycklar));
					xLed++;
				}

				kollaNycklar = "";
			}

		} else {
			int lengthCounter = 0;

			for (Koordinater nycklar : map.keySet()) {

				if (storlek == lengthCounter) {
					break;
				}

				String kollaNycklar = nycklar.toString();

				if ((kollaNycklar.charAt(0) == yLed) && (nycklar.toString().charAt(1) == xLed)) {
					Koordinater replaceCoords = new Koordinater(kollaNycklar);
					map.put(replaceCoords, boatPiece);
					båtKoordinater.add(new Koordinater(kollaNycklar));
					// skeppKoordinater.add(new Koordinater(kollaNycklar));
					yLed++;
					lengthCounter++;
				}

				kollaNycklar = "";
			}

		}
		skeppar2.add(new Skepp(storlek, namn, båtKoordinater));
		System.out.println(skeppar2);

	}

	public void placeraSkepp() {
		printBoard();
		Scanner scan = new Scanner(System.in);
		for (Skepp obj : skeppar) {
			System.out.println("Vart vill du placera " + obj.getNamn() + "?");
			String koordinat = scan.nextLine();
			boolean riktning = riktning();
			while (kollaBoard(koordinat, riktning, obj.getStorlek()) != true) {
				System.out.println("Placera om " + obj.getNamn());
				koordinat = scan.nextLine();
				riktning = riktning();

			}
			addBoat(koordinat, riktning, obj.getStorlek(), obj, obj.getNamn());
			printBoard();

		}
	}

	public void placeraSkepp2() {
		printBoard();

		for (Skepp obj : skeppar) {
			System.out.println("Vart vill du placera " + obj.getNamn() + "?");
			Random r = new Random();
			char xko = (char) (r.nextInt(10) + 'A');

			Random f = new Random();
			int a = f.nextInt(10);

			String koordinat = xko + String.valueOf(a);
			System.out.println(koordinat);
			boolean riktning = riktning2();
			while (kollaBoard(koordinat, riktning, obj.getStorlek()) != true) {
				Random r1 = new Random();
				char xko1 = (char) (r1.nextInt(10) + 'A');

				Random f1 = new Random();
				int a1 = f1.nextInt(10);
				koordinat = xko1 + String.valueOf(a1);
				riktning = riktning2();

			}
			addBoat(koordinat, riktning, obj.getStorlek(), obj, obj.getNamn());
			printBoard();

		}
	}
}