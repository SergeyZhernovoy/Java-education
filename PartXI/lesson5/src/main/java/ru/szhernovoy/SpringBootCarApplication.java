package ru.szhernovoy;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@SpringBootApplication
public class SpringBootCarApplication {

	@Value("${spring.datasource.driver-class-name}")
	private String databaseDriverClassName;

	@Value("${spring.datasource.url}")
	private String datasourceUrl;

	@Value("${spring.datasource.username}")
	private String databaseUsername;

	@Value("${spring.datasource.password}")
	private String databasePassword;

	@Bean(name = "dataSource")
	public DataSource datasource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(databaseDriverClassName);
		ds.setUrl(datasourceUrl);
		ds.setUsername(databaseUsername);
		ds.setPassword(databasePassword);
		return ds;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCarApplication.class, args);
	}
}
