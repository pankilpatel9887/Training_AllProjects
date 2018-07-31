package com.niit.skill.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.niit.skill")
@EnableTransactionManagement
public class ConfigrationDetails {
	

	@Autowired
	@Bean(name="dataSource")
	public DataSource getDataSource()
	{
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/hello");
		dataSource.setUsername("sa");
		dataSource.setPassword("pankil");
		System.out.println("datasource"+dataSource);
		return dataSource;
		
	}
	
	public Properties getHibernateProperties()
	{
		Properties prop=new Properties();
		prop.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		prop.setProperty("hibernate.show_sql","true");
		prop.setProperty("hibernate.hbm2ddl.auto","update");
		System.out.println("prop"+prop);
		return prop;
		
	}

	
	@Autowired
	@Bean(name="sessionFactory")
	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setHibernateProperties(getHibernateProperties());
		sessionFactory.setDataSource(dataSource);
		
		sessionFactory.setPackagesToScan("com.niit.skill");
		
		System.out.println("session"+sessionFactory);
		return sessionFactory;
		
	}
	
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
	{
		HibernateTransactionManager transactionmanager=new HibernateTransactionManager(sessionFactory);
		
		System.out.println(transactionmanager);
		return transactionmanager;
		
	}
	
}