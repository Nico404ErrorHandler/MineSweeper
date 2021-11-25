import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MeinTabelModel implements TableModel {
	private final Class[] spaltenKlasse = {Integer.class, String.class};

	@Override
	public int getRowCount() {
		return Highscore.getInstance().size(); /// Highscore
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnIndex == 0 ? "Name" : "Highscore";
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return spaltenKlasse[columnIndex];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 1) {
			return Highscore.getInstance().get(rowIndex).getTime();
		}
		if (columnIndex == 0) {
			return Highscore.getInstance().get(rowIndex).getName();
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

}
