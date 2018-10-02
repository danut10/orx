package ro.jdmx.orx.app.core;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import ro.jdmx.orx.common.core.dataObject.IDataRecord;

@Service
public class DaoFactorySpring implements IDaoFactory, ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public <T extends IDataRecord> IDao<T> getInstance(String entityCode) {
		String beanName = "dao" + StringUtils.capitalize(entityCode);
		@SuppressWarnings("unchecked")
		IDao<T> dao = (IDao<T>) applicationContext.getBean(beanName);
		return dao;
	}
	
}
