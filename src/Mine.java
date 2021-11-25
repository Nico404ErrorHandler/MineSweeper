import java.util.Random;

public class Mine extends Koordinate {

	static Random zufall = new Random();

	// Hier wird der Konstruktor der erweiternden Klasse Mine definiert, als
	// Parameter werden zwei Integer Werte übergeben,
	// mithilfe des Befehls super() kann ich auf die Attribute in der Basisklasse
	// zugreifen, und dadurch Minen mit einer random Position definieren.
	public Mine(int x, int y) {
		super(x = zufall.nextInt(x), y = zufall.nextInt(y));
	}

}
