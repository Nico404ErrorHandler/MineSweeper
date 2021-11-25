
public class Positionen {
	// Es werden 4 Attribute definiert.
	int menge, xGroese, yGroese;
	private Mine[] array;

	// Hier wird der Konstruktor mit drei Parametern aufgerufen. Es wird dann mit
	// dem ersten �bergebenem Parameter ein Array vom Typ Mine erstellt.
	// Daraufhin wird das erzeugte Array mithilfe einer for-Schleife mit Minen
	// gef�llt. In der n�chsten for-Schleife wird noch gepr�ft ob sich
	// unter den erzeugten Minen, doppelte befanden.
	public Positionen(int menge, int xGroese, int yGroese) {
		this.menge = menge;
		this.xGroese = xGroese;
		this.yGroese = yGroese;
		array = new Mine[menge];

		for (int count = 0; count < array.length; count++) {
			array[count] = new Mine(xGroese, yGroese);

			for (int count1 = 0; count1 < count; count1++) {

				if (array[count].equals(array[count1])) {
					count--;
				}
			}
		}
	}

	// Diese GET-Methode wird ben�tigt um die (x,y)-Werte einer Koordinate
	// auszugeben
	public Koordinate get(int index) {
		return array[index];
	}

	// Diese Methode gibt aus ob sich eine �bergebene Koordinate in dem
	// Minen-Array++++++++++++
	// befindet, wenn dies der Fall ist soll ein TREFFER returned werden,
	// sollte es sich nicht um einen TREFFER handeln, so wird gepr�ft wie viele
	// Minen, Nachbarn der �bergebenen Koordinate sind.
	public char Suche(Koordinate koord) {
		char rueckgabe = '0';
		int anzahl = 0;

		for (int i = 0; i < array.length; i++) {
			boolean wsg = array[i].equals(koord);
			if (wsg == true) {
				return Anzeige.TREFFER;
			} else {
				if (array[i].istNachbar(koord) == true) {
					anzahl++;
				}
			}
		}
		return rueckgabe = (char) ('0' + anzahl);
	}

}
