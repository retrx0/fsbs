package com.nsi.fsbs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

import static com.nsi.fsbs.constants.DatabaseConfigConstants.DATASOURCE_DRIVER_CLASS_NAME;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource managerDataSource = new DriverManagerDataSource();

        managerDataSource.setDriverClassName(DATASOURCE_DRIVER_CLASS_NAME);
        managerDataSource.setUrl("jdbc:postgresql://@localhost:5432");
        managerDataSource.setUsername("postgres");
        managerDataSource.setPassword("abdulrahmaniliyasu");

        return managerDataSource;
    }

}
