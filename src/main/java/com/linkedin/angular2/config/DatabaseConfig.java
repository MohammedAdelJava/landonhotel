package com.linkedin.angular2.config;

import javax.activation.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.linkedin.angular2.repository")
@EnableTransactionManagement
@Configuration
public class DatabaseConfig {

	 	@Bean
	    @Primary
	    @ConfigurationProperties(prefix = "spring.datasource")
	    public DataSource dataSource() {
	        return (DataSource) DataSourceBuilder.create().build();
	    }
	
}
