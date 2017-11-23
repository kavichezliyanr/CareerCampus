/**
 * 
 */
package com.career.compass.configuration;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

/**
 * In this configuration class, we are doing a lot: Creating datasource [using Hikari connection pooling], creating EntityManagerFactory, setting up transaction manager, referring to Spring-data repositories etc.
 * Spring Data @EnableJpaRepositories: @EnableJpaRepositories Annotation enables JPA repositories. It will scan the specified packages for Spring Data repositories. by default, it will look into current package for Spring-data repositories.
 * Spring Boot DataSourceProperties : DataSourceProperties is the helper class for configuration of a data source. Interesting point is that we can map the properties right from .yml files, thanks to hierarchical data. Matching-name properties from .yml will be mapped directly to properties of DataSourceProperties object.
 * Spring Boot DataSourceBuilder : DataSourceBuilder is a builder that can help creating a datasource using the mapped properties.
 * Additionally,if a datasource property is missing in DataSourceProperties [maxPoolSize e.g.], we can still take the advantage of good old @Value annotation to map it form property file to actual object property.
 * 
 * @author Kavichezliyan Rajendran
 *
 */
@Configuration
@EnableJpaRepositories(basePackages="com.career.compass.repository" ,
entityManagerFactoryRef="entityManagerFactoryRef" ,
transactionManagerRef = "transactionManagerRef")
@EnableTransactionManagement
public class JpaConfiguration {
	
	@Autowired
    private Environment environment;
 
    @Value("${datasource.ccapp.maxPoolSize:10}")
    private int maxPoolSize;
 
    /*
     * Populate SpringBoot DataSourceProperties object directly from application.yml 
     * based on prefix.Thanks to .yml, Hierachical data is mapped out of the box with matching-name
     * properties of DataSourceProperties object].
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.ccapp")
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }
 
    /*
     * Configure HikariCP pooled DataSource.
     */
    @Bean
    public DataSource dataSource() {
        DataSourceProperties dataSourceProperties = dataSourceProperties();
            HikariDataSource dataSource = (HikariDataSource) DataSourceBuilder
                    .create(dataSourceProperties.getClassLoader())
                    .driverClassName(dataSourceProperties.getDriverClassName())
                    .url(dataSourceProperties.getUrl())
                    .username(dataSourceProperties.getUsername())
                    .password(dataSourceProperties.getPassword())
                    .type(HikariDataSource.class)
                    .build();
            dataSource.setMaximumPoolSize(maxPoolSize);
            return dataSource;
    }
 
    /*
     * Entity Manager Factory setup.
     */
    @Bean(name = "entityManagerFactoryRef")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan(new String[] { "com.career.compass.data" });
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.setJpaProperties(jpaProperties());
        return factoryBean;
    }
 
    /*
     * Provider specific adapter.
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        return hibernateJpaVendorAdapter;
    }
 
    /*
     * Here you can specify any provider specific properties.
     */
    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("datasource.ccapp.hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("datasource.ccapp.hibernate.hbm2ddl.method"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("datasource.ccapp.hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("datasource.ccapp.hibernate.format_sql"));
        if(StringUtils.isNotEmpty(environment.getRequiredProperty("datasource.ccapp.defaultSchema"))){
            properties.put("hibernate.default_schema", environment.getRequiredProperty("datasource.ccapp.defaultSchema"));
        }
        return properties;
    }
 
    @Bean(name = "transactionManagerRef")
    @Autowired
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf);
        return txManager;
    }}
