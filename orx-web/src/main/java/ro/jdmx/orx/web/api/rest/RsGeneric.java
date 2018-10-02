package ro.jdmx.orx.web.api.rest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import ro.jdmx.orx.app.core.IDao;
import ro.jdmx.orx.app.core.IDaoFactory;
import ro.jdmx.orx.common.core.DataRecord;
import ro.jdmx.orx.common.core.LexicalFactory;
import ro.jdmx.orx.common.core.dataObject.IDataFilter;
import ro.jdmx.orx.common.core.dataObject.IDataRecord;
import ro.jdmx.orx.common.core.dataQuery.DataQuery;
import ro.jdmx.orx.common.core.dataQuery.Pager;

@Consumes(MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
public class RsGeneric {

	private DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	private ObjectMapper jsonMapper = new ObjectMapper().setDateFormat(dateFormat);
	
	private LexicalFactory recordFactory = new LexicalFactory()
		.addPackage("ro.jdmx.orx.common.dataRecords");
	private LexicalFactory filterFactory = new LexicalFactory()
		.addPackage("ro.jdmx.orx.common.dataFilters");
	
	@Autowired IDaoFactory daoFactory;
	
	/*
	 * REST Methods
	 */
	
	@POST 
	@Path("/{entityCode}/filter")
	public <F extends IDataFilter, R extends IDataRecord> List<R> readFilter(
		@PathParam("entityCode") String entityCode, 
		@PathParam("pageNo") Integer pageNo,
		String json) {
		
		F filter = getFilter(entityCode, json);
		IDao<R> dao = daoFactory.getInstance(entityCode);
		List<R> recordList = dao.readList(new DataQuery(filter));
		return recordList;
	}	

	@POST 
	@Path("/{entityCode}/filter/{pageNo}")
	public <F extends IDataFilter, R extends IDataRecord> List<R> readFilterPager(
		@PathParam("entityCode") String entityCode, 
		@PathParam("pageNo") Integer pageNo,
		String json) {
		
		F filter = getFilter(entityCode, json);
		DataQuery qry = new DataQuery().setFilter(filter);
		IDao<R> dao = daoFactory.getInstance(entityCode);
		int recordCount = dao.readRecordCount(qry);
		Pager pager = new Pager().setPageNo(pageNo).setRecordCount(recordCount).build();
		qry.setPager(pager);
		List<R> recordList = dao.readList(qry);
		return recordList;
	}	
	
	@GET 
	@Path("/{entityCode}")
	public <T extends IDataRecord> List<T> readList(@PathParam("entityCode") String entityCode) {
		IDao<T> dao = daoFactory.getInstance(entityCode);
		List<T> recordList = dao.readList();
		return recordList;
	}
	
	@GET 
	@Path("/{entityCode}/{id}")
	public <T extends IDataRecord> T read(@PathParam("entityCode") String entityCode, @PathParam("id") Integer id) {
		IDao<T> dao = daoFactory.getInstance(entityCode);
		T record = dao.read(id);
		return record;
	}	
	
	@POST 
	@Path("/{entityCode}") 	
	public <T extends IDataRecord> Integer create(@PathParam("entityCode") String entityCode, String json) {
		T record = getRecord(entityCode, json);
		IDao<T> dao = daoFactory.getInstance(entityCode);
		dao.create(record);
		if (! DataRecord.class.isAssignableFrom(record.getClass())) {
			return null;
		}
		return ((DataRecord) record).getId(); 
	}	
	
	@PUT 
	@Path("/{entityCode}/{id}") 
	public <T extends IDataRecord> void update(@PathParam("entityCode") String entityCode, @PathParam("id") Integer id, String json) {
		T record = getRecord(entityCode, json);
		IDao<T> dao = daoFactory.getInstance(entityCode);
		dao.update(record); 
	}	

	@DELETE 
	@Path("/{entityCode}/{id}") 
	public <T extends IDataRecord> void delete(@PathParam("entityCode") String entityCode, @PathParam("id") Integer id) {
		IDao<T> dao = daoFactory.getInstance(entityCode);
		dao.delete(id); 
	}
	
	/*
	 * Private methods
	 */
	
	private <T extends IDataRecord> T getRecord(String entityCode, String json) {
		jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			String className = StringUtils.capitalize(entityCode);
			Class<?> cls = recordFactory.getType(className);
			@SuppressWarnings("unchecked")
			T record = (T) jsonMapper.readValue(json, cls);
			return record;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private <T extends IDataFilter> T getFilter(String entityCode, String json) {
		jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			String className = "F" + StringUtils.capitalize(entityCode);
			Class<?> cls = filterFactory.getType(className);
			@SuppressWarnings("unchecked")
			T filter = (T) jsonMapper.readValue(json, cls);
			return filter;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}		
}
