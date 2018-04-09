package com.linkedin.angular2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.linkedin.angular2.repository")
@EnableTransactionManagement
public class DatabaseConfig {

}
