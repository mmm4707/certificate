package com.nhnacademy.jpa.config;

import com.nhnacademy.jpa.Base;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackageClasses = Base.class, excludeFilters = {@ComponentScan.Filter(Controller.class)})
public class RootConfig {

    @Bean
    public DataSource dataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(com.mysql.cj.jdbc.Driver.class.getName());
        basicDataSource.setUrl("jdbc:mysql://localhost/jpa");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("1234");

        basicDataSource.setInitialSize(2);
        basicDataSource.setMaxTotal(10);

        return basicDataSource;
    }
}
