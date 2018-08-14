package com.trucker;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfig{
	
	@Bean
	public LocalContainerEntityManagerFactoryBean emf(){
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(getDataSource());
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setPackagesToScan("com.trucker.entityPack");
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
		jpaProperties.put("hibernate.hbm2ddl.auto", "validate");
		jpaProperties.put("hibernate.show_sql", "true");
		
		emf.setJpaProperties(jpaProperties);
		return emf;
	}
	
	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/trucker_db");
		ds.setUsername("root");
		ds.setPassword("pass");
		
		return ds;
	}
	
	@Bean
	public PlatformTransactionManager tcMgr(EntityManagerFactory emf){
		JpaTransactionManager txm = new JpaTransactionManager(emf);
		return txm;
	}
	
	
}
