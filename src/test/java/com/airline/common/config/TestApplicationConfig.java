package com.airline.common.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * This class is a configuration file for this application
 * It defines the configuration in the form of annotations that can be defined in application-context.xml file
 * It specifies the configurations such as data source, jdbc template, etc.
 * 
 * @author Muthu
 *
 */
@Configuration
@ComponentScan(basePackages = "com.airline")
@PropertySource(value = {"classpath:test_application.properties"})
public class TestApplicationConfig {

  @Autowired
  private Environment env;

  /**
   * This method is used to configure the Data source by using the connection properties
   * The required properties to create this Data source is defined in application.properties
   * It returns the DataSource object by connecting to the database and creating new DataSource 
   * 
   * @return DataSource - DataSource
   */
  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
    dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
    dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
    dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
    return dataSource;
  }

  /**
   * This method is used to create and returns the JdbcTemplate using the given DataSource
   * 
   * @param dataSource - DataSource to obtain the connection
   * @return jdbcTemplate - JdbcTemplate 
   */
  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    jdbcTemplate.setResultsMapCaseInsensitive(true);
    return jdbcTemplate;
  }

  /**
   * This method returns the MessageSource obtained from ResourceBundleMessageSource
   * It reads the messages, error messages from the property files in the class path
   * 
   * @return messageSource - MessageSource
   */
  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasenames("classpath:messages", "classpath:errormessages");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }

}
