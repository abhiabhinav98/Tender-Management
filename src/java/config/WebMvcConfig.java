package org.websparrow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.websparrow.dao.UserDao;
import org.websparrow.dao.UserDaoImpl;
import org.websparrow.dao.adminDAO;
import org.websparrow.dao.adminDaoImpl;
import org.websparrow.dao.vendorDAO;
import org.websparrow.dao.vendorDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan("org.websparrow")
public class WebMvcConfig {

	@Bean
	InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver vr = new InternalResourceViewResolver();

		vr.setPrefix("/");
		vr.setSuffix(".jsp");
		return vr;

	}

	@Bean
	DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/tendermanagement");
		ds.setUsername("root");
		ds.setPassword("root");

		return ds;

	}

	@Bean
	public UserDao getUserDao() {
		return new UserDaoImpl(getDataSource());
	}
	
	@Bean
	public adminDAO getAdminDAO() {
		return new adminDaoImpl(getDataSource());
	}

	@Bean
		public vendorDAO getVendorDAO() {
			return new vendorDaoImpl(getDataSource());
		}
	
	

}
