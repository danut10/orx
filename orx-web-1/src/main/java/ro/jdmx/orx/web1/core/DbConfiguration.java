package ro.jdmx.orx.web1.core;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@Configuration
@MapperScan("ro.jdmx.orx.app.dao")
public class DbConfiguration {

    @Autowired private Environment environment;
    @Autowired private ResourceLoader resourceLoader;
    
    @Bean(name="dataSource")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setUsername(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		return dataSource;
	}
	
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean sqlSessionFactory() {
		Resource configLocation = resourceLoader.getResource("classpath:conf/mybatis.xml");
		Resource[] mapperLocations = { resourceLoader.getResource("classpath:mybatis/mappers/*.xml") };
		String typeAliassesPackage = "ro.jdmx.orx.common.dataRecords";
		
		final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setConfigLocation(configLocation);
		sqlSessionFactoryBean.setMapperLocations(mapperLocations);
		sqlSessionFactoryBean.setTypeAliasesPackage(typeAliassesPackage);
		return sqlSessionFactoryBean;
	 }
	
}
