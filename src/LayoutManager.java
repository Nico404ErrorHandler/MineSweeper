import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LayoutManager extends JFrame {
	private MinePanel oberBereich;
	
	public LayoutManager() {
		// MinePanel wird erzeugt
		oberBereich = new MinePanel();
		this.setSize(1000, 1000);
		
		MineTimer.getInstance().start();	// Der Timer startet neu

		// MinePanel wird in den Center bereich des BorderLayouts gelegt
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.CENTER, oberBereich);
		
		// Hier werden die zwei JPanels für den Button erzeugt. (MITTIGE AUSRICHTUNG)
		JPanel pane = new JPanel(new FlowLayout());
		JPanel paneFinal = new JPanel(new GridLayout(1, 1));
		
		// Hier werden die zwei JPanels für den Countdown erzeugt. (MITTIGE AUSRICHTUNG)
		JPanel timer = new JPanel(new FlowLayout());
		JPanel timerFinal = new JPanel(new GridLayout(1,1));

		JButton restart = new JButton("Neu starten");
		
		// Die Panels werden miteinander verküpft
		timerFinal.add(MineTimer.getInstance());
		timer.add(timerFinal);
		this.add(BorderLayout.NORTH, timer);
		
		// Die Panels werden miteinander verküpft
		paneFinal.add(restart);
		pane.add(paneFinal);
		this.add(BorderLayout.SOUTH, pane);
		
		// Hier wird der Button mit einem ActionListener belegt.
		restart.addActionListener(oberBereich);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
}
