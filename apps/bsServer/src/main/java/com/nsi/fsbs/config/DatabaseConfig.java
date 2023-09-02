package com.nsi.fsbs.config;

import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import static com.nsi.fsbs.constants.DatabaseConfigConstants.DATASOURCE_DRIVER_CLASS_NAME;

@Configuration
@EnableTransactionManagement
@EntityScan("com.nsi.common.model.jpa")
public class DatabaseConfig {

    @Bean
    public DataSource userDBDataSource(){
        DriverManagerDataSource managerDataSource = new DriverManagerDataSource();

        managerDataSource.setDriverClassName(DATASOURCE_DRIVER_CLASS_NAME);
        managerDataSource.setUrl("jdbc:postgresql://localhost:5432/userdb");
        managerDataSource.setUsername("postgres");
        managerDataSource.setPassword("abdulrahmaniliyasu");

        return managerDataSource;
    }

//    @Bean
//    public DataSource bookingDBDataSource(){
//        DriverManagerDataSource managerDataSource = new DriverManagerDataSource();
//
//        managerDataSource.setDriverClassName(DATASOURCE_DRIVER_CLASS_NAME);
//        managerDataSource.setUrl("jdbc:postgresql://localhost:5432/bookingdb");
//        managerDataSource.setUsername("postgres");
//        managerDataSource.setPassword("abdulrahmaniliyasu");
//
//        return managerDataSource;
//    }

}
