package ro.jdmx.orx.common.dataset;

public class DataCell {
	private DataColumn column;
	private DataRow row;
	private  Object value;
	
	public DataCell(DataColumn column, DataRow row) {
		this.column = column;
		this.row = row;
	}
	
	public DataColumn getColumn() { return column; }
	public DataRow getRow() { return row; }

	public Object getValue() { return value; }
	public void setValue(Object value) { this.value = value; }
	

}
