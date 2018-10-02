package ro.jdmx.orx.app.core;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import ro.jdmx.orx.common.core.dataObject.IDataRecord;
import ro.jdmx.orx.common.core.dataQuery.DataQuery;

public interface IDao<T extends IDataRecord>  {

	int readRecordCount(@Param("qry") DataQuery qry);
	List<T> readList();
	List<T> readList(@Param("qry") DataQuery qry);
	List<T> readList(@Param("qry") DataQuery qry, RowBounds rb);

	void update(@Param("record") T record);
	void create(@Param("record") T record);
	
	T read(@Param("id") Integer id);
	void delete(@Param("id") Integer id);

}
