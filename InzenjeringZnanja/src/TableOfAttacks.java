import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableOfAttacks extends AbstractTableModel {

	private static final long serialVersionUID = 8098032356732224415L;
	
	private final String[] columnNames = { "attack name", "parent of", "can follow", "domains of attack", "mitigations", "weaknesses"};
    private ArrayList<String[]> datas = new ArrayList<String[]>();

    public void AddCSVData(ArrayList<String[]> dataIn) {
        this.datas = dataIn;
        this.fireTableDataChanged();
    }

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datas.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	public String getColumnName(int col) {
        return columnNames[col];
    }
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return datas.get(rowIndex)[columnIndex];
	}
}
