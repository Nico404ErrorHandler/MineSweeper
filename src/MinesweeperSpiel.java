import javax.swing.JOptionPane;

public class MinesweeperSpiel implements KlickBrettSpiel {
	final int X = 10;
	final int Y = 10;
	final int MINEN = 10;
	private Positionen minen = new Positionen(MINEN, X, Y);
	private Anzeige anzeige = new Anzeige(X, Y);
	private Koordinate klick;

	// Hier wird ein Char aus einer Koordinate gesucht, und im Anschluss in die Anzeige eingefügt.
	@Override
	public void set(int x, int y) {
		klick = new Koordinate(x, y);
		char ziel = minen.Suche(klick);
		anzeige.set(x, y, ziel);
	}
	
	// Hier wird nach einem Rechtsklick ein Feld mit einem Char belegt (Markiert)
	@Override
	public void markiere(int x, int y) {
		anzeige.set(x, y, '$');
	}

	// Hier wird eine Koordinate aus einem Savegame Array ausgelesen und zurückgegeben.
	@Override
	public char get(int x, int y) {
		return anzeige.savegame[x][y];
	}

	// Diese Methode prüft wieviele Felder KEINEN Treffer enthalten, stimmt diese Menge mit den vorher festgelegten Werten überein hat man gewonnen.
	@Override
	public boolean gewonnen() {
		if (anzeige.sieg() == X * Y - MINEN && minen.Suche(klick) != Anzeige.TREFFER) {
			MineTimer.getInstance().stop();
			return true;
		} else {
			return false;
		}
	}
	
	// Diese Methode prüft ob ein Treffer enthalten ist, wenn dies so ist, soll der Spieler verloren haben.
	@Override
	public boolean verloren() {
		if (anzeige.niederlage() > 0) {
			MineTimer.getInstance().stop();
			return true;
		} else {
			return false;
			
		}
	}

	// Diese Methode gibt die Zeilenzahl des Arrays zurück.
	@Override
	public int getZeilenZahl() {
		return Y;
	}

	// Diese Methoder gibt die Spaltenzahl des Arrays zurück.
	@Override
	public int getSpaltenZahl() {
		return X;
	}
}
