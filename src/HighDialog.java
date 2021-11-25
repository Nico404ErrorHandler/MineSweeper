import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class HighDialog extends JDialog {

	public HighDialog() {
		JTable table = new JTable(new MeinTabelModel());
		add(new JScrollPane(table));
		this.setSize(1000, 1000);
		this.setVisible(true);
		
		
	
	
}
}
