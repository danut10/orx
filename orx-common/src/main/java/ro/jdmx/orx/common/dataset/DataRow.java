package ro.jdmx.orx.common.dataset;

import java.util.ArrayList;
import java.util.List;

public class DataRow {
	private DataTable table;
	private int index;
	private List<DataCell> cells;
	private List<DataRow> children;
	
	public DataRow(DataTable table) {
		this.table = table;
		this.index = table.getRowCount();
		int columnCount = table.getColumnCount();
		cells = new ArrayList<DataCell>();
		for (int i = 0; i < columnCount; i++) {
			cells.set(i, new DataCell(table.getColumn(i), this));
		}
	}
	
	public DataTable getTable() { return table; }
	public int getIndex() { return index; }
	public List<DataCell> getCells() { return cells; }
	public List<DataRow> getChildren() { return children; }

	public void setCell(String columnName, Object value) {
		DataColumn column = table.getColumn(columnName);
		if (column == null) { return; }
		DataCell cell = cells.get(column.getIndex());
		cell.setValue(value);
	}
	
	public DataCell getCell(String columnName) {
		DataCell cell = null;
		DataColumn column = table.getColumn(columnName);
		if (column != null) {
			 cell = cells.get(column.getIndex());
		}
		return cell;
	}
	
	public void addChildRow(DataRow row) {
		this.children.add(row);
	}

}
