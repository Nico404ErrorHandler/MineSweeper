import javax.swing.JFrame;

public class MineFrame extends JFrame {
	public MineFrame() {

		MinePanel centeredPanel = new MinePanel();
		add(centeredPanel);
		this.setSize(1000, 1000);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

}
