
public class Koordinate {
	// Es werden zwei Attribute definiert.
	private int x, y;

	// Es wird der Konstruktor definiert, übergeben werden zwei Parameter, welche
	// dann den Attributen zugewiesen werden.
	public Koordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// Die Methode equals prüft zwei Koordinaten auf Gleichheit, also x1=x2 und
	// y1=y2
	public Boolean equals(Koordinate other) {
		// @override
		boolean wert = this.x == other.x && this.y == other.y;
		return wert;

	}

	// Diese Methode gibt die x- und y-Koordinaten als String aus.
	public String toString() {
		String a = "" + this.x;
		String b = "" + this.y;
		String ergebnis = "(" + a + "," + b + ")";
		return ergebnis;
	}

	// Diese Methode prüft zwei Koordinaten darauf, ob diese direkte Nachbarn im
	// Koordinaten-Array sind.
	public boolean istNachbar(Koordinate vergleich) {
		return (this.x + 1 == vergleich.x || this.x - 1 == vergleich.x || this.x == vergleich.x)
				&& (this.y + 1 == vergleich.y || this.y - 1 == vergleich.y || this.y == vergleich.y);
	}

}
