package com.mycompany.myapp.config;

import io.github.jhipster.config.JHipsterConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;
@Configuration
@EnableJpaRepositories(basePackages = {"com.mycompany.myapp.secondaryrepository"},entityManagerFactoryRef = "secondaryEntityManagerFactory",transactionManagerRef = "secondaryTransactionManager")
@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
@EnableTransactionManagement
@Profile(JHipsterConstants.SPRING_PROFILE_PRODUCTION)
public class Database2Configuration {

    private final Logger log = LoggerFactory.getLogger(Database2Configuration.class);

    @Autowired
    @Qualifier("secondaryDataSource")
    private DataSource dataSource;

    @Primary
    @Bean(name = "secondaryEntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return secondaryEntityManagerFactory(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "secondaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory (EntityManagerFactoryBuilder builder) {
        Map<String,Object> properties= hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(),new HibernateSettings());
        return builder
            .dataSource(dataSource)
            .properties(properties)
            .packages("com.mycompany.myapp.secondarydomain") //设置实体类所在位置
            .persistenceUnit("secondaryPersistenceUnit")
            .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    private HibernateProperties hibernateProperties;


    @Primary
    @Bean(name = "secondaryTransactionManager")
    public PlatformTransactionManager secondaryTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(secondaryEntityManagerFactory(builder).getObject());
    }
}
