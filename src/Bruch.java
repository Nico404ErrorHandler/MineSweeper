public class Bruch {

	private int zaehler, nenner;

	/**
	 * Der Konstruktor zwingt dazu, das Bruchobjekt bei der Entstehung mit Werten
	 * vorzubelegen.
	 * 
	 * @param zaehler
	 * @param nenner
	 */
	public Bruch(int z, int n) {
		zaehler = z;
		nenner = n;
		int ggt = euklid(zaehler, nenner);
		zaehler = zaehler / ggt;
		nenner = nenner / ggt;
		if (nenner < 0) {
			zaehler = -zaehler;
			nenner = -nenner;
		}
	}

	/**
	 * Multipliziere Bruch
	 * 
	 * @param Der zu multiplizierende Bruch
	 * @return ergebnis
	 */
	public Bruch mul(Bruch other) {
		// liefert das Produkt der Brüche this und other
		int z = this.zaehler * other.zaehler;
		int n = this.nenner * other.nenner;
		return new Bruch(z, n);
	}

	/**
	 * Multipliziere eine ganze Zahl
	 * 
	 * @param die zu multiplizierende int-Zahl
	 * @return ergebnis
	 */
	public Bruch mul(int wert) {
		Bruch ergebnis = new Bruch(this.zaehler * wert, nenner);
		return ergebnis;
	}

	/*
	 * Die Methode ADD liefert nach Eingabe zweier Br�che, einen Bruch als Ergebnis.
	 * Die Rechnung f�r den Z�hler: (z�hler_A * Nenner_B) + (z�hler_B * nenner_A)
	 * Die Rechnung f�r den Nenner: (nenner_A * nenner_B)
	 */
	public Bruch add(Bruch memory) {
		return memory = new Bruch((this.zaehler * memory.nenner) + (memory.zaehler * this.nenner),
				this.nenner * memory.nenner);
	}

	/*
	 * Die Methode EUKLID liefert den GGT des Z�hlers und Nenners! Damit ein
	 * Bruchelement nun gek�rzt wird, ist es noch n�tig jeweils Z�hler & Nenner
	 * durch den GGT zu teilen! Dies geschieht aus�erhalb dieser Methode!
	 */
	public int euklid(int x, int y) {
		int z;
		while (y != 0) {
			z = x % y;
			x = y;
			y = z;
		}
		return x;
	}

	// GETTER-Methode f�r den Z�hler eines Bruches!
	public int getZaehler() {
		return this.zaehler;
	}

	// GETTER-Methode f�r den Nenner eines Bruches!
	public int getNenner() {
		return this.nenner;
	}
}
