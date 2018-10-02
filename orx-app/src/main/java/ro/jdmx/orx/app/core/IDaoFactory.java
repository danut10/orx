package ro.jdmx.orx.app.core;

import ro.jdmx.orx.common.core.dataObject.IDataRecord;

public interface IDaoFactory {
	<T extends IDataRecord> IDao<T> getInstance(String entityCode); 
}
