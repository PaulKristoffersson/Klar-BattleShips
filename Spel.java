package SankaSkepp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Spel {
	public ArrayList<String> highscore = new ArrayList<String>();
	public LinkedList<Spelare> spelarLista = new LinkedList<Spelare>();
	public LinkedList<Skepp> skeppar = new LinkedList<Skepp>();
	public LinkedList<Skepp> skeppar2 = new LinkedList<Skepp>();
	Scanner scan = new Scanner(System.in);

	public void startaSpel() {

		System.out.println("Hur många spelare vill du ha?");
		int antalSpelare = scan.nextInt();
		if (antalSpelare == 0) {
			spelaSpelEvE(antalSpelare);
		}
		if (antalSpelare == 1) {
			spelaSpelPvE(antalSpelare);
		}
		if (antalSpelare > 1) {
			spelaSpel(antalSpelare);
		}

	}

	public void spelaSpel(int antalSpelare) {
		System.out.println(antalSpelare);
		nySpelare(antalSpelare);
		System.out.println(spelarLista.size());
		int runda = 1;
		boolean c = false;

		int i = 0;
		int skepp2 = 1;
		while (c == false) {
			for (i = 0; i < antalSpelare; i++) {
				if (i == antalSpelare) {
					i = 0;
				}
				if (skepp2 == (antalSpelare)) {
					skepp2 = 0;
				}
				int x = 0;

				System.out.println("Det är " + spelarLista.get(i).getNamn() + " tur att skjuta");
				System.out.println("\n");
				System.out.println(spelarLista.get(i).getNamn() + "s bräde! ");
				System.out.println("\n");

				spelarLista.get(i).printBoard();
				spelarLista.get(skepp2).printEnemyBoard();
				x = spelarLista.get(skepp2).skjutKoordinat();
				while(x==1) {
					spelarLista.get(i).setTräffar(spelarLista.get(i).getTräffar() + x);
					spelarLista.get(skepp2).setLiv(spelarLista.get(skepp2).getLiv() - x);
					System.out.println(spelarLista.get(skepp2).getLiv());
					x=0;
					x=spelarLista.get(skepp2).skjutKoordinat();
				}
				System.out.println("\n");
				statistik(runda, i, skepp2);
				System.out.println("\n");
				if (fleraSpelare(spelarLista.get(skepp2)) == true) {
					spelarLista.remove(skepp2);
					antalSpelare--;
					break;
				}

				skepp2 = skepp2 + 1;
				continue;
			}

			if (antalSpelare == 1) {
				System.out.println(spelarLista.get(0).getNamn() + " Är vår vinnare!!!!!!!!");

				break;
			}

			System.out.println("Runda " + runda + " avklarad. Här är listan av kvarvarande spelar och deras liv: ");
			System.out.println("\n");
			runda++;
			System.out.println(spelarLista);
			i = 0;
			skepp2 = 1;

		}
		spelarLista.clear();

	}

	public boolean fleraSpelare(Spelare obj) {

		if (obj.getLiv() == 0) {
			System.out.println(obj.getNamn() + " är död!");
			System.out.println("\n");
			return true;
		} else {
			return false;
		}
	}

	public void spelaSpelPvE(int antalSpelare) {
		nySpelare(antalSpelare);
		int botAntal = nyBot(antalSpelare);
		antalSpelare = antalSpelare + botAntal;
		boolean c = false;
		int i = 0;
		int runda = 0;
		int skepp2 = 1;
		while (c == false) {
			for (i = 0; i < antalSpelare; i++) {
				int x = 0;

				if (i == antalSpelare) {
					i = 0;
				}
				if (skepp2 == (antalSpelare)) {
					skepp2 = 0;
				}
				if (i == 0) {
					System.out.println("Det är " + spelarLista.get(i).getNamn() + " tur att skjuta");
					System.out.println(spelarLista.get(i).getNamn() + "s bräde! ");

					spelarLista.get(i).printBoard();
					spelarLista.get(skepp2).printEnemyBoard();
					x = spelarLista.get(skepp2).skjutKoordinat();
					while(x==1) {
						spelarLista.get(i).setTräffar(spelarLista.get(i).getTräffar() + x);
						spelarLista.get(skepp2).setLiv(spelarLista.get(skepp2).getLiv() - x);
						System.out.println(spelarLista.get(skepp2).getLiv());
						x=0;
						x=spelarLista.get(skepp2).skjutKoordinat();
					}
					System.out.println("\n");
				}

				if (i == 1) {
					System.out.println("Det är " + spelarLista.get(i).getNamn() + " tur att skjuta");
					System.out.println(spelarLista.get(i).getNamn() + "s bräde! ");

					spelarLista.get(i).printBoard();
					spelarLista.get(skepp2).printEnemyBoard();
					x = spelarLista.get(skepp2).skjutKoordinat2();
					while(x==1) {
						spelarLista.get(i).setTräffar(spelarLista.get(i).getTräffar() + x);
						spelarLista.get(skepp2).setLiv(spelarLista.get(skepp2).getLiv() - x);
						System.out.println(spelarLista.get(skepp2).getLiv());
						x=0;
						x=spelarLista.get(skepp2).skjutKoordinat2();
					}
					System.out.println("\n");
				}
				statistik(runda, i, skepp2);

				if (fleraSpelare(spelarLista.get(skepp2)) == true) {
					spelarLista.remove(skepp2);
					antalSpelare--;
					break;
				}

				skepp2 = skepp2 + 1;
				continue;
			}

			if (antalSpelare == 1) {
				System.out.println(spelarLista.get(0).getNamn() + " Är vår vinnare!!!!!!!!");
				checkHighscore(spelarLista.get(0).getNamn(), runda, spelarLista.get(0).gettotalLiv());
				break;
			}
			System.out.println("Runda " + runda + " avklarad. Här är listan av kvarvarande spelar och deras liv: ");
			System.out.println(spelarLista);
			runda++;
			i = 0;
			skepp2 = 1;

		}
		spelarLista.clear();
	}

	public void spelaSpelEvE(int antalSpelare) {
		int botAntal = nyBot(antalSpelare);
		int botAntal2 = nyBot(antalSpelare+1);
		botAntal = botAntal + botAntal2;
		antalSpelare = botAntal;
		boolean c = false;
		int i = 0;
		int skepp2 = 1;
		int runda = 0;
		int maxRunda = 100;
		while ((c == false) && (runda < maxRunda)) {
			for (i = 0; i < antalSpelare; i++) {
				int x = 0;

				if (i == antalSpelare) {
					i = 0;
				}
				if (skepp2 == (antalSpelare)) {
					skepp2 = 0;
				}

				System.out.println("Det är " + spelarLista.get(i).getNamn() + " tur att skjuta");
				System.out.println(spelarLista.get(i).getNamn() + "s bräde! ");

				spelarLista.get(i).printBoard();
				spelarLista.get(skepp2).printEnemyBoard();
				x = spelarLista.get(skepp2).skjutKoordinat2();
				while(x==1) {
					spelarLista.get(i).setTräffar(spelarLista.get(i).getTräffar() + x);
					spelarLista.get(skepp2).setLiv(spelarLista.get(skepp2).getLiv() - x);
					System.out.println(spelarLista.get(skepp2).getLiv());
					x=0;
					x=spelarLista.get(skepp2).skjutKoordinat2();
				}
				spelarLista.get(skepp2).setLiv(spelarLista.get(skepp2).getLiv() - x);

				statistik(runda, i, skepp2);
				System.out.println("\n");
				if (fleraSpelare(spelarLista.get(skepp2)) == true) {
					spelarLista.remove(skepp2);
					antalSpelare--;
					break;
				}

				skepp2 = skepp2 + 1;
				continue;
			}

			if (antalSpelare == 1) {
				System.out.println(
						spelarLista.get(0).getNamn() + " Är vår vinnare!!!!!!!! Det tog " + runda + " rundor!");
				checkHighscore(spelarLista.get(0).getNamn(), runda, spelarLista.get(0).gettotalLiv());
				break;
			} else if (runda == 100) {
				if (spelarLista.get(0).getTräffar() > spelarLista.get(1).getTräffar()) {
					System.out.println("Spelare " + spelarLista.get(0) + " Vann!");
					checkHighscore(spelarLista.get(0).getNamn(), runda, spelarLista.get(0).gettotalLiv());

				} else {
					System.out.println("Spelare " + spelarLista.get(1) + " Vann!");
					checkHighscore(spelarLista.get(1).getNamn(), runda, spelarLista.get(0).gettotalLiv());
					break;
				}
			}

			System.out.println("Runda " + runda + " avklarad. Här är listan av kvarvarande spelar och deras liv: ");
			System.out.println(spelarLista);
			runda++;

			i = 0;
			skepp2 = 1;

		}
		spelarLista.clear();

	}

	private void checkHighscore(String winner, int runda, int maxliv) {
		ArrayList<Highscore> currentHighscore = readhighscore();
		if (currentHighscore.isEmpty() || currentHighscore.size() < 11) {
			currentHighscore.add(new Highscore(winner, runda, maxliv));
			Collections.sort(currentHighscore);
			printToHighscore(currentHighscore);
		} else {
			int worstHighscore = currentHighscore.get(currentHighscore.size() - 1).runda();
			if (runda <= worstHighscore) {
				currentHighscore.add(new Highscore(winner, runda, maxliv));
				Collections.sort(currentHighscore);
				printToHighscore(currentHighscore);
			}
		}
	}

	private void printToHighscore(ArrayList<Highscore> highscore) {
		try {
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("highscore.txt", false)));
			int i = 0;
			for (Highscore entry : highscore) {
				// Fugly way of breaking the highscore-writing after 10 entries
				if (i == 10) {
					break;
				}
				writer.append(entry.winner() + ";" + entry.runda() + ";" + entry.maxLiv() + "\n");
				i++;

			}
			writer.close();
		} catch (IOException e) {
			System.out.println("highscore.txt hittades inte. Skapar filen.");
		}
	}

	public ArrayList<Highscore> readhighscore() {
		ArrayList<Highscore> highscore = new ArrayList<Highscore>();
		System.out.println(highscore);
		try {
			BufferedReader br = new BufferedReader(new FileReader("highscore.txt"));
			String line = br.readLine();

			while (line != null) {
				String[] score = line.split(";");
				highscore.add(new Highscore(score[0], Integer.parseInt(score[1]), Integer.parseInt(score[2])));
				line = br.readLine();
			}

			br.close();
			Collections.sort(highscore);

		} catch (IOException e) {
			System.out.println("Hittade inte highscore.txt");
		}

		return highscore;
	}

	public int nyBot(int spelarAntal) {
		String c = Integer.toString(spelarAntal);
		String namn = ("COM" + c);
		int liv = 0;
		int träffar = 0;
		int totalLiv = 0;
		Spelare spelare = new Spelare(liv, namn, träffar, totalLiv);
		spelare.newBoard();
		spelare.newEnemyBoard();
		if (spelarLista.isEmpty()) {
			spelare.skapaSkepp();
		} else {
			for (Spelare obj : spelarLista) {
				spelare.kopieraSkepp2(obj.kopieraSkepp());
			}
		}

		spelarLista.add(spelare);
		spelare.setLiv(spelare.spelareLiv());
		spelare.settotalLiv(spelare.getLiv());
		spelare.placeraSkepp2();
		System.out.println("\n");System.out.println("\n");		System.out.println("\n");System.out.println("\n");		System.out.println("\n");System.out.println("\n");		System.out.println("\n");System.out.println("\n");		System.out.println("\n");System.out.println("\n");
		System.out.println("\n");System.out.println("\n");		System.out.println("\n");System.out.println("\n");		System.out.println("\n");System.out.println("\n");		System.out.println("\n");System.out.println("\n");
		return 1;

	}

	public void nySpelare(int spelarNummer) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		for (int i = 1; i <= spelarNummer; i++) {
			System.out.println("Välj namn spelare " + i + "!");
			String namn = scan.nextLine();
			int liv = 0;
			int träffar = 0;
			int totalLiv = 0;
			Spelare spelare = new Spelare(liv, namn, träffar, totalLiv);
			spelare.newBoard();
			spelare.newEnemyBoard();
			if (spelarLista.isEmpty()) {
				spelare.skapaSkepp();
			} else {
				for (Spelare obj : spelarLista) {
					spelare.kopieraSkepp2(obj.kopieraSkepp());
				}
			}
			spelarLista.add(spelare);
			spelare.setLiv(spelare.spelareLiv());
			spelare.settotalLiv(spelare.getLiv());
			System.out.println(
					"Vill du placera båtarna själv? Skriv Ja för att göra det själv och Nej för att automatisera det");
			String svar = scan.nextLine();
			if (svar.contentEquals("Ja") || svar.contentEquals("ja")) {
				spelare.placeraSkepp();
			} else {
				spelare.placeraSkepp2();
			}
			System.out.println("\n");System.out.println("\n");		System.out.println("\n");System.out.println("\n");		System.out.println("\n");System.out.println("\n");		System.out.println("\n");System.out.println("\n");		System.out.println("\n");System.out.println("\n");
			System.out.println("\n");System.out.println("\n");		System.out.println("\n");System.out.println("\n");		System.out.println("\n");System.out.println("\n");		System.out.println("\n");System.out.println("\n");
		}

	}

	private void statistik(int runda, int i, int skepp2) {
		System.out.println();
		// player1
		System.out.println();
		System.out.println(spelarLista.get(i).getNamn());
		System.out.println("Träffprocent: " + (float) spelarLista.get(i).getTräffar() * 100 / runda);
		// System.out.println("Träffprocent: " + (float)
		// (spelarLista.get(skepp2).spelareLiv() - spelarLista.get(skepp2).getLiv()) *
		// 100 / runda);
		System.out.println(
				"Skadeprocent: " + (float) spelarLista.get(i).getLiv() * 100 / spelarLista.get(i).gettotalLiv());

	}
}