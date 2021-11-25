import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MinePanel extends JPanel implements MouseListener, ActionListener {

	private KlickBrettSpiel spiel = new MinesweeperSpiel();
	private int offx, offy, feldBreite, feldHoehe;

	// KONSTRUKTOR
	public MinePanel() {
		this.addMouseListener(this);
	}

	// PAINT METHODE
	public void paint(Graphics gr) {
		super.paint(gr);
		// Wenn alle Felder ohne Minen getroffen wurden, erscheint ein Grünes Rechteck
		// auf dem Display
		boolean win = spiel.gewonnen();
		if (win == true) {
			gr.setColor(Color.green);
			gr.fillRect(offx, offy, spiel.getSpaltenZahl() * feldBreite, spiel.getZeilenZahl() * feldHoehe);
		}
		// Wenn eine Mine getroffen wurde, erscheint ein Rotes Rechteck auf dem Display
		boolean lose = spiel.verloren();
		if (lose == true) {
			gr.setColor(Color.red);
			gr.fillRect(offx, offy, spiel.getSpaltenZahl() * feldBreite, spiel.getZeilenZahl() * feldHoehe);
		}

		// Berechnung der Felbreite und Feldhöhe
		feldBreite = getWidth() / spiel.getSpaltenZahl();
		feldHoehe = getHeight() / spiel.getZeilenZahl();

		// Das macht meine einzelnen Felder quadratisch
		if (feldHoehe > feldBreite) {
			feldHoehe = feldBreite;
		} else {
			feldBreite = feldHoehe;
		}

		// Hier wird der Offset berechnet
		offx = (getWidth() - spiel.getSpaltenZahl() * feldBreite) / 2;
		offy = (getHeight() - spiel.getZeilenZahl() * feldHoehe) / 2;

		// Die Farbe der Linien & Strings soll wieder schwarz gefärbt werden
		gr.setColor(Color.black);

		// VERTIKALE LINIEN
		for (int i = 0; i <= spiel.getSpaltenZahl(); i++) {
			gr.drawLine(i * feldBreite + offx, offy, i * feldBreite + offx, spiel.getZeilenZahl() * feldHoehe + offy);
		}

		// HORIZONTALE LINIEN
		for (int j = 0; j <= spiel.getZeilenZahl(); j++) {
			gr.drawLine(offx, j * feldHoehe + offy, spiel.getSpaltenZahl() * feldBreite + offx, j * feldHoehe + offy);
		}

		// STRINGAUSGABE
		for (int k = 0; k < spiel.getSpaltenZahl(); k++) {
			for (int l = 0; l < spiel.getZeilenZahl(); l++) {
				gr.drawString(spiel.get(k, l) + " ", k * feldBreite + offx, (l + 1) * feldHoehe + offy);
			}
		}

	}

	// MAUSKLICK EVENT
	@Override
	public void mouseClicked(MouseEvent e) {

		// Hier wird die gefragt welche Maustaste gedrückt wird, und im Anschluss wird
		// die logische Koordinate berechnet aus der Mausposition.
		int klick = e.getButton();
		int logischesX = (e.getX() - offx) / feldBreite;
		int logischesY = (e.getY() - offy) / feldHoehe;

		// Wenn der BUTTON 1 gedrückt wurde, soll ein Feld aufgedeckt werden.
		if (klick == 1) {
			
			spiel.set(logischesX, logischesY);
			
			if (spiel.gewonnen()) {
			String name = JOptionPane.showInputDialog(this, "Name");
			if (name!=null) {
				Score winner = new Score(name, MineTimer.getInstance().getTime());
				Highscore.getInstance().add(winner);
				HighDialog liste = new HighDialog();
			}}
		}

		// Wenn der BUTTON 2 gedrückt wird, soll ein Feld markiert werden.
		else if (klick == 3){
			spiel.markiere(logischesX, logischesY);
		}

		// Hier wird geprüft ob eine Koordinate den Char '0' enthält.
		// Alle Felder im Umkreis sollen aufgedeckt werden.
		// In die Set Methode logik von panel trennen 
		if (spiel.get(logischesX, logischesY) == '0') {
			for (int z = -1; z <= 1; z++) {
				for (int y = -1; y <= 1; y++) {
					int zZahl = logischesX;
					int yZahl = logischesY;
					zZahl += z;
					yZahl += y;

					if (zZahl >= 0 && yZahl >= 0 && zZahl < spiel.getSpaltenZahl() 
							&& yZahl < spiel.getZeilenZahl()) {
						spiel.set(zZahl, yZahl);
					}
				}
			}
		}
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	// Hier wird durch den ActionListener auf ein Ereignis gehorcht, sobald der
	// Button gedrückt wurde wird das Spiel neugestartet.
	@Override
	public void actionPerformed(ActionEvent e) {
		spiel = new MinesweeperSpiel();
		MineTimer.getInstance().start();
		System.out.println("sda");
		repaint();
	}
}
