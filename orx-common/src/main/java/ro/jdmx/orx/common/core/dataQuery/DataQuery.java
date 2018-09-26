package ro.jdmx.orx.common.core.dataQuery;

import ro.jdmx.orx.common.core.dataObject.IDataFilter;

public class DataQuery {
	
	private IDataFilter filter;
	private Sorter sorter;
	private Pager pager;
	
	public DataQuery() { }
	public DataQuery(IDataFilter filter) { this.filter = filter; }
	
	public IDataFilter getFilter() { return filter; }
	public DataQuery setFilter(IDataFilter filter) { this.filter = filter; return this; }

	public Sorter getSorter() { return sorter; }
	public DataQuery setSorter(Sorter sorter) { this.sorter = sorter; return this; }
	
	public Pager getPager() { return pager; }
	public DataQuery setPager(Pager pager) { this.pager = pager; return this; }
	
	

}

