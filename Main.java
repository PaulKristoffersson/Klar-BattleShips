package SankaSkepp;

import java.util.*;

import java.io.*;

public class Main {
	static ArrayList<String> highscore = new ArrayList<String>();
	public static void main(String[] args) {
		Spel spel = new Spel();
		int result = 0;
		while (!(result == -1)) {
			printMenu();
			try {
				Scanner scan = new Scanner(System.in);
				int val = scan.nextInt();
				switch (val) {
				case 1: 
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
		System.out.println("1. Starta spelet");
		System.out.println("3. Se highscore");
		System.out.println("4. Rensa highscore");
		System.out.println("0. Avsluta");
		highscore.add("hej:1");
		System.out.println(highscore);

	}




}