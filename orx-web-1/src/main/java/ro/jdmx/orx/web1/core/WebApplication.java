package ro.jdmx.orx.web1.core;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
@ComponentScan(basePackages="ro.jdmx.orx.web1")
@Import(DbConfiguration.class)
public class WebApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplicationBuilder appBuilder = new SpringApplicationBuilder(WebApplication.class);
		appBuilder.web(WebApplicationType.NONE);
		appBuilder.run(args);
		//SpringApplication.run(WebApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebApplication.class);
	}	
}
