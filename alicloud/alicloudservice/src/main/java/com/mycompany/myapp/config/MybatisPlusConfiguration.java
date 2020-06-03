package com.mycompany.myapp.config;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.extension.incrementer.H2KeyGenerator;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.mycompany.myapp.mapper")
public class MybatisPlusConfiguration {

//  显示执行的SQL
    @Profile("dev")
    @Bean
    public PerformanceMonitorInterceptor performanceMonitorInterceptor(){
        return new PerformanceMonitorInterceptor();
    }

    /**
     * MP 自带分页插件
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setCountSqlParser(new JsqlParserCountOptimize(true));

        return page;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource, MybatisPlusProperties mybatisPlusProperties) throws Exception {
//        DataSourceProxy dataSourceProxy = new DataSourceProxy(dataSource);

        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // bean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
        bean.setMapperLocations(mybatisPlusProperties.resolveMapperLocations());
//        bean.setMapperLocations(resolver.getResources(mybatisPlusProperties.resolveMapperLocations());
        SqlSessionFactory factory = null;
        try {
            factory = bean.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return factory;
    }
}
