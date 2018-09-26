package ro.jdmx.orx.common.dataset;

import java.util.ArrayList;
import java.util.List;

public class DataTable {
	private String name;
	private String title;
	private List<DataColumn> columns;
	private List<DataRow> rows;
	
	public DataTable() {
		columns = new ArrayList<DataColumn>();
		rows = new ArrayList<DataRow>();
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public int getColumnCount() { return columns.size(); }
	public int getRowCount() { return rows.size(); }
	public List<DataColumn> getColumns() { return columns; }
	public List<DataRow> getRows() { return rows; }

	public DataColumn addColumn(String columnName, String columnType) {
		DataColumn column = new DataColumn(this, columnName, columnType);
		columns.add(column);
		return column;
	}
	
	public DataRow addRow() {
		if (this.getColumnCount() == 0) { return null; }
		DataRow row = new DataRow(this);
		rows.add(row);
		return row;
	}
	
	public DataColumn getColumn(String columnName) {
		DataColumn result = null;
		for (DataColumn column: columns) {
			if (column.getName().equalsIgnoreCase(columnName)) {
				result = column;
				break;
			}
		}
		return result;
	}
	
	public DataColumn getColumn(int index) {
		DataColumn result = null;
		for (DataColumn column: columns) {
			if (column.getIndex() == index) {
				result = column;
				break;
			}
		}
		return result;
	}
	
	public DataRow getRow(int index) {
		DataRow result = null;
		for (DataRow row: rows) {
			if (row.getIndex() == index) {
				result = row;
				break;
			}
		}
		return result;
	}
	
}
