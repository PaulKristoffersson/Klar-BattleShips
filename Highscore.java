package SankaSkepp;

public class Highscore implements Comparable<Highscore> {

	private final Integer runda;
	private final String winner;
	private final Integer maxLiv;

	public Highscore(String winner, int runda, int maxLiv) {
		this.winner = winner;
		this.runda = runda;
		this.maxLiv = maxLiv;

	}

	public String winner() {
		return winner;
	}

	public Integer runda() {
		return runda;
	}

	public Integer maxLiv() {
		return maxLiv;
	}

	@Override
	public int compareTo(Highscore a) {
		int lastCmp = runda.compareTo(a.runda);
		// TODO Auto-generated method stub
		return lastCmp != 0 ? lastCmp : maxLiv.compareTo(a.maxLiv);
	}
	
}