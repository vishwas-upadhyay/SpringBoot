package com.vishwas.springsecurityjdbcauthenticator.datasource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// This class is only needed when we want to configure customize data source.
// like Hikari connection pool setup and all. Most of the configuration for data source
// can be passed from application.properties file

@Configuration
public class DataSourceConfig{

//    @Bean
//    public DataSource dataSource(){
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("oracle.jdbc.driver.OracleDriver");
//        dataSourceBuilder.url("jdbc:oracle:thin:@localhost:1527:xe");
//        dataSourceBuilder.username("CRMDEV01");
//        dataSourceBuilder.password("adidas123");
//        return dataSourceBuilder.build();
//    }

}