package ro.jdmx.orx.common.dataset;

public class DataColumn {
	private DataTable table;
	private int index;
	private String name;
	private String type;
	private String title;
	
	public DataColumn(DataTable table, String name, String type) {
		this.table = table;
		this.index = table.getColumnCount();
		this.name = name;
		this.type = type;
	}
	
	public DataTable getTable() { return table; }
	public int getIndex() { return index; }
	public String getName() { return name; }
	public String getType() { return type; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
}
