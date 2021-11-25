import javax.swing.event.TableModelListener;

public interface AbstractTableModel {

	int getRowCount();

	int getColumnCount();

	String getColumnName(int columnIndex);

	Class<?> getColumnClass(int columnIndex);

	boolean isCellEditable(int rowIndex, int columnIndex);

	Object getValueAt(int rowIndex, int columnIndex);

	void setValueAt(Object aValue, int rowIndex, int columnIndex);

	void addTableModelListener(TableModelListener l);

	void removeTableModelListener(TableModelListener l);

}
