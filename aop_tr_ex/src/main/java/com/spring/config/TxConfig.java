package com.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class TxConfig {
    @Autowired
    DriverManagerDataSource ds;
    @Bean
    public PlatformTransactionManager transactionManager() {
	    DataSourceTransactionManager txMgr = new DataSourceTransactionManager();
	    txMgr.setDataSource(ds);
	    return txMgr;
    }
}