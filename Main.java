package SankaSkepp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Spel spel = new Spel();

		int result = 0;
		while (!(result == -1)) {
			printMenu();
			try {
				@SuppressWarnings("resource")
				Scanner scan = new Scanner(System.in);
				int val = scan.nextInt();
				switch (val) {

				case 1:
					System.out.println("Highscore");
					System.out.println("Plats:Antal rundor:Namn:MaxLiv");

					ArrayList<Highscore> highscore = new ArrayList<Highscore>();
					try {
						BufferedReader br = new BufferedReader(new FileReader("highscore.txt"));
						String line = br.readLine();

						while (line != null) {
							String[] score = line.split(";");
							highscore.add(
									new Highscore(score[0], Integer.parseInt(score[1]), Integer.parseInt(score[2])));
							line = br.readLine();
						}
						br.close();
						Collections.sort(highscore);
						int i = 1;
						for (Highscore rad : highscore) {

							System.out.println(i + ": " + rad.runda() + ";" + rad.winner() + ";" + rad.maxLiv());
							i++;
						}

					} catch (IOException e) {
						System.out.println("Hittade ingen highscore.txt");
					}

					break;
				case 2:
					PrintWriter pw = null;
					try {
						pw = new PrintWriter("highscore.txt");
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					pw.close();
					break;

				case 3:
					spel.startaSpel();

					break;
				case 0:
					System.exit(0);
					break;

				default:
					System.out.println("Ange rätt siffra!");
				}
			} catch (InputMismatchException e) {
				System.out.println("Ange siffra!");
			}
			// TODO Auto-generated method stub

		}
	}

	private static void printMenu() {

		System.out.println();
		System.out.println("Välkommen till Sänka Skepp!");
		System.out.println("===========================");
		System.out.println("Skapad av Martin och Paul");
		System.out.println("===========================");
		System.out.println("Meny:");
		System.out.println("1. Se highscore");
		System.out.println("2. Rensa highscore");
		System.out.println("3. Starta spelet!");
		System.out.println("0. Avsluta");

	}

}