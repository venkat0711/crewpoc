package com.delta.css.dao;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.delta.css.utils.BsLogger;
import com.delta.css.utils.CssApiCnst;


/**
 * Database configuration
 * 
 */
@Configuration
public class DataSrcConfig {


    private final Logger LOGGER = BsLogger.getLogger(DataSrcConfig.class);

    @Bean
    public DataSource getDataSource() {

    	System.out.println("Database Connection ....");
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
        try {
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUsername("root");
            dataSource.setPassword("admin");
            dataSource.setUrl("jdbc:mysql://10.245.231.23:3306/crew");
            

        } catch (IllegalArgumentException e) {
            LOGGER.debug("In side DataSrcConfig IllegalArgumentException error:" + e.getMessage());
        }
        
			return dataSource;
		
       
    }
    
    
    @Bean
    public SqlSessionFactory getSqlSessionFactory() throws Exception {

        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setConfigLocation(new ClassPathResource(CssApiCnst.SQL_CONFIG));
        return sessionFactory.getObject();
    }
    
}
