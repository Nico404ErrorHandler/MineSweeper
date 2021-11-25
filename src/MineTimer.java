import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class MineTimer extends JLabel implements ActionListener {
	private static MineTimer instance = null;
	private Timer timer = new Timer(1000, this);
	private int i;

	private MineTimer() {
	}

	// Es wird eine statische Methode deklariert um zu ermöglichen auf diese Methode
	// aus anderen Klassen zuzugreifen. Es wird eine Instanz erstellt wenn es keine bereits erstellte
	// geben sollte, sollte es doch eine geben wird die erstellte Instanz
	// zurückgegeben.
	static public MineTimer getInstance() {
		if (instance == null) {
			instance = new MineTimer();
		}
		return instance;
	}

	// Der Timer wird gestartet.
	public void start() {
		i = 0;
		timer.start();
	}

	// Der Timer wird gestoppt.
	public void stop() {
		timer.stop();
	}

	// Hier wird auf das eigene Objekt über setText zugegriffen. (Weil diese Klasse
	// das JLabel erweitert!!!)
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setText("Abgelaufene Zeit: " + i++);
	}
	
	public int getTime() {
		return i;
	}

}
