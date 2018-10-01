package ro.jdmx.orx.app.core;

import org.apache.ibatis.annotations.Param;

import ro.jdmx.orx.common.core.DataRecordID;

public interface IDaoID<T extends DataRecordID> extends IDao<T> {

	T read(@Param("id") Integer id);
	void delete(@Param("id") Integer id);
	void deleteAll();
}
