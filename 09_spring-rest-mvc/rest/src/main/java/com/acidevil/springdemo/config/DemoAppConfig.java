package com.acidevil.springdemo.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.acidevil.springdemo")
@PropertySource({ "classpath:persistence-mysql.properties" })
public class DemoAppConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;

	private Logger logger = Logger.getLogger(getClass().getName());

	@Bean
	public DataSource myDataSource() {
		ComboPooledDataSource myDataSource = new ComboPooledDataSource();

		try {
			myDataSource.setDriverClass(this.env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}

		this.logger.info("jdbc.url=" + this.env.getProperty("jdbc.url"));
		this.logger.info("jdbc.user=" + this.env.getProperty("jdbc.user"));

		myDataSource.setJdbcUrl(this.env.getProperty("jdbc.url"));
		myDataSource.setUser(this.env.getProperty("jdbc.user"));
		myDataSource.setPassword(this.env.getProperty("jdbc.password"));

		myDataSource.setInitialPoolSize(this.getIntProperty("connection.pool.initialPoolSize"));
		myDataSource.setMinPoolSize(this.getIntProperty("connection.pool.minPoolSize"));
		myDataSource.setMaxPoolSize(this.getIntProperty("connection.pool.maxPoolSize"));
		myDataSource.setMaxIdleTime(this.getIntProperty("connection.pool.maxIdleTime"));

		return myDataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan(this.env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());

		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

	private Properties getHibernateProperties() {
		Properties props = new Properties();

		props.setProperty("hibernate.dialect", this.env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", this.env.getProperty("hibernate.show_sql"));

		return props;
	}

	private int getIntProperty(String key) {
		return Integer.parseInt(this.env.getProperty(key));
	}
}
