
public class Anzeige {
	// Insgesamt werden 6 Attribute definiert.
	char[][] savegame;
	private int zeile, spalte, j;
	static final char LEER = ' ';
	static final char TREFFER = 'X';

	// Hier wird der Konstruktor der Klasse Anzeige definiert. Um eine Anzeige zu
	// erstellen müssen zwei Parameter angegeben werden.
	// Es wird ein Array erstellt: Savegame, im Anschluss wird jedes Element dieses
	// Arrays, mit der Char-Variable LEER belegt.
	public Anzeige(int zeile, int spalte) {
		this.zeile = zeile;
		this.spalte = spalte;
		savegame = new char[zeile][spalte];
		for (int i = 0; i < zeile; i++) {

			for (int j = 0; j < spalte; j++) {
				savegame[i][j] = LEER;
			}
		}
	}

	// Die SET-Methode wird genutzt, um im Savegame-Array ein Symbol auf eine
	// bestimmte Position im Array zu legen.
	public void set(int x, int y, char symbol) {
		savegame[x][y] = symbol;

	}

	// Diese GET-Methode wird verwendet, um sich ausgeben zu lassen, ob auf einer
	// bestimmten Position im Array, ein Symbol liegt.
	public char get(int x, int y) {
		return savegame[x][y];
	}

	// Diese Methode prüft ob sich in einem diesem Savegame-Array, ein Array
	// befindet das die Char-Variable TREFFER enthält.
	// Die Anzahl der getroffenen Minen wird in getroffeneMine gespeichert und
	// returned.
	public int niederlage() {
		int getroffeneMinen = 0;
		for (int i = 0; i < savegame.length; i++) {
			for (int j = 0; j < savegame[0].length; j++) {
				if (savegame[i][j] == TREFFER) {
					getroffeneMinen++;
				}
			}
		}
		return getroffeneMinen;
	}

	public int sieg() {
		int geklickteFelder = 0;
		for (int i = 0; i < savegame.length; i++) {
			for (int j = 0; j < savegame[0].length; j++) {
				if (savegame[i][j] != ' ') {
					geklickteFelder++;
				}
			}
		}
		return geklickteFelder;
	}

}
